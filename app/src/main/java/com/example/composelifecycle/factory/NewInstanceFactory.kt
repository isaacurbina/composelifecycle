package com.example.composelifecycle.factory

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.composelifecycle.repository.BooksRepository
import com.example.composelifecycle.viewmodel.BookListViewModel

class NewInstanceFactory : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return if (modelClass.isAssignableFrom(BookListViewModel::class.java)) {
            BookListViewModel(
                repo = BooksRepository.getInstance()
            ) as T
        } else throw IllegalArgumentException("ViewModel not found")
    }
}
