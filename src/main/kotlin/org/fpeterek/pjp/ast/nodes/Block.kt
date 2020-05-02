package org.fpeterek.pjp.ast.nodes

import org.fpeterek.pjp.ast.DataType
import org.fpeterek.pjp.ast.NodeType
import java.lang.Exception

class Block(parent: Block?) : AstNode(NodeType.Block, DataType.Unit, parent) {

    private val subnodes = mutableListOf<AstNode>()
    private val scopeVariables = mutableMapOf<String, DataType>()

    val nodes: List<AstNode>
        get() = subnodes


    fun addNode(node: AstNode) {
        if (node.nodeType == NodeType.Var) {
            node as Var
            if (getVarType(node.name) != null) {
                throw Exception("Redefinition of variable '${node.name}'")
            }
            scopeVariables[node.name] = node.dataType
        }
        subnodes.add(node)
    }

    fun getVarType(id: String): DataType? =
        scopeVariables.getOrDefault(id, null) ?: parent?.getVarType(id)

    override fun toString() =
        "{${nodes.joinToString(";\n    ", prefix = "\n    ", postfix = ";\n")}}"

    fun toString(indent: Int): String {

        val sb = StringBuilder()

        sb.append(" ".repeat(indent)).append("{\n")

        subnodes.forEach {

            if (it is Block) {
                sb.append(it.toString(indent+4))
            } else if (it is For) {
                sb.append(it.toString(indent+4))
            } else if (it is If) {
                sb.append(it.toString(indent+4))
            } else {
                sb.append(" ".repeat(indent+4)).append(it).append(";\n")
            }

        }

        sb.append(" ".repeat(indent)).append("}\n")

        return sb.toString()

    }

}