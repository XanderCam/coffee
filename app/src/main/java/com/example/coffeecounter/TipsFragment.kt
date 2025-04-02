package com.example.coffeecounter

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import com.example.coffeecounter.databinding.FragmentTipsBinding

class TipsFragment : Fragment() {
    private var _binding: FragmentTipsBinding? = null
    private val binding get() = _binding!!
    private lateinit var tipsAdapter: CoffeeTipsAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentTipsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        
        setupRecyclerView()
        loadTips()
    }

    private fun setupRecyclerView() {
        tipsAdapter = CoffeeTipsAdapter()
        binding.rvTips.apply {
            layoutManager = GridLayoutManager(context, 2)
            adapter = tipsAdapter
            setHasFixedSize(true)
        }
    }

    private fun loadTips() {
        val tips = listOf(
            CoffeeTip("Cold Brew", "Smooth and less acidic", R.drawable.ic_cold_brew),
            CoffeeTip("Espresso", "Strong and concentrated", R.drawable.ic_espresso),
            CoffeeTip("Cappuccino", "Espresso with steamed milk", R.drawable.ic_cappuccino),
            CoffeeTip("Latte", "Espresso with lots of milk", R.drawable.ic_latte),
            CoffeeTip("Americano", "Espresso with hot water", R.drawable.ic_americano),
            CoffeeTip("Mocha", "Chocolate coffee delight", R.drawable.ic_mocha)
        )
        tipsAdapter.submitList(tips)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}