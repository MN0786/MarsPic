package com.example.marspic.fake

import com.example.marspic.data.MarsPhotoRepository
import com.example.marspic.network.MarsPic

class FakeNetworkRepositoryTest: MarsPhotoRepository {
    override suspend fun getMarsPic(): List<MarsPic> {
        return FakeDataSource.photoList
    }
}