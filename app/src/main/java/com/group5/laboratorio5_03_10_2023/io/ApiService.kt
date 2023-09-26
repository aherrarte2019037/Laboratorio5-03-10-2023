package com.group5.laboratorio5_03_10_2023.io

import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.GET

interface ApiService {
    @FormUrlEncoded
    @GET("oauth2/token")
    suspend fun requestAccess(
        @Field("grant_type") grantType: String = "client_credentials",
        @Field("client_id") clientId: String,
        @Field("client_secret") clientSecret: String
    ): Response<Any>
}