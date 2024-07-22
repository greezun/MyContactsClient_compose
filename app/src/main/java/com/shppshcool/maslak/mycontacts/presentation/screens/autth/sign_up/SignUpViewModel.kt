package com.shppshcool.maslak.mycontacts.presentation.screens.autth.sign_up

import android.util.Log
import com.shppshcool.maslak.mycontacts.presentation.screens.base.BaseViewModel
import com.shppshcool.maslak.mycontacts.presentation.screens.utils.TAG

class SignUpViewModel:BaseViewModel<SignUpContract.Event, SignUpContract.State, SignUpContract.Effect>( ) {
    override fun setInitialState()= SignUpContract.State(
        email = "",
        isEmailError = false,
        emailErrorText = "",
        password = "",
        isPasswordError = false,
        passwordErrorText = "",
        checkboxChecked = false
    )


    override fun handleEvents(event: SignUpContract.Event) {
        when(event){
            is SignUpContract.Event.Email -> setState { copy(email=event.text) }
            is SignUpContract.Event.Password->setState { copy(password=event.text) }
            is SignUpContract.Event.Checkbox -> setState {
                Log.d(TAG, "handleEvents: ${this.checkboxChecked}")
                copy(checkboxChecked= !this.checkboxChecked)

            }
            is SignUpContract.Event.Register -> {}
        }
    }
}