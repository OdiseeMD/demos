package be.druwe.scorecounter

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import be.druwe.scorecounter.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    val mainViewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding =
            DataBindingUtil.setContentView<ActivityMainBinding>(this, R.layout.activity_main)

        binding.viewmodel = mainViewModel
        binding.lifecycleOwner = this

        binding.PlusOneTeam1Button.setOnClickListener {
            mainViewModel.increaseScoreTeamA()
        }

        binding.PlusOneTeam2Button.setOnClickListener {
            mainViewModel.increaseScoreTeamB()
        }

        binding.PlusTwoTeam1Button.setOnClickListener {
            mainViewModel.increaseScoreTeamA()
            mainViewModel.increaseScoreTeamA()
        }

        binding.PlusTwoTeam2Button.setOnClickListener {
            mainViewModel.increaseScoreTeamB()
            mainViewModel.increaseScoreTeamB()
        }

        mainViewModel.resultA.observe(this) {
            binding.winnerTextView.text = it
        }

        mainViewModel.resultB.observe(this) {
            binding.winnerTextView.text = it
        }

//        mainViewModel.scoreA.observe(this) {
//            binding.score1TextView.text = getString(R.string.score, it)
//        }
//
//        mainViewModel.scoreB.observe(this) {
//            binding.score2TextView.text = getString(R.string.score, it)
//        }
    }

}