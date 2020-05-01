package org.fpeterek.pjp.ast.nodes

import org.fpeterek.pjp.ast.DataType
import org.fpeterek.pjp.ast.NodeType

class Write(parent: AstNode, val args: List<AstNode>) : AstNode(NodeType.Write, DataType.Unit, parent) {

    init {
        args.forEach {
            if (it.dataType == DataType.Unit) {
                throw IllegalArgumentException("Argument of 'write' must return a value")
            }
        }
    }

}