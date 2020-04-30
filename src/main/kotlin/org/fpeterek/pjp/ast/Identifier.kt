package org.fpeterek.pjp.ast

class Identifier(type: DataType, val name: String, parent: Node)
    : Expression(parent, type, NodeType.Identifier)