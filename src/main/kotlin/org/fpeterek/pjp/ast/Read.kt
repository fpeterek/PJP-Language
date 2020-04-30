package org.fpeterek.pjp.ast

class Read(parent: Node, val args: List<Identifier>)
    : Node(NodeType.Read, DataType.Unit, parent)