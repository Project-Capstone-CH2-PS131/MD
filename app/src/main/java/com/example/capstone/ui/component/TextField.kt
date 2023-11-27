package com.example.capstone.ui.component

import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.AccountBox
import androidx.compose.material.icons.outlined.Email
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.capstone.ui.theme.CapstoneTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TextFieldEmail(
    putName: String,
    modifier: Modifier = Modifier
) {
    var filledText by remember {
        mutableStateOf("")
    }
    val myColor = Color(0xFF87CEEB)
    val useColor = Color(0x4D87CEEB)
    TextField(
        value = filledText,
        onValueChange = {filledText = it},
        label = {
            Text(text = putName)
        },
        leadingIcon = {
            Icon(
                imageVector = Icons.Outlined.Email,
                contentDescription = null,
                tint = myColor
            )
        },
        shape = RoundedCornerShape(15.dp),
        keyboardOptions = KeyboardOptions(
            keyboardType = KeyboardType.Email
        ),
        colors = TextFieldDefaults.textFieldColors(
            unfocusedLabelColor = Color.LightGray,
            focusedLabelColor = myColor,
            unfocusedIndicatorColor = myColor,
            focusedIndicatorColor = myColor,
            containerColor = useColor.copy(.1f)
        )

    )



}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TextFieldPassword(
    putName: String,
    modifier: Modifier = Modifier
){
    var filledTextPass by remember {
        mutableStateOf("")
    }
    val myColor = Color(0xFF87CEEB)
    val useColor = Color(0x4D87CEEB)
    val indacatorColor = Color(0xFF007CFF)

    TextField(
        value = filledTextPass,
        onValueChange = {filledTextPass = it},
        label = {
            Text(text = putName)
        },
        leadingIcon = {
            Icon(
                imageVector = Icons.Outlined.AccountBox,
                contentDescription = null,
                tint = myColor
            )
        },
        shape = RoundedCornerShape(15.dp),
        visualTransformation = PasswordVisualTransformation(),
        colors = TextFieldDefaults.textFieldColors(
            unfocusedLabelColor = Color.LightGray,
            focusedLabelColor = myColor,
            unfocusedIndicatorColor = myColor,
            focusedIndicatorColor = myColor,
            containerColor = useColor.copy(.1f)
        )
    )
}

@Preview(showBackground = true)
@Composable
fun TextPreview(){
    CapstoneTheme {
        TextFieldEmail(putName = "Ur Email")
    }
}