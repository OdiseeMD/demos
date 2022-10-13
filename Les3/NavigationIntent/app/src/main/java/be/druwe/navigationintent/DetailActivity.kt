package be.druwe.navigationintent

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import be.druwe.navigationintent.databinding.ActivityDetailBinding
import be.druwe.navigationintent.databinding.ActivityMainBinding

class DetailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding = DataBindingUtil.setContentView<ActivityDetailBinding>(this, R.layout.activity_detail);

    }
}