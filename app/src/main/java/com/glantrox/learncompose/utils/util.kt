package com.glantrox.learncompose.utils

import android.content.Context
import android.widget.Toast
import androidx.compose.ui.platform.LocalContext

class AppUtil {
    fun toast(context: Context, message: String = "") {
        Toast.makeText(context, message, Toast.LENGTH_SHORT).show()
    }
}