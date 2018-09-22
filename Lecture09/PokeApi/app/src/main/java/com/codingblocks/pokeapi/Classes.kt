package com.codingblocks.pokeapi

import android.util.Log

const val version = 5

fun globalFunc(msg: String) {
    Log.e("TAG", msg)
}

data class Result(val abilities: ArrayList<Abilities>? = null,
                  val base_experience: Int = 0,
                  val forms: ArrayList<ReusableClass>? = null,
                  val game_indices: ArrayList<GameIndex>? = null,
                  val height: Int = 0,
                  val held_items: ArrayList<HeldItems>? = null,
                  val id: Int = 0,
                  val is_default: Boolean? = null,
                  val location_area_encounters: String? = null,
                  val name: String? = null,
                  val order: Int = 0,
                  val speices: ReusableClass? = null,
                  val sprites: Sprites? = null,
                  val weight: Int = 0
)

data class Abilities(val is_hidden: Boolean? = null, val slot: Int = 0, val ability: ReusableClass? = null)

data class ReusableClass(val name: String? = null, val url: String? = null)

data class GameIndex(val game_index: Int = 0, val version: ReusableClass? = null)

data class HeldItems(val item: ReusableClass? = null, val version_details: ArrayList<InnerHeldItem>? = null)

data class InnerHeldItem(val rarity: Int = 0, val version: ReusableClass? = null)

data class Sprites(val back_default: String? = null, val back_shiny: String? = null, val front_default: String? = null, val front_shiny: String? = null)