package com.evirgenoguz.run.data.di

import com.evirgenoguz.core.domain.run.SyncRunScheduler
import com.evirgenoguz.run.data.CreateRunWorker
import com.evirgenoguz.run.data.DeleteRunWorker
import com.evirgenoguz.run.data.FetchRunsWorker
import com.evirgenoguz.run.data.SyncRunWorkerScheduler
import org.koin.androidx.workmanager.dsl.workerOf
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.bind
import org.koin.dsl.module

val runDataModule = module {
    workerOf(::CreateRunWorker)
    workerOf(::FetchRunsWorker)
    workerOf(::DeleteRunWorker)

    singleOf(::SyncRunWorkerScheduler).bind<SyncRunScheduler>()
}