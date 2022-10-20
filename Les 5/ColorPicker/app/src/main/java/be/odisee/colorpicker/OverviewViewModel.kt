package be.odisee.colorpicker

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import be.odisee.colorpicker.database.ColorDao

class OverviewViewModel(private val colorDao: ColorDao) : ViewModel() {

    fun getColors() = colorDao.getAllLiveData()
}

@Suppress("UNCHECKED_CAST")
class OverviewViewModelFactory(val colorDao: ColorDao) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(OverviewViewModel::class.java)) {
            return OverviewViewModel(colorDao) as T
        }
        throw  IllegalArgumentException("Not a valid ViewModel")
    }
}