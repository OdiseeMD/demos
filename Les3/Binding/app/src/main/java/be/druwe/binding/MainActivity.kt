package be.druwe.binding

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import be.druwe.binding.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
  //      setContentView(R.layout.activity_main)

//        val button = findViewById<TextView>(R.id.button)
        val binding = DataBindingUtil.setContentView<ActivityMainBinding>(this, R.layout.activity_main)

        binding.clickButton.setOnClickListener{
            binding.greeting = "DEMO IN DE KLAS"
        }

    }
}