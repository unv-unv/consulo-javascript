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

package com.intellij.lang.javascript.psi.impl;

import com.intellij.lang.javascript.psi.JSBlockStatement;
import com.intellij.lang.javascript.psi.JSElementVisitor;
import com.intellij.lang.javascript.psi.JSExpression;
import com.intellij.lang.javascript.psi.JSLetStatement;
import consulo.language.ast.ASTNode;

import jakarta.annotation.Nonnull;

/**
 * @author maxim
 */
public class JSLetStatementImpl extends JSStatementImpl implements JSLetStatement {
    public JSLetStatementImpl(ASTNode node) {
        super(node);
    }

    @Override
    protected void accept(@Nonnull JSElementVisitor visitor) {
        visitor.visitJSLetStatement(this);
    }

    @Override
    public JSExpression[] getExpressions() {
        return findChildrenByClass(JSExpression.class);
    }

    @Override
    public JSBlockStatement getBody() {
        return findChildByClass(JSBlockStatement.class);
    }
}