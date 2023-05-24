package com.glantrox.learncompose.`interface`

import android.annotation.SuppressLint
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.CornerRadius
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import coil.compose.AsyncImage
import com.glantrox.learncompose.R
import com.glantrox.learncompose.core.dataclasses.models.VideosModel
import com.glantrox.learncompose.navigation.AppNavigator
import com.glantrox.learncompose.ui.theme.LearnComposeTheme
import com.glantrox.learncompose.viewmodel.VideosViewModel




@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun InterfaceEnamUI(navController: NavHostController, viewModel: VideosViewModel = VideosViewModel() ) {
    var isExpanded by remember { mutableStateOf(false) }
    val iconDown: Int = com.google.android.material.R.drawable.material_ic_menu_arrow_down_black_24dp
    val iconUp: Int = com.google.android.material.R.drawable.material_ic_menu_arrow_up_black_24dp


    var video = viewModel.currentVideo.value

    Scaffold() {
        Column {
            Box (
                modifier = Modifier
                    .fillMaxWidth()
                    .height(250.dp)
                    .background(Color.LightGray)
                    ) {
                CircularProgressIndicator(
                    modifier = Modifier.align(
                        alignment = Alignment.Center
                    )
                )
                AsyncImage(model = video?.thumbnailUrl,
                    contentDescription = "",
                    modifier = Modifier
                        .fillMaxWidth(),

                    contentScale = ContentScale.Crop
                )

                IconButton(onClick = {
                    viewModel.clearStateVideo()
                    AppNavigator().pop(navController)
                },
                    content = {
                        Icon(
                            painter = painterResource(R.drawable.baseline_arrow_back_ios_new_24),
                            contentDescription = "backIcon",
                            tint = Color.White
                        )
                    }
                )
            }
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Column(
                ) {
                    if (video != null) {
                        Text(video.title,
                            style = TextStyle(
                                fontSize = 15.sp,
                                fontWeight = FontWeight.Medium
                            ),
                            modifier = Modifier.width(280.dp)
                        )
                    }
                    Text("${video?.views} views • ${video?.date}",
                        style = TextStyle(
                            fontSize = 12.sp
                        )
                    )
                }

                IconButton(onClick = { isExpanded = !isExpanded },
                content = {
                Icon(
                    painter = painterResource(if(isExpanded) iconDown else iconUp),
                    contentDescription ="",
                    modifier = Modifier.align(
                        alignment = Alignment.Top
                    )
                )
                },
                    modifier = Modifier.align(
                        alignment = Alignment.Top
                    )
                )
            }
            AnimatedVisibility(isExpanded) {
                Column {
                    if (video != null) {
                        Text(video.description,
                            style = TextStyle(
                                fontSize = 12.sp
                            ),
                            modifier = Modifier
                                .padding(
                                    start = 16.dp,
                                    end = 16.dp,
                                    bottom = 6.dp
                                )
                                .fillMaxWidth()
                        )
                    }
                    Divider(
                        modifier = Modifier.padding(horizontal = 12.dp)
                    )
                }
            }
            Card(
                modifier = Modifier
                    .padding(12.dp)
                    .height(62.dp)
                    .fillMaxWidth(),
                shape = RoundedCornerShape(8.dp),
            ) {
                Row(
                    modifier = Modifier.fillMaxSize(),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Spacer(modifier = Modifier.size(12.dp))
                    IconButton( onClick = {},
                        content = {
                            AsyncImage(
                                model = video?.authorProfilePicture ,
                                contentDescription = "",
                                modifier = Modifier.fillMaxSize(),
                                contentScale = ContentScale.Crop
                            )
                        },
                        modifier = Modifier
                            .clip(CircleShape)
                            .size(42.dp)
                            .background(Color.DarkGray)

                    )
                    Spacer(modifier = Modifier.size(12.dp))
                    if (video != null) {
                        Column {
                            Text(video.authorName,
                                style = TextStyle(
                                    fontWeight   = FontWeight.Bold
                                )
                            )
                            Text("${video.authorSubscribers} subscribers",
                                style = TextStyle(
                                    fontWeight = FontWeight.Light,
                                    fontSize = 14.sp
                                )
                            )
                        }
                    }
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewInterfaceEnam() {
    LearnComposeTheme {
        InterfaceEnamUI(rememberNavController())
    }
}