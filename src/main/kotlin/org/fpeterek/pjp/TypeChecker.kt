package org.fpeterek.pjp

import org.fpeterek.pjp.ast.DataType
import org.fpeterek.pjp.ast.nodes.Expression
import org.fpeterek.pjp.error.ErrorCause
import org.fpeterek.pjp.error.TypeErrorException
import java.lang.Exception

object TypeChecker {

    private val numericTypes = listOf(DataType.Float, DataType.Int)

    private fun promotionPossible(left: DataType, right: DataType) =
        left != right && left in numericTypes && right in numericTypes

    private fun assignmentType(varType: DataType, lType: DataType) = when {
        varType == lType -> varType
        varType == DataType.Float && lType == DataType.Int -> DataType.Float
        varType == DataType.TypeError -> throw TypeErrorException(
            "Assignment of incompatible types ($lType <- $varType)", ErrorCause.Left)
        else -> throw TypeErrorException(
            "Assignment of incompatible types ($lType <- $varType)", ErrorCause.Right)
    }

    private fun comparisonOp(left: DataType, right: DataType) = when {
        left == right -> DataType.Bool
        promotionPossible(left, right) -> DataType.Bool
        else -> throw TypeErrorException(
            "Types '$left', '$right' cannot be compared directly", ErrorCause.Left)
    }

    private fun arithmeticOp(left: DataType, right: DataType) = when {
        !isNumeric(left) -> throw TypeErrorException(
            "Argument of an arithmetic operator must be a numeric type", ErrorCause.Left)
        !isNumeric(right) -> throw TypeErrorException(
            "Argument of an arithmetic operator must be a numeric type", ErrorCause.Right)
        left == right -> left
        else -> DataType.Float
    }

    private fun modOp(left: DataType, right: DataType) = when {
        left != DataType.Int -> throw TypeErrorException(
            "Modulo can only be applied on integral types", ErrorCause.Left)
        right != DataType.Int -> throw TypeErrorException(
            "Modulo can only be applied on integral types", ErrorCause.Right)
        else -> DataType.Int
    }

    private fun catOp(left: DataType, right: DataType) = when {
        left != DataType.String -> throw TypeErrorException("Only strings can be concatenated", ErrorCause.Left)
        right != DataType.String -> throw TypeErrorException("Only strings can be concatenated", ErrorCause.Right)
        else -> DataType.String
    }

    private fun logicalOp(left: DataType, right: DataType) = when {
        left != DataType.Bool -> throw TypeErrorException(
            "Arguments of logical operators must be of type bool", ErrorCause.Left)
        right != DataType.Bool -> throw TypeErrorException(
            "Arguments of logical operators must be of type bool", ErrorCause.Right)
        else -> DataType.Bool
    }

    fun binaryOp(left: DataType, right: DataType, op: String) = when(op) {
        "+", "-", "*", "/" -> arithmeticOp(left, right)
        "%" -> modOp(left, right)
        "&&", "||" -> logicalOp(left, right)
        "." -> catOp(left, right)
        "==", "!=", ">", "<", "<=", ">=" -> comparisonOp(left, right)
        "=" -> assignmentType(left, right)
        else -> throw Exception("Invalid operator $op")
    }

    fun isValidCondition(expr: Expression) {
        if (expr.dataType != DataType.Bool) {
            throw TypeErrorException("Condition must be of type bool", ErrorCause.Left)
        }
    }

    private fun logicalNeg(type: DataType) = when(type) {
        DataType.Bool -> DataType.Bool
        else -> throw TypeErrorException(
            "Argument of logical negation must be of type bool", ErrorCause.Left)
    }

    private fun arithmeticNeg(type: DataType) = when {
        isNumeric(type) -> type
        else -> throw TypeErrorException(
            "Argument of arithmetic negation must be of a numeric type", ErrorCause.Left)
    }

    fun unaryOp(type: DataType, op: String) = when(op) {
        "!" -> logicalNeg(type)
        "-" -> arithmeticNeg(type)
        else -> throw Exception("$op cannot be used as a unary operator")
    }

    fun ternaryType(left: DataType, right: DataType) = when {
        left == right -> left
        promotionPossible(left, right) -> DataType.Float
        left == DataType.TypeError -> throw TypeErrorException("Incompatible types ($left, $right)", ErrorCause.Left)
        right == DataType.TypeError -> throw TypeErrorException("Incompatible types ($left, $right)", ErrorCause.Right)
        else -> throw TypeErrorException("Incompatible types ($left, $right)", ErrorCause.Left)
    }

    fun attemptTernaryRecovery(left: DataType, right: DataType) = when {
        left == DataType.TypeError -> right
        right == DataType.TypeError -> left
        else -> DataType.TypeError
    }

    fun isNumeric(type: DataType) = type in numericTypes

    private fun assignRecovery(left: DataType, right: DataType) = when {
        left != DataType.TypeError -> left
        else -> right
    }

    private fun arithmeticRecovery(left: DataType, right: DataType) = when {
        left == DataType.Float || right == DataType.Float -> DataType.Float
        left == DataType.Int || right == DataType.Int -> DataType.Int
        else -> DataType.TypeError
    }

    fun attemptBinaryRecovery(left: DataType, right: DataType, op: String) = when(op) {
        "==", "!=", ">", "<", "<=", ">=" -> DataType.Bool
        "||", "&&" -> DataType.Bool
        "%" -> DataType.Int
        "." -> DataType.String
        "=" -> assignRecovery(left, right)
        "+", "-", "*", "/" -> arithmeticRecovery(left, right)
        else -> DataType.TypeError
    }

    fun attemptUnaryRecovery(op: String) = when(op) {
        "!" -> DataType.Bool
        /* Unary- always has to return a numeric type (Int, Float)       */
        /* Of those two types, Int is safer as it can always be promoted */
        "-" -> DataType.Int
        else -> DataType.TypeError
    }



}
