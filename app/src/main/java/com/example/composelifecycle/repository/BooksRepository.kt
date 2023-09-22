package com.example.composelifecycle.repository

import com.example.composelifecycle.model.Book

interface BooksRepository {
    suspend fun fetchBooks(): List<Book>

    companion object {
        fun getInstance(): BooksRepository = BooksRepositoryImpl()
    }
}