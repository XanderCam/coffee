package com.example.coffeecounter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView

data class CoffeeTip(
    val name: String,
    val description: String,
    val iconRes: Int
)

class CoffeeTipsAdapter : ListAdapter<CoffeeTip, CoffeeTipsAdapter.CoffeeTipViewHolder>(DiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CoffeeTipViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_coffee_tip, parent, false)
        return CoffeeTipViewHolder(view)
    }

    override fun onBindViewHolder(holder: CoffeeTipViewHolder, position: Int) {
        val item = getItem(position)
        holder.bind(item)
    }

    class CoffeeTipViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val nameView: TextView = itemView.findViewById(R.id.tvTipName)
        private val descView: TextView = itemView.findViewById(R.id.tvTipDesc)
        private val iconView: ImageView = itemView.findViewById(R.id.ivTipIcon)

        fun bind(tip: CoffeeTip) {
            nameView.text = tip.name
            descView.text = tip.description
            iconView.setImageResource(tip.iconRes)
        }
    }

    class DiffCallback : DiffUtil.ItemCallback<CoffeeTip>() {
        override fun areItemsTheSame(oldItem: CoffeeTip, newItem: CoffeeTip): Boolean {
            return oldItem.name == newItem.name
        }

        override fun areContentsTheSame(oldItem: CoffeeTip, newItem: CoffeeTip): Boolean {
            return oldItem == newItem
        }
    }
}