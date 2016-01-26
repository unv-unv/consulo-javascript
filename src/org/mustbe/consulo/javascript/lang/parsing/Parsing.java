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

package org.mustbe.consulo.javascript.lang.parsing;

import com.intellij.lang.PsiBuilder;
import com.intellij.psi.tree.IElementType;

/**
 * User: max
 * Date: Jan 28, 2005
 * Time: 7:03:42 PM
 */
public class Parsing
{
	private JavaScriptParsingContext myContext;

	public Parsing(JavaScriptParsingContext context)
	{
		myContext = context;
	}

	public FunctionParsing getFunctionParsing()
	{
		return myContext.getFunctionParsing();
	}

	public StatementParsing getStatementParsing()
	{
		return myContext.getStatementParsing();
	}

	public ExpressionParsing getExpressionParsing()
	{
		return myContext.getExpressionParsing();
	}

	public static void buildTokenElement(IElementType type, PsiBuilder builder)
	{
		final PsiBuilder.Marker marker = builder.mark();
		builder.advanceLexer();
		marker.done(type);
	}

	public static boolean checkMatches(final PsiBuilder builder, final IElementType token, final String message)
	{
		if(builder.getTokenType() == token)
		{
			builder.advanceLexer();
			return true;
		}
		else
		{
			builder.error(message);
			return false;
		}
	}

	public boolean isIdentifierToken(PsiBuilder builder, IElementType tokenType)
	{
		return myContext.isIdentifierToken(builder, tokenType);
	}

	public boolean isIdentifierName(PsiBuilder builder, IElementType tokenType)
	{
		return myContext.isIdentifierName(builder, tokenType);
	}
}
