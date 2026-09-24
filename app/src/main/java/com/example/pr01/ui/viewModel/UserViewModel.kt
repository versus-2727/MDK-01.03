package com.example.pr01.ui.viewModel

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.pr01.data.model.User
import com.example.pr01.data.RetrofitClient
import kotlinx.coroutines.launch

class UserViewModel: ViewModel() {
    var userBefore: User? = null
    var userAfter: User? = null

    // Метод теперь принимает userId и готовый объект updatedUser
    fun fetchAndUpdateUser(userId: Int, updatedUser: User) {
        viewModelScope.launch {
            try {
                // 1. Получаем данные пользователя до редактирования
                userBefore = RetrofitClient.userAPI.getUser(userId)
                Log.d(
                    "UserViewModel",
                    "ДО редактирования: ${userBefore?.firstName} ${userBefore?.lastName}, " +
                            "Компания: ${userBefore?.company?.name}, Должность: ${userBefore?.company?.title}"
                )

                // 2. Отправляем запрос на обновление с переданными из Activity данными
                userAfter = RetrofitClient.userAPI.updateUser(userId, updatedUser)
                Log.d(
                    "UserViewModel",
                    "ПОСЛЕ редактирования: ${userAfter?.firstName} ${userAfter?.lastName}, " +
                            "Компания: ${userAfter?.company?.name}, Должность: ${userAfter?.company?.title}"
                )

            } catch (e: Exception) {
                Log.e("UserViewModel", "Ошибка при работе с пользователем: ${e.message}", e)
            }
        }
    }
}