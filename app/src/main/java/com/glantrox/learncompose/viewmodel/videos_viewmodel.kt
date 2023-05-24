package com.glantrox.learncompose.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.glantrox.learncompose.core.dataclasses.models.VideosModel

class VideosViewModel: ViewModel() {
    private val _currentVideo: MutableLiveData<VideosModel> = MutableLiveData()
    val currentVideo: LiveData<VideosModel> = _currentVideo

    fun setStateVideo(video: VideosModel) {
        _currentVideo.value = video
    }
    fun clearStateVideo() {
        _currentVideo.value = null
    }


}