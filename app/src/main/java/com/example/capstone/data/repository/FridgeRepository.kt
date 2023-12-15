package com.example.capstone.data.repository

import androidx.lifecycle.liveData
import com.example.capstone.data.pref.UserModel
import com.example.capstone.data.pref.UserPreference
import com.example.capstone.data.remote.retrofit.ApiService
import com.example.capstone.ui.state.UiState
import kotlinx.coroutines.flow.Flow

class FridgeRepository private constructor(
    private val apiService: ApiService,
    private val userPreference: UserPreference,
){
    suspend fun saveSeasoin(user: UserModel){
        userPreference.saveSession(user)
    }

     fun getSession(): Flow<UserModel>{
         return userPreference.getSession()
     }

    suspend fun logout(){
        userPreference.logout()
    }

//    Create Account
    suspend fun regiter(name: String, email: String, password: String) =
        liveData {
            emit(UiState.Loading)
            try {
                val successRespone = apiService.register(name, email, password)
                emit(UiState.Success(successRespone))
            } catch (e: Exception){
                emit(UiState.Error("Error: ${e.message.toString()}"))
            }
        }



    companion object {
        fun getInstance(
            apiService: ApiService,
            userPreference: UserPreference,
        ): FridgeRepository = FridgeRepository(apiService, userPreference)
    }
}