package ru.alexeypostnov.yandexlamp.data

import okhttp3.ResponseBody
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Query
import ru.alexeypostnov.yandexlamp.data.model.BrightnessInfo
import ru.alexeypostnov.yandexlamp.data.model.ColorInfo

interface LampService {
    @GET("color/")
    suspend fun loadColorsInfo(): Response<List<ColorInfo>>

    @POST("color/")
    suspend fun applyColor(
        @Query("color") color: String
    )

    @POST("state/on")
    suspend fun setStateOn()

    @POST("state/off")
    suspend fun setStateOff()

    @GET("brightness/")
    suspend fun loadBrightnessInfo(): Response<BrightnessInfo>

    @GET("brightness/current")
    suspend fun getCurrentBrightnessLevel(): Response<ResponseBody>

    @POST("brightness/")
    suspend fun setBrightnessLevel(
        @Query("level") level: Int
    )
}