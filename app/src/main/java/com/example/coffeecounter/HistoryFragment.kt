package com.example.coffeecounter

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.coffeecounter.databinding.FragmentHistoryBinding
import com.github.mikephil.charting.components.XAxis
import com.github.mikephil.charting.data.BarData
import com.github.mikephil.charting.data.BarDataSet
import com.github.mikephil.charting.data.BarEntry
import java.text.SimpleDateFormat
import java.util.*

class HistoryFragment : Fragment() {
    private var _binding: FragmentHistoryBinding? = null
    private val binding get() = _binding!!
    private lateinit var viewModel: CupCounterViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHistoryBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProvider(requireActivity())[CupCounterViewModel::class.java]

        setupChart()
        observeData()
    }

    private fun setupChart() {
        with(binding.chart) {
            description.isEnabled = false
            setDrawGridBackground(false)
            setDrawBorders(false)
            setTouchEnabled(true)
            isDragEnabled = true
            setScaleEnabled(true)
            setPinchZoom(true)

            xAxis.position = XAxis.XAxisPosition.BOTTOM
            xAxis.setDrawGridLines(false)
            axisLeft.setDrawGridLines(false)
            axisRight.isEnabled = false
            legend.isEnabled = false
        }
    }

    private fun observeData() {
        viewModel.repository.getWeeklyHistory().observe(viewLifecycleOwner) { entries ->
            val barEntries = entries.mapIndexed { index, entry ->
                BarEntry(
                    index.toFloat(),
                    entry.count.toFloat(),
                    SimpleDateFormat("MMM d", Locale.getDefault()).format(entry.date)
                )
            }

            val dataSet = BarDataSet(barEntries, "Coffee Consumption").apply {
                color = resources.getColor(R.color.coffee_brown)
                valueTextColor = resources.getColor(R.color.white)
            }

            binding.chart.data = BarData(dataSet)
            binding.chart.invalidate()
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}