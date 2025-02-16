package com.evirgenoguz.core.data.di

import com.evirgenoguz.core.data.auth.EncryptedSessionStorage
import com.evirgenoguz.core.data.networking.HttpClientFactory
import com.evirgenoguz.core.domain.SessionStorage
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.bind
import org.koin.dsl.module

val coreDataModule = module {
    single {
        HttpClientFactory(get()).build()
    }
    singleOf(::EncryptedSessionStorage).bind<SessionStorage>()
}