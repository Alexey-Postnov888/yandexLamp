package ru.alexeypostnov.yandexlamp

import android.app.Application
import android.content.Context
import ru.alexeypostnov.yandexlamp.di.AppComponent
import ru.alexeypostnov.yandexlamp.di.DaggerAppComponent

class MainApplication: Application() {
    lateinit var appComponent: AppComponent
        private set

    override fun onCreate() {
        appComponent = DaggerAppComponent.create()

        super.onCreate()
    }

}

val Context.appComponent: AppComponent
    get() = when(this) {
        is MainApplication -> this.appComponent
        else -> this.applicationContext.appComponent
    }