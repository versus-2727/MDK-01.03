package com.example.pr01.data.service

import com.example.pr01.data.model.ProductsResponse
import retrofit2.http.GET

interface ProductsInterface {
    @GET ("products")
    suspend fun getProducts(): ProductsResponse
}