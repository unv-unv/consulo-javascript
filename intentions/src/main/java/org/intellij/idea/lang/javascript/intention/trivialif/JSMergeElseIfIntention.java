/*
 * Copyright 2005-2006 Olivier Descout
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
package org.intellij.idea.lang.javascript.intention.trivialif;

import com.intellij.lang.javascript.psi.JSBlockStatement;
import com.intellij.lang.javascript.psi.JSElement;
import com.intellij.lang.javascript.psi.JSIfStatement;
import com.intellij.lang.javascript.psi.JSStatement;
import consulo.annotation.component.ExtensionImpl;
import consulo.language.editor.intention.IntentionMetaData;
import consulo.language.psi.PsiElement;
import consulo.language.util.IncorrectOperationException;
import org.intellij.idea.lang.javascript.intention.JSElementPredicate;
import org.intellij.idea.lang.javascript.intention.JSIntention;
import org.intellij.idea.lang.javascript.intention.JSIntentionBundle;
import org.intellij.idea.lang.javascript.psiutil.ErrorUtil;
import org.intellij.idea.lang.javascript.psiutil.JSElementFactory;

import jakarta.annotation.Nonnull;

@ExtensionImpl
@IntentionMetaData(
	ignoreId = "JSMergeElseIfIntention",
	categories = {"JavaScript", "Control Flow"},
	fileExtensions = "js"
)
public class JSMergeElseIfIntention extends JSIntention
{
	@Override
	protected String getBasicText() {
		return JSIntentionBundle.message("trivialif.merge-else-if.display-name");
	}

	@Override
	@Nonnull
	public JSElementPredicate getElementPredicate()
	{
		return new MergeElseIfPredicate();
	}

	@Override
	public void processIntention(@Nonnull PsiElement element) throws IncorrectOperationException
	{
		final JSIfStatement parentStatement = (JSIfStatement) element.getParent();

		assert (parentStatement != null);

		final JSBlockStatement elseBranch = (JSBlockStatement) parentStatement.getElse();
		final JSStatement elseBranchContents = elseBranch.getStatements()[0];

		JSElementFactory.replaceStatement(elseBranch, elseBranchContents.getText());
	}

	private static class MergeElseIfPredicate implements JSElementPredicate
	{
		@Override
		public boolean satisfiedBy(@Nonnull PsiElement element)
		{
			return element instanceof JSElement
				&& element.getParent() instanceof JSIfStatement ifStatement
				&& !ErrorUtil.containsError(ifStatement)
				&& ifStatement.getThen() != null
				&& ifStatement.getElse() instanceof JSBlockStatement elseBlock
				&& isSingleIfStatement(elseBlock.getStatements());
		}

		private boolean isSingleIfStatement(JSStatement[] statements)
		{
			return statements.length == 1 && statements[0] instanceof JSIfStatement;
		}
	}
}