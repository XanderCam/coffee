package com.example.coffeecounter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class TipsAdapter(private val coffeeTips: List<CoffeeTip>) : RecyclerView.Adapter<TipsAdapter.CoffeeTipViewHolder>() {

    inner class CoffeeTipViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val nameView: TextView = itemView.findViewById(R.id.tvTipName)
        private val descView: TextView = itemView.findViewById(R.id.tvTipDesc)
        private val iconView: ImageView = itemView.findViewById(R.id.ivTipIcon)

        fun bind(tip: CoffeeTip) {
            nameView.text = tip.name
            descView.text = tip.description
            iconView.setImageResource(tip.iconRes)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CoffeeTipViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_coffee_tip, parent, false)
        return CoffeeTipViewHolder(view)
    }

    override fun onBindViewHolder(holder: CoffeeTipViewHolder, position: Int) {
        holder.bind(coffeeTips[position])
    }

    override fun getItemCount(): Int = coffeeTips.size
}
