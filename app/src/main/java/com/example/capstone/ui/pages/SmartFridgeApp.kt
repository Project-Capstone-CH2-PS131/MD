package com.example.capstone.ui.pages

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.FabPosition
import androidx.compose.material.FloatingActionButton
import androidx.compose.material.Icon
import androidx.compose.material.Scaffold
import androidx.compose.material.rememberScaffoldState
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.capstone.R
import com.example.capstone.ui.component.BottomBar
import com.example.capstone.ui.loginpage.LoginPage
import com.example.capstone.ui.navigation.Screen
import com.example.capstone.ui.theme.BluePrimary
import com.example.capstone.ui.theme.CapstoneTheme
import com.example.capstone.ui.welcomepage.WelcomePage

@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun SmartFridgeApp(
    modifier: Modifier = Modifier,
    navController:NavHostController = rememberNavController()
) {

    val scaffoldState = rememberScaffoldState()
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry?.destination?.route

    Scaffold(
        bottomBar = {
                       BottomBar(navController = navController)
                    },
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
        Column(
            modifier = Modifier
                .fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            NavHost(
                navController = navController,
                startDestination = Screen.Home.route,
                modifier = Modifier.padding(it)
            ){
                composable(Screen.Home.route){
                    MainPage(user = "Zufar")
                }
                composable(Screen.Profile.route){
                    ProfilePage(nameProfile = "zufar", email = "zufar@gmail.com")
                }
                composable(Screen.Setting.route){
//                    INI MASI PERCOBAAN
                    WelcomePage()
                }
                composable(Screen.Favorite.route){
//                    INIPUN
                   LoginPage()
                }
            }
        }
        }
    }



@Preview(showBackground = true, device = Devices.PIXEL)
@Composable
fun SmartFrigePreview(){
    CapstoneTheme() {
        SmartFridgeApp()
    }
}