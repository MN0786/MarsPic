package com.example.marspic.data

import com.example.marspic.network.MarsApiService
import com.example.marspic.network.MarsPic


interface MarsPhotoRepository {

    suspend fun getMarsPic():List<MarsPic>
}
class NetworkMarsPicRepository(
    private val marsApiService : MarsApiService

): MarsPhotoRepository{

    override suspend fun getMarsPic(): List<MarsPic>  =
        marsApiService.getPhotos()
    }
