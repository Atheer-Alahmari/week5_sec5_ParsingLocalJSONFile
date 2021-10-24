package com.example.week5_sec5_parsinglocaljsonfile

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.image_view.view.*

class RVAdapter(private val imageList : ArrayList<String>): RecyclerView.Adapter<RVAdapter.ItemViewHolder>() {
    class ItemViewHolder(itemView: View): RecyclerView.ViewHolder(itemView)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        return ItemViewHolder(LayoutInflater.from(parent.context).inflate(
                R.layout.image_view,
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {

        holder.itemView.apply {
            val imags_url = imageList[position]

            Glide.with(this)
                .load(imags_url)
                .centerCrop()
                .into(imageView)
        }
    }

    override fun getItemCount() = imageList.size
}




