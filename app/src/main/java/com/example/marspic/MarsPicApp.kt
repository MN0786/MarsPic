package com.example.marspic


import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.TopAppBarScrollBehavior
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.marspic.screens.HomeScreen
import com.example.marspic.screens.MarsPicViewModel



@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MarsPicApp(){
    val scrollBehaviour = TopAppBarDefaults.enterAlwaysScrollBehavior()
    Scaffold(
        topBar = {MarsPicAppBar(scrollBehaviour = scrollBehaviour)},
        modifier  = Modifier.nestedScroll(scrollBehaviour.nestedScrollConnection)
    ) {
        Surface(modifier = Modifier.fillMaxSize()) {
            val marsPicViewModel : MarsPicViewModel = viewModel()
            HomeScreen(
                marsUIState = marsPicViewModel.marsUiState,
                contentPadding = it,
            )

        }
    }
}



@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MarsPicAppBar(
    scrollBehaviour  : TopAppBarScrollBehavior ,
    modifier : Modifier =  Modifier
){


    CenterAlignedTopAppBar(
        title = {
            Text(
                text  = stringResource(R.string.app_name),
                style = MaterialTheme.typography.headlineSmall

                )
        },
        modifier = modifier
    )
}
@Preview
@Composable
fun MarsPicAppPreview(){
    MarsPicApp()
}