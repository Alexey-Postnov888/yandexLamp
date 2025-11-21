package ru.alexeypostnov.yandexlamp.data

import ru.alexeypostnov.yandexlamp.data.model.BrightnessInfo
import ru.alexeypostnov.yandexlamp.data.model.ColorInfo
import javax.inject.Inject

interface LampRepository {
    suspend fun getColors(): List<ColorInfo>?
    suspend fun applyColor(color: String)
    suspend fun setStateOn()
    suspend fun setStateOff()
    suspend fun getBrightnessInfo(): BrightnessInfo?
    suspend fun getCurrentBrightnessLevel(): Int?
    suspend fun setBrightnessLevel(level: Int)
}

class LampRepositoryImpl @Inject constructor(
    private val service: LampService,
): LampRepository {
    override suspend fun getColors(): List<ColorInfo>? {
        val response = service.loadColorsInfo()

        return if (response.isSuccessful)
            return response.body()
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

    override suspend fun getBrightnessInfo(): BrightnessInfo? {
        val response = service.loadBrightnessInfo()

        return if (response.isSuccessful)
            return response.body()
        else null
    }

    override suspend fun getCurrentBrightnessLevel(): Int? {
        val response = service.getCurrentBrightnessLevel()

        return if (response.isSuccessful)
            return response.body()?.string()?.trim()?.toIntOrNull()
        else null
    }

    override suspend fun setBrightnessLevel(level: Int) {
        service.setBrightnessLevel(level)
    }
}