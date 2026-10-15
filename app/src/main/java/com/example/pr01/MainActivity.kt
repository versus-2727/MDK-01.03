package com.example.pr01

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.example.pr01.data.TokenManager
import com.example.pr01.data.model.LoginRequest
import com.example.pr01.ui.theme.Pr01Theme
import com.example.pr01.ui.viewModel.LoginViewModel
import com.example.pr01.ui.viewModel.RecipeViewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            //ПР01
//            val productViewModul: ProductViewModul = viewModel()
//            productViewModul.updateProducts()

            //ПР02
//            val recipeViewModul: RecipeViewModul = viewModel()
//
//            val recipe = Recipe(
//                name = "Запеченный лосось в лимонно-горчичном маринаде",
//                ingredients = listOf(
//                    "Стейк или филе лосося",
//                    "Лимонный сок",
//                    "Горчица дижонская",
//                    "Оливковое масло",
//                    "Мед",
//                    "Чеснок",
//                    "Соль",
//                    "Свежемолотый черный перец"
//                ),
//                difficulty = "Easy",
//                caloriesPerServing = 420
//            )
//
//            recipeViewModul.addRecipe(recipe)


            //ПР03
//            val userViewModel: UserViewModel = viewModel()
//            userViewModel.UpdateUser()

            //ПР04
//            val productViewModel: ProductViewModul = viewModel()
//            productViewModel.deleteProduct(12)

            //ПР05
//            val loginViewModel: LoginViewModel = viewModel()
//            val lodinUser = LoginRequest(
//                username = "jamesd",
//                password = "jamesdpass"
//            )
//            loginViewModel.login(lodinUser)

            //ПР05-ПР06
            val tokenManager = TokenManager(applicationContext)

            val recipeViewModel: RecipeViewModel by viewModels {
                viewModelFactory {
                    initializer {
                        RecipeViewModel(tokenManager)
                    }
                }
            }

            val loginViewModel: LoginViewModel by viewModels {
                viewModelFactory {
                    initializer {
                        LoginViewModel(tokenManager,recipeViewModel )
                    }
                }
            }

            val loginUser = LoginRequest(
                identity = "artem.podguzkov@gmail.com",
                password = "123456789"
            )
            loginViewModel.login(loginUser)

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