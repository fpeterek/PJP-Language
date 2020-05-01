package org.fpeterek.pjp.ast.nodes

import org.fpeterek.pjp.ast.DataType
import org.fpeterek.pjp.ast.NodeType

class TernaryOperator(parent: AstNode, type: DataType, nodeType: NodeType,
                      val cond: Expression, val onTrue: Expression, val onFalse: Expression)
    : Expression(parent, type, nodeType)
