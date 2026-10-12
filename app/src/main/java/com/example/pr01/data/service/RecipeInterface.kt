package com.example.pr01.data.service

import retrofit2.http.GET
import retrofit2.http.Header
import com.example.pr01.data.model.Record

interface RecipeInterface {
    @GET("recipes/records")
    suspend fun getRecord(@Header("Authorization") token: String): Record
}