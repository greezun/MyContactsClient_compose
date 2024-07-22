package com.shppshcool.maslak.mycontacts.data.model.auth.page_state

data class SignAppState(
    val email:String = "",
    val isEmailError:Boolean = false,
    val emailErrorText:String = "",
    val password:String = "",
    val isPasswordError:Boolean = false,
    val passwordErrorText:String = "",
    val checkboxChecked:Boolean = true,
){
    val registerButtonEnabled = email.isNotBlank() && password.isNotBlank()
}
