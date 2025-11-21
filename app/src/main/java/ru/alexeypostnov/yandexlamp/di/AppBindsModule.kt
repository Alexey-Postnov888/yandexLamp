package ru.alexeypostnov.yandexlamp.di

import dagger.Binds
import dagger.Module
import ru.alexeypostnov.yandexlamp.data.LampRepository
import ru.alexeypostnov.yandexlamp.data.LampRepositoryImpl
import ru.alexeypostnov.yandexlamp.domain.GetBrightnessInfoUseCase
import ru.alexeypostnov.yandexlamp.domain.GetBrightnessInfoUseCaseImpl
import ru.alexeypostnov.yandexlamp.domain.GetColorsUseCase
import ru.alexeypostnov.yandexlamp.domain.GetColorsUseCaseImpl
import ru.alexeypostnov.yandexlamp.domain.GetCurrentBrightnessLevelUseCase
import ru.alexeypostnov.yandexlamp.domain.GetCurrentBrightnessLevelUseCaseImpl
import ru.alexeypostnov.yandexlamp.domain.PostApplyColorUseCase
import ru.alexeypostnov.yandexlamp.domain.PostApplyColorUseCaseImpl
import ru.alexeypostnov.yandexlamp.domain.PostSetBrightnessLevelUseCase
import ru.alexeypostnov.yandexlamp.domain.PostSetBrightnessLevelUseCaseImpl
import ru.alexeypostnov.yandexlamp.domain.PostSetStateOffUseCase
import ru.alexeypostnov.yandexlamp.domain.PostSetStateOffUseCaseImpl
import ru.alexeypostnov.yandexlamp.domain.PostSetStateOnUseCase
import ru.alexeypostnov.yandexlamp.domain.PostSetStateOnUseCaseImpl

@Module
interface AppBindsModule {
    @Binds
    fun bindColorsRepository(impl: LampRepositoryImpl): LampRepository

    @Binds
    fun bindGetColorsUseCase(impl: GetColorsUseCaseImpl): GetColorsUseCase

    @Binds
    fun bindPostApplyColorUseCase(impl: PostApplyColorUseCaseImpl): PostApplyColorUseCase

    @Binds
    fun bindPostSetStateOnUseCase(impl: PostSetStateOnUseCaseImpl): PostSetStateOnUseCase

    @Binds
    fun bindPostSetStateOffUseCase(impl: PostSetStateOffUseCaseImpl): PostSetStateOffUseCase

    @Binds
    fun bindGetBrightnessInfoUseCase(impl: GetBrightnessInfoUseCaseImpl): GetBrightnessInfoUseCase

    @Binds
    fun bindGetCurrentBrightnessLevelUseCase(impl: GetCurrentBrightnessLevelUseCaseImpl): GetCurrentBrightnessLevelUseCase

    @Binds
    fun bindPostSetBrightnessLevelUseCase(impl: PostSetBrightnessLevelUseCaseImpl): PostSetBrightnessLevelUseCase
}