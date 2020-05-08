package org.fpeterek.pjp

object ErrorReporter {

    private val errorList = mutableListOf<String>()

    val errors: List<String>
        get() = errorList

    val errorsDetected: Boolean
        get() = errorList.isNotEmpty()

    val errorCount: Int
        get() = errorList.size

    fun reset() = errorList.clear()

    fun report(msg: String) = errorList.add(msg)

}