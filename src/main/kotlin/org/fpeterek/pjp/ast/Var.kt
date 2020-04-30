package org.fpeterek.pjp.ast

class Var(parent: Node, val name: String, type: DataType)
    : Node(NodeType.Var, type, parent)