package org.fpeterek.pjp

import org.fpeterek.pjp.ast.DataType
import org.fpeterek.pjp.ast.nodes.Expression

object TypeChecker {

    private val numericTypes = listOf(DataType.Float, DataType.Int)

    private fun promotionPossible(left: DataType, right: DataType) =
        left != right && left in numericTypes && right in numericTypes

    private fun assignmentType(varType: DataType, lType: DataType) = when {
        varType == lType -> varType
        varType == DataType.Float && lType == DataType.Int -> DataType.Float
        else -> throw TypeErrorException(
            "Assignment of incompatible types ($lType <- $varType)")
    }

    private fun comparisonOp(left: DataType, right: DataType) = when {
        left == right -> DataType.Bool
        promotionPossible(left, right) -> DataType.Bool
        else -> throw TypeErrorException(
            "Types '$left', '$right' cannot be compared directly")
    }

    private fun arithmeticOp(left: DataType, right: DataType) = when {
        !isNumeric(left) || !isNumeric(right) -> throw TypeErrorException(
            "Argument of an arithmetic operator must be a numeric type")
        left == right -> left
        promotionPossible(left, right) -> DataType.Float
        else -> throw TypeErrorException("Incompatible types ($left, $right)")
    }

    private fun modOp(left: DataType, right: DataType) = when {
        left == right && left == DataType.Int -> DataType.Int
        else -> throw TypeErrorException("Modulo can only be applied on integral types")
    }

    private fun catOp(left: DataType, right: DataType) = when {
        left == DataType.String && right == DataType.String -> DataType.String
        else -> throw TypeErrorException("Only strings can be concatenated")
    }

    private fun logicalOp(left: DataType, right: DataType) = when {
        left == right && left == DataType.Bool -> DataType.Bool
        else -> throw TypeErrorException(
            "Arguments of logical operators must be of type bool")
    }

    fun binaryOp(left: DataType, right: DataType, op: String) = when(op) {
        "+", "-", "*", "/" -> arithmeticOp(left, right)
        "%" -> modOp(left, right)
        "&&", "||" -> logicalOp(left, right)
        "." -> catOp(left, right)
        "==", "!=", ">", "<", "<=", ">=" -> comparisonOp(left, right)
        "=" -> assignmentType(left, right)
        else -> throw TypeErrorException("Invalid operator $op")
    }

    fun isValidCondition(expr: Expression) {
        if (expr.dataType != DataType.Bool) {
            throw TypeErrorException("Condition must be of type bool")
        }
    }

    private fun logicalNeg(type: DataType) = when(type) {
        DataType.Bool -> DataType.Bool
        else -> throw TypeErrorException(
            "Argument of logical negation must be of type bool")
    }

    private fun arithmeticNeg(type: DataType) = when {
        isNumeric(type) -> type
        else -> throw TypeErrorException(
            "Argument of arithmetic negation must be of a numeric type")
    }

    fun unaryOp(type: DataType, op: String) = when(op) {
        "!" -> logicalNeg(type)
        "-" -> arithmeticNeg(type)
        else -> throw TypeErrorException("$op cannot be used as a unary operator")
    }

    fun ternaryType(left: DataType, right: DataType) = when {
        left == right -> left
        promotionPossible(left, right) -> DataType.Float
        else -> throw TypeErrorException("Incompatible types ($left, $right)")
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
