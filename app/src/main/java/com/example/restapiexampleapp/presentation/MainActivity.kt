package com.example.restapiexampleapp.presentation

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.example.restapiexampleapp.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val viewModel by viewModels<MainViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater).also {
            setContentView(it.root)
        }

        clickListeners()

    }

    private fun clickListeners() {
        with(binding) {
            getButton.setOnClickListener {
                viewModel.getAllPosts()
            }

            postButton.setOnClickListener {
                viewModel.postPost()
            }

            putButton.setOnClickListener {
                viewModel.putPost()
            }

            patchButton.setOnClickListener {
                viewModel.patchPost()
            }

            deleteButton.setOnClickListener {
                viewModel.deletePost()
            }
        }
    }

}