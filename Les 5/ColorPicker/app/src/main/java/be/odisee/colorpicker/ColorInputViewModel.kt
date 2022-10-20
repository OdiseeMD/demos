package be.odisee.colorpicker

import androidx.lifecycle.*
import be.odisee.colorpicker.database.Color
import be.odisee.colorpicker.database.ColorDao
import kotlinx.coroutines.launch

class ColorInputViewModel(val colorDao: ColorDao) : ViewModel() {

    private val _colors = MutableLiveData<Array<Color>>()
    val colors: LiveData<Array<Color>> = _colors

    fun getAllColors() {
        viewModelScope.launch {
            _colors.value = colorDao.getAll()
        }
    }

    fun getAllLiveData() = colorDao.getAllLiveData()

    fun insertColor() {
        viewModelScope.launch {
            colorDao.insert(Color(name = "Blue", colorHex = "#0000FF"))
        }
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