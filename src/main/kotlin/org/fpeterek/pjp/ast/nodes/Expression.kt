package org.fpeterek.pjp.ast.nodes

import org.fpeterek.pjp.ast.DataType
import org.fpeterek.pjp.ast.NodeType

open class Expression(parent: Block, type: DataType, nodeType: NodeType, row: Int, col: Int)
    : AstNode(nodeType, type, parent, row, col)
