package com.luu9798.library.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.luu9798.library.model.Book
import com.luu9798.library.network.BookRepository
import kotlinx.coroutines.launch

class MainViewModel: ViewModel() {
    private val bookRepository = BookRepository()

    private val _booksLiveData = MutableLiveData<List<Book>>()
    val booksLiveData: LiveData<List<Book>>
        get() = _booksLiveData

    var selectedBook: Book? = null

    fun fetchBooks() {
        viewModelScope.launch {
            bookRepository.getBooks().collect {
                if (it.isSuccess) {
                    _booksLiveData.postValue(it.getOrThrow())
                }
            }
        }
    }
}
