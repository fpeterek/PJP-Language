package org.fpeterek.pjp.ast.nodes

import org.fpeterek.pjp.ast.DataType
import org.fpeterek.pjp.ast.NodeType

class Write(parent: Block, val args: List<AstNode>, row: Int, col: Int)
    : AstNode(NodeType.Write, DataType.Unit, parent, row, col) {

    init {
        args.forEach {
            if (it.dataType == DataType.Unit) {
                throw IllegalArgumentException("Argument of 'write' must return a value")
            }
        }
    }

    override fun toString() = "write ${args.joinToString(", ")}"

}