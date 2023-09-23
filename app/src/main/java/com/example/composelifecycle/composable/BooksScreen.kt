package com.example.composelifecycle.composable

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Refresh
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import com.example.composelifecycle.viewmodel.BookListViewModel

@Composable
fun BooksScreen(
    viewModel: BookListViewModel
) {
    // State
    val books = viewModel.books.observeAsState()
    val refreshCount by remember { mutableIntStateOf(1) }

    // API call
    LaunchedEffect(key1 = refreshCount) {
        viewModel.fetchBooks()
    }

    // UI
    Column {
        IconButton(onClick = {
            refreshCount.inc()
        }) {
            Icon(Icons.Outlined.Refresh, "Refresh")
        }
        books.value?.forEach {
            BookListItem(title = it.title)
        }
        LazyColumn {
            items(books.value.orEmpty()) { book ->
                // List item composable
                BookListItem(title = book.title)
            }
        }
    }
}