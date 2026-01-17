package com.example.marspic.screens

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.example.marspic.MarsPicApplication
import com.example.marspic.data.MarsPhotoRepository
import kotlinx.coroutines.launch
import retrofit2.HttpException
import java.io.IOException
import androidx.lifecycle.ViewModelProvider.AndroidViewModelFactory.Companion.APPLICATION_KEY

class MarsPicViewModel(private val marsPhotoRepository : MarsPhotoRepository): ViewModel() {

    var marsUiState : MarsUiState  by mutableStateOf(MarsUiState.Loading)
        private set


    init {

    getMarsPic()
    }

    fun getMarsPic(){

        viewModelScope.launch {
            try {

                val listResult = marsPhotoRepository.getMarsPic()
                marsUiState  = MarsUiState.Success(
                    "Success: ${listResult.size} Mars photos retrieved"
                )

            }
            catch (e: IOException){

                marsUiState = MarsUiState.Error
            }
            catch (e: HttpException){
                marsUiState = MarsUiState.Error
            }


            }


        }

    companion object {
        val Factory: ViewModelProvider.Factory = viewModelFactory {
            initializer {
                val application = (this[APPLICATION_KEY] as MarsPicApplication)
                val marsPhotosRepository = application.container.marsPhotoRepository
                MarsPicViewModel(marsPhotosRepository)
            }
        }
    }

    sealed interface MarsUiState {
        data class Success(val photos: String) : MarsUiState
        object Error : MarsUiState
        object Loading : MarsUiState
    }
}