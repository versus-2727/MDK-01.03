package com.example.pr01.ui.viewModel

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.pr01.data.RetrofitClient
import kotlinx.coroutines.launch

class ProductViewModul: ViewModel() {
    fun updateProducts(){
        viewModelScope.launch {
            try {
                val productResponse = RetrofitClient.retrofitAPI.getProducts()
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

    fun deleteProduct(id:Int){
        viewModelScope.launch {
            try {
                val product = RetrofitClient.retrofitAPI.deletedProduct(id)
                Log.d("ProductViewModel", "Товар удален:\n"+ "ID: ${product.id}\n" +
                        "Название: ${product.title}\nРэйтинг: ${product.rating}\n" +
                        "Брэнд: ${product.brand}\n" +
                        "IsDeleted: ${product.isDeleted}")

            }catch (e: Exception)
            {
                Log.e("ProductViewModel","${e.message}", e)
            }
        }

    }

}