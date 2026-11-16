package com.rabby.recipeexplorer

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import androidx.recyclerview.widget.GridLayoutManager
import com.rabby.recipeexplorer.data.remote.RetrofitInstance
import com.rabby.recipeexplorer.data.repository.RecipeRepository
import com.rabby.recipeexplorer.databinding.ActivityMainBinding
import com.rabby.recipeexplorer.presentation.viewmodel.RecipeViewModel
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private val viewModel: RecipeViewModel by viewModels<RecipeViewModel>{
        viewModelFactory {
            initializer {
                RecipeViewModel(RecipeRepository(RetrofitInstance.api))
            }
        }
    }

    private val adapter = RecipeAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        binding.rvItem.layoutManager = GridLayoutManager(this,2)
        binding.rvItem.adapter = adapter
        observeRecipes()
        viewModel.fetchRecipes()

    }

    private fun observeRecipes(){

        lifecycleScope.launch {

            repeatOnLifecycle(Lifecycle.State.STARTED){

                viewModel.recipes.collect { recipes ->

                  adapter.updateList(recipes)

                }
            }
        }
    }
}