package com.chaitanya.pokedexmobile

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.chaitanya.pokedexmobile.pokemondetail.PokemonDetailScreen
import com.chaitanya.pokedexmobile.pokemonlist.PokemonListScreen
import com.chaitanya.pokedexmobile.ui.theme.PokeDexMobileTheme
import dagger.hilt.android.AndroidEntryPoint
import timber.log.Timber
import java.util.Locale

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
                        PokemonListScreen(navController = navController)
                    }
                    composable("pokemon_detail_screen/{dominantColor}/{pokemonName}",
                        arguments = listOf(
                            navArgument("dominantColor"){
                                type = NavType.IntType
                            },
                            navArgument("pokemonName"){
                                type = NavType.StringType
                            }
                        )
                        ){backstack ->
                        val dominantColor = remember {
                            val color = backstack.arguments?.getInt("dominantColor")
                            color?.let { Color(it) } ?: Color.White
                        }
                        val pokemonName = remember {
                            backstack.arguments?.getString("pokemonName")
                        }
                        PokemonDetailScreen(
                            dominantColor = dominantColor,
                            pokemonName = pokemonName?.lowercase(Locale.ROOT) ?: "",
                            navController = navController
                        )
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