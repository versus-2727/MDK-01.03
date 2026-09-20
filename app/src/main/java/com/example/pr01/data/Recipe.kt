package com.example.pr01.data

data class Recipe(
    val id: Int? = null,
    val name: String,
    val ingredients: List<String>,
    val difficulty: String,
    val caloriesPerServing: Int
)
