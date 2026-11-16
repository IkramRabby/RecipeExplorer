package com.rabby.recipeexplorer

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import coil3.load
import coil3.request.crossfade
import com.rabby.recipeexplorer.data.dto.RecipeDto
import com.rabby.recipeexplorer.databinding.ItemRecipeBinding

class RecipeAdapter(
    private var list: List<RecipeDto> = emptyList()
) : RecyclerView.Adapter<RecipeAdapter.ViewHolder>() {

    fun updateList(newList: List<RecipeDto>){
        list = newList
        notifyDataSetChanged()
    }

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
            binding.recipeTime.text = "Time : ${recipe.cookTimeMinutes}min"
            binding.recipeImage.load(recipe.image){
                crossfade(true)
            }

            binding.btnItemDetails.setOnClickListener {

                val context = itemView.context

                val intent = Intent(context, RecipeDetails::class.java)

                intent.putExtra("RECIPE_NAME",recipe.name)
                intent.putExtra("RECIPE_TIME",recipe.cookTimeMinutes)
                intent.putExtra("RECIPE_IMAGE",recipe.image)


                context.startActivity(intent)
            }

        }

    }

    override fun getItemCount(): Int {return list.size}
}