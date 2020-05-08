package org.fpeterek.pjp.error

class TypeErrorException(msg: String, val causingExpr: ErrorCause) : Exception(msg)
