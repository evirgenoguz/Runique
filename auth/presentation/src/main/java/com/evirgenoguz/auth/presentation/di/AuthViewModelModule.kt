package com.evirgenoguz.auth.presentation.di

import com.evirgenoguz.auth.presentation.login.LoginViewModel
import com.evirgenoguz.auth.presentation.register.RegisterViewModel
import org.koin.androidx.viewmodel.dsl.viewModelOf
import org.koin.dsl.module

val authViewModelModule = module {
    viewModelOf(::RegisterViewModel)
    viewModelOf(::LoginViewModel)
}