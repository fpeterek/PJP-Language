package org.fpeterek.pjp.error

data class CompilerError(val msg: String, val row: Int, val col: Int)
