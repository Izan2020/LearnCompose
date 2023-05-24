package com.glantrox.learncompose.core.dataclasses.models

class CuisinesModel(
    val id: Int,
    val name: String,
    val description: String,
    val imgUrl: String,
    val price: String,
    val detailed: String,
    var isExpanded: Boolean = false,
)