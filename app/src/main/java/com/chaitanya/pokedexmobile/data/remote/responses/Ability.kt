package com.chaitanya.pokedexmobile.data.remote.responses


import com.google.gson.annotations.SerializedName
import com.chaitanya.pokedexmobile.data.remote.responses.AbilityX

data class Ability(
    val ability: AbilityX,
    @SerializedName("is_hidden")
    val isHidden: Boolean,
    val slot: Int
)