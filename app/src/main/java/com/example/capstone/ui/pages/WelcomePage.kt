package com.example.capstone.ui.pages

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.capstone.R
import com.example.capstone.ui.theme.CapstoneTheme
import com.example.capstone.ui.component.JetButton
import com.example.capstone.ui.theme.BlackPrimary
import com.example.capstone.ui.theme.BluePrimary

@Composable
fun WelcomePage() {
    val backColor = Color(0xFF669EB6)
    Column(modifier = Modifier
        .fillMaxHeight()
        .fillMaxWidth()
        .background(backColor),

        horizontalAlignment = Alignment.CenterHorizontally,
    ){
        Image(
            painter = painterResource(id = R.drawable.welcome),
            contentDescription = null,
            contentScale = ContentScale.FillBounds,
            modifier = Modifier.height(300.dp)
        )

        Surface(
            modifier = Modifier.fillMaxSize(),
            color = Color.White, // Set your desired background color here
            shape = RoundedCornerShape(topStart = 60.dp, topEnd = 60.dp)
        ) {
            Column(
                modifier = Modifier
                    .fillMaxHeight()
                    .fillMaxWidth()
                    .background(Color.White)
                    .padding(16.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
            ) {
                Image(
                    painter = painterResource(id = R.drawable.welcomeava),
                    contentDescription = null,
                    modifier = Modifier.height(200.dp)
                )
                JetButton(color = BlackPrimary, enabled = true, label = "LOG IN", onClick = {})
                Column(modifier = Modifier.padding(10.dp)){}
                JetButton(color = BluePrimary, enabled = true, label = "SIGN UP", onClick = {})
            }
        }

    }



}

@Preview(showBackground = true, device = Devices.PIXEL)
@Composable
fun WelcomePreview(){
    CapstoneTheme() {
        WelcomePage()
    }
}