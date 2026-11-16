package com.rabby.recipeexplorer.data.remote

import com.rabby.recipeexplorer.data.dto.RecipeDto
import com.rabby.recipeexplorer.data.dto.RecipesResponseDto
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface RecipeApiService {

    @GET("recipes")
    suspend fun getRecipes(): RecipesResponseDto

    @GET("recipes/{id}")
    suspend fun getRecipeById(
        @Path("id") id: Int
    ): RecipeDto


    @GET("recipes/search")
    suspend fun searchRecipe(
        @Query("q") query: String
    ): RecipesResponseDto


}