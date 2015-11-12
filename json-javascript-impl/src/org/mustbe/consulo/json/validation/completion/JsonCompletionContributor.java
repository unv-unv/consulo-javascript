/*
 * Copyright 2013-2015 must-be.org
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.mustbe.consulo.json.validation.completion;

import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.jetbrains.annotations.NotNull;
import org.mustbe.consulo.RequiredReadAction;
import org.mustbe.consulo.json.validation.JsonFileDescriptorProviders;
import org.mustbe.consulo.json.validation.descriptor.JsonObjectDescriptor;
import org.mustbe.consulo.json.validation.descriptor.JsonPropertyDescriptor;
import org.mustbe.consulo.json.validation.descriptor.JsonPropertyType;
import org.mustbe.consulo.json.validation.inspections.PropertyValidationInspection;
import com.intellij.codeInsight.completion.CompletionContributor;
import com.intellij.codeInsight.completion.CompletionParameters;
import com.intellij.codeInsight.completion.CompletionProvider;
import com.intellij.codeInsight.completion.CompletionResultSet;
import com.intellij.codeInsight.completion.CompletionType;
import com.intellij.codeInsight.completion.InsertHandler;
import com.intellij.codeInsight.completion.InsertionContext;
import com.intellij.codeInsight.lookup.LookupElement;
import com.intellij.codeInsight.lookup.LookupElementBuilder;
import com.intellij.icons.AllIcons;
import com.intellij.lang.javascript.JSTokenTypes;
import com.intellij.lang.javascript.psi.JSObjectLiteralExpression;
import com.intellij.lang.javascript.psi.JSProperty;
import com.intellij.openapi.util.text.StringUtil;
import com.intellij.patterns.StandardPatterns;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiFile;
import com.intellij.psi.codeStyle.CodeStyleManager;
import com.intellij.util.ProcessingContext;
import com.intellij.util.containers.ContainerUtil;

/**
 * @author VISTALL
 * @since 10.11.2015
 */
public class JsonCompletionContributor extends CompletionContributor
{
	public JsonCompletionContributor()
	{
		extend(CompletionType.BASIC, StandardPatterns.psiElement(JSTokenTypes.IDENTIFIER), new CompletionProvider<CompletionParameters>()
		{
			@RequiredReadAction
			@Override
			protected void addCompletions(@NotNull CompletionParameters parameters, ProcessingContext context, @NotNull CompletionResultSet result)
			{
				final PsiFile originalFile = parameters.getOriginalFile();

				JsonObjectDescriptor rootDescriptor = JsonFileDescriptorProviders.getRootDescriptor(originalFile);
				if(rootDescriptor == null)
				{
					return;
				}

				PsiElement position = parameters.getPosition();
				final PsiElement jsProperty = position.getParent();
				if(!(jsProperty instanceof JSProperty))
				{
					return;
				}

				Collection<JSProperty> jsProperties = PropertyValidationInspection.buildPropertiesAsTree(position, rootDescriptor);
				if(jsProperties.isEmpty())
				{
					return;
				}

				JsonObjectDescriptor parentObject = null;
				JsonPropertyDescriptor currentProperty = null;
				JsonObjectDescriptor currentObject = rootDescriptor;
				for(JSProperty property : jsProperties)
				{
					String name = property.getName();
					if(name == null)
					{
						return;
					}

					currentProperty = currentObject.getProperty(name);
					if(currentProperty == null)
					{
						if(property == jsProperty)
						{
							parentObject = currentObject;
							break;
						}
						else
						{
							return;
						}
					}
					else if(currentProperty.getValue() instanceof JsonObjectDescriptor)
					{
						currentObject = (JsonObjectDescriptor) currentProperty.getValue();
					}
					else
					{
						break;
					}
				}

				if(parentObject == null)
				{
					return;
				}

				Map<String, JsonPropertyDescriptor> properties = parentObject.getProperties();

				Set<String> alreadyDefined = Collections.emptySet();
				PsiElement parent = jsProperty.getParent();
				if(parent instanceof JSObjectLiteralExpression)
				{
					JSProperty[] parentProperties = ((JSObjectLiteralExpression) parent).getProperties();
					alreadyDefined = new HashSet<String>(parentProperties.length);
					for(JSProperty parentProperty : parentProperties)
					{
						ContainerUtil.addIfNotNull(alreadyDefined, parentProperty.getName());
					}
				}

				for(final Map.Entry<String, JsonPropertyDescriptor> entry : properties.entrySet())
				{
					String key = entry.getKey();
					if(alreadyDefined.contains(key))
					{
						continue;
					}
					LookupElementBuilder builder = LookupElementBuilder.create(StringUtil.QUOTER.fun(key));
					builder = builder.withPresentableText(key);
					builder = builder.withIcon(AllIcons.Nodes.Property);

					if(((JSProperty) jsProperty).getValue() == null)
					{
						builder = builder.withInsertHandler(new InsertHandler<LookupElement>()
						{
							@Override
							public void handleInsert(InsertionContext context, LookupElement item)
							{
								JsonPropertyDescriptor value = entry.getValue();
								if(value.getType() == JsonPropertyType.Object)
								{
									context.getDocument().insertString(context.getTailOffset(), ": {\n}");
									context.getEditor().getCaretModel().moveToOffset(context.getTailOffset() - 2);

									context.commitDocument();
									CodeStyleManager.getInstance(context.getProject()).reformatRange(originalFile, context.getStartOffset(), context.getTailOffset());
								}
								else
								{
									context.getDocument().insertString(context.getTailOffset(), ": ");
									context.getEditor().getCaretModel().moveToOffset(context.getTailOffset());
								}
							}
						});
					}
					result.addElement(builder);
				}
			}
		});
	}
}