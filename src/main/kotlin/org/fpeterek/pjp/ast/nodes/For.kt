package org.fpeterek.pjp.ast.nodes

import org.fpeterek.pjp.ast.DataType
import org.fpeterek.pjp.ast.NodeType

class For(parent: Block, val init: Expression, val cond: Expression, val increment: Expression,
          val body: AstNode?)
    : AstNode(NodeType.For, DataType.Unit, parent)
