package com.example.marspic.data

import com.example.marspic.network.MarsApiService
import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import retrofit2.Retrofit

interface AppContainer {

    val marsPhotoRepository : MarsPhotoRepository
}
class DefaultAppContainer: AppContainer{
    private val baseUrl =
        "https://android-kotlin-fun-mars-server.appspot.com"

    private val retrofit = Retrofit.Builder()
        .addConverterFactory(Json.asConverterFactory("application/json".toMediaType()))
        .baseUrl(baseUrl)
        .build()

   private val retrofitServices : MarsApiService  by lazy {
        retrofit.create(MarsApiService::class.java)
    }
    override val marsPhotoRepository: MarsPhotoRepository by lazy {
        NetworkMarsPicRepository(retrofitServices)
    }

}