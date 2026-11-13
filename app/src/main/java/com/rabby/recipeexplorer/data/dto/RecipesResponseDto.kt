package com.rabby.recipeexplorer.data.dto

data class RecipesResponseDto(
    val recipes : List<RecipeDto>,
    val total : Int,
    val skip : Int,
    val limit : Int
)
