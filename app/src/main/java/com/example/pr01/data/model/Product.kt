package com.example.pr01.data.model

data class Product(
    val id: Int,
    val title: String,
    val rating: Double,
    val brand: String,
    val isDeleted: Boolean = false
)
