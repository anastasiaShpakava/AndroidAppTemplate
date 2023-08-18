package com.softteco.template.presentation.features.apis

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.appcompat.content.res.AppCompatResources
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.softteco.template.domain.model.ApiEntry
import com.softteco.template.presentation.R
import com.softteco.template.presentation.databinding.ItemApiEntryBinding
import com.softteco.template.presentation.extensions.setOnSafeClickListener

/**
 * Provide adapter for API list
 */
class ApiListAdapter(
    private val items: List<ApiEntry>,
    private val onClick: (position: Int) -> Unit,
    private val onClickFavorite: (position: Int) -> Unit,
) : RecyclerView.Adapter<ApiEntryViewHolder>() {

    /**
     * Returns new ViewHolder that holds a View of the given view type
     */
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ApiEntryViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = ItemApiEntryBinding.inflate(layoutInflater, parent, false)
        val holder = ApiEntryViewHolder(binding)
        binding.run {
            cvApiItem.setOnSafeClickListener {
                onClick(holder.bindingAdapterPosition)
            }
            ivFavorite.setOnSafeClickListener {
                onClickFavorite(holder.bindingAdapterPosition)
            }
        }
        return holder
    }

    /**
     * Method to display the data at the specified position.
     */
    override fun onBindViewHolder(holder: ApiEntryViewHolder, position: Int) {
        val item = items[position]
        holder.binding.run {
            tvTitle.text = item.name
            ivApiLogo.load(item.logo)
            val favoriteRes = if (item.favorite) {
                R.drawable.ic_favorite_filled_white
            } else {
                R.drawable.ic_favorite_outline_white
            }
            ivFavorite.setImageDrawable(
                AppCompatResources.getDrawable(
                    holder.itemView.context,
                    favoriteRes
                )
            )
        }
    }

    /**
     *  Method to get total number of items in the data set held by the adapter
     */
    override fun getItemCount(): Int = items.size
}

/**
 * Provide viewHolder for adapter
 * @property binding ItemApiEntryBinding
 */
class ApiEntryViewHolder(val binding: ItemApiEntryBinding) : RecyclerView.ViewHolder(binding.root)
