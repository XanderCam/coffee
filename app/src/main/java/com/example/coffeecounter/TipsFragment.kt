package com.example.coffeecounter

import com.example.coffeecounter.R
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class TipsFragment : Fragment() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var tipsAdapter: TipsAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_tips, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        recyclerView = view.findViewById(R.id.recyclerTips)
        recyclerView.layoutManager = LinearLayoutManager(requireContext())
        recyclerView.setHasFixedSize(true)

        val coffeeTips = listOf(
            CoffeeTip("Grind Size", "Use coarser grind for French press", R.drawable.ic_coffee_cup),
            CoffeeTip("Water Temp", "195°F-205°F is ideal", R.drawable.ic_americano),
            CoffeeTip("Brew Time", "4 minutes for best extraction", R.drawable.ic_espresso)
        )

        tipsAdapter = TipsAdapter(coffeeTips)
        recyclerView.adapter = tipsAdapter
    }
}
