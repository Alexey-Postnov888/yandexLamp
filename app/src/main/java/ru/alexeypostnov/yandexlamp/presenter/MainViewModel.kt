package ru.alexeypostnov.yandexlamp.presenter

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import ru.alexeypostnov.yandexlamp.domain.GetColorsUseCase
import ru.alexeypostnov.yandexlamp.domain.PostApplyColorUseCase
import javax.inject.Inject
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import ru.alexeypostnov.yandexlamp.data.model.BrightnessInfo
import ru.alexeypostnov.yandexlamp.data.model.ColorInfo
import ru.alexeypostnov.yandexlamp.domain.GetBrightnessInfoUseCase
import ru.alexeypostnov.yandexlamp.domain.GetCurrentBrightnessLevelUseCase
import ru.alexeypostnov.yandexlamp.domain.PostSetBrightnessLevelUseCase
import ru.alexeypostnov.yandexlamp.domain.PostSetStateOffUseCase
import ru.alexeypostnov.yandexlamp.domain.PostSetStateOnUseCase
import java.lang.Exception


class MainViewModel @Inject constructor(
    private val getColorsUseCase: GetColorsUseCase,
    private val postApplyUseCase: PostApplyColorUseCase,
    private val postSetStateOnUseCase: PostSetStateOnUseCase,
    private val postSetStateOffUseCase: PostSetStateOffUseCase,
    private val getBrightnessInfoUseCase: GetBrightnessInfoUseCase,
    private val getCurrentBrightnessLevelUseCase: GetCurrentBrightnessLevelUseCase,
    private val postSetBrightnessLevelUseCase: PostSetBrightnessLevelUseCase
): ViewModel() {
    private val _colors = MutableLiveData<List<ColorInfo>>()
    val colors: LiveData<List<ColorInfo>>
        get() = _colors

    val _brightness = MutableLiveData<BrightnessInfo>()
    val brightness: LiveData<BrightnessInfo> get() = _brightness

    val _currentBrightnessLevel = MutableLiveData<Int>()
    val currentBrightnessLevel: LiveData<Int> get() = _currentBrightnessLevel

    init {
        loadColorsInfo()
        loadCurrentBrightnessLevel()
        loadBrightnessInfo()
    }

    fun loadColorsInfo() {
        viewModelScope.launch {
            val colorsInfo = getColorsUseCase()

            _colors.postValue(
                if (colorsInfo.isNullOrEmpty()) {
                    error("Список цветов = null")
                } else {
                    colorsInfo
                }
            )
        }
    }

    fun applyColor(color: String) {
        viewModelScope.launch {
            postApplyUseCase(color)
        }
    }

    fun setStateOn() {
        viewModelScope.launch {
            postSetStateOnUseCase()
        }
    }

    fun setStateOff() {
        viewModelScope.launch {
            postSetStateOffUseCase()
        }
    }

    fun loadBrightnessInfo() {
        viewModelScope.launch {
            val brightnessInfo = getBrightnessInfoUseCase()

            _brightness.postValue(
                if (brightnessInfo != null) {
                    brightnessInfo
                } else {
                    error("brightnessInfo is null")
                }
            )
        }
    }

    fun loadCurrentBrightnessLevel() {
        viewModelScope.launch {
            val currentBrightnessLevel = getCurrentBrightnessLevelUseCase()

            _currentBrightnessLevel.postValue(
                if (currentBrightnessLevel != null) {
                    currentBrightnessLevel
                } else {
                    error("currentBrightnessLevel is null")
                }
            )
        }
    }

    fun setBrightnessLevel(level: Int) {
        viewModelScope.launch {
            postSetBrightnessLevelUseCase(level)
        }
    }
}