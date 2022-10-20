package be.odisee.colorpicker

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
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



        binding.blueSlider.addOnChangeListener { _, value, _ ->
            viewModel.setBlue(value)
        }
        binding.greenSlider.addOnChangeListener { _, value, _ ->
            viewModel.setGreen(value)
        }
        binding.redSlider.addOnChangeListener { _, value, _ ->
            viewModel.setRed(value)
        }

        viewModel.selectedColor.observe(viewLifecycleOwner) {
            binding.colorPreview.setBackgroundColor(it)
        }
        binding.addButton.setOnClickListener {
            if (binding.nameEditText.text.isNotBlank()) {
                viewModel.insertColor(binding.nameEditText.text.toString())
                findNavController().popBackStack()
            } else {
                Toast.makeText(requireActivity(), R.string.no_name, Toast.LENGTH_LONG).show()
            }
        }

        return binding.root
    }

}