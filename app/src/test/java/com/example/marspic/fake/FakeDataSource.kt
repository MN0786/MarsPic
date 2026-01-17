package com.example.marspic.fake

import com.example.marspic.MarsPicAppBar
import com.example.marspic.network.MarsPic

object FakeDataSource {
    const val id_1 = "img1"
    const val id_2 = "img2"
    const val img_1 = "url.1"
    const val img_2 = "url.2"
    val photoList = listOf(
        MarsPic(
            id = id_2,
            imgSrc = img_2
        ),
        MarsPic(
            id = id_1,
            img_1
        )
    )

}