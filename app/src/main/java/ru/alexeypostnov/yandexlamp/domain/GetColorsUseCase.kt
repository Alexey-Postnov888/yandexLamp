package ru.alexeypostnov.yandexlamp.domain

import ru.alexeypostnov.yandexlamp.data.LampRepository
import ru.alexeypostnov.yandexlamp.data.model.ColorInfo
import javax.inject.Inject

interface GetColorsUseCase {
    suspend operator fun invoke(): List<ColorInfo>?
}

class GetColorsUseCaseImpl @Inject constructor(
    private val repository: LampRepository
): GetColorsUseCase {
    override suspend operator fun invoke(): List<ColorInfo>? =
        repository.getColors()
}