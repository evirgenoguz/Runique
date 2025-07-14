package com.evirgenoguz.analytics.data.di

import com.evirgenoguz.analytics.data.RunAnalyticsRepositoryImpl
import com.evirgenoguz.analytics.domain.RunAnalyticsRepository
import com.evirgenoguz.core.database.RunDatabase
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.bind
import org.koin.dsl.module

val analyticsModule = module {
    singleOf(::RunAnalyticsRepositoryImpl).bind<RunAnalyticsRepository>()
    single {
        get<RunDatabase>().runAnalyticsDao
    }
}