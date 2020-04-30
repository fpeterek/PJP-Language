package org.fpeterek.pjp.ast

class Write(parent: Node, val args: List<Node>) : Node(NodeType.Write, DataType.Unit, parent) {

    init {
        args.forEach {
            if (it.dataType == DataType.Unit) {
                throw IllegalArgumentException("Argument of 'write' must return a value")
            }
        }
    }

}