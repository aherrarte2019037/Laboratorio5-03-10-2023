package com.group5.laboratorio5_03_10_2023.io

data class RequestAccessResponse(
    val token_type: String,
    val expires_in: Int,
    val access_token: String
)
