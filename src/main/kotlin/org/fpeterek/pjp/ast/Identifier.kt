package org.fpeterek.pjp.ast

class Identifier(type: DataType, val name: String, parent: Node)
    : Node(NodeType.Identifier, type, parent) {
}