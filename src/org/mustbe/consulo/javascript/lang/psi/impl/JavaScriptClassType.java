/*
 * Copyright 2013-2016 must-be.org
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

package org.mustbe.consulo.javascript.lang.psi.impl;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.mustbe.consulo.RequiredReadAction;
import org.mustbe.consulo.javascript.lang.psi.JavaScriptType;
import com.intellij.lang.javascript.psi.JSClass;
import com.intellij.psi.PsiElement;

/**
 * @author VISTALL
 * @since 23.02.2016
 */
public class JavaScriptClassType implements JavaScriptType
{
	private JSClass myClass;

	public JavaScriptClassType(JSClass aClass)
	{
		myClass = aClass;
	}

	@RequiredReadAction
	@NotNull
	@Override
	public String getPresentableText()
	{
		return myClass.getName();
	}

	@Nullable
	@Override
	public PsiElement getTargetElement()
	{
		return myClass;
	}
}
