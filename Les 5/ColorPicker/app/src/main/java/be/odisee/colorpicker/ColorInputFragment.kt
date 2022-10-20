package be.odisee.colorpicker

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import be.odisee.colorpicker.database.ColorDatabase
import be.odisee.colorpicker.databinding.FragmentColorInputBinding


/**
 * A simple [Fragment] subclass.
 * Use the [ColorInputFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class ColorInputFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val binding = DataBindingUtil.inflate<FragmentColorInputBinding>(
            inflater,
            R.layout.fragment_color_input,
            container,
            false
        )

        val colorDao = ColorDatabase.getInstance(requireActivity().application).colorDao()
        val viewModel = ViewModelProvider(
            this,
            ColorInputViewModelFactory(colorDao)
        ).get(ColorInputViewModel::class.java)

        viewModel.getAllLiveData().observe(viewLifecycleOwner) {
            binding.numberOfitems.text = it.size.toString()
        }

        viewModel.colors.observe(viewLifecycleOwner) {
            binding.numberOfitems.text = it.size.toString()
        }

        viewModel.getAllColors()



        binding.addButton.setOnClickListener {
            viewModel.insertColor()

        }


        return binding.root
    }

}