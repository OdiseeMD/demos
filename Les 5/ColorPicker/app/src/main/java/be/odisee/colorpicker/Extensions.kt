package be.odisee.colorpicker

import android.graphics.Color
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.databinding.BindingAdapter

@BindingAdapter("color")
fun ConstraintLayout.setColor(hexString: String) {

    val color = Color.parseColor(hexString)
    this.setBackgroundColor(color)

}