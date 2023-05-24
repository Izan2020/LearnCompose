package com.glantrox.learncompose.`interface`

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color

import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import coil.compose.AsyncImage
import com.glantrox.learncompose.R
import com.glantrox.learncompose.core.dataclasses.database.AppDatabase
import com.glantrox.learncompose.core.dataclasses.models.VideosModel
import com.glantrox.learncompose.navigation.AppNavigator
import com.glantrox.learncompose.navigation.Screen
import com.glantrox.learncompose.ui.theme.LearnComposeTheme
import com.glantrox.learncompose.viewmodel.VideosViewModel


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun InterfaceLimaUI(navController: NavHostController, viewModel: VideosViewModel = VideosViewModel()) {
    val listOfVideos = AppDatabase().videos
    Scaffold(
        topBar = {
            TopAppBar(
                actions = {
                    IconButton(onClick = { /*TODO*/ },
                        content = {
                            Icon(
                                painter = painterResource(R.drawable.baseline_more_vert_24),
                                contentDescription = "backIcon",
                            )
                        }
                    )
                },
                navigationIcon = {
                    IconButton(onClick = { /*TODO*/ },
                        content = {
                            Image(
                                painter = painterResource(R.drawable.drawable_yt),
                                contentDescription = "backIcon"
                            )
                        }
                    )
                },
                title = {
                    Text("YouTube",
                        style = TextStyle(
                            textAlign = TextAlign.Center,
                            fontSize = 18.sp,
                            fontWeight = FontWeight.Black
                        ),
                        modifier = Modifier.fillMaxWidth()
                    )
                }
            )
        }
    ) {
        Column(
            modifier = Modifier.padding(it)
        ) {
        LazyColumn {
            items(listOfVideos) {
                ItemVideos(it, onTap = {
                    viewModel.setStateVideo(it)
                    AppNavigator().push(navController, Screen.uienamScreen.route)
                })
            }
        }
        }
    }
}

@Composable
fun ItemVideos(vid: VideosModel, onTap: () -> Unit) {
    Column(
        modifier = Modifier.clickable { onTap() }
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(230.dp)
                .background(Color.Gray)
                .clip(RoundedCornerShape(8.dp)),
        ) {
            AsyncImage(
                modifier = Modifier
                    .fillMaxSize()
                    .clip(RoundedCornerShape(8.dp)),
                contentScale = ContentScale.Crop,
                model = vid.thumbnailUrl ,
                contentDescription = ""
            )
            Card(
                modifier = Modifier
                    .align(
                        alignment = Alignment.BottomEnd
                    )
                    .padding(12.dp),
                colors = CardDefaults.cardColors(
                    containerColor = if(vid.isLiveContent) Color.Red else Color.DarkGray,
                    contentColor = Color.White
                ),
                shape = RoundedCornerShape(4.dp)
            ) {
                Text(if (vid.isLiveContent) "LIVE" else vid.duration,
                    modifier = Modifier.padding(vertical = 2.dp, horizontal = 4.dp),
                    style = TextStyle(
                        fontSize = 12.sp
                    )
                )
            }
        }
        Column(
            modifier = Modifier.padding(horizontal = 12.dp, vertical = 7.dp)
        ) {


            Spacer(modifier = Modifier.size(8.dp))
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 8.dp),

                ) {
                IconButton( onClick = {},
                    content = {
                        AsyncImage(
                            model = vid.authorProfilePicture ,
                            contentDescription = "",
                            modifier = Modifier.fillMaxSize(),
                            contentScale = ContentScale.Crop
                        )
                    },
                    modifier = Modifier
                        .clip(CircleShape)
                        .size(36.dp)
                        .background(Color.DarkGray)
                        .padding(top = 8.dp)
                )
                Column(
                    modifier = Modifier.padding(start = 8.dp)
                ) {
                    Text(vid.title,
                        style = TextStyle(
                            fontSize = 16.sp,
                            fontWeight = FontWeight.Bold
                        ),
                        overflow = TextOverflow.Ellipsis,
                        maxLines = 2
                    )
                    Text("${vid.authorName} • ${vid.views} views • ${vid.date}",
                        style = TextStyle(
                            fontSize = 13.sp,
                            fontWeight = FontWeight.Light
                        )
                    )
                }
            }
        }
    }

}



@Preview(showBackground = true)
@Composable
fun PreviewInterfaceLima() {
    LearnComposeTheme {
        InterfaceLimaUI(rememberNavController())
    }
}