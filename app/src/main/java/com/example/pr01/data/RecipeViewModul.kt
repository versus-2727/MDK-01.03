package com.example.pr01.data
import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.pr01.service.RetrofitClient
import kotlinx.coroutines.launch

class RecipeViewModul: ViewModel() {
    fun addRecipe(recipe: Recipe) {
        viewModelScope.launch {
            try {
                val result = RetrofitClient.recipeAPI.addRecipe(recipe)

                Log.d("RecipeViewModul", "Название - ${result.name}")
                Log.d("RecipeViewModul", "Ингредиенты - ${result.ingredients}")
                Log.d("RecipeViewModul", "Сложность - ${result.difficulty}")
                Log.d("RecipeViewModul", "Калории - ${result.caloriesPerServing}")
                Log.d("RecipeViewModul", "ID - ${result.id}")

            } catch (e: Exception) {
                Log.e("RecipeViewModul", "${e.message}", e)
            }
        }
    }
}