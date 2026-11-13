package com.rabby.recipeexplorer.data.dto

object MoshiDeserialization {

    val jsonString = """
    {
        "id": 1,
        "name": "Chicken Handi",
        "ingredients": ["Chicken", "Onion", "Garlic"],
        "instructions": ["Cut chicken", "Cook chicken"],
        "prepTimeMinutes": 15,
        "cookTimeMinutes": 30,
        "servings": 4,
        "cuisine": "Indian",
        "image": "chicken.jpg"
    }
""".trimIndent()



    val recipe = MoshiProvider.recipeAdapter.fromJson(jsonString)


    val recipeName = recipe?.name
    val recipeId = recipe?.id
    val recipeCuisine = recipe?.cuisine
    val ingredientCount = recipe?.ingredients?.size

    fun printRecipeDetails() {
        println("Recipe Name: $recipeName")
        println("Recipe ID: $recipeId")
        println("Cuisine: $recipeCuisine")
        println("Ingredient Count: $ingredientCount")
    }

    val invalidJson = """
    {
        "id": 1,
        "name": "Chicken Handi",
        "ingredients": ["Chicken", "Onion"],
        "instructions": ["Cook chicken"],
        "prepTimeMinutes": 15,
        "cookTimeMinutes": 30,
        "servings": 4,
        "image": "chicken.jpg"
    }
""".trimIndent()

    fun testInvalidJson(){

        try {
            val invalidRecipe = MoshiProvider.recipeAdapter.fromJson(invalidJson)
            val cuisine = invalidRecipe?.cuisine

            println("Recipe Cuisine : $cuisine")

        } catch (e: Exception){

            println("Error : ${e.message}")

        }
    }
}