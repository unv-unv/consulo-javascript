/*
 * @author max
 */
package com.intellij.lang.javascript;

import org.jetbrains.annotations.NotNull;
import com.intellij.lang.LanguageVersion;
import com.intellij.lang.PsiParser;
import com.intellij.lang.javascript.parsing.JSParser;
import com.intellij.lexer.Lexer;
import com.intellij.openapi.project.Project;
import com.intellij.psi.tree.IFileElementType;

public class JSONParserDefinition extends JavascriptParserDefinition
{
	@Override
	@NotNull
	public Lexer createLexer(final Project project, LanguageVersion languageVersion)
	{
		return new JSONLexer(new JavaScriptParsingLexer(JavascriptLanguage.DIALECT_OPTION_HOLDER));
	}

	@Override
	public IFileElementType getFileNodeType()
	{
		return JSElementTypes.JSON_FILE;
	}

	@Override
	@NotNull
	public PsiParser createParser(final Project project, LanguageVersion languageVersion)
	{
		return new JSParser(JavaScriptSupportLoader.JSON);
	}
}