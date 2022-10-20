package be.odisee.colorpicker

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import be.odisee.colorpicker.database.Color
import be.odisee.colorpicker.database.ColorDao
import kotlinx.coroutines.launch

class ColorDetailViewModel(private val colorDao: ColorDao) : ViewModel() {

    fun getColor(id: Long) = colorDao.getColor(id)

    fun deleteItem(id: Long) {
        viewModelScope.launch {
            colorDao.delete(Color(id, "", ""))
        }
    }
}

@Suppress("UNCHECKED_CAST")
class ColorDetailViewModelFactory(val colorDao: ColorDao) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(ColorDetailViewModel::class.java)) {
            return ColorDetailViewModel(colorDao) as T
        }
        throw  IllegalArgumentException("Not a valid ViewModel")
    }
}