package com.example.pr01.data.service

import com.example.pr01.data.model.Product
import com.example.pr01.data.model.ProductResponse
import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.Path

interface ProductInterface {
    @GET ("product")
    suspend fun getProducts(): ProductResponse

    @DELETE("products/{id}")
    suspend fun deletedProduct(@Path("id") id: Int): Product
}