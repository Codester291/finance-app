package com.ai.doye.financeapp.dto

class ResponseDTO(val code: String, val message: String, val data: Any) {

    constructor(code: String, message: String): this(code, message, "")
}