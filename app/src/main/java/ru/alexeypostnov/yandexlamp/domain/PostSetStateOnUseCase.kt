package ru.alexeypostnov.yandexlamp.domain

import ru.alexeypostnov.yandexlamp.data.LampRepository
import javax.inject.Inject

interface PostSetStateOnUseCase {
    suspend operator fun invoke(): Unit
}

class PostSetStateOnUseCaseImpl @Inject constructor(
    private val repository: LampRepository
): PostSetStateOnUseCase {
    override suspend operator fun invoke(): Unit =
        repository.setStateOn()
}