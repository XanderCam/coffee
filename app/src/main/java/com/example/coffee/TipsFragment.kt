package com.example.coffee

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

        // Initialize RecyclerView
        recyclerView = view.findViewById(R.id.recyclerTips)
        
        // Configure RecyclerView
        recyclerView.layoutManager = LinearLayoutManager(requireContext())
        recyclerView.setHasFixedSize(true)

        // Create sample data
        val tipsList = listOf(
            Tip("Grind Size Matters", "Use a coarser grind for French press and finer for espresso"),
            Tip("Water Temperature", "Optimal brewing temperature is between 195°F and 205°F"),
            Tip("Brewing Time", "4 minutes is ideal for most manual brewing methods")
        )

        // Set up adapter
        tipsAdapter = TipsAdapter(tipsList)
        recyclerView.adapter = tipsAdapter
    }
}