package com.luu9798.library.model

data class Book(
    val id: Int,
    val title: String,
    val author: String,
    val status: String,
    val fee: Double,
    val lastEdited: String
)
