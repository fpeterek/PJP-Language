package org.fpeterek.pjp

import org.fpeterek.pjp.ast.DataType
import org.fpeterek.pjp.ast.nodes.Expression
import java.lang.Exception
import java.lang.IllegalArgumentException

object TypeChecker {

    private val numericTypes = listOf(DataType.Float, DataType.Int)

    private fun promotionPossible(left: DataType, right: DataType) =
        left != right && left in numericTypes && right in numericTypes

    fun mergeType(left: DataType, right: DataType) =
        when {
            DataType.Unit in listOf(left, right) ->
                throw IllegalArgumentException("Unexpected type: Unit")
            left == right -> left
            promotionPossible(left, right) -> DataType.Float
            else -> DataType.Unit
        }

    fun assignmentType(varType: DataType, rType: DataType) =
        when {
            varType == rType -> varType
            varType == DataType.Float && rType == DataType.Int -> DataType.Float
            else -> throw IllegalArgumentException(
                "Assignment of incompatible types ($varType, $rType)")
        }

    fun operatorType(left: DataType, right: DataType) =
        when {
            left == right -> left
            promotionPossible(left, right) -> DataType.Float
            else -> throw IllegalArgumentException(
                "Incompatible types ($left, $right)")
        }

    fun comparisonType(left: DataType, right: DataType): DataType {
        operatorType(left, right) // Check if types are compatible
        return DataType.Bool
    }

    fun isValidCondition(expr: Expression) {
        if (expr.dataType != DataType.Bool) {
            throw Exception("Condition must be of type bool")
        }
    }

    fun isNumeric(type: DataType) = type in numericTypes

}
