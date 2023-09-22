package com.example.composelifecycle

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.remember
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.composelifecycle.composable.BooksScreen
import com.example.composelifecycle.`interface`.BookListViewModel
import com.example.composelifecycle.ui.theme.ComposeLifecycleTheme

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeLifecycleTheme {
                BooksScreen(viewModel = BookListViewModel.getInstance())
            }
        }
    }
}
