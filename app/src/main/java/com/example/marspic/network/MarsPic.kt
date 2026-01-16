package com.example.marspic.network

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class MarsPic(
    val id : String,
    @SerialName(value = "img_src")
    val imgSrc: String
)
