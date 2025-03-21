package com.evirgenoguz.run.network.di

import com.evirgenoguz.core.domain.run.RemoteRunDataSource
import com.evirgenoguz.run.network.KtorRemoteRunDataSource
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.bind
import org.koin.dsl.module

val networkModule = module {
    singleOf(::KtorRemoteRunDataSource).bind<RemoteRunDataSource>()
}