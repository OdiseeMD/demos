package be.druwe.scorecounter

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel() {

    private val _scoreA = MutableLiveData(0)
    private val _scoreB = MutableLiveData(0)

    val scoreA: LiveData<Int>
        get() = _scoreA
    val scoreB: LiveData<Int>
        get() = _scoreB

    val resultA: LiveData<String> = Transformations.map(scoreA) {
        if (it > 10) {
            "A wins"
        } else {
            ""
        }
    }

    val resultB: LiveData<String> = Transformations.map(scoreB) {
        if (it > 10) {
            "B wins"
        } else {
            ""
        }
    }

    fun increaseScoreTeamA() {
        _scoreA.value = (_scoreA.value ?: 0) + 1
    }

    fun increaseScoreTeamB() {
        _scoreB.value = (_scoreB.value ?: 0) + 1

    }
}