package be.druwe.recyclerview

import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class MyAdapter(val data: List<Int>): RecyclerView.Adapter<MyAdapter.NumberViewHolder>() {

    class NumberViewHolder(itemView: View) :RecyclerView.ViewHolder(itemView) {
        val textView = itemView.findViewById<TextView>(R.id.numberTextView)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NumberViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.list_item, parent, false)
        val red = (0..255).random()
        val blue = (0..255).random()
        val green = (0..255).random()
        view.setBackgroundColor(Color.rgb(red,green, blue))
        return NumberViewHolder(view);
    }

    override fun onBindViewHolder(holder: NumberViewHolder, position: Int) {
        holder.textView.text = data[position].toString()
    }

    override fun getItemCount(): Int {
        return data.size
    }
}