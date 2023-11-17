package com.chaitanya.pokedexmobile

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.chaitanya.pokedexmobile.ui.theme.PokeDexMobileTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PokeDexMobileTheme {
                val navController = rememberNavController()
                NavHost(
                    navController = navController,
                    startDestination = "pokemon_list_screen"
                ){
                    composable("pokemon_list_screen"){

                    }
                    composable("pokemon_detail_screen/{pokemonColor}/{pokemonName}",
                        arguments = listOf(
                            navArgument("pokemonColor"){
                                type = NavType.IntType
                            },
                            navArgument("pokemonName"){
                                type = NavType.StringType
                            }
                        )
                        ){backstack ->
                        val pokemonColor = backstack.arguments?.getInt("pokemonColor")
                        pokemonColor?.let { Color(it) } ?: Color.White
                        val pokemonName = remember {
                            backstack.arguments?.getString("pokemonName")
                        }

                    }
                }

            }
        }
    }
}


@Preview(showBackground = true)
@Composable
fun AppPreview() {
    PokeDexMobileTheme {

    }
}