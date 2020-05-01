package org.fpeterek.pjp.ast.nodes

import org.fpeterek.pjp.ast.DataType
import org.fpeterek.pjp.ast.NodeType

class BinaryOperator(parent: AstNode, type: DataType, nodeType: NodeType,
                     val operator: String, val left: Expression, val right: Expression)
    : Expression(parent, type, nodeType)
