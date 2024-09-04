package com.example.authorization

import androidx.compose.material3.SnackbarHostState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.platform.LocalContext
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.authorization.model.AuthorizationEffect
import org.orbitmvi.orbit.compose.collectAsState
import org.orbitmvi.orbit.compose.collectSideEffect

@Composable
fun AuthorizationRoute(navController: NavController) {
    val viewModel = hiltViewModel<AuthorizationViewModel>()
    val viewState by viewModel.collectAsState()
    val snackbarHostState = remember { SnackbarHostState() }
    val context = LocalContext.current


    AuthorizationScreen(viewModel = viewModel, viewState = viewState, snackbarHostState = snackbarHostState)

    viewModel.collectSideEffect { sideEffect ->
        when (sideEffect) {
            is AuthorizationEffect.ShowToast -> {
                snackbarHostState.showSnackbar(
                    context.getString(sideEffect.resId)
                )
            }
        }
    }
}