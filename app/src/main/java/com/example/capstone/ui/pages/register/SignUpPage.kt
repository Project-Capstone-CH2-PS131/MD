package com.example.capstone.ui.pages.register

import android.content.Context
import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.AccountBox
import androidx.compose.material.icons.outlined.Email
import androidx.compose.material.icons.outlined.Person
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.capstone.R
import com.example.capstone.data.remote.response.AuthResponse
import com.example.capstone.data.remote.retrofit.ApiConfig
import com.example.capstone.di.Injection
import com.example.capstone.ui.ViewModelFactory
import com.example.capstone.ui.component.JetButton
import com.example.capstone.ui.component.JetTextField
import com.example.capstone.ui.theme.BlackPrimary
import com.example.capstone.ui.theme.BluePrimary
import com.example.capstone.ui.theme.BlueText
import retrofit2.Call
import retrofit2.Callback

@Composable
fun SignUpPage(
    context: Context = LocalContext.current,
    viewModel: SignUpViewModel = androidx.lifecycle.viewmodel.compose.viewModel(
        factory = ViewModelFactory(Injection.provideRepository(context)))
){
    var username by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxHeight(1f)
            .fillMaxWidth(1f),
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        Image(
            painter = painterResource(id = R.drawable.regist),
            contentDescription = null,
            modifier = Modifier
                .height(300.dp)
                .padding(top = 50.dp)
        )
        Text(
            text = "SIGN UP",
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold,
            color = BlueText
        )
        Text(
            modifier = Modifier.padding(top = 5.dp, bottom = 20.dp),
            text = "REGISTER YOUR SMART\nFRIDGE ACCOUNT",
            fontSize = 12.sp,
            textAlign = TextAlign.Center,
            color = BlackPrimary,
        )
        JetTextField(
            hint = "USERNAME",
            icon = Icons.Outlined.Person,
            keyboardType = KeyboardType.Text,
            value = { new -> username = new })
        Column(modifier = Modifier.padding(5.dp)){}
        JetTextField(hint = "EMAIL", icon = Icons.Outlined.Email, keyboardType = KeyboardType.Email, value = { new -> email = new })
        Column(modifier = Modifier.padding(5.dp)){}
        JetTextField(hint = "PASSWORD", icon = Icons.Outlined.AccountBox, keyboardType = KeyboardType.Password, value = { new -> password = new })
        Column(modifier = Modifier.padding(20.dp)){}
        JetButton(
//            onClick = { viewModel.register(username, email, password)},
            onClick = {},
            color = BluePrimary, enabled = true, label = "SIGN UP")
    }
}

//private fun register(username: String, email: String, password: String){
//    val client = ApiConfig.getApiService().register(username, email, password)
//    client.enqueue(object : Callback<AuthResponse>{
//        override fun onResponse(call: Call<AuthResponse>, response: retrofit2.Response<AuthResponse>) {
//            if (response.isSuccessful){
//                val responseBody = response.body()
//                Log.d("test123", "success "+responseBody!!.token)
//            }
//            else{
//            }
//        }
//
//        override fun onFailure(call: Call<AuthResponse>, t: Throwable) {
//            Log.d("Error : ", call.toString())
//        }
//    })
//}

