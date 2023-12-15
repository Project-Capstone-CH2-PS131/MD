package com.example.capstone.ui.pages.login

import androidx.lifecycle.ViewModel
import com.example.capstone.data.repository.AuthRepository

class LoginViewModel(private val authRepository: AuthRepository): ViewModel() {
    fun login(email: String, password: String) = authRepository.login(email, password)
}