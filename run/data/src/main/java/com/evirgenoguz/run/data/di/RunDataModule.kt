package com.evirgenoguz.run.data.di

import com.evirgenoguz.run.data.CreateRunWorker
import com.evirgenoguz.run.data.DeleteRunWorker
import com.evirgenoguz.run.data.FetchRunsWorker
import org.koin.androidx.workmanager.dsl.workerOf
import org.koin.dsl.module

val runDataModule = module {
    workerOf(::CreateRunWorker)
    workerOf(::FetchRunsWorker)
    workerOf(::DeleteRunWorker)
}