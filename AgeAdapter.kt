package com.example.pogo

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class AgeAdapter(
    private val ages: List<Int>,
    private val onAgeSelected: (Int) -> Unit
) : RecyclerView.Adapter<AgeAdapter.AgeViewHolder>() {

    inner class AgeViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val ageTextView: TextView = itemView.findViewById(R.id.tvAge)

        fun bind(age: Int) {
            ageTextView.text = age.toString()
            itemView.setOnClickListener {
                onAgeSelected(age)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AgeViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_age, parent, false)
        return AgeViewHolder(view)
    }

    override fun onBindViewHolder(holder: AgeViewHolder, position: Int) {
        holder.bind(ages[position])
    }

    override fun getItemCount(): Int = ages.size
}
