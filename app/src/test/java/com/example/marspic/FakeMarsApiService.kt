package com.example.marspic

import com.example.marspic.fake.FakeDataSource
import com.example.marspic.network.MarsApiService
import com.example.marspic.network.MarsPic

class FakeMarsApiService: MarsApiService {
    override suspend fun getPhotos() :List<MarsPic>{
        return FakeDataSource.photoList
    }
}