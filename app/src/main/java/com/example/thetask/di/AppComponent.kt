package com.example.thetask.di

import android.app.Application
import dagger.Component
import javax.inject.Singleton

// AppComponent.kt
@Singleton
@Component(modules = [AppModule::class])
interface AppComponent {
    fun inject(application: Application)
}
