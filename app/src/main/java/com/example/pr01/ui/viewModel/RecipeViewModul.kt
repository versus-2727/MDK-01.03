package com.example.pr01.ui.viewModel

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.pr01.data.RetrofitClient
import com.example.pr01.data.TokenManager
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.launch

class RecipeViewModel(private val tokenManager: TokenManager): ViewModel(){
    fun fetch(){
        viewModelScope.launch {
            val token =  tokenManager.tokenFlow().first()
            try {
                val records = RetrofitClient.recipeAPI.getRecord("${token}")
                val items = records.items

                for(item in items)
                {
                    Log.d("LoginViewModel", "id:${item.id}\n" +
                            "name:${item.name}\n" +
                            "difficulty:${item.difficulty}\n" +
                            "created:${item.created}\n" +
                            "updated:${item.updated}\n")
                }
                Log.d("LoginViewModel", "" +
                        " page:${records.page}\n " +
                        "perPage:${records.perPage}\n totalItems:${records.totalItems}\n " +
                        "totalPages:${records.totalPages}")
            } catch (ex: Exception) {
                Log.e("LoginViewModel", "${ex.message}")
            }
        }

    }
}