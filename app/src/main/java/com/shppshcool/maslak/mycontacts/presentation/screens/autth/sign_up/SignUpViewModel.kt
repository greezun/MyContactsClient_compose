package com.shppshcool.maslak.mycontacts.presentation.screens.autth.sign_up

import android.util.Log
import android.util.Patterns
import com.shppshcool.maslak.mycontacts.presentation.screens.base.BaseViewModel
import com.shppshcool.maslak.mycontacts.presentation.screens.utils.TAG

const val PASS_REGEX = "^(?=.*[0-9])(?=.*[a-zA-Z]).{8,}$"
class SignUpViewModel:BaseViewModel<SignUpContract.Event, SignUpContract.State, SignUpContract.Effect>( ) {
    override fun setInitialState()= SignUpContract.State.empty()

    override fun handleEvents(event: SignUpContract.Event) {
        when(event){
            is SignUpContract.Event.Email -> setState { copy(email=event.text) }
            is SignUpContract.Event.Password->setState { copy(password=event.text) }
            is SignUpContract.Event.Checkbox -> setState {
                Log.d(TAG, "handleEvents: ${this.rememberMe}")
                copy(rememberMe= !this.rememberMe)

            }
            is SignUpContract.Event.Register -> {
                setState { copy(isEmailError = !isValidEmail(this.email)) }
                setState { copy(isPasswordError = !isValidPassword(this.password)) }
                if(!viewState.value.isPasswordError && !viewState.value.isEmailError){
                    setEffect { SignUpContract.Effect.Navigation.ToProfileDetail}
                }
            }
        }
    }

    private fun isValidEmail(email: String): Boolean {
        return email.isNotEmpty() && Patterns.EMAIL_ADDRESS.matcher(email).matches()
    }

    private fun isValidPassword(password: String): Boolean {
        val pattern = Regex(PASS_REGEX)
        return password.isNotEmpty() && pattern.matches(password)
    }
}