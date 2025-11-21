package ru.alexeypostnov.yandexlamp.domain

import ru.alexeypostnov.yandexlamp.data.LampRepository
import javax.inject.Inject

interface GetCurrentBrightnessLevelUseCase {
    suspend operator fun invoke(): Int?
}

class GetCurrentBrightnessLevelUseCaseImpl @Inject constructor(
    private val repository: LampRepository
): GetCurrentBrightnessLevelUseCase {
    override suspend fun invoke(): Int? =
        repository.getCurrentBrightnessLevel()
}