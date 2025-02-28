package com.example.pogo

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class HeightAdapter(private val heights: List<Int>, private val onHeightSelected: (Int) -> Unit) :
    RecyclerView.Adapter<HeightAdapter.HeightViewHolder>() {

    inner class HeightViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val heightText: TextView = itemView.findViewById(R.id.heightTextItem)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HeightViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_height, parent, false)
        return HeightViewHolder(view)
    }

    override fun onBindViewHolder(holder: HeightViewHolder, position: Int) {
        val height = heights[position]
        holder.heightText.text = "$height Cm"

        holder.itemView.setOnClickListener {
            onHeightSelected(height)
        }
    }

    override fun getItemCount(): Int = heights.size
}
