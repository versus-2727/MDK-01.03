package com.example.pr01.data.service

import com.example.pr01.data.model.Recipe
import retrofit2.http.Body
import retrofit2.http.POST

interface RecipeInterface {
    @POST("recipes/add")
    suspend fun addRecipe(@Body recipe: Recipe): Recipe
}