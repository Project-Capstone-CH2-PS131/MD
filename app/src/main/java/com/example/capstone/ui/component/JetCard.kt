package com.example.capstone.ui.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.capstone.R


@Composable
fun JetCard(
    modifier: Modifier = Modifier,
    title: String,
    date: String
) {
    ElevatedCard(
        modifier = modifier.size(width = 200.dp, height = 175.dp),
        elevation = CardDefaults.cardElevation(
            defaultElevation = 6.dp
        ),
        shape = RoundedCornerShape(15.dp)
    ) {
        Column {
            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                Image(painter = painterResource(id = R.drawable.apple), contentDescription = null, modifier = Modifier.size(width = 200.dp, height = 120.dp))
            }
            Column(modifier = Modifier.padding(start = 10.dp, top = 10.dp)) {
                Text(text = title, fontWeight = FontWeight.Bold, fontSize = 17.sp)
                Text(text = date, fontSize = 13.sp)
            }
        }
    }
}

