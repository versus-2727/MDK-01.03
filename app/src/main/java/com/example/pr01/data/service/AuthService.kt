package com.example.pr01.data.service

import com.example.pr01.data.model.LoginRequest
import com.example.pr01.data.model.Profile
import com.example.pr01.data.model.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.POST

interface AuthService {
    @POST("users/auth-with-password")
    suspend fun logoutUser( @Body loginRequest: LoginRequest): Response
}