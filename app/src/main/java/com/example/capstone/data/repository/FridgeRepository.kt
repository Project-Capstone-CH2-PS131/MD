package com.example.capstone.data.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.liveData
import com.example.capstone.data.pref.UserModel
import com.example.capstone.data.pref.UserPreference
import com.example.capstone.data.remote.response.AuthResponse
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
//    suspend fun register(name: String, email: String, password: String): LiveData<UiState<AuthResponse>> =
//        liveData {
//            emit(UiState.Loading)
//            val response = apiService.register(name, email, password)
//            if (!response.error){
//                emit(UiState.Success(response))
//            }else{
//                emit(UiState.Error(response.message))
//            }
//        }



    companion object {
        fun getInstance(
            apiService: ApiService,
            userPreference: UserPreference,
        ): FridgeRepository = FridgeRepository(apiService, userPreference)
    }
}