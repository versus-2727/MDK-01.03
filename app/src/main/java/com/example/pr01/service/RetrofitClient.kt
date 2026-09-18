package com.example.pr01.service

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitClient {
    val loggingInterceptor = HttpLoggingInterceptor().apply {
        level = HttpLoggingInterceptor.Level.BODY
    }
    //прокся если нужно запустить на эмуляторе
    //val proxy = Proxy(Proxy.Type.HTTP, InetSocketAddress("", ))
    val okHttpClient = OkHttpClient.Builder()
        .addInterceptor (loggingInterceptor)
        .build()

    val retrofit = Retrofit.Builder()
        .baseUrl("https://dummyjson.com/")
        .client(okHttpClient)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    val retrofitAPI = retrofit.create(productsinterface::class.java)
}