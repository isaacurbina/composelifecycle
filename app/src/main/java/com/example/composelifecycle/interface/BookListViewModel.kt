package com.example.composelifecycle.`interface`

import androidx.lifecycle.LiveData
import com.example.composelifecycle.model.Book
import com.example.composelifecycle.repository.BooksRepository

interface BookListViewModel {
    // Data
    val books: LiveData<List<Book>>

    // Operations
    fun fetchBooks()

    companion object {
        fun getInstance(): BookListViewModel = BookListViewModelImpl(BooksRepository.getInstance())
    }
}