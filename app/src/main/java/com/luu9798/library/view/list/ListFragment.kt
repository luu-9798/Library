package com.luu9798.library.view.list

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.luu9798.library.R
import com.luu9798.library.model.Book
import com.luu9798.library.view.MainActivity
import com.luu9798.library.viewmodel.MainViewModel

class ListFragment: Fragment() {

    private lateinit var viewModel: MainViewModel
    private lateinit var bookRecyclerView: RecyclerView

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_list, container, false)
        bookRecyclerView = view.findViewById(R.id.recycler_view_book)
        bookRecyclerView.layoutManager = LinearLayoutManager(context)

        return view
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = ViewModelProvider(requireActivity())[MainViewModel::class.java]

        viewModel.booksLiveData.observe(this) {
            if (it != null) {
                populateRecyclerView(it)
            }
        }
    }

    override fun onStart() {
        super.onStart()
        viewModel.booksLiveData.value.let {
            if (it != null) {
                populateRecyclerView(it)
            }
        }
    }

    private fun populateRecyclerView(books: List<Book>) {
        val adapter = BookAdapter(books) {
            viewModel.selectedBook = it
            (activity as MainActivity).navigateToDetailFragment()
        }
        bookRecyclerView.adapter = adapter
    }
}