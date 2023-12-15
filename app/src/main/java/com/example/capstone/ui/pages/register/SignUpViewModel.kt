package com.example.capstone.ui.pages.register

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asFlow
import androidx.lifecycle.viewModelScope
import com.example.capstone.data.remote.response.AuthResponse
import com.example.capstone.data.repository.FridgeRepository
import com.example.capstone.ui.state.UiState
import kotlinx.coroutines.launch

class SignUpViewModel(private val repository: FridgeRepository): ViewModel() {

    suspend fun register(name: String, email: String, password: String) : LiveData<UiState<AuthResponse>> {
        return repository.register(name, email, password)
    }
}