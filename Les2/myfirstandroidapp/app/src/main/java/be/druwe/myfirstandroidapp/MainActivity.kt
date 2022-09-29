package be.druwe.myfirstandroidapp

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.View.OnClickListener
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    lateinit var helloWorldView: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        helloWorldView = findViewById(R.id.helloWorld)


        val button = findViewById<Button>(R.id.mainButton)

        button.setOnClickListener { view ->
            helloWorldView.text = "Hello Demo"
        }
    }

}