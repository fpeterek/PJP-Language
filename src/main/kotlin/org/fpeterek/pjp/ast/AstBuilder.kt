package org.fpeterek.pjp.ast

import org.fpeterek.pjp.ErrorReporter
import org.fpeterek.pjp.TypeChecker
import org.fpeterek.pjp.ast.nodes.*
import org.fpeterek.pjp.generated.*
import java.lang.Exception

class AstBuilder {

    private val root = Block(null, 1, 1)
    private var current = root

    private fun enterScope(new: Block) {
        current = new
    }

    private fun leaveScope() {
        current = current.parent ?: root
    }

    private fun operatorTypeCheck(node: SimpleNode) =
        when (node) {
            is ASTAssignment -> TypeChecker::assignmentType
            is ASTCmp -> TypeChecker::comparisonType
            else -> TypeChecker::operatorType
        }

    private fun error(msg: String, row: Int, col: Int): Error {
        ErrorReporter.report("$msg (row: $row, column: $col)")
        return Error(current, row, col)
    }

    private fun binaryOperator(node: SimpleNode): BinaryOperator {

        val lChild = node.jjtGetChild(0) as SimpleNode
        val rChild = node.jjtGetChild(1) as SimpleNode

        val left = parseNode(lChild) as? Expression
            ?: error("Expression expected", lChild.line, lChild.column)
        val right = parseNode(rChild) as? Expression
            ?: error("Expression expected", lChild.line, lChild.column)
        val op = node.jjtGetValue() as String

        val typeCheck = operatorTypeCheck(node)

        return BinaryOperator(current, typeCheck(left.dataType, right.dataType),
            NodeType.Expression, op, left, right, node.line, node.column)
    }

    private fun ternaryOperator(node: SimpleNode): TernaryOperator {

        val cChild = node.jjtGetChild(0) as SimpleNode
        val tChild = node.jjtGetChild(1) as SimpleNode
        val fChild = node.jjtGetChild(2) as SimpleNode

        val cond = parseNode(cChild) as? Expression
            ?: throw Exception("Expression expected, row: ${cChild.line}, column: ${cChild.column}")
        val ifTrue = parseNode(tChild) as? Expression
            ?: throw Exception("Expression expected, row: ${tChild.line}, column: ${tChild.column}")
        val ifFalse = parseNode(fChild) as? Expression
            ?: throw Exception("Expression expected, row: ${fChild.line}, column: ${fChild.column}")

        val type = TypeChecker.operatorType(ifTrue.dataType, ifFalse.dataType)

        TypeChecker.isValidCondition(cond)

        return TernaryOperator(current, type, NodeType.Expression, cond,
            ifTrue, ifFalse, node.line, node.column)
    }

    private fun literal(node: SimpleNode): Literal {
        val value = node.jjtGetValue() as String
        val type = when (node) {
            is ASTIntLiteral -> DataType.Int
            is ASTStringLiteral -> DataType.String
            is ASTBoolLiteral -> DataType.Bool
            else -> DataType.Float
        }
        return Literal(current, type, value, node.line, node.column)
    }

    private fun identifier(node: SimpleNode): Identifier {
        val id = node.jjtGetValue() as String

        val type = current.getVarType(id) ?:
            throw Exception("Unresolved identifier '$id' on line ${node.line}, column ${node.column}")

        return Identifier(current, type, id, node.line, node.column)
    }

    private fun unaryOperator(node: SimpleNode): UnaryOperator {
        val value = parseNode(node.jjtGetChild(0)) as Expression
        val op = node.jjtGetValue() as String

        val type = when {
            op == "!" -> {
                TypeChecker.isValidCondition(value)
                DataType.Bool
            }
            TypeChecker.isNumeric(value.dataType) -> value.dataType
            else -> throw Exception(
                "Operator$op argument has invalid type (${value.dataType}), row: ${value.row}, column: ${value.column}")
        }

        return UnaryOperator(current, type, NodeType.Expression, op, value, node.line, node.column)
    }

    private fun variable(node: SimpleNode): Var {

        val type = DataType.fromString(node.jjtGetValue() as String)
        val variables = (0 until node.jjtGetNumChildren()).map {
            (node.jjtGetChild(it) as SimpleNode).jjtGetValue() as String
        }.map {
            Var(current, it, type, node.line, node.column)
        }

        /* Little bit of a hack */
        /* We need to return a valid node from this function                   */
        /* This node will then be added to the current block                   */
        /* We can't obviously return a list of variables as that would only    */
        /* complicate the code more                                            */
        /* If we add all variables to the current block, and return a variable */
        /* from the list, we will get a redefinition error                     */
        /* All but the last variable are added to the scope here, the last one */
        /* is returned and emplaced elsewhere                                  */
        variables.dropLast(1).forEach { current.addNode(it) }

        return variables.last()
    }

    private fun write(node: SimpleNode): Write {
        val exprs = (0 until node.jjtGetNumChildren()).map {
            parseNode(node.jjtGetChild(it))
        }
        return Write(current, exprs, node.line, node.column)
    }

    private fun read(node: SimpleNode): Read {
        val ids = (0 until node.jjtGetNumChildren()).map {
            parseNode(node.jjtGetChild(it)) as Identifier
        }
        return Read(current, ids, node.line, node.column)
    }

    private fun forLoop(node: SimpleNode): For {
        val init = parseNode(node.jjtGetChild(0)) as Expression
        val cond = parseNode(node.jjtGetChild(1)) as Expression
        val increment = parseNode(node.jjtGetChild(2)) as Expression

        val body = if (node.jjtGetNumChildren() == 4) {
            parseNode(node.jjtGetChild(3))
        } else {
            null
        }

        if (cond.dataType != DataType.Bool) {
            throw Exception("Loop condition must be of type 'bool', row: ${cond.row}, column: ${cond.column}")
        }

        return For(current, init, cond, increment, body, node.line, node.column)
    }

    private fun ifStatement(node: SimpleNode): If {
        val cond = parseNode(node.jjtGetChild(0)) as Expression
        val onTrue = if (node.jjtGetNumChildren() >= 2) {
            parseNode(node.jjtGetChild(1))
        } else {
            null
        }
        val onFalse = if (node.jjtGetNumChildren() >= 3) {
            parseNode(node.jjtGetChild(2))
        } else {
            null
        }

        return If(current, cond, onTrue, onFalse, node.line, node.column)
    }

    private fun block(node: SimpleNode): Block {
        val b = Block(current, node.line, node.column)
        enterScope(b)
        (0 until node.jjtGetNumChildren()).forEach {
            b.addNode(parseNode(node.jjtGetChild(it)))
        }
        leaveScope()
        return b
    }

    private fun isBinaryOperator(node: Node) =
        node is ASTAdd || node is ASTAssignment || node is ASTCmp || node is ASTMult ||
        node is ASTOr || node is ASTAnd

    private fun isLiteral(node: Node) =
        node is ASTIntLiteral || node is ASTFloatLiteral || node is ASTBoolLiteral ||
        node is ASTStringLiteral

    private fun parseNode(node: Node): AstNode = when {
        isBinaryOperator(node) -> binaryOperator(node as SimpleNode)
        isLiteral(node) -> literal(node as SimpleNode)
        node is ASTTernary -> ternaryOperator(node)
        node is ASTUnaryOp -> unaryOperator(node)
        node is ASTIdentifier -> identifier(node)
        node is ASTVar -> variable(node)
        node is ASTWrite -> write(node)
        node is ASTRead -> read(node)
        node is ASTFor -> forLoop(node)
        node is ASTIf -> ifStatement(node)
        node is ASTBlock -> block(node)
        else -> root
    }

    fun build(start: ASTStart): Block {

        (0 until start.jjtGetNumChildren()).forEach {
            root.addNode(parseNode(start.jjtGetChild(it)))
        }

        return root
    }

}