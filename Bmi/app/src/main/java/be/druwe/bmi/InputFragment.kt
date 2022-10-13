package be.druwe.bmi

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import be.druwe.bmi.databinding.FragmentInputBinding


/**
 * A simple [Fragment] subclass.
 * Use the [InputFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class InputFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val binding = DataBindingUtil.inflate<FragmentInputBinding>(
            inflater,
            R.layout.fragment_input,
            container,
            false
        )

        binding.calculateButton.setOnClickListener {
            val weightText = binding.weightEditText.text.toString()
            val lengthText = binding.lengthEditText.text.toString()
            val weight = weightText.toFloatOrNull()
            val length = lengthText.toFloatOrNull()

            if (length != null && weight != null) {
                findNavController().navigate(
                    InputFragmentDirections.actionInputFragmentToResultFragment(
                        weight,
                        length
                    )
                )
            }
        }

        return binding.root
    }
}