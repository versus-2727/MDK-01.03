package com.example.pr01

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.pr01.data.ProductViewModul
import com.example.pr01.data.Recipe
import com.example.pr01.data.RecipeViewModul
import com.example.pr01.ui.theme.Pr01Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            //ПР01
            //val productViewModul: ProductViewModul = viewModel()
            //productViewModul.fetchproducts()

            //ПР02
            val recipeViewModul: RecipeViewModul = viewModel()

            val recipe = Recipe(
                name = "Запеченный лосось в лимонно-горчичном маринаде",
                ingredients = listOf(
                    "Стейк или филе лосося",
                    "Лимонный сок",
                    "Горчица дижонская",
                    "Оливковое масло",
                    "Мед",
                    "Чеснок",
                    "Соль",
                    "Свежемолотый черный перец"
                ),
                difficulty = "Easy",
                caloriesPerServing = 420
            )

            recipeViewModul.addRecipe(recipe)

        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    Pr01Theme {
        Greeting("Android")
    }
}