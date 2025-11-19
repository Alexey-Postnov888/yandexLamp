package ru.alexeypostnov.yandexlamp.presenter

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import ru.alexeypostnov.yandexlamp.domain.GetColorsUseCase
import ru.alexeypostnov.yandexlamp.domain.PostApplyColorUseCase
import javax.inject.Inject
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import ru.alexeypostnov.yandexlamp.data.model.ColorInfo
import ru.alexeypostnov.yandexlamp.domain.PostSetStateOffUseCase
import ru.alexeypostnov.yandexlamp.domain.PostSetStateOnUseCase


class MainViewModel @Inject constructor(
    private val getColorsUseCase: GetColorsUseCase,
    private val postApplyUseCase: PostApplyColorUseCase,
    private val postSetStateOnUseCase: PostSetStateOnUseCase,
    private val postSetStateOffUseCase: PostSetStateOffUseCase
): ViewModel() {
    private val _colors = MutableLiveData<List<ColorInfo>>()
    val colors: LiveData<List<ColorInfo>>
        get() = _colors

    init {
        loadColorsInfo()
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
}