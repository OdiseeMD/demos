package be.odisee.colorpicker

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import be.odisee.colorpicker.database.Color
import be.odisee.colorpicker.databinding.ColorViewBinding

class ColorAdapter(private val onClick: (Long) -> Unit) :
    ListAdapter<Color, ColorAdapter.ColorViewHolder>(ColorDiffUtilCallback()) {

    class ColorViewHolder(val binding: ColorViewBinding) : RecyclerView.ViewHolder(binding.root) {

        companion object {
            fun from(parent: ViewGroup): ColorViewHolder {
                val layoutInflater =
                    LayoutInflater.from(parent.context)

                val binding = ColorViewBinding.inflate(layoutInflater, parent, false)
                return ColorViewHolder(binding)
            }
        }
    }


    class ColorDiffUtilCallback : DiffUtil.ItemCallback<Color>() {
        override fun areItemsTheSame(oldItem: Color, newItem: Color): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: Color, newItem: Color): Boolean {
            return oldItem == newItem
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ColorViewHolder {

        return ColorViewHolder.from(parent)
    }

    override fun onBindViewHolder(holder: ColorViewHolder, position: Int) {
        holder.binding.color = getItem(position)
        holder.binding.root.setOnClickListener {
            onClick(getItem(position).id)
        }
    }

}