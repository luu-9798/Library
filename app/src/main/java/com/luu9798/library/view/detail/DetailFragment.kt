package com.luu9798.library.view.detail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.luu9798.library.R
import com.luu9798.library.view.MainActivity
import com.luu9798.library.viewmodel.MainViewModel

class DetailFragment: Fragment() {

    private lateinit var viewModel: MainViewModel

    private lateinit var titleTextView: TextView
    private lateinit var authorTextView: TextView
    private lateinit var statusTextView: TextView
    private lateinit var feeTextView: TextView
    private lateinit var lastEditedTextView: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = ViewModelProvider(requireActivity())[MainViewModel::class.java]
    }

    override fun onResume() {
        super.onResume()
        (requireActivity() as MainActivity).supportActionBar?.setDisplayHomeAsUpEnabled(true)
    }

    override fun onPause() {
        super.onPause()
        (requireActivity() as MainActivity).supportActionBar?.setDisplayHomeAsUpEnabled(false)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_detail, container, false)

        titleTextView = view.findViewById(R.id.text_view_title)
        authorTextView = view.findViewById(R.id.text_view_author)
        statusTextView = view.findViewById(R.id.text_view_status)
        feeTextView = view.findViewById(R.id.text_view_fee)
        lastEditedTextView = view.findViewById(R.id.text_view_last_edited)

        titleTextView.text = resources.getString(
            R.string.title_display,
            viewModel.selectedBook?.title ?: ""
        )
        authorTextView.text = resources.getString(
            R.string.author_display,
            viewModel.selectedBook?.author ?: ""
        )
        statusTextView.text = resources.getString(
            R.string.status_display,
            viewModel.selectedBook?.status?: ""
        )
        feeTextView.text = resources.getString(
            R.string.fee_display,
            viewModel.selectedBook?.fee ?: ""
        )
        lastEditedTextView.text = resources.getString(
            R.string.last_edited_display,
            viewModel.selectedBook?.lastEdited ?: ""
        )

        return view
    }
}