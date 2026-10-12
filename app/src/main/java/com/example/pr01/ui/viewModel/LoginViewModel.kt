package com.example.pr01.ui.viewModel

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.pr01.data.RetrofitClient
import com.example.pr01.data.TokenManager
import com.example.pr01.data.model.LoginRequest
import kotlinx.coroutines.launch

class LoginViewModel(private val tokenManager: TokenManager,
                     private val recipeViewModel: RecipeViewModel): ViewModel() {
    fun login(loginRequest: LoginRequest){
        viewModelScope.launch {
            try {
                val authUser = RetrofitClient.authAPI.logoutUser(loginRequest)
                Log.d("LoginViewModel", "Responses: ${authUser.token} ${authUser.record}")

                authUser.token?.let{
                    writeToken(it)
                    recipeViewModel.fetch()
                }


            } catch (ex: Exception) {
                Log.e("LoginViewModel", "${ex.message}")
            }
        }

    }

    fun writeToken(token: String) {
        viewModelScope.launch {
            tokenManager.saveToken(token)
        }
    }

}