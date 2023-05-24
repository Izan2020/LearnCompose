package com.glantrox.learncompose.`interface`




import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
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
import com.glantrox.learncompose.R
import com.glantrox.learncompose.core.dataclasses.models.Analyze
import com.glantrox.learncompose.navigation.AppNavigator
import com.glantrox.learncompose.ui.theme.LearnComposeTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun InterfaceDuaUI(navController: NavHostController) {
    val analyze = listOf(
        Analyze("Income", "+$24.897"),
        Analyze( "Expenses", "-$10.597"),
        Analyze( "Credit used", "$1.347"),
        Analyze( "Available", "$8.953"),
    )
    return Column(
        modifier = Modifier.fillMaxSize()
    ) {
        TopAppBar(
            modifier = Modifier.padding(8.dp),
            title = {
                IconButton(
                    onClick = {
                              AppNavigator().pop(navController)
                    },
                    content = {
                        Icon(
                            painter = painterResource(id = R.drawable.baseline_arrow_back_ios_new_24),
                            contentDescription = "Menu"
                        )
                    }
                )
            },
            actions = {
                IconButton(
                    onClick = {},
                    content = {
                        Icon(
                            painter = painterResource(id = R.drawable.baseline_calendar_month_24),
                            contentDescription = "Menu"
                        )

                    }
                )
            }
        )
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .height(150.dp)
                .padding(22.dp)
        ) {
            Box(
                modifier = Modifier.fillMaxSize()
            ) {
                Column(
                    modifier = Modifier
                        .padding(22.dp)
                        .align(
                            alignment = Alignment.CenterStart
                        )
                ) {
                    Text("Analyze",
                        style = TextStyle(
                            fontWeight = FontWeight.Medium,
                            fontSize = 22.sp
                        )
                    )
                    Text("Income and Expenses.",
                        style = TextStyle(
                            fontWeight = FontWeight.Light,
                            fontSize = 16.sp
                        )
                    )
                }
            }
        }
        Box(
            modifier = Modifier
                .padding(22.dp)
                .fillMaxWidth()
        ) {
          Column {
              Text("August 2021",
                  style = TextStyle(
                      fontWeight = FontWeight.Normal,
                      fontSize = 18.sp
                  )
              )
              LazyColumnAnalyze(items = analyze)

          }
        }
        Box(
            modifier = Modifier
                .padding(22.dp)
                .fillMaxWidth()
        ) {
            Column {
                Text("Notifications",
                    style = TextStyle(
                        fontWeight = FontWeight.Bold,
                        fontSize = 18.sp
                    )
                )
                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(122.dp)
                        .padding(top = 22.dp),
                    content = {
                        Row(
                            modifier = Modifier.fillMaxSize(),
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Icon(
                                modifier = Modifier.height(62.dp).width(62.dp).padding(start = 16.dp),
                                painter = painterResource(id = R.drawable.baseline_circle_notifications_24),
                                contentDescription = "Notifications"
                            )
                            Text("Open your bussiness account within minutes",
                                modifier = Modifier.padding(end = 32.dp, start = 12.dp)
                                )
                        }
                    }
                )
            }
        }
    }
}



@Composable
fun LazyColumnAnalyze(items: List<Analyze>) {
    return LazyColumn(
        modifier = Modifier.padding(top = 22.dp)
    ) {
        items(items) { analyze ->
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 12.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Row(
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Icon(
                        painter = painterResource(id = R.drawable.baseline_monetization_on_24),
                        contentDescription = "Monetization"
                    )
                    Text(analyze.name,
                        modifier = Modifier.padding(
                            start = 8.dp
                        ),
                        style = TextStyle(
                            fontWeight = FontWeight.Medium,
                            fontSize = 14.sp
                        )
                    )
                }
                Text(analyze.value,
                    modifier = Modifier.padding(
                        start = 8.dp
                    ),
                    style = TextStyle(
                        fontWeight = FontWeight.Bold,
                        fontSize = 16.sp
                    )
                )
            }
            Divider(
                modifier = Modifier
                    .padding(top = 12.dp)
                    .fillMaxWidth(),
                color = Color.LightGray
            )
        }
    }
}



@Preview(showBackground = true)
@Composable
fun PreviewInterfaceDua() {
    LearnComposeTheme {

    }
}