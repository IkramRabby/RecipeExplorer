package com.rabby.recipeexplorer

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.rabby.recipeexplorer.databinding.ActivityRecipeDetailsBinding

class RecipeDetails : AppCompatActivity() {

    private lateinit var binding: ActivityRecipeDetailsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        binding = ActivityRecipeDetailsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val image = intent.getIntExtra("RECIPE_IMAGE",0)
        val name = intent.getStringExtra("RECIPE_NAME")
        val time = intent.getStringExtra("RECIPE_TIME")



        binding.recipeImage.setImageResource(image)
        binding.recipeName.text = name
        binding.recipeTime.text = "Time : ${time}min"


    }
}