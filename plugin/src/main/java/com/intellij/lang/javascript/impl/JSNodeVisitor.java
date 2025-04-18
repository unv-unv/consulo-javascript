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

package com.intellij.lang.javascript.impl;

import com.intellij.lang.javascript.JSElementTypes;
import com.intellij.lang.javascript.JSTokenTypes;
import consulo.language.ast.ASTNode;
import com.intellij.lang.javascript.types.JSFileElementType;
import consulo.language.ast.IElementType;

/**
 * @author max
 * @since 2005-02-01
 */
public abstract class JSNodeVisitor {
    public final void visit(ASTNode node) {
        IElementType type = node.getElementType();
        if (type instanceof JSFileElementType) {
            visitFile(node);
        }
        else if (type == JSElementTypes.FUNCTION_DECLARATION) {
            visitFunctionDeclaration(node);
        }
        else if (type == JSElementTypes.PARAMETER_LIST) {
            visitParameterList(node);
        }
        else if (type == JSElementTypes.VARIABLE) {
            visitVariable(node);
        }
        else if (type == JSElementTypes.FORMAL_PARAMETER) {
            visitParameter(node);
        }
        else if (type == JSElementTypes.ARGUMENT_LIST) {
            visitArgumentList(node);
        }
        else if (type == JSElementTypes.BLOCK_STATEMENT) {
            visitBlock(node);
        }
        else if (type == JSElementTypes.LABELED_STATEMENT) {
            visitLabeledStatement(node);
        }
        else if (type == JSElementTypes.EXPRESSION_STATEMENT) {
            visitExpressionStatement(node);
        }
        else if (type == JSElementTypes.VAR_STATEMENT) {
            visitVarStatement(node);
        }
        else if (type == JSElementTypes.EMPTY_STATEMENT) {
            visitEmptyStatement(node);
        }
        else if (type == JSElementTypes.IF_STATEMENT) {
            visitIfStatement(node);
        }
        else if (type == JSElementTypes.CONTINUE_STATEMENT) {
            visitContinueStatement(node);
        }
        else if (type == JSElementTypes.BREAK_STATEMENT) {
            visitBreakStatement(node);
        }
        else if (type == JSElementTypes.WITH_STATEMENT) {
            visitWithStatement(node);
        }
        else if (type == JSElementTypes.RETURN_STATEMENT) {
            visitReturnStatement(node);
        }
        else if (type == JSElementTypes.THROW_STATEMENT) {
            visitThrowStatement(node);
        }
        else if (type == JSElementTypes.TRY_STATEMENT) {
            visitTryStatement(node);
        }
        else if (type == JSElementTypes.CATCH_BLOCK) {
            visitCatchBlock(node);
        }
        else if (type == JSElementTypes.SWITCH_STATEMENT) {
            visitSwitchStatement(node);
        }
        else if (type == JSElementTypes.CASE_CLAUSE) {
            visitCaseClause(node);
        }
        else if (type == JSElementTypes.WHILE_STATEMENT) {
            visitWhileStatement(node);
        }
        else if (type == JSElementTypes.DOWHILE_STATEMENT) {
            visitDoWhileStatement(node);
        }
        else if (type == JSElementTypes.FOR_STATEMENT) {
            visitForStatement(node);
        }
        else if (type == JSElementTypes.FOR_IN_STATEMENT) {
            visitForInStatement(node);
        }
        else if (type == JSElementTypes.THIS_EXPRESSION) {
            visitThisExpression(node);
        }
        else if (type == JSElementTypes.LITERAL_EXPRESSION) {
            visitLiteralExpression(node);
        }
        else if (type == JSElementTypes.REGEXP_LITERAL_EXPRESSION) {
            visitLiteralExpression(node);
        }
        else if (type == JSElementTypes.REFERENCE_EXPRESSION) {
            visitReferenceExpression(node);
        }
        else if (type == JSElementTypes.PARENTHESIZED_EXPRESSION) {
            visitParenthesizedExpression(node);
        }
        else if (type == JSElementTypes.ARRAY_LITERAL_EXPRESSION) {
            visitArrayLiteralExpression(node);
        }
        else if (type == JSElementTypes.OBJECT_LITERAL_EXPRESSION) {
            visitObjectLiteralExpression(node);
        }
        else if (type == JSElementTypes.PROPERTY) {
            visitProperty(node);
        }
        else if (type == JSElementTypes.BINARY_EXPRESSION) {
            visitBinaryExpression(node);
        }
        else if (type == JSElementTypes.ASSIGNMENT_EXPRESSION) {
            visitAssignmentExpression(node);
        }
        else if (type == JSElementTypes.COMMA_EXPRESSION) {
            visitCommaExpression(node);
        }
        else if (type == JSElementTypes.CONDITIONAL_EXPRESSION) {
            visitConditionalExpression(node);
        }
        else if (type == JSElementTypes.POSTFIX_EXPRESSION) {
            visitPostfixExpression(node);
        }
        else if (type == JSElementTypes.PREFIX_EXPRESSION) {
            visitPrefixExpression(node);
        }
        else if (type == JSElementTypes.FUNCTION_EXPRESSION) {
            visitFunctionExpression(node);
        }
        else if (type == JSElementTypes.NEW_EXPRESSION) {
            visitNewExpression(node);
        }
        else if (type == JSElementTypes.INDEXED_PROPERTY_ACCESS_EXPRESSION) {
            visitIndexedPropertyAccessExpression(node);
        }
        else if (type == JSElementTypes.ATTRIBUTE_LIST) {
            visitAttributeList(node);
        }
        else if (type == JSElementTypes.CALL_EXPRESSION) {
            visitCallExpression(node);
        }
        else if (type == JSTokenTypes.C_STYLE_COMMENT) {
            visitComment(node);
        }
        else if (type == JSTokenTypes.DOC_COMMENT) {
            visitDocComment(node);
        }
        else if (type == JSElementTypes.EMBEDDED_CONTENT) {
            visitEmbeddedContent(node);
        }
        else if (type == JSElementTypes.PACKAGE_STATEMENT) {
            visitPackageStatement(node);
        }
        else if (type == JSElementTypes.CLASS) {
            visitClass(node);
        }
        else if (type == JSElementTypes.XML_LITERAL_EXPRESSION) {
            visitXmlLiteralExpression(node);
        }
        else {
            visitElement(node);
        }
    }

    public void visitXmlLiteralExpression(ASTNode node) {
        visitExpression(node);
    }

    public void visitAttributeList(ASTNode node) {
        visitElement(node);
    }

    public void visitPackageStatement(ASTNode node) {
        visitElement(node);
    }

    public void visitClass(ASTNode node) {
        visitElement(node);
    }

    public void visitFile(ASTNode node) {
        visitElement(node);
    }

    public void visitCallExpression(ASTNode node) {
        visitExpression(node);
    }

    public void visitIndexedPropertyAccessExpression(ASTNode node) {
        visitExpression(node);
    }

    public void visitNewExpression(ASTNode node) {
        visitExpression(node);
    }

    public void visitFunctionExpression(ASTNode node) {
        visitExpression(node);
    }

    public void visitPrefixExpression(ASTNode node) {
        visitExpression(node);
    }

    public void visitPostfixExpression(ASTNode node) {
        visitExpression(node);
    }

    public void visitConditionalExpression(ASTNode node) {
        visitExpression(node);
    }

    public void visitCommaExpression(ASTNode node) {
        visitBinaryExpression(node);
    }

    public void visitAssignmentExpression(ASTNode node) {
        visitBinaryExpression(node);
    }

    public void visitBinaryExpression(ASTNode node) {
        visitExpression(node);
    }

    public void visitProperty(ASTNode node) {
        visitElement(node);
    }

    public void visitObjectLiteralExpression(ASTNode node) {
        visitExpression(node);
    }

    public void visitArrayLiteralExpression(ASTNode node) {
        visitExpression(node);
    }

    public void visitParenthesizedExpression(ASTNode node) {
        visitExpression(node);
    }

    public void visitReferenceExpression(ASTNode node) {
        visitExpression(node);
    }

    public void visitLiteralExpression(ASTNode node) {
        visitExpression(node);
    }

    public void visitThisExpression(ASTNode node) {
        visitExpression(node);
    }

    public void visitForInStatement(ASTNode node) {
        visitStatement(node);
    }

    public void visitForStatement(ASTNode node) {
        visitStatement(node);
    }

    public void visitDoWhileStatement(ASTNode node) {
        visitStatement(node);
    }

    public void visitWhileStatement(ASTNode node) {
        visitStatement(node);
    }

    public void visitCaseClause(ASTNode node) {
        visitElement(node);
    }

    public void visitSwitchStatement(ASTNode node) {
        visitStatement(node);
    }

    public void visitCatchBlock(ASTNode node) {
        visitElement(node);
    }

    public void visitTryStatement(ASTNode node) {
        visitStatement(node);
    }

    public void visitThrowStatement(ASTNode node) {
        visitStatement(node);
    }

    public void visitReturnStatement(ASTNode node) {
        visitStatement(node);
    }

    public void visitWithStatement(ASTNode node) {
        visitStatement(node);
    }

    public void visitBreakStatement(ASTNode node) {
        visitStatement(node);
    }

    public void visitContinueStatement(ASTNode node) {
        visitStatement(node);
    }

    public void visitIfStatement(ASTNode node) {
        visitStatement(node);
    }

    public void visitEmptyStatement(ASTNode node) {
        visitStatement(node);
    }

    public void visitVarStatement(ASTNode node) {
        visitStatement(node);
    }

    public void visitExpressionStatement(ASTNode node) {
        visitStatement(node);
    }

    public void visitLabeledStatement(ASTNode node) {
        visitStatement(node);
    }

    public void visitBlock(ASTNode node) {
        visitStatement(node);
    }

    public void visitArgumentList(ASTNode node) {
        visitElement(node);
    }

    public void visitParameter(ASTNode node) {
        visitVariable(node);
    }

    public void visitVariable(ASTNode node) {
        visitElement(node);
    }

    public void visitParameterList(ASTNode node) {
        visitElement(node);
    }

    public void visitEmbeddedContent(ASTNode node) {
        visitElement(node);
    }

    public void visitElement(ASTNode node) {
    }

    public void visitSourceElement(ASTNode node) {
        visitElement(node);
    }

    public void visitFunctionDeclaration(ASTNode node) {
        visitSourceElement(node);
    }

    public void visitStatement(ASTNode node) {
        visitSourceElement(node);
    }

    public void visitExpression(ASTNode node) {
        visitElement(node);
    }

    public void visitDocComment(ASTNode node) {
        visitElement(node);
    }

    public void visitComment(ASTNode node) {
        visitElement(node);
    }
}
