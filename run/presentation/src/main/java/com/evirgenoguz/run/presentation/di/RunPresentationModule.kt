package com.evirgenoguz.run.presentation.di

import com.evirgenoguz.run.domain.RunningTracker
import com.evirgenoguz.run.presentation.active_run.ActiveRunViewModel
import com.evirgenoguz.run.presentation.run_overview.RunOverviewViewModel
import org.koin.androidx.viewmodel.dsl.viewModelOf
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module

val runPresentationModule = module {
    singleOf(::RunningTracker)

    viewModelOf(::RunOverviewViewModel)
    viewModelOf(::ActiveRunViewModel)
}