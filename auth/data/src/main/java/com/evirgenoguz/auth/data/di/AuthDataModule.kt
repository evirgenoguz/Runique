package com.evirgenoguz.auth.data.di

import com.evirgenoguz.auth.data.AuthRepositoryImpl
import com.evirgenoguz.auth.data.EmailPatternValidator
import com.evirgenoguz.auth.domain.AuthRepository
import com.evirgenoguz.auth.domain.PatternValidator
import com.evirgenoguz.auth.domain.UserDataValidator
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.bind
import org.koin.dsl.module

val authDataModule = module {
    single<PatternValidator> {
        EmailPatternValidator
    }
    singleOf(::UserDataValidator)
    singleOf(::AuthRepositoryImpl).bind<AuthRepository>()

}