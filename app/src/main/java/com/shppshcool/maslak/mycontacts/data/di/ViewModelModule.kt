package com.shppshcool.maslak.mycontacts.data.di

import com.shppshcool.maslak.mycontacts.presentation.screens.autth.sign_up.SignUpViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {
    viewModel { SignUpViewModel() }
}