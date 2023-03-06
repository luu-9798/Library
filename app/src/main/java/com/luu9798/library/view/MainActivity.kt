package com.luu9798.library.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.app.AppCompatViewInflater
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.NavOptions
import androidx.navigation.Navigation
import com.luu9798.library.R
import com.luu9798.library.viewmodel.MainViewModel

class MainActivity : AppCompatActivity() {

    private lateinit var viewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        viewModel = ViewModelProvider(this)[MainViewModel::class.java]
        viewModel.fetchBooks()
    }

    fun navigateToDetailFragment() {
        val options = NavOptions.Builder()
            .build()
        Navigation.findNavController(this, R.id.navigation_host_fragment)
            .navigate(R.id.ListFragment_to_DetailFragment, null, options)
    }

    override fun onSupportNavigateUp(): Boolean {
        val navController = Navigation.findNavController(this, R.id.navigation_host_fragment)
        return navController.navigateUp() || super.onSupportNavigateUp()
    }
}
