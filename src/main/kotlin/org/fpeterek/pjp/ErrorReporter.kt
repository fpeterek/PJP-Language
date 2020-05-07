package org.fpeterek.pjp

object ErrorReporter {

    private val errors = mutableListOf<String>()

    val errorsDetected: Boolean
        get() = errors.isNotEmpty()

    val errorCount: Int
        get() = errors.size

    fun reset() = errors.clear()

    fun report(msg: String) = errors.add(msg)

}