package org.fpeterek.pjp.ast.nodes

import org.fpeterek.pjp.ast.DataType
import org.fpeterek.pjp.ast.NodeType

class For(parent: AstNode, val init: AstNode?, val cond: Expression, val increment: AstNode?,
          val body: AstNode)
    : AstNode(NodeType.For, DataType.Unit, parent)
