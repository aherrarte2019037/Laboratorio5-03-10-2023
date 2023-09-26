package com.group5.laboratorio5_03_10_2023.io

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {
    @GET("oauth2/token")
    suspend fun requestAccess(
        @Query("grant_type") grantType: String = "client_credentials",
        @Query("client_id") clientId: String,
        @Query("client_secret") clientSecret: String
    ): Response<RequestAccessResponse>
}