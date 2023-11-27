package com.example.capstone.ui.welcomepage

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
import com.example.capstone.ui.component.SecondButton
import com.example.capstone.ui.component.SliceButton
import com.example.capstone.ui.theme.CapstoneTheme

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
            // Your content goes here
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
                SecondButton(
                    text = "LOG IN",
                    modifier = Modifier.padding(horizontal = 30.dp, vertical = 15.dp)
                ) {

                }
//                val changeClor = Color(0xFF373E46)
                SliceButton(
                    text = "SIGN UP",
                    modifier = Modifier
                        .padding(horizontal = 30.dp, vertical = 15.dp)

                ) {

                }
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