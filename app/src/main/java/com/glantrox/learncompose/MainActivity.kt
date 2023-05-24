package com.glantrox.learncompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.compose.rememberNavController
import com.glantrox.learncompose.core.dataclasses.models.VideosModel
import com.glantrox.learncompose.`interface`.EmployeeScreenUI


import com.glantrox.learncompose.navigation.AppNavigator

import com.glantrox.learncompose.ui.theme.LearnComposeTheme
import com.glantrox.learncompose.viewmodel.VideosViewModel

class MainActivity : ComponentActivity() {
    private lateinit var viewModel: VideosViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = ViewModelProvider(this).get(VideosViewModel::class.java)
        setContent {
            LearnComposeTheme {
                AppNavigator().screenNav(viewModel)
            }
        }
    }
}




