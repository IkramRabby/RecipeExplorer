package com.rabby.recipeexplorer.data.dto

data class RecipeDto(
    val id : Int,
    val name : String,
    val ingredients : List<String>,
    val instructions : List<String>,
    val prepTimeMinutes : Int,
    val cookTimeMinutes : Int,
    val servings : Int,
    val cuisine : String,
    val image : String
)
