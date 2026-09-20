package com.example.pr01.service

import com.example.pr01.data.Recipe
import retrofit2.http.Body
import retrofit2.http.POST

interface RecipeInterface {
    @POST("recipes/add")
    suspend fun addRecipe(@Body recipe: Recipe): Recipe
}