package com.glantrox.learncompose.core.dataclasses.models

class VideosModel(
    val id: Int,
    val title: String,
    val authorName: String,
    val authorProfilePicture: String,
    val thumbnailUrl: String,
    val views: Double,
    val duration: String,
    val isLiveContent: Boolean,
    val date: String,
    val description: String,
    val authorSubscribers: String,
)