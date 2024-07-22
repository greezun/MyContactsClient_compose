package com.shppshcool.maslak.mycontacts

import android.app.Application
import com.shppshcool.maslak.mycontacts.data.di.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class MyContactsApp: Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@MyContactsApp)
            modules(viewModelModule)
        }
    }
}