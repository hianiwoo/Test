package com.test.presentation.home.home

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.test.common.inflater
import com.test.domain.models.Anime
import com.test.test.databinding.ItemAnimeBinding

class HomeAdapter(private val OnClickItem: (Anime) -> Unit) :
    RecyclerView.Adapter<HomeAdapter.ItemHolder>() {

    var list = listOf<Anime>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        ItemHolder(ItemAnimeBinding.inflate(parent.inflater()))

    override fun getItemCount() = list.size

    override fun onBindViewHolder(holder: ItemHolder, position: Int) {
        val anime = list[position]
        holder.binding.item = anime
        holder.itemView.setOnClickListener { OnClickItem.invoke(anime) }
    }

    class ItemHolder(val binding: ItemAnimeBinding) : RecyclerView.ViewHolder(binding.root)
}