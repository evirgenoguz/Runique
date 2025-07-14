package com.evirgenoguz.run.location.di

import com.evirgenoguz.run.domain.LocationObserver
import com.evirgenoguz.run.location.AndroidLocationObserver
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.bind
import org.koin.dsl.module

val locationModule = module {
    singleOf(::AndroidLocationObserver).bind<LocationObserver>()
}