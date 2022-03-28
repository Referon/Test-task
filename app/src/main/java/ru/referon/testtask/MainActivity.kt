package ru.referon.testtask

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.activity.viewModels
import androidx.core.view.isVisible
import ru.referon.testtask.databinding.ActivityMainBinding
import ru.referon.testtask.viewmodel.ViewModel


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val viewModel: ViewModel by viewModels()
        viewModel.loadFoods()
        binding.b1.isSelected = true

        binding.b1.setOnClickListener {
            it.isSelected = !it.isSelected
        }

        val adapter = Adapter()
        binding.list.adapter = adapter

        viewModel.data.observe(this) { model ->
            binding.loading.isVisible = model.loading
            adapter.submitList(model.foods?.results)
        }

    }
}