package com.example.grpahqldemo

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.collectAsState
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.grpahqldemo.presentation.CountriesScreen
import com.example.grpahqldemo.presentation.CountriesViewModel
import com.example.grpahqldemo.ui.theme.GrpahQLDemoTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            GrpahQLDemoTheme {
                val viewModel = hiltViewModel<CountriesViewModel>()
                val state = viewModel.state.collectAsState()
                CountriesScreen(
                    state = state.value,
                    onSelectCountry = viewModel::selectCountry,
                    onDismissCountryDialog = viewModel::dismissCountryDialog
                )
            }
        }
    }
}