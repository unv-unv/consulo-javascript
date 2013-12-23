/*
 * Copyright 2000-2005 JetBrains s.r.o.
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
package com.intellij.lang.javascript.surroundWith;

import org.jetbrains.annotations.NotNull;
import com.intellij.lang.javascript.psi.JSCallExpression;
import com.intellij.lang.javascript.psi.JSExpression;
import com.intellij.lang.javascript.psi.JSReferenceExpression;
import com.intellij.lang.surroundWith.SurroundDescriptor;
import com.intellij.lang.surroundWith.Surrounder;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiFile;
import com.intellij.psi.PsiWhiteSpace;
import com.intellij.psi.util.PsiTreeUtil;

/**
 * Created by IntelliJ IDEA.
 * User: yole
 * Date: 12.07.2005
 * Time: 12:46:24
 * To change this template use File | Settings | File Templates.
 */
public class JSExpressionSurroundDescriptor implements SurroundDescriptor
{
	private static final Surrounder[] SURROUNDERS = {
			new JSWithParenthesesSurrounder()
	};

	@Override
	@NotNull
	public PsiElement[] getElementsToSurround(PsiFile file, int startOffset, int endOffset)
	{
		final JSExpression expr = findExpressionInRange(file, startOffset, endOffset);
		if(expr == null)
		{
			return PsiElement.EMPTY_ARRAY;
		}
		return new PsiElement[]{expr};
	}

	@Override
	@NotNull
	public Surrounder[] getSurrounders()
	{
		return SURROUNDERS;
	}

	@Override
	public boolean isExclusive()
	{
		return false;
	}

	private static JSExpression findExpressionInRange(PsiFile file, int startOffset, int endOffset)
	{
		PsiElement element1 = file.findElementAt(startOffset);
		PsiElement element2 = file.findElementAt(endOffset - 1);
		if(element1 instanceof PsiWhiteSpace)
		{
			startOffset = element1.getTextRange().getEndOffset();
		}
		if(element2 instanceof PsiWhiteSpace)
		{
			endOffset = element2.getTextRange().getStartOffset();
		}
		JSExpression expression = PsiTreeUtil.findElementOfClassAtRange(file, startOffset, endOffset, JSExpression.class);
		if(expression == null || expression.getTextRange().getEndOffset() != endOffset)
		{
			return null;
		}
		if(expression instanceof JSReferenceExpression && expression.getParent() instanceof JSCallExpression)
		{
			return null;
		}
		return expression;
	}
}
