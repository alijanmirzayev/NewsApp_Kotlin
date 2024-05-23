package com.alijan.newsapp.ui.home

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.alijan.newsapp.R
import com.alijan.newsapp.databinding.ItemSmallNewsCardBinding
import com.alijan.newsapp.data.model.ArticleModel
import com.bumptech.glide.Glide

class SmallNewsCardAdapter : RecyclerView.Adapter<SmallNewsCardAdapter.SmallNewsCardViewHolder>() {

    private val newsList = arrayListOf<ArticleModel>()
    lateinit var onClick: (item: ArticleModel) -> Unit

    inner class SmallNewsCardViewHolder(val itemSmallNewsCardBinding: ItemSmallNewsCardBinding) :
        RecyclerView.ViewHolder(itemSmallNewsCardBinding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SmallNewsCardViewHolder {
        val view =
            ItemSmallNewsCardBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return SmallNewsCardViewHolder(view)
    }

    override fun getItemCount(): Int {
        return newsList.size
    }

    override fun onBindViewHolder(holder: SmallNewsCardViewHolder, position: Int) {
        val item = newsList[position]
        holder.itemSmallNewsCardBinding.item = item

        holder.itemSmallNewsCardBinding.clSmallNews.setOnClickListener {
            onClick(item)
        }

        item.title?.let {
            holder.itemSmallNewsCardBinding.textViewDescription.text = truncatedStr(it)
        }
    }

    fun updateList(newList: List<ArticleModel>) {
        newsList.clear()
        newsList.addAll(newList)
        notifyDataSetChanged()
    }

    private fun truncatedStr(str: String): String {
        return if (str.length > 50) {
            "${str.substring(0, 50)}..."
        } else {
            str
        }
    }
}