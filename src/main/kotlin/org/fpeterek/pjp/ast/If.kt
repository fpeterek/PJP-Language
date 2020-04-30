package org.fpeterek.pjp.ast

class If(parent: Node, val cond: Expression, val onTrue: Node, val onFalse: Node)
    : Node(NodeType.If, DataType.Unit, parent)