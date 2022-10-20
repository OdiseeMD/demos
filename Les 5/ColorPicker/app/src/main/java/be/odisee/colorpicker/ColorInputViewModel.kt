package be.odisee.colorpicker

import androidx.lifecycle.*
import be.odisee.colorpicker.database.Color
import be.odisee.colorpicker.database.ColorDao
import kotlinx.coroutines.launch

class ColorInputViewModel(val colorDao: ColorDao) : ViewModel() {

    private val _colors = MutableLiveData<Array<Color>>()
    private val blueColor = MutableLiveData<Int>(0)
    private val redColor = MutableLiveData<Int>(0)
    private val greenColor = MutableLiveData<Int>(0)

    val selectedColor: MediatorLiveData<Int> = MediatorLiveData()

    init {
        selectedColor.addSource(blueColor) {
            setColor()
        }
        selectedColor.addSource(redColor) {
            setColor()
        }
        selectedColor.addSource(greenColor) {
            setColor()
        }
    }

    private fun setColor() {
        selectedColor.value =
            android.graphics.Color.rgb(redColor.value!!, greenColor.value!!, blueColor.value!!)
    }

    fun insertColor(name: String) {
        viewModelScope.launch {
            colorDao.insert(
                Color(
                    name = name,
                    colorHex = "#" + Integer.toHexString(
                        selectedColor.value!!
                    ).drop(2)
                )
            )
        }
    }

    fun setBlue(value: Float) {
        blueColor.value = (value * 255).toInt()
    }

    fun setGreen(value: Float) {
        greenColor.value = (value * 255).toInt()
    }

    fun setRed(value: Float) {
        redColor.value = (value * 255).toInt()
    }
}

@Suppress("UNCHECKED_CAST")
class ColorInputViewModelFactory(val colorDao: ColorDao) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(ColorInputViewModel::class.java)) {
            return ColorInputViewModel(colorDao) as T
        }

        throw IllegalArgumentException("Not a ColorInputViewModel")
    }
}