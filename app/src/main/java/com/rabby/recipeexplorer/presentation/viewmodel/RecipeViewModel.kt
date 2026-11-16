package com.rabby.recipeexplorer.presentation.viewmodel

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.rabby.recipeexplorer.data.dto.RecipeDto
import com.rabby.recipeexplorer.data.repository.RecipeRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class RecipeViewModel(
    private val recipeRepository: RecipeRepository
): ViewModel() {

    private val _recipes =
        MutableStateFlow<List<RecipeDto>>(emptyList())

    val recipes = _recipes.asStateFlow()

    fun fetchRecipes(){

        viewModelScope.launch {

            try {

                val response = recipeRepository.getRecipes()
                _recipes.value = response.recipes

            } catch (e: Exception){

                Log.e("RecipeViewModel","Failed to fetch recipes",e)
            }
        }
    }

}