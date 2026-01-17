package com.example.marspic.fake
import com.example.marspic.data.NetworkMarsPicRepository

import com.example.marspic.FakeMarsApiService
import kotlinx.coroutines.test.runTest
import org.junit.Assert.assertEquals
import org.junit.Test

class NetworkMarsRepositoryTest {
    @Test
    fun networkMarsPhotoRepository_getMarsPic_verifyPhotosList() = runTest{
        val repository = NetworkMarsPicRepository(
            marsApiService = FakeMarsApiService()
        )
        assertEquals(
            FakeDataSource.photoList , repository.getMarsPic()
        )

    }
}