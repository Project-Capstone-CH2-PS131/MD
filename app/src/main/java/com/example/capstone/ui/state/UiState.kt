package com.example.capstone.ui.state

sealed class UiState<out T: Any?> {
    data class Success<out T: Any>(val data:T): UiState<T>()

    data class Error (val errorMessage: String) : UiState<Nothing>()

    object Loading: UiState<Nothing>()
}