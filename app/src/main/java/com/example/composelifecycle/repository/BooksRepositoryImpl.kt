package com.example.composelifecycle.repository

import com.example.composelifecycle.model.Book

class BooksRepositoryImpl : BooksRepository {
    override suspend fun fetchBooks(): List<Book> {
        // Some API call
        // Parser logic
        return listOf(
            Book(System.currentTimeMillis().toString()),
            Book("book1"),
            Book("2book"),
            Book("libro3"),
            Book("4livre"),
            Book("shuwu")
        )
    }
}