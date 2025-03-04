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

import com.intellij.javascript.documentation.JSDocumentationUtils;
import com.intellij.lang.javascript.JSElementTypes;
import com.intellij.lang.javascript.JSTokenTypes;
import com.intellij.lang.javascript.psi.*;
import com.intellij.lang.javascript.psi.resolve.JSImportHandlingUtil;
import com.intellij.lang.javascript.psi.resolve.JSResolveUtil;
import com.intellij.lang.javascript.psi.stubs.JSFunctionStub;
import consulo.annotation.access.RequiredWriteAction;
import consulo.language.psi.PsiElement;
import consulo.language.psi.resolve.ResolveState;
import consulo.language.psi.resolve.PsiScopeProcessor;
import consulo.language.psi.stub.IStubElementType;
import consulo.language.util.IncorrectOperationException;
import consulo.annotation.access.RequiredReadAction;
import consulo.javascript.language.JavaScriptLanguage;
import consulo.javascript.lang.JavaScriptTokenSets;
import consulo.javascript.language.psi.JavaScriptType;
import consulo.javascript.language.psi.JavaScriptTypeElement;
import consulo.language.ast.ASTNode;

import jakarta.annotation.Nonnull;

/**
 * @author max
 * @since 2005-01-30
 */
abstract class JSFunctionBaseImpl<T extends JSFunctionStub, T2 extends JSFunction> extends JSStubElementImpl<T> implements JSFunction {
    private boolean referencesArgumentsCalculated;
    private boolean referencesArguments;

    public JSFunctionBaseImpl(ASTNode node) {
        super(node);
    }

    public JSFunctionBaseImpl(T stub, IStubElementType type) {
        super(stub, type);
    }

    @Override
    public void subtreeChanged() {
        super.subtreeChanged();
        referencesArgumentsCalculated = false;
        referencesArguments = false;
    }

    @RequiredReadAction
    @Override
    public JSParameterList getParameterList() {
        return getStubOrPsiChild(JSElementTypes.PARAMETER_LIST);
    }

    @Override
    @RequiredReadAction
    public JSSourceElement[] getBody() {
        ASTNode[] children = getNode().getChildren(JSElementTypes.SOURCE_ELEMENTS);
        if (children.length == 0) {
            return JSSourceElement.EMPTY_ARRAY;
        }
        JSSourceElement[] result = new JSSourceElement[children.length];
        for (int i = 0; i < children.length; i++) {
            result[i] = (JSSourceElement)children[i].getPsi();
        }
        return result;
    }

    @Nonnull
    @Override
    public JavaScriptType getReturnType() {
        return JavaScriptType.UNKNOWN;
    }

    @Override
    @RequiredReadAction
    public String getReturnTypeString() {
        T stub = getStub();
        if (stub != null) {
            return stub.getReturnTypeString();
        }
        return JSPsiImplUtils.getType(this);
    }

    @Override
    @RequiredReadAction
    public JavaScriptTypeElement getReturnTypeElement() {
        return JSPsiImplUtils.findTypeElement(this);
    }

    @Override
    @RequiredWriteAction
    public PsiElement setName(@Nonnull String name) throws IncorrectOperationException {
        ASTNode newNameElement = createNameIdentifier(name);
        ASTNode nameIdentifier = getNameIdentifier().getNode();
        nameIdentifier.getTreeParent().replaceChild(nameIdentifier, newNameElement);
        return this;
    }

    @RequiredReadAction
    protected ASTNode createNameIdentifier(String name) {
        return JSChangeUtil.createExpressionFromText(getProject(), name).getNode();
    }

    @Override
    @RequiredReadAction
    public String getName() {
        JSFunctionStub stub = getStub();
        if (stub != null) {
            return stub.getName();
        }
        PsiElement name = getNameIdentifier();

        if (name != null) {
            return name instanceof JSReferenceExpression nameRefExpr ? nameRefExpr.getReferencedName() : name.getText();
        }
        return null;
    }

    private static ASTNode advance(ASTNode astNode) {
        astNode = astNode != null ? astNode.getTreeNext() : null;

        if (astNode != null && astNode.getElementType() == JSTokenTypes.WHITE_SPACE) {
            astNode = astNode.getTreeNext();
        }
        return astNode;
    }

    @RequiredReadAction
    @Override
    public int getTextOffset() {
        PsiElement name = getNameIdentifier();
        return name != null ? name.getTextOffset() : super.getTextOffset();
    }

    @Override
    @RequiredReadAction
    public boolean processDeclarations(
        @Nonnull PsiScopeProcessor processor,
        @Nonnull ResolveState state,
        PsiElement lastParent,
        @Nonnull PsiElement place
    ) {
        if (lastParent != null && lastParent.getParent() == this) {
            if (place instanceof JSReferenceExpression referenceExpression) {
                boolean b = JSImportHandlingUtil.tryResolveImports(processor, this, place);
                if (!b || JSResolveUtil.isExprInStrictTypeContext(referenceExpression)) {
                    return b;
                }
            }

            JSParameter[] params = getParameterList().getParameters();
            for (JSParameter param : params) {
                if (!param.processDeclarations(processor, state, lastParent, place)) {
                    return false;
                }
            }

            boolean b = JSResolveUtil.processDeclarationsInScope(this, processor, state, lastParent, place);
            if (b) {
                processor.handleEvent(PsiScopeProcessor.Event.SET_DECLARATION_HOLDER, this);
            }
            return b;
        }

        return processor.execute(this, state);
    }

    @Override
    @RequiredWriteAction
    public PsiElement addBefore(@Nonnull PsiElement element, PsiElement anchor) throws IncorrectOperationException {
        if (anchor == getFirstChild() && element instanceof JSAttributeList attributeList
            && anchor.getNode().getElementType() == JSTokenTypes.FUNCTION_KEYWORD) {
            return JSChangeUtil.doDoAddBefore(this, attributeList, anchor);
        }
        return super.addBefore(element, anchor);
    }

    @Override
    public boolean isDeprecated() {
        T stub = getStub();
        return stub != null ? stub.isDeprecated() : JSDocumentationUtils.calculateDeprecated(this);
    }

    @Override
    @RequiredReadAction
    public boolean isReferencesArguments() {
        T stub = getStub();
        if (stub != null) {
            return stub.isReferencesArguments();
        }

        if (!referencesArgumentsCalculated) {
            acceptChildren(new JSElementVisitor() {
                boolean continueVisiting = true;

                @Override
                @RequiredReadAction
                public void visitJSReferenceExpression(JSReferenceExpression node) {
                    if (isInJS(node) && node.getQualifier() == null && "arguments".equals(node.getText())) {
                        referencesArguments = true;
                        continueVisiting = false;
                        return;
                    }
                    super.visitJSReferenceExpression(node);
                }

                @Override
                public void visitJSElement(JSElement node) {
                    if (continueVisiting) {
                        node.acceptChildren(this);
                    }
                }
            });

            referencesArgumentsCalculated = true;
        }

        return referencesArguments;
    }

    @RequiredReadAction
    private static boolean isInJS(JSReferenceExpression node) {
        PsiElement parent = node.getParent();
        return parent == null || parent.getLanguage() instanceof JavaScriptLanguage;
    }

    @Override
    @RequiredReadAction
    public PsiElement getNameIdentifier() {
        return findChildByType(JavaScriptTokenSets.NAME_TOKEN_TYPES);
    }
}
