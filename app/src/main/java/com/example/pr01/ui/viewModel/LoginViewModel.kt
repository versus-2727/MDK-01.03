package com.example.pr01.ui.viewModel

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.pr01.data.RetrofitClient
import com.example.pr01.data.model.LoginRequest
import kotlinx.coroutines.launch

class LoginViewModel: ViewModel() {
    fun login(loginRequest: LoginRequest){
        viewModelScope.launch {
            try {
                val authUser = RetrofitClient.authAPI.logoutUser(loginRequest)

                Log.d("LoginViewModel", "User: ${authUser.firstName} ${authUser.lastName}")

                val currentUser = RetrofitClient.authAPI.getUser("Bearer ${authUser.accessToken}")

                Log.d("LoginViewModel", "${authUser.firstName}")
            } catch (ex: Exception) {
                Log.e("LoginViewModel", "${ex.message}")
            }
        }
    }
}