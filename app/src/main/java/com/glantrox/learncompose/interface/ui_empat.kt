package com.glantrox.learncompose.`interface`

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.animation.AnimatedVisibility

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Divider
import androidx.compose.material.IconButton
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text

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
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.glantrox.learncompose.R
import com.glantrox.learncompose.core.dataclasses.models.QuestionsModel
import com.glantrox.learncompose.ui.theme.LearnComposeTheme

@RequiresApi(Build.VERSION_CODES.O)
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun InterfaceEmpatUI() {
    val listOfQuestions: List<QuestionsModel> = listOf(
        QuestionsModel(1, "What is Flutter?","Flutter is an open-source UI software development kit created by Google. It allows developers to build cross-platform applications for mobile, web, and desktop using a single codebase. Flutter is an open-source UI software development kit created by Google. It allows developers to build cross-platform applications for mobile, web, and desktop using a single codebase. Flutter is an open-source UI software development kit created by Google. It allows developers to build cross-platform applications for mobile, web, and desktop using a single codebase."),
        QuestionsModel(2, "What programming language is used in Flutter?","Flutter uses Dart as its primary programming language. Dart is a modern, object-oriented language developed by Google, which is specifically designed for building user interfaces."),
        QuestionsModel(3, "What is a widget in Flutter?", "n Flutter, a widget is a fundamental building block for constructing user interfaces. Widgets define the structure and behavior of UI elements such as buttons, text inputs, containers, and more. Flutter provides a rich set of pre-built widgets as well as the ability to create custom widgets."),
        QuestionsModel(4, "What is the difference between stateful and stateless widgets in Flutter?", "Stateful widgets are those that can change or maintain state over time, such as accepting user input or animating a component. They have an associated mutable state. In contrast, stateless widgets are immutable and do not have any internal state. They represent UI elements that do not change once rendered."),
        QuestionsModel(5,"What is the Flutter hot reload feature?", "The Flutter hot reload feature allows developers to quickly see the changes made to their code without restarting the entire application. When code changes are saved, Flutter automatically injects the updated code into the running app, providing a near-instant feedback loop for developers during the development process."),
        QuestionsModel(6,"How can I handle user input and gestures in Flutter?","Flutter provides various widgets and gesture recognizers to handle user input and gestures. Widgets like TextField, RaisedButton, and GestureDetector can be used to capture user input and respond to different types of gestures like taps, swipes, and drags. Additionally, Flutter offers a rich set of event handlers and callbacks to respond to user interactions effectively.")

    )

    Scaffold() {
        LazyColumn(
            modifier = Modifier.padding(it)
        ) {
            items(listOfQuestions) {
                ItemsQuestions(it)
            }
        }
    }
}


@Composable
fun ItemsQuestions(qnas: QuestionsModel) {
    var isExpanded by remember { mutableStateOf(qnas.isExpanded) }

    Column(
        modifier = Modifier.fillMaxWidth()
    ) {
        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .padding(horizontal = 8.dp)
                .fillMaxWidth()
        ) {
            Text(qnas.question,
                style = TextStyle(
                    fontWeight = FontWeight.Bold,
                    fontSize = 16.sp,
                ),
                modifier = Modifier.width(290.dp)

            )

        IconButton(
            onClick = {
                      isExpanded = !isExpanded
            },
            content = {
                Icon(
                    painter = painterResource(id = if(!isExpanded) R.drawable.baseline_arrow_circle_up_24 else R.drawable.baseline_expand_circle_down_24),
                    contentDescription = "",
                    modifier = Modifier.height(15.dp),
                )
            },


            )
        }
        AnimatedVisibility(isExpanded) {
            Text(qnas.answers,
                style = TextStyle(
                    fontWeight = FontWeight.Light,
                    fontSize = 14.sp,
                    color = Color.DarkGray,
                    lineHeight = 19.sp
                ),
                modifier = Modifier
                    .padding(start = 8.dp),
            )
        }

        Divider(
            modifier = Modifier.padding(8.dp)
        )
    }
}



@RequiresApi(Build.VERSION_CODES.O)
@Preview(showBackground = true)
@Composable
fun PreviewInterfaceEmpat() {
    LearnComposeTheme {
        InterfaceEmpatUI()
    }
}

