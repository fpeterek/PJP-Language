package org.fpeterek.pjp.ast

class Literal(parent: Node, nodeType: NodeType, type: DataType, val value: String)
    : Expression(parent, type, nodeType)
