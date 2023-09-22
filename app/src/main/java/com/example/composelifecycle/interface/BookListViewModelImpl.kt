package com.example.composelifecycle.`interface`

import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.composelifecycle.model.Book
import com.example.composelifecycle.repository.BooksRepository
import kotlinx.coroutines.launch

class BookListViewModelImpl(private val repo: BooksRepository) : BookListViewModel, ViewModel() {
    private val _books = MutableLiveData<List<Book>>()
    override val books: LiveData<List<Book>> = _books

    override fun fetchBooks() {
        viewModelScope.launch {
            _books.value = repo.fetchBooks()
        }
    }
}