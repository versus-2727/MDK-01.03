package com.example.pr01.data

import com.example.pr01.data.service.ProductInterface
import com.example.pr01.data.service.RecipeInterface
import com.example.pr01.data.service.UserInterface
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.net.Proxy
import java.net.InetSocketAddress
object RetrofitClient {
    val proxy = Proxy(Proxy.Type.HTTP, InetSocketAddress("10.207.106.59",3128))
    val loggingInterceptor = HttpLoggingInterceptor().apply {
        level = HttpLoggingInterceptor.Level.BODY
    }

    val okHttpClient = OkHttpClient.Builder()
        .proxy(proxy)
        .addInterceptor (loggingInterceptor)
        .build()

    val retrofit = Retrofit.Builder()
        .baseUrl("https://dummyjson.com/")
        .client(okHttpClient)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    val retrofitAPI = retrofit.create(ProductInterface::class.java)
    val recipeAPI = retrofit.create(RecipeInterface::class.java)
    val userAPI: UserInterface = retrofit.create(UserInterface::class.java)
}