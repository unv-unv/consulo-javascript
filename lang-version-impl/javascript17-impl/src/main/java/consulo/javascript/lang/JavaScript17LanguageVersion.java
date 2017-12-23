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

package consulo.javascript.lang;

import org.jetbrains.annotations.NotNull;
import com.intellij.lexer.Lexer;
import com.intellij.openapi.fileTypes.SyntaxHighlighter;
import com.intellij.openapi.util.Factory;
import consulo.javascript.ide.hightlight.JavaScriptHighlighter;
import consulo.javascript.lang.lexer.JavaScript17Lexer;

/**
 * @author VISTALL
 * @since 11.12.2015
 */
public class JavaScript17LanguageVersion extends BaseJavaScriptLanguageVersion implements StandardJavaScriptVersions.Marker
{
	private static final Factory<Lexer> ourLexerFactory = new Factory<Lexer>()
	{
		@Override
		public Lexer create()
		{
			return new JavaScript17Lexer();
		}
	};

	@NotNull
	public static JavaScript17LanguageVersion getInstance()
	{
		return JavaScriptLanguage.INSTANCE.findVersionByClass(JavaScript17LanguageVersion.class);
	}

	public JavaScript17LanguageVersion()
	{
		super("JAVASCRIPT_1_7");
	}

	@NotNull
	@Override
	public String getPresentableName()
	{
		return "JavaScript 1.7";
	}

	@NotNull
	@Override
	public Lexer createLexer()
	{
		return ourLexerFactory.create();
	}

	@NotNull
	@Override
	public SyntaxHighlighter getSyntaxHighlighter()
	{
		return new JavaScriptHighlighter(ourLexerFactory);
	}

	@Override
	public int getWeight()
	{
		return 20;
	}
}