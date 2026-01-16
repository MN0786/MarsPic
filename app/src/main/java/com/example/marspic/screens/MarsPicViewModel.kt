package com.example.marspic.screens

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.marspic.network.MarsApi
import kotlinx.coroutines.launch
import java.io.IOException

class MarsPicViewModel: ViewModel() {

    var marsUiState : MarsUiState  by mutableStateOf(MarsUiState.Loading)
        private set


    init {

    getMarsPic()
    }

    fun getMarsPic(){

        viewModelScope.launch {
            try {
                val listResult = MarsApi.retrofitServices.getPhotos()
                marsUiState  = MarsUiState.Success(
                    "Success: ${listResult.size} Mars photos retrieved"
                )

            }
            catch (e: IOException){

                marsUiState = MarsUiState.Error
            }


            }


        }


    sealed interface MarsUiState {
        data class Success(val photos: String) : MarsUiState
        object Error : MarsUiState
        object Loading : MarsUiState
    }
}