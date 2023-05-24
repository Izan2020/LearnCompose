package com.glantrox.learncompose.`interface`

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.glantrox.learncompose.R
import com.glantrox.learncompose.navigation.AppNavigator
import com.glantrox.learncompose.navigation.Screen
import com.glantrox.learncompose.ui.theme.LearnComposeTheme

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DashboardScreenUI(navController: NavHostController) {
    val selectedItem by remember { mutableStateOf(0) }
    Scaffold(
        floatingActionButton = {
            FloatingActionButton(
                onClick = {
                          AppNavigator().push(navController, Screen.uisatuScreen.route)
                },
                content = { Icon(
                                painter = painterResource(id = R.drawable.baseline_add_24),
                                contentDescription = "Icon Add")
                }
            )
        },
        bottomBar = {
            BottomAppBar {
                NavigationBar(
                ) {
                    NavigationBarItem(
                        label = {
                                Text("Calendar")
                        },
                        selected = selectedItem >= 1  ,
                        onClick = { /*TODO*/ },
                        icon = {
                            Icon(
                                painter = painterResource(id = R.drawable.baseline_calendar_month_24),
                                contentDescription = ""
                            )
                        })
                    NavigationBarItem(
                        label = {
                            Text("People")
                        },
                        selected = selectedItem >= 1  ,
                        onClick = { /*TODO*/ },
                        icon = {
                            Icon(
                                painter = painterResource(id = R.drawable.baseline_person_24),
                                contentDescription = ""
                            )
                        })
                    NavigationBarItem(
                        label = {
                            Text("Transfers")
                        },
                        selected = selectedItem >= 1  ,
                        onClick = { /*TODO*/ },
                        icon = {
                            Icon(
                                painter = painterResource(id = R.drawable.baseline_swap_vertical_circle_24),
                                contentDescription = ""
                            )
                        })
                    NavigationBarItem(
                        label = {
                            Text("Notif")
                        },
                        selected = selectedItem >= 1  ,
                        onClick = { /*TODO*/ },
                        icon = {
                            Icon(
                                painter = painterResource(id = R.drawable.baseline_circle_notifications_24),
                                contentDescription = ""
                            )
                        })
                    NavigationBarItem(
                        label = {
                            Text("Home")
                        },
                        selected = selectedItem >= 1  ,
                        onClick = { /*TODO*/ },
                        icon = {
                            Icon(
                                painter = painterResource(id = R.drawable.baseline_home_24),
                                contentDescription = ""
                            )
                        })
                }
            }
        },
        topBar = { CustomAppBar() } ,
        content = {
            Box(
                modifier = Modifier.fillMaxSize(),
                content = {
                Text(
                    text = "Dashboard Screen",
                    modifier = Modifier.align(alignment = Alignment.Center)
                )
            })
        }
    )
}

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CustomAppBar() {
    return  TopAppBar(
        title = {
            Text(
                text = "Antares App",
                style = TextStyle(
                    color = Color.White,
                    fontWeight = FontWeight.Medium,
                    fontSize = 22.sp
                )
            )},
        navigationIcon = {
            IconButton(
                onClick = { /*TODO*/ },
                content = { Icon(
                    painter = painterResource(
                        id = R.drawable.baseline_menu_24),
                    tint = Color.White,
                    contentDescription = "Logo")})
        },
        colors = TopAppBarDefaults.mediumTopAppBarColors(
            containerColor = Color.Blue
        )


    )
}

@Composable
@Preview(showBackground = true)
fun DashboardScreenPreview() {
    LearnComposeTheme {
        DashboardScreenUI(rememberNavController())
    }
}