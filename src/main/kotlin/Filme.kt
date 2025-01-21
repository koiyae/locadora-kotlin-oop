package org.example

data class Filme(
    val titulo: String,
    val ano: Int,
    var availability: Boolean = true
)