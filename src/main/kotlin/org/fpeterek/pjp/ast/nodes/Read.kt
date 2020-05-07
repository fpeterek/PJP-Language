package org.fpeterek.pjp.ast.nodes

import org.fpeterek.pjp.ast.DataType
import org.fpeterek.pjp.ast.NodeType

class Read(parent: Block, val args: List<Identifier>, row: Int, col: Int)
    : AstNode(NodeType.Read, DataType.Unit, parent, row, col) {

    override fun toString() = "read ${args.joinToString(", ")}"

}