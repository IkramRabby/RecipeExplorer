package com.rabby.recipeexplorer

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.rabby.recipeexplorer.databinding.ItemRecipeBinding

class RecipeAdapter(
    private val list : List<Recipe>
) : RecyclerView.Adapter<RecipeAdapter.ViewHolder>() {

    inner class ViewHolder(
        val binding: ItemRecipeBinding
    ) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemRecipeBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,false
        )

        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        val recipe = list[position]


        holder.apply {

            binding.recipeName.text = recipe.name
            binding.recipeTime.text = "Time : ${recipe.cookingTime}min"
            binding.recipeImage.setImageResource(recipe.image)

            binding.btnItemDetails.setOnClickListener {

                val context = itemView.context

                val intent = Intent(context, RecipeDetails::class.java)

                intent.putExtra("RECIPE_NAME",recipe.name)
                intent.putExtra("RECIPE_TIME",recipe.cookingTime)
                intent.putExtra("RECIPE_IMAGE",recipe.image)


                context.startActivity(intent)
            }

        }

    }

    override fun getItemCount(): Int {return list.size}
}