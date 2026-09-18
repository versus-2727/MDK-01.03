package com.example.pr01.service

import com.example.pr01.data.productsresponce
import retrofit2.http.GET

interface productsinterface {
    @GET ("products")
    suspend fun getproducts(): productsresponce
}