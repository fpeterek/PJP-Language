package org.fpeterek.pjp.error

import org.fpeterek.pjp.ast.nodes.AstNode

enum class ErrorCause {
    Left, Right;

    fun getCause(left: AstNode, right: AstNode) = when(this) {
        Left -> left
        Right -> right
    }
}
