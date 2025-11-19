package ru.alexeypostnov.yandexlamp.data

import androidx.core.graphics.toColorInt

object ColorMapper {
    fun getHexFromColorName(colorName: String): String {
        return when (colorName) {
            "TEAL" -> "#377e7f"
            "CORAL" -> "#ef865b"
            "RED" -> "#ea3322"
            "PERU" -> "#c3884c"
            "BROWN" -> "#98342f"
            "GREEN" -> "#377e21"
            "BLUE" -> "#0000f5"
            "GOLD" -> "#f9d848"
            "MAROON" -> "#75140b"
            "MEDIUMPURPLE" -> "#8e71d4"
            "TOMATO" -> "#ed6d51"
            "WHITE" -> "#FFFFFF"
            "PINK" -> "#f5c3cb"
            "SLATEBLUE" -> "#675bc6"
            "INDIGO" -> "#44087d"
            "CYAN" -> "#75fbfd"
            "SEAGREEN" -> "#4a895c"
            "PURPLE" -> "#75147c"
            "YELLOW" -> "#ffff54"
            else -> "#666666"
        }
    }

    fun getAndroidColorFromColorName(colorName: String): Int {
        return getHexFromColorName(colorName).toColorInt()
    }
}