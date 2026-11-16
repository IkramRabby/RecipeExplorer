package com.rabby.recipeexplorer.data.repository

import com.rabby.recipeexplorer.data.dto.RecipesResponseDto
import com.rabby.recipeexplorer.data.remote.RecipeApiService

class RecipeRepository(
    private val apiService: RecipeApiService
) {

    suspend fun getRecipes(): RecipesResponseDto =  apiService.getRecipes()

}