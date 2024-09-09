package com.example.registration;

import android.app.Activity
import androidx.activity.compose.BackHandler
import androidx.compose.material3.SnackbarHostState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.platform.LocalContext
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.SavedStateHandle
import androidx.navigation.NavController
import com.example.navigation.NavScreen
import com.example.registration.model.RegistrationEffect
import org.orbitmvi.orbit.compose.collectAsState
import org.orbitmvi.orbit.compose.collectSideEffect

@Composable
fun RegistrationRoute(
    navController: NavController,
) {
    val viewModel = hiltViewModel<RegistrationViewModel>()
    val viewState by viewModel.collectAsState()
    val snackbarHostState = remember { SnackbarHostState() }
    val context = LocalContext.current

    RegistrationScreen(
        viewModel = viewModel,
        viewState = viewState,
        snackbarHostState = snackbarHostState
    )

    BackHandler { (context as? Activity)?.finish() }

    viewModel.collectSideEffect { effect ->
        when (effect) {
            is RegistrationEffect.ShowToast -> {
                snackbarHostState.showSnackbar(context.getString(effect.resId))
            }

            RegistrationEffect.NavigationToChats -> {
                navController.navigate(NavScreen.Chats.route){
                    navController.popBackStack()
                }
            }
        }
    }

}