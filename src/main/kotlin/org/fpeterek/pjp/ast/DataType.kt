package org.fpeterek.pjp.ast

import java.lang.IllegalArgumentException

enum class DataType(val value: kotlin.String) {
    Int("int"),
    Float("float"),
    Bool("boolean"),
    String("String"),
    Unit("Unit");

    companion object {
        fun fromString(str: kotlin.String) = when (str) {
            Int.value -> Int
            Float.value -> Float
            Bool.value -> Bool
            String.value -> String
            Unit.value -> Unit
            else -> throw IllegalArgumentException("No such enum value: '$str'")
        }
    }

}
