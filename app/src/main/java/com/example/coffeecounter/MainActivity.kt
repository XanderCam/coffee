package com.example.coffeecounter

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.example.coffeecounter.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var viewModel: CupCounterViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel = ViewModelProvider(this)[CupCounterViewModel::class.java]

        setupUI()
        observeViewModel()
    }

    private fun setupUI() {
        binding.apply {
            btnAddCup.setOnClickListener {
                viewModel.addCup()
                checkForTaunt()
            }

            btnReset.setOnClickListener {
                viewModel.resetCount()
            }
        }
    }

    private fun observeViewModel() {
        viewModel.cupCount.observe(this) { count ->
            binding.tvCupCount.text = getString(R.string.cup_count_format, count)
            updateQuoteBasedOnCount(count)
        }

        viewModel.currentQuote.observe(this) { quote ->
            binding.tvDailyQuote.text = quote
        }
    }

    private fun checkForTaunt() {
        if (viewModel.shouldTauntUser()) {
            showTauntDialog(viewModel.getRandomTaunt())
        }
    }

    private fun updateQuoteBasedOnCount(count: Int) {
        if (count % 3 == 0) {
            viewModel.updateDailyQuote()
        }
    }

    private fun showTauntDialog(taunt: String) {
        // Implementation for showing taunt dialog
    }
}