package ru.alexeypostnov.yandexlamp.di

import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create
import ru.alexeypostnov.yandexlamp.data.LampService

@Module
object NetworkModule {
    @Provides
    fun provideLampService(): LampService =
        Retrofit.Builder()
            .baseUrl("http://195.133.53.179:1337/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create()
}