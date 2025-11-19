package ru.alexeypostnov.yandexlamp.data.model

import ru.alexeypostnov.yandexlamp.data.ColorMapper

data class ColorInfo(
    val id: Int,
    val name: String,
    val type: String,
    val color: String
)

val ColorInfo.androidColor: Int get() = ColorMapper.getAndroidColorFromColorName(name)