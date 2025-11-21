package ru.alexeypostnov.yandexlamp.domain

import ru.alexeypostnov.yandexlamp.data.LampRepository
import ru.alexeypostnov.yandexlamp.data.model.BrightnessInfo
import javax.inject.Inject

interface GetBrightnessInfoUseCase {
    suspend operator fun invoke(): BrightnessInfo?
}

class GetBrightnessInfoUseCaseImpl @Inject constructor(
    private val repository: LampRepository
): GetBrightnessInfoUseCase {
    override suspend operator fun invoke(): BrightnessInfo? =
        repository.getBrightnessInfo()
}