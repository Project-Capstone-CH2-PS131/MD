package com.example.capstone.ui.pages

import android.graphics.drawable.Icon
import android.media.JetPlayer
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.AccountBox
import androidx.compose.material.icons.outlined.Email
import androidx.compose.material.icons.outlined.Person
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.capstone.R
import com.example.capstone.ui.component.JetButton
import com.example.capstone.ui.component.JetTextField
import com.example.capstone.ui.pages.ui.theme.CapstoneTheme
import com.example.capstone.ui.theme.BlackPrimary
import com.example.capstone.ui.theme.BluePrimary
import com.example.capstone.ui.theme.BlueText


@Composable
fun SignUpPage(){
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
        JetTextField(hint = "USERNAME", icon = Icons.Outlined.Person, keyboardType = KeyboardType.Text)
        Column(modifier = Modifier.padding(5.dp)){}
        JetTextField(hint = "EMAIL", icon = Icons.Outlined.Email, keyboardType = KeyboardType.Email)
        Column(modifier = Modifier.padding(5.dp)){}
        JetTextField(hint = "PASSWORD", icon = Icons.Outlined.AccountBox, keyboardType = KeyboardType.Password)
        Column(modifier = Modifier.padding(20.dp)){}
        JetButton(onClick = {}, color = BluePrimary, enabled = true, label = "SIGN UP")
    }
}