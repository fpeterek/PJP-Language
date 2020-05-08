package org.fpeterek.pjp.error

object ErrorReporter {

    private val errorList = mutableListOf<CompilerError>()

    val errors: List<CompilerError>
        get() = errorList

    val errorsDetected: Boolean
        get() = errorList.isNotEmpty()

    val errorCount: Int
        get() = errorList.size

    fun reset() = errorList.clear()

    private fun formatMsg(msg: String, row: Int, col: Int) = "Error: $msg (row: $row, column: $col)"
    private fun createError(msg: String, row: Int, col: Int) = CompilerError(formatMsg(msg, row, col), row, col)

    fun report(msg: String, row: Int, col: Int) = errorList.add(createError(msg, row, col))

}