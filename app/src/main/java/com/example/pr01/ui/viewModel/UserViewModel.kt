package com.example.pr01.ui.viewModel

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.pr01.data.model.User
import com.example.pr01.data.RetrofitClient
import com.example.pr01.data.model.Company
import kotlinx.coroutines.launch

class UserViewModel: ViewModel() {

    fun UpdateUser() {
        viewModelScope.launch {
            try {

                val userBefore = RetrofitClient.userAPI.getUser(89)


                Log.d("UserViewModel", "ДО редактирования:\n" +
                        "Имя: ${userBefore.firstName} ${userBefore.lastName}\n" +
                        "Компания: ${userBefore.company.name}\n" +
                        "Должность: ${userBefore.company.title}"
                )

                val localUpdatedUser = userBefore.copy(
                    firstName = "Олег",
                    lastName = "Павлов",
                    company = Company(
                        name = "Интел",
                        title = "Менеджер по продажам"
                    )
                )
                if (userBefore.id != null) {
                    val responseUser =
                        RetrofitClient.userAPI.updateUser(userBefore.id, localUpdatedUser)


                    Log.d(
                        "UserViewModel", "ПОСЛЕ редактирования:\n" +
                                "Имя: ${responseUser.firstName} ${responseUser.lastName}\n" +
                                "Компания: ${responseUser.company.name}\n" +
                                "Должность: ${responseUser.company.title}"
                    )
                }

            } catch (e: Exception) {
                Log.e("UserViewModel", "Ошибка при работе с пользователем: ${e.message}", e)
            }
        }
    }
}