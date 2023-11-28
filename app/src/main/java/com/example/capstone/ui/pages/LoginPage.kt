package com.example.capstone.ui.loginpage

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.capstone.R
import com.example.capstone.ui.component.JetButton
import com.example.capstone.ui.theme.CapstoneTheme

@Composable
fun LoginPage() {


    Column(
        modifier = Modifier
            .fillMaxHeight(1f)
            .fillMaxWidth(1f)
            .background(color = Color(android.graphics.Color.parseColor("#ffffff"))),

        horizontalAlignment = Alignment.CenterHorizontally,
    )
    {
        Image(
            painter = painterResource(R.drawable.backgroundwave),
            contentDescription = null,
            contentScale = ContentScale.FillBounds,
            modifier = Modifier.height(150.dp)
        )

        Image(
            painter = painterResource(id = R.drawable.login),
            contentDescription = null,
            modifier = Modifier.height(250.dp)
        )




        Text(
            text = "LOG IN",
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold,
            color = Color(android.graphics.Color.parseColor("#007CFF"))
        )
        Text(
            modifier = Modifier.padding(top = 5.dp, bottom = 20.dp),
            text = "REGISTER YOUR SMART\nFRIDGE ACCOUNT",
            fontSize = 12.sp,
            textAlign = TextAlign.Center,
//            fontWeight = FontWeight.Bold,
            color = Color(android.graphics.Color.parseColor("#000000")),


            )
//        JetButton(
//            label = ""
//        )
//        Spacer(modifier = Modifier.height(20.dp))
//
//        TextFieldPassword(
//            putName = "Your Password",
//            Modifier.padding(top = 15.dp)
//        )
//        SliceButton(
//            text = "LOG IN",
//            modifier = Modifier.padding(horizontal = 30.dp, vertical = 15.dp)
//        ) {
//
//        }

    }
}

@Preview(showBackground = true, device = Devices.PIXEL)
@Composable
fun LoginPreview(){
    CapstoneTheme() {
        LoginPage()
    }
}



