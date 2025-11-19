package ru.alexeypostnov.yandexlamp.domain

import ru.alexeypostnov.yandexlamp.data.LampRepository
import javax.inject.Inject

interface PostSetStateOffUseCase {
    suspend operator fun invoke(): Unit
}

class PostSetStateOffUseCaseImpl @Inject constructor(
    private val repository: LampRepository
): PostSetStateOffUseCase {
    override suspend operator fun invoke(): Unit =
        repository.setStateOff()
}