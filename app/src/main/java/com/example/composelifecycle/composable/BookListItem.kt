package com.example.composelifecycle.composable

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable

@Composable
fun BookListItem(title: String) {
    Text(text = title)
}