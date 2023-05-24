package com.glantrox.learncompose.core.dataclasses.models

class QuestionsModel(
    val id: Int,
    val question: String,
    val answers: String,
    val isExpanded: Boolean = true
)