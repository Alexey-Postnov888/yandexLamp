package ru.alexeypostnov.yandexlamp.domain

import ru.alexeypostnov.yandexlamp.data.LampRepository
import javax.inject.Inject

interface PostApplyColorUseCase {
    suspend operator fun invoke(color: String): Unit
}

class PostApplyColorUseCaseImpl @Inject constructor(
    private val repository: LampRepository
): PostApplyColorUseCase {
    override suspend operator fun invoke(color: String): Unit =
        repository.applyColor(color)
}