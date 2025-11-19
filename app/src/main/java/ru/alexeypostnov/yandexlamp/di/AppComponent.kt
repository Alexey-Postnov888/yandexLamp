package ru.alexeypostnov.yandexlamp.di

import dagger.Component
import dagger.Module
import ru.alexeypostnov.yandexlamp.di.viewModel.ViewModelModule
import ru.alexeypostnov.yandexlamp.presenter.MainFragment

@Component(
    modules = [
        AppModule::class
    ]
)
abstract class AppComponent {
    abstract fun inject(fragment: MainFragment)
}

@Module(
    includes = [
        NetworkModule::class,
        AppBindsModule::class,
        ViewModelModule::class
    ]
)
class AppModule