package com.glantrox.learncompose.`interface`

import android.annotation.SuppressLint
import androidx.compose.foundation.clickable
import androidx.compose.foundation.gestures.Orientation
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
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
fun InterfaceSatuUI(navController: NavHostController) {
    val items = listOf("Services", "Transfers")
    val itemsTransactions = listOf("Antonnio","Carl","Alex","Johnson")

    return Column(
        modifier = Modifier.fillMaxSize().scrollable(
            state = rememberScrollState(),
            orientation = Orientation.Vertical

        )
    ) {
        TopAppBar(
            modifier = Modifier.padding(8.dp),
            title = {
                Text("Money flow",
                        style = TextStyle(
                            fontSize = 22.sp,
                            fontWeight = FontWeight.Bold
                        )
                    )
                    },
            actions = {
                IconButton(
                    onClick = {
                    },
                    content = {
                        Icon(
                            painter = painterResource(id = R.drawable.baseline_menu_24),
                            contentDescription = "Menu"
                        )
                    }
                )
            }
        )
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .height(200.dp)
                .padding(22.dp),
            colors = CardDefaults.cardColors(contentColor = Color.DarkGray),
            content = {
                    Box(
                        modifier = Modifier.fillMaxSize()
                    ) {
                        Box(
                            modifier = Modifier
                                .padding(18.dp)
                                .fillMaxWidth()
                        ) {
                            Column(
                                modifier = Modifier.align(
                                    alignment = Alignment.CenterStart
                                )
                            ) {
                                Text("Total balance",
                                    style = TextStyle(
                                        color = Color.DarkGray,
                                        fontWeight = FontWeight.Light
                                    )
                                )
                                Text("24.022",
                                    style = TextStyle(
                                        color = Color.DarkGray,
                                        fontWeight = FontWeight.Medium,
                                        fontSize = 36.sp
                                    )
                                )
                            }
                            Icon(
                                modifier = Modifier
                                    .align(
                                        alignment = Alignment.TopEnd
                                    )
                                    .clickable {
                                        AppNavigator().push(navController, Screen.uiduaScreen.route)
                                    },
                                painter = painterResource(id = R.drawable.baseline_notifications_active_24),
                                contentDescription = "Notification"
                            )

                        }

                       Box(
                           modifier = Modifier
                               .align(
                                   Alignment.BottomCenter
                               )
                               .fillMaxWidth()
                               .padding(18.dp)
                       ) {
                           Text("**** 3567",
                               style = TextStyle(
                                 fontWeight = FontWeight.Bold
                               ),
                               modifier = Modifier.align(
                                   alignment = Alignment.CenterStart
                               )
                           )
                           Card(
                               modifier = Modifier.align(
                                   alignment = Alignment.CenterEnd
                               ),
                               colors = CardDefaults.cardColors(
                                   containerColor = Color.Yellow
                               ),
                               content = {
                                 Row(
                                     modifier = Modifier.padding(8.dp),
                                     verticalAlignment = Alignment.CenterVertically
                                     ) {
                                     Text("USD",
                                         modifier = Modifier.padding(
                                             end = 12.dp,
                                             start = 6.dp
                                         ),
                                         style = TextStyle(
                                             fontWeight = FontWeight.Bold
                                         )
                                     )
                                     Icon(
                                        painter = painterResource(id = R.drawable.baseline_add_24),
                                        contentDescription = "Money"
                                     )
                                 }
                               }
                           )
                       }
                    }
                }
            )
            Box(
                modifier = Modifier
                    .padding(22.dp)
                    .fillMaxWidth()
            ) {
                Column(
                    modifier = Modifier.align(
                        alignment = Alignment.CenterStart
                    )
                ) {
                    Text("Statistics")
                    Spacer(modifier = Modifier.height(8.dp))
                    LinearProgressIndicator(
                        modifier = Modifier.height(12.dp),

                    )

                    Spacer(modifier = Modifier.height(8.dp))
                    Row {
                        Text("$10.597 ",
                                style = TextStyle(
                                    fontWeight = FontWeight.Medium,

                                )
                            )
                        Text("expenses",
                            style = TextStyle(
                                fontWeight = FontWeight.Light
                            )
                            )
                    }
                }
                Column(
                    modifier = Modifier.align(
                        alignment = Alignment.CenterEnd
                    )
                ) {
                    Text("$10.3k",
                        modifier = Modifier.align(
                            alignment = Alignment.CenterHorizontally
                        ),
                        style = TextStyle(
                            fontWeight = FontWeight.Medium,
                            fontSize = 22.sp
                        )
                        )
                    Text("available",
                        modifier = Modifier.align(
                            alignment = Alignment.CenterHorizontally
                        ),
                        style = TextStyle(
                            fontWeight = FontWeight.Light
                        )
                        )
                }
            }
            Box(
                modifier = Modifier
                    .padding(22.dp)
                    .fillMaxWidth()
            ) {
                Column {
                    Box(
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        Text("Services",
                            modifier = Modifier.align(
                                alignment = Alignment.CenterStart
                            ),
                            style = TextStyle(
                                fontWeight = FontWeight.Bold,
                                fontSize = 18.sp
                            )
                        )
                        IconButton(onClick = { /*TODO*/ },
                            modifier = Modifier.align(
                                alignment = Alignment.CenterEnd
                            ),
                            content = {
                                Icon(
                                    modifier = Modifier.padding(start = 22.dp),
                                    painter = painterResource(id = R.drawable.baseline_navigate_next_24),
                                    contentDescription = "Services"
                                )
                            }
                        )
                    }
                    LazyRow {
                        items(items) {
                            Card(
                                modifier = Modifier
                                    .height(92.dp)
                                    .padding(5.dp)
                                    .width(162.dp),
                                content = {
                                    Box(
                                        modifier = Modifier.fillMaxSize()
                                    ) {
                                        Column(
                                            modifier = Modifier
                                                .align(
                                                    alignment = Alignment.CenterStart
                                                )
                                                .padding(12.dp)
                                        ) {
                                            Icon(
                                                painter = painterResource(
                                                    if(it == "Services")
                                                        R.drawable.baseline_swap_vertical_circle_24
                                                    else
                                                        R.drawable.baseline_monetization_on_24 ),
                                                contentDescription = "Icon"
                                            )
                                            Text(it,
                                                style = TextStyle(
                                                    fontWeight = FontWeight.Medium,
                                                    fontSize = 16.sp
                                                )
                                                )
                                        }
                                    }
                                }
                            )
                        }
                    }
                }

            }
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .padding(22.dp)
        ) {
            Column {
                Box(
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Text("Recent Transactions",
                        modifier = Modifier.align(
                            alignment = Alignment.CenterStart
                        ),
                        style = TextStyle(
                            fontWeight = FontWeight.Bold,
                            fontSize = 18.sp
                        )
                    )
                    IconButton(onClick = { /*TODO*/ },
                        modifier = Modifier.align(
                            alignment = Alignment.CenterEnd
                        ),
                        content = {
                            Icon(
                                modifier = Modifier.padding(start = 22.dp),
                                painter = painterResource(id = R.drawable.baseline_navigate_next_24),
                                contentDescription = "Services"
                            )
                        }
                    )
                }
                LazyRow {
                    items(itemsTransactions) {
                        Box() {
                            Column {
                                Icon(
                                    painter = painterResource(id = R.drawable.baseline_monetization_on_24),
                                    contentDescription = "People",
                                    modifier = Modifier
                                        .height(90.dp)
                                        .width(90.dp)
                                        .padding(12.dp)
                                )
                                Text(it,
                                    modifier = Modifier.align(
                                        alignment = Alignment.CenterHorizontally
                                    )
                                    )
                            }
                        }
                    }
                }
            }
        }
    }
}




@Preview(showBackground = true)
@Composable
fun PreviewInterfaceSatu() {
    LearnComposeTheme {
        InterfaceSatuUI(rememberNavController())
    }
}