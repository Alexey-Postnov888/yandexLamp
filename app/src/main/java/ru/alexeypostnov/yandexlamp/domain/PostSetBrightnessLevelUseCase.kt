package ru.alexeypostnov.yandexlamp.domain

import ru.alexeypostnov.yandexlamp.data.LampRepository
import javax.inject.Inject

interface PostSetBrightnessLevelUseCase {
    suspend operator fun invoke(level: Int)
}

class PostSetBrightnessLevelUseCaseImpl @Inject constructor(
    private val repository: LampRepository
): PostSetBrightnessLevelUseCase {
    override suspend operator fun invoke(level: Int) =
        repository.setBrightnessLevel(level)

}