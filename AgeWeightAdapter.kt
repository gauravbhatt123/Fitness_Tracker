package com.example.pogo

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class AgeWeightAdapter(
    private val items: List<Int>,
    private val onItemSelected: (Int) -> Unit
) : RecyclerView.Adapter<AgeWeightAdapter.ViewHolder>() {

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val tvValue: TextView = view.findViewById(R.id.tvAge)

        fun bind(value: Int) {
            tvValue.text = value.toString()
            itemView.setOnClickListener {
                onItemSelected(value)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_weight, parent, false)
        return ViewHolder(view)
















    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(items[position])
    }

    override fun getItemCount() = items.size
}
