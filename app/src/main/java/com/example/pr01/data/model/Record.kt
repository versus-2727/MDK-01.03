package com.example.pr01.data.model

data class Record(
    val items: List<Recipe>,
    val page: Int? = null,
    val perPage: Int? = null,
    val totalItems: Int? = null,
    val totalPages: Int? = null
)
