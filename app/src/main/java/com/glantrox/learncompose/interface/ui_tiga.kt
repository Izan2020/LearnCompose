package com.glantrox.learncompose.`interface`

import android.annotation.SuppressLint
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.gestures.Orientation
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.rememberScrollState
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
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
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.glantrox.learncompose.R
import com.glantrox.learncompose.core.dataclasses.models.CuisinesModel
import com.glantrox.learncompose.ui.theme.LearnComposeTheme

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun InterfaceTigaUI() {
    val listOfFoods: List<CuisinesModel> = listOf(
        CuisinesModel(1, "Sushi Mentai", "Japanese Sushi with Salmon, and Mentai Sauce", "https://cdn.discordapp.com/attachments/1110006269571514438/1110404676874162246/image.png","32.000",
            "Japanese Sushi with Salmon and Mentai Sauce combines the exquisite flavors of fresh salmon and the unique tang of mentai sauce, creating a delectable culinary experience. This tantalizing dish showcases the artistry of Japanese cuisine, as the delicate slices of salmon are expertly rolled with seasoned rice and wrapped in a sheet of nori. The creamy and slightly spicy mentai sauce adds a burst of umami, perfectly complementing the rich flavor of the salmon. Whether enjoyed as a traditional sushi roll or as delicate pieces of nigiri, this fusion of ingredients delights the palate with its harmonious blend of textures and tastes, embodying the essence of Japanese gastronomy."),
        CuisinesModel(2,"Korean Chicken Wings","Spicy and sweet sauce with tasty chicken wing", "https://cdn.discordapp.com/attachments/1110006269571514438/1110405403176620142/image.png","32.000",
            "The Spicy and Sweet Sauce with Tasty Chicken Wings offers a tantalizing blend of flavors that perfectly balances the heat of spiciness with a delightful touch of sweetness. This delectable sauce coats succulent chicken wings, creating a mouthwatering culinary experience. The spicy elements add a fiery kick that awakens the taste buds, while the sweetness provides a pleasing contrast, enhancing the overall savory profile of the dish. Each bite delivers a burst of flavor as the tender chicken is infused with the zesty sauce, creating a harmonious fusion of tastes. Whether enjoyed as a delightful appetizer or a satisfying main course, this combination of spicy and sweet sauce with tasty chicken wings is sure to leave a lasting impression on your palate."),
        CuisinesModel(3,"Mango Sticky Rice","Sweet flavour mango and rice","https://cdn.discordapp.com/attachments/1110006269571514438/1110405327934980137/image.png","40.000",
            "Mango Sticky Rice is a delightful Thai dessert that combines the natural sweetness of ripe mangoes with the creamy richness of coconut-infused sticky rice. This heavenly treat showcases the harmonious marriage of flavors and textures, where the soft and slightly sticky rice is delicately steamed and infused with the aromatic essence of coconut milk. The luscious mangoes, perfectly ripe and juicy, provide a refreshing and tropical counterpart to the rice, adding a burst of tangy sweetness. With each spoonful, the velvety rice and succulent mango harmonize in a blissful symphony, creating a dessert that is both comforting and indulgent. Mango Sticky Rice captures the essence of Thai cuisine, offering a tantalizing combination of simplicity and complexity that delights the senses and leaves a lasting impression."),
        CuisinesModel(4,"Wagyu Steak","WAHYU A5?!!!","https://cdn.discordapp.com/attachments/1110006269571514438/1110405456943403049/image.png","79.000",
            "Wagyu Steak is a pinnacle of culinary excellence, renowned for its unmatched tenderness, marbling, and exceptional flavor. Originating from Japan, this premium beef is meticulously raised and carefully bred to produce meat that is exceptionally tender and succulent. Each bite of Wagyu Steak is an exquisite experience, as the delicate marbling of fat melts seamlessly into the meat, resulting in a buttery, melt-in-your-mouth sensation. The rich, intense flavor profile boasts notes of umami and a distinct, unparalleled juiciness. Cooked to perfection, whether seared on a grill or gently pan-fried, the Wagyu Steak is a true indulgence for steak enthusiasts, offering a culinary journey that epitomizes luxury and refinement."
            )
    )
    Scaffold(
        topBar = {
            TopAppBar(
                actions = {
                          Row(
                              modifier = Modifier.padding(end = 12.dp)
                          ) {
                              Icon(
                                  painter = painterResource(R.drawable.baseline_search_24),
                                  contentDescription = "",
                                  modifier = Modifier.padding(end = 12.dp)
                              )
                              Icon(
                                  painter = painterResource(R.drawable.baseline_share_24),
                                  contentDescription = ""
                              )
                          }
                },
                navigationIcon = {
                    IconButton(onClick = { /*TODO*/ },
                        content = {
                            Icon(
                                painter = painterResource(R.drawable.baseline_arrow_back_24),
                                contentDescription = "backIcon"
                            )
                        }
                        )
                },
                title = {

                }
            )
        }
    ) {
        Column(
            modifier = Modifier
                .padding(it)
                .fillMaxSize()
                .scrollable(
                    state = rememberScrollState(),
                    orientation = Orientation.Vertical,
                    enabled = true
                )
        ) {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(14.dp)
            ) {
               Column(
                   modifier = Modifier.align(
                       alignment = Alignment.CenterStart
                   )
               ) {
                   Text("GoFood Festival",
                        style = TextStyle(
                            fontWeight = FontWeight.Black,
                            fontSize = 24.sp
                        ))
                   Row(
                       modifier = Modifier.padding(top = 8.dp),
                       verticalAlignment = Alignment.CenterVertically
                   ) {
                       Card(
                           colors = CardDefaults.cardColors(
                               containerColor = Color(android.graphics.Color.parseColor("#f26300")),
                               contentColor = Color.White
                           )
                       ) {
                        Row(
                            modifier = Modifier.padding(4.dp),
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Icon(
                                painter = painterResource(R.drawable.baseline_thumb_up_alt_24),
                                contentDescription = "",
                                modifier = Modifier.size(18.dp)
                            )
                            Text("Super Partner",
                                fontSize = 12.sp,
                                style = TextStyle(
                                    fontWeight = FontWeight.Medium
                                ),
                                modifier = Modifier.padding(start = 4.dp)
                            )
                        }
                       }
                       Text("Japanese, Rice",
                           style = TextStyle(
                               fontSize = 12.sp,
                           ),
                            modifier = Modifier.padding(start = 6.dp)
                           )
                   }
               }
                Card(
                    modifier = Modifier
                        .align(
                            alignment = Alignment.CenterEnd
                        )
                        .height(62.dp)
                        .width(62.dp)
                ) {
                    Image(
                        modifier = Modifier.fillMaxSize(),
                        painter = painterResource(R.drawable.baseline_person_24),
                        contentDescription = ""
                    )
                }
            }
            Spacer(modifier = Modifier.size(12.dp))
            Row(
                Modifier
                    .background(
                        color = Color(android.graphics.Color.parseColor("#fafafa"))
                    )
                    .height(82.dp)
                    .fillMaxWidth()
                    .padding(12.dp)
                    .horizontalScroll(
                        rememberScrollState()
                    ),
                verticalAlignment = Alignment.CenterVertically,

            ) {
                // Section Ratings
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Row(
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Icon(
                            painter = painterResource(R.drawable.baseline_star_24),
                            contentDescription = "",
                            modifier = Modifier.size(18.dp),
                            tint = Color(android.graphics.Color.parseColor("#f06400"))
                        )
                        Text(text = "4.5",
                            style = TextStyle(
                                fontSize = 18.sp,
                                fontWeight = FontWeight.Bold
                            )
                        )
                    }

                    Text(text = "200+ ratings",
                        style = TextStyle(
                            fontSize = 12.sp
                        ),
                        modifier = Modifier.padding(top = 4.dp)
                        )
                }
                Spacer(modifier = Modifier.size(22.dp))
                Card(
                    modifier = Modifier
                        .fillMaxHeight()
                        .width(1.dp)
                        .padding(vertical = 4.dp)
                ) {}
                // Section Jarak
                Spacer(modifier = Modifier.size(22.dp))
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Row(
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Icon(
                            painter = painterResource(R.drawable.baseline_location_on_24),
                            contentDescription = "",
                            modifier = Modifier.size(18.dp),
                            tint = Color(android.graphics.Color.parseColor("#d92d3b"))
                        )
                        Text(text = "4.5km",
                            style = TextStyle(
                                fontSize = 18.sp,
                                fontWeight = FontWeight.Bold
                            )
                        )
                    }
                    Text(text = "in 30 min",
                        style = TextStyle(
                            fontSize = 12.sp
                        ),
                        modifier = Modifier.padding(top = 4.dp)
                    )
                }
                Spacer(modifier = Modifier.size(22.dp))
                Card(
                    modifier = Modifier
                        .fillMaxHeight()
                        .width(1.dp)
                        .padding(vertical = 4.dp)
                ) {}
                // Section Kasta Harga
                Spacer(modifier = Modifier.size(22.dp))
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(text = "$$$$",
                        style = TextStyle(
                            fontSize = 18.sp,
                            fontWeight = FontWeight.Bold
                        )
                    )
                    Text(text = "20 - 100rb",
                        style = TextStyle(
                            fontSize = 12.sp
                        ),
                        modifier = Modifier.padding(top = 4.dp)
                    )
                }
                Spacer(modifier = Modifier.size(22.dp))
                Card(
                    modifier = Modifier
                        .fillMaxHeight()
                        .width(1.dp)
                        .padding(vertical = 4.dp)
                ) {}
                // Section Rating
                Spacer(modifier = Modifier.size(22.dp))
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                    ) {
                        Icon(
                            painter = painterResource(R.drawable.baseline_emoji_emotions_24),
                            contentDescription = "",
                            modifier = Modifier.size(18.dp),
                            tint = Color(android.graphics.Color.parseColor("#e12a37"))
                        )
                        Text(text = "Great",
                            style = TextStyle(
                                fontSize = 18.sp,
                                fontWeight = FontWeight.Bold
                            ),
                            modifier = Modifier.padding(start = 4.dp)
                        )
                    }
                    Text(text = "200+ ratings",
                        style = TextStyle(
                            fontSize = 12.sp
                        ),
                        modifier = Modifier.padding(top = 4.dp)
                    )
                }
                Spacer(modifier = Modifier.size(22.dp))

            }
            // ListView Section
            Text("Best Seller",
                style = TextStyle(
                    fontWeight = FontWeight.Black,
                    fontSize = 18.sp
                ),
                modifier = Modifier
                    .padding(12.dp)
                    .fillMaxWidth()
                )
            Divider(
                modifier = Modifier.padding(horizontal = 12.dp)
            )
            LazyColumn(
                modifier = Modifier.padding(12.dp)
            ) {
                itemsIndexed(listOfFoods) { index, foods ->

                    ItemCuisines(foods, index)
                }
            }
        }
    }
}

@OptIn(ExperimentalAnimationApi::class)
@Composable
fun ItemCuisines(food: CuisinesModel, index: Int) {
    var isExpanded by remember { mutableStateOf(food.isExpanded) }
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 8.dp, vertical = 14.dp)
    ) {
       Column(
           modifier = Modifier
               .align(
                   alignment = Alignment.TopStart
               )
               .width(220.dp)

       ) {
           Text(food.name,
                style = TextStyle(
                    fontWeight = FontWeight.Bold,
                    fontSize = 15.sp
                )
           )
           Text(
               arrowDescription(food.description, isExpanded),
               style = TextStyle(
                   fontWeight = FontWeight.Normal,
                   fontSize = 13.sp
               ),
               modifier = Modifier.clickable {
                   isExpanded = !isExpanded
               }
           )
           AnimatedVisibility(isExpanded) {
               Text(food.price,
                   style = TextStyle(
                       fontWeight = FontWeight.Bold,
                       fontSize = 13.sp
                   ),
                   modifier = Modifier.padding(top = 8.dp)
               )
           }
           AnimatedVisibility(isExpanded) {
               Text(food.detailed,
                   style = TextStyle(
                       fontWeight = FontWeight.Light,
                       fontSize = 13.sp,
                       color = Color(android.graphics.Color.parseColor("#00880d")),
                       textAlign = TextAlign.Justify
                   ),
                   modifier = Modifier.padding(top = 22.dp)
               )
           }
           AnimatedVisibility(!isExpanded) {
               Text(food.price,
                   style = TextStyle(
                       fontWeight = FontWeight.Bold,
                       fontSize = 13.sp
                   ),
                   modifier = Modifier.padding(top = 8.dp)
               )
           }

       }

        IconButton(onClick = { /*TODO*/ },
            content = {
                Icon(painter = painterResource(R.drawable.baseline_love_24) ,
                    contentDescription = "",
                    modifier = Modifier.align(
                        alignment = if(!isExpanded) Alignment.BottomStart else Alignment.BottomEnd
                    ),
                    tint = Color.LightGray,
                )
            },
            modifier = Modifier
                .align(
                    alignment = if(!isExpanded) Alignment.BottomStart else Alignment.BottomEnd
                )
        )
        Column(
            modifier = Modifier
                .align(
                    alignment = Alignment.CenterEnd
                )
                .height(110.dp)
                .width(72.dp)
            ,
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.SpaceBetween
        ) {
            Card(
                modifier = Modifier
                    .height(72.dp)
                    .width(72.dp)


            ) {
                AsyncImage(food.imgUrl,
                    modifier = Modifier.fillMaxSize(),
                    contentDescription = ""
                )
            }
            Button(onClick = { /*TODO*/ },
                modifier = Modifier
                    .height(24.dp)
                    .fillMaxWidth(),
                content = {
                    Text("Add",
                        style = TextStyle(
                            fontWeight = FontWeight.Bold,
                            fontSize = 12.sp,
                            color = Color(android.graphics.Color.parseColor("#00880d")
                        )
                    )
                    )
                },
                contentPadding = PaddingValues(0.dp),
                colors = ButtonDefaults.buttonColors(containerColor = Color.White),
                border = BorderStroke(1.dp, Color(android.graphics.Color.parseColor("#00880d") )

            )
            )
        }
    }
    Divider()
}



fun arrowDescription(description: String, expanded: Boolean): String {
    val arrow = if (!expanded) "▼" else "▲"
    return "$description  $arrow"
}

@Preview(showBackground = true)
@Composable
fun PreviewInterfaceTigaUI() {
    LearnComposeTheme {
        InterfaceTigaUI()
    }
}