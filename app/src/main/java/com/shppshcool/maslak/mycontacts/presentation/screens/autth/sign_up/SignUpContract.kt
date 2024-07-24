package com.shppshcool.maslak.mycontacts.presentation.screens.autth.sign_up

import com.shppshcool.maslak.mycontacts.presentation.screens.base.ViewEvent
import com.shppshcool.maslak.mycontacts.presentation.screens.base.ViewSideEffect
import com.shppshcool.maslak.mycontacts.presentation.screens.base.ViewState

class SignUpContract {

    sealed class Event : ViewEvent {
        data object Register : Event()
        data class Email(val text: String) : Event()
        data class Password(val text: String) : Event()
        data object Checkbox : Event()
    }

    data class State(
        val email: String,
        val isEmailError: Boolean,
        val password: String,
        val isPasswordError: Boolean,
        val rememberMe: Boolean,
    ) : ViewState {
        val registerButtonEnabled = email.isNotBlank() && password.isNotBlank()

        companion object {
            fun empty() = State(
                email = "",
                isEmailError = false,
                password = "",
                isPasswordError = false,
                rememberMe = false
            )
        }
    }

    sealed class Effect : ViewSideEffect {

        sealed class Navigation : Effect() {
            data object ToProfileDetail : Navigation()
        }
    }

}