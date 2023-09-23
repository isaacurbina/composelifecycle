package com.example.composelifecycle.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.composelifecycle.model.Book
import com.example.composelifecycle.repository.BooksRepository
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class BookListViewModel(
    private val repo: BooksRepository = BooksRepository.getInstance(),
    private val ioDispatcher: CoroutineDispatcher = Dispatchers.IO
) : ViewModel() {

    private val _books = MutableLiveData<List<Book>>()
    val books: LiveData<List<Book>> = _books

    fun fetchBooks() {
        viewModelScope.launch(ioDispatcher) {
            _books.postValue(repo.fetchBooks())
        }
    }
}