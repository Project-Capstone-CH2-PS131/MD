package com.example.capstone.ui.pages

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material.FabPosition
import androidx.compose.material.FloatingActionButton
import androidx.compose.material.Icon
import androidx.compose.material.rememberScaffoldState
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.compose.rememberNavController
import com.example.capstone.R
import com.example.capstone.data.Dummy
import com.example.capstone.ui.component.BottomBar
import com.example.capstone.ui.component.JetCard
import com.example.capstone.ui.component.JetSearchBar
import com.example.capstone.ui.theme.BluePrimary

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@ExperimentalMaterial3Api
@Composable
fun MainPage(modifier: Modifier = Modifier, user: String){
    val navController = rememberNavController()
    val scaffoldState = rememberScaffoldState()
    androidx.compose.material.Scaffold(
        bottomBar = { BottomBar(navController = navController) },
        floatingActionButton = {
            FloatingActionButton(
                onClick = { },
                backgroundColor = BluePrimary
            ) {
                Icon(
                    imageVector = ImageVector.vectorResource(id = R.drawable.fridge),
                    contentDescription = "scan",
                    modifier = Modifier.size(36.dp)
                )
            }
        },
        floatingActionButtonPosition = FabPosition.Center,
        isFloatingActionButtonDocked = true,
        scaffoldState = scaffoldState
    ) {
        Image(painter = painterResource(id = R.drawable.corner), contentDescription = null, modifier = Modifier.size(100.dp))
        Text("HI "+user, fontWeight = FontWeight.Bold, fontSize = 20.sp, modifier = Modifier.padding(start = 100.dp, top = 10.dp))
        Column(modifier = modifier.padding(5.dp, top = 50.dp), horizontalAlignment = Alignment.CenterHorizontally) {
            Row(horizontalArrangement = Arrangement.SpaceBetween, verticalAlignment = Alignment.CenterVertically) {
                Column {
                    Text("Whats Your Want To Search?", fontSize = 16.sp)
                }
                Image(
                    painter = painterResource(id = R.drawable.photoprofile),
                    contentDescription = null,
                    modifier = Modifier
                        .height(50.dp)
                )
            }
            JetSearchBar(placeholder = "banana, apple", modifier = Modifier.padding(vertical = 10.dp))

            lazyGrid()
        }
    }

}

@Composable
fun lazyGrid(){
    LazyVerticalGrid(
        columns = GridCells.Fixed(2),
        modifier = Modifier.padding(5.dp),
        horizontalArrangement = Arrangement.spacedBy(5.dp),
        verticalArrangement = Arrangement.spacedBy(10.dp)
    ) {
        items(Dummy.dummys, key = {it.id}) { item ->
            JetCard(image = item.photo, titile = item.name, date = item.date)
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Preview(showBackground = true, device = Devices.PIXEL)
@Composable
fun MainPagePriview(){
    com.example.capstone.ui.theme.CapstoneTheme {
        MainPage(user = "BosToken")
    }
}