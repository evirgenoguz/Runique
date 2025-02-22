package com.evirgenoguz.runique

import android.app.Application
import com.evirgenoguz.auth.data.di.authDataModule
import com.evirgenoguz.auth.presentation.di.authViewModelModule
import com.evirgenoguz.core.data.di.coreDataModule
import com.evirgenoguz.run.location.di.locationModule
import com.evirgenoguz.run.presentation.di.runPresentationModule
import com.evirgenoguz.runique.di.appModule
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.SupervisorJob
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import timber.log.Timber

class RuniqueApp : Application() {

    val applicationScope = CoroutineScope(SupervisorJob())
    override fun onCreate() {
        super.onCreate()
        if (BuildConfig.DEBUG) {
            Timber.plant(Timber.DebugTree())
        }

        startKoin {
            androidLogger()
            androidContext(this@RuniqueApp)
            modules(
                appModule,
                authDataModule,
                authViewModelModule,
                coreDataModule,
                runPresentationModule,
                locationModule,
            )
        }
    }
}