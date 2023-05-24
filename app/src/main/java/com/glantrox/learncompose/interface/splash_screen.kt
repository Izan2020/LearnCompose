package com.glantrox.learncompose.`interface`

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController

import androidx.navigation.compose.rememberNavController
import com.glantrox.learncompose.R
import com.glantrox.learncompose.navigation.AppNavigator
import com.glantrox.learncompose.navigation.Screen
import com.glantrox.learncompose.ui.theme.LearnComposeTheme
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch


@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter", "CoroutineCreationDuringComposition")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SplashScreenUI(navController: NavHostController = rememberNavController()) {
    rememberCoroutineScope().launch {
        delay(3000)
        AppNavigator().pushAndReplace(navController, Screen.loginScreen.route)
    }
    Scaffold(
        content = {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .background(Color.White),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Image(
                    painter = painterResource(id = R.drawable.antares),
                    contentDescription = "Gambar",
                    modifier = Modifier.size(300.dp)
                )
            }
            Box(
                modifier = Modifier.fillMaxSize()
            ) {
                
            }

        }
    )
}

@Preview(showBackground = true)
@Composable
fun Preview() {
    LearnComposeTheme {
    SplashScreenUI()
    }
}

