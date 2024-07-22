package com.shppshcool.maslak.mycontacts.presentation.screens.autth.sign_up

import com.shppshcool.maslak.mycontacts.presentation.screens.base.ViewEvent
import com.shppshcool.maslak.mycontacts.presentation.screens.base.ViewSideEffect
import com.shppshcool.maslak.mycontacts.presentation.screens.base.ViewState

class SignUpContract {

    sealed class Event : ViewEvent {
        data object Register : Event()
        data class Email(val text:String):Event()
        data class Password(val text:String):Event()
        data object Checkbox:Event()
    }

    data class State(
        val email: String = "",
        val isEmailError: Boolean = false,
        val emailErrorText: String = "",
        val password: String = "",
        val isPasswordError: Boolean = false,
        val passwordErrorText: String = "",
        val checkboxChecked: Boolean = true,
    ):ViewState {
        val registerButtonEnabled = email.isNotBlank() && password.isNotBlank()
    }

    sealed class Effect : ViewSideEffect {

        sealed class Navigation : Effect() {
            data class ToDetail(val userId: String): Navigation()
        }
    }

}