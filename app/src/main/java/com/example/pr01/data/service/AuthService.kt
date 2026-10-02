package com.example.pr01.data.service

import com.example.pr01.data.model.LoginRequest
import com.example.pr01.data.model.User
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.POST

interface AuthService {
    @GET("user/me")
    suspend fun getUser(@Header("Authorization") auth: String)

    @POST("auth/login")
    suspend fun logoutUser(@Body loginRequest: LoginRequest): User
}