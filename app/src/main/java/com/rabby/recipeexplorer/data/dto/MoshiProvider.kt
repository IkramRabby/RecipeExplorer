package com.rabby.recipeexplorer.data.dto

import com.squareup.moshi.JsonAdapter
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory

object MoshiProvider {

    val moshi : Moshi = Moshi.Builder()
        .add(KotlinJsonAdapterFactory())
        .build()

    val recipeAdapter : JsonAdapter<RecipeDto> =
        moshi.adapter(RecipeDto:: class.java)
}