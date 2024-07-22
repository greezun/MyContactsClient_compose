package com.shppshcool.maslak.mycontacts.presentation.navigation.destonation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.shppshcool.maslak.mycontacts.presentation.screens.autth.sign_up.SignUpViewModel
import com.shppshcool.maslak.mycontacts.presentation.screens.autth.sign_up.compose.SignUpScreen
import org.koin.androidx.compose.koinViewModel

@Composable
fun SignUpDestination(modifier: Modifier) {
    val viewModel: SignUpViewModel = koinViewModel()
    SignUpScreen(
        modifier = modifier,
        state = viewModel.viewState.value,
        effectFlow = viewModel.effect ,
        onEventSent = {event-> viewModel.setEvent(event)}
    )
    {

    }


}