package com.example.marspic.fake
import com.example.marspic.rules.TestDispatcherRule
import com.example.marspic.screens.MarsPicViewModel
import kotlinx.coroutines.test.runTest
import org.junit.Assert.assertEquals
import com.example.marspic.screens.MarsPicViewModel.MarsUiState
import org.junit.Rule
import org.junit.Test

class MarsViewmodelTest {
    @get:Rule
    val testDispatcher   = TestDispatcherRule()


    @Test
    fun marsViewmodel_getMarsPhotos_verifyMarsUiStateSuccess(){
        runTest {
            val marsViewmodel  =  MarsPicViewModel(
             marsPhotoRepository = FakeNetworkRepositoryTest()
            )
            assertEquals(
                MarsUiState.Success(FakeDataSource.photoList),
                marsViewmodel.marsUiState
            )
        }
    }
}