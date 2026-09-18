package com.example.pr01.data

import android.content.ContentValues.TAG
import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.pr01.service.RetrofitClient
import kotlinx.coroutines.launch

class ProductViewModul: ViewModel() {
    fun fetchproducts(){
        viewModelScope.launch {
            try {
                val productResponse = RetrofitClient.retrofitAPI.getproducts()
                val products = productResponse.products
                for (product in products)
                {
                    Log.d("ProductViewModul", "Название - ${product.title}  " + "Рейтинг - ${product.rating}  "+ "Производитель - ${product.brand}")
                }
            }
            catch (e: Exception){
                Log.e("ProductViewModul", "${e.message}", e)
            }
        }
    }

}