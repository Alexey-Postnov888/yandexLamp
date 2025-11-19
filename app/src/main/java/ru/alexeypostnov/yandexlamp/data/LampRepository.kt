package ru.alexeypostnov.yandexlamp.data

import ru.alexeypostnov.yandexlamp.data.model.ColorInfo
import javax.inject.Inject

interface LampRepository {
    suspend fun getColors(): List<ColorInfo>?
    suspend fun applyColor(color: String)
    suspend fun setStateOn()
    suspend fun setStateOff()
}

class LampRepositoryImpl @Inject constructor(
    private val service: LampService,
): LampRepository {
    override suspend fun getColors(): List<ColorInfo>? {
        val response = service.loadColorsInfo()

        return if (response.isSuccessful)
            return response.body() as List<ColorInfo>?
        else null
    }

    override suspend fun applyColor(color: String) {
        service.applyColor(color)
    }

    override suspend fun setStateOn() {
        service.setStateOn()
    }

    override suspend fun setStateOff() {
        service.setStateOff()
    }
}