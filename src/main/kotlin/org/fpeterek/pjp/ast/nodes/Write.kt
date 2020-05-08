package org.fpeterek.pjp.ast.nodes

import org.fpeterek.pjp.ast.DataType
import org.fpeterek.pjp.ast.NodeType

class Write(parent: Block, val args: List<AstNode>, row: Int, col: Int)
    : AstNode(NodeType.Write, DataType.Unit, parent, row, col) {

    init {
        args.forEach {
            if (it.dataType == DataType.Unit) {
                // This should actually be checked during syntax analysis
                // I don't think it should ever throw, but it doesn't hurt to check
                throw IllegalArgumentException("Argument of 'write' must return a value")
            }
        }
    }

    override fun toString() = "write ${args.joinToString(", ")}"

}