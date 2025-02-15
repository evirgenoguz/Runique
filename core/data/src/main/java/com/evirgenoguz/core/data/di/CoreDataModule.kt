package com.evirgenoguz.core.data.di

import com.evirgenoguz.core.data.networking.HttpClientFactory
import org.koin.dsl.module

val coreDataModule = module {
    single {
        HttpClientFactory().build()
    }
}