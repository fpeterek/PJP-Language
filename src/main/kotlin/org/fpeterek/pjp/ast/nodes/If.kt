package org.fpeterek.pjp.ast.nodes

import org.fpeterek.pjp.ast.DataType
import org.fpeterek.pjp.ast.NodeType

class If(parent: AstNode, val cond: Expression, val onTrue: AstNode, val onFalse: AstNode)
    : AstNode(NodeType.If, DataType.Unit, parent)