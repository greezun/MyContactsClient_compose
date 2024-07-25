package com.shppshcool.maslak.mycontacts.domain.api.server

import com.shppshcool.maslak.mycontacts.presentation.screens.autth.sign_up.SignUpContract

interface AuthApi {

    suspend fun registerUser(email:String, password: String)
    suspend fun autoLoginUser()
}