package com.rabby.recipeexplorer.data.remote

import com.rabby.recipeexplorer.data.dto.MoshiProvider
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

object RetrofitInstance {

    private val retrofit: Retrofit = Retrofit.Builder()
        .baseUrl("https://dummyjson.com/")
        .addConverterFactory(MoshiConverterFactory.create(MoshiProvider.moshi))
        .build()

    val api: RecipeApiService = retrofit.create(RecipeApiService::class.java)



}