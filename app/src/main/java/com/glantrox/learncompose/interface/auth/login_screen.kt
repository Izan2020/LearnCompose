package com.glantrox.learncompose.`interface`.auth
import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.glantrox.learncompose.R
import com.glantrox.learncompose.navigation.AppNavigator
import com.glantrox.learncompose.navigation.Screen

import com.glantrox.learncompose.ui.theme.LearnComposeTheme


@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun LoginScreenUI(navController: NavHostController) {
    Scaffold(
    content = {
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                painter = painterResource(id = R.drawable.antares),
                contentDescription = "Logo",
                modifier = Modifier.size(250.dp)
            )
            TextField(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 62.dp),
                value = "" ,
                placeholder = {
                    Text(text = "Email")
                },
                onValueChange = {} )
            TextField(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(
                        horizontal = 62.dp,
                        vertical = 12.dp
                    ),
                value = "" ,
                placeholder = {
                    Text(text = "Password")
                },
                onValueChange = {}
            )
            Text(
                text = "Forgot Password?",
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 62.dp),
                textAlign = TextAlign.End,
                fontSize = 13.sp,


                )
            Column(
                modifier = Modifier.padding(vertical = 32.dp)
            ) {
                Button(
                    onClick = {
                        AppNavigator().pushAndReplace(navController, Screen.dashboardScreen.route)
                    },
                    content = { Text("Login") },
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(
                            horizontal = 62.dp,
                            vertical = 12.dp
                        ),
                )
                Text(
                    text = "Register",
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 62.dp),
                    textAlign = TextAlign.Center,

                )
            }
        }
    }
)
}



@Preview(showBackground = true)
@Composable
fun Preview() {
    LearnComposeTheme {
    LoginScreenUI(rememberNavController())
    }
}
