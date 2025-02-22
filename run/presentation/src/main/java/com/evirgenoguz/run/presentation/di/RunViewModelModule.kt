package com.evirgenoguz.run.presentation.di

import com.evirgenoguz.run.presentation.active_run.ActiveRunViewModel
import com.evirgenoguz.run.presentation.run_overview.RunOverviewViewModel
import org.koin.androidx.viewmodel.dsl.viewModelOf
import org.koin.dsl.module

val runViewModelModule = module {
    viewModelOf(::RunOverviewViewModel)
    viewModelOf(::ActiveRunViewModel)
}