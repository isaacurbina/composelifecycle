package com.example.composelifecycle

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import com.example.composelifecycle.composable.BooksScreen
import com.example.composelifecycle.ui.theme.ComposeLifecycleTheme
import com.example.composelifecycle.viewmodel.BookListViewModel

class MainActivity : ComponentActivity() {

    private val viewModel: BookListViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeLifecycleTheme {
                BooksScreen(viewModel = viewModel)
            }
        }
    }

    override fun onResume() {
        super.onResume()
        viewModel.fetchBooks()
    }
}
