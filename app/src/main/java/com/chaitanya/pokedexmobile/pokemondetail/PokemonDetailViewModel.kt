package com.chaitanya.pokedexmobile.pokemondetail

import androidx.lifecycle.ViewModel
import com.chaitanya.pokedexmobile.data.remote.responses.Pokemon
import com.chaitanya.pokedexmobile.repository.PokemonRepository
import com.chaitanya.pokedexmobile.util.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class PokemonDetailViewModel @Inject constructor(private val repository: PokemonRepository) :
    ViewModel()  {
    suspend fun getPokemonInfo(pokemonName: String): Resource<Pokemon> {
        return repository.getPokemonInfo(pokemonName)
    }
}