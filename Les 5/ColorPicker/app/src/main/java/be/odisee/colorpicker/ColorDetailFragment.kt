package be.odisee.colorpicker

import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import be.odisee.colorpicker.database.ColorDatabase
import be.odisee.colorpicker.databinding.FragmentColorDetailBinding

class ColorDetailFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val binding = DataBindingUtil.inflate<FragmentColorDetailBinding>(
            inflater,
            R.layout.fragment_color_detail,
            container,
            false
        )
        val args = ColorDetailFragmentArgs.fromBundle(requireArguments())
        val viewModel = ViewModelProvider(
            this, ColorDetailViewModelFactory(
                ColorDatabase.getInstance(requireActivity().application).colorDao()
            )
        ).get(ColorDetailViewModel::class.java)

        viewModel.getColor(args.id).observe(viewLifecycleOwner) {
            binding.root.setBackgroundColor(Color.parseColor(it.colorHex))
        }

        binding.deleteButton.setOnClickListener {
            viewModel.deleteItem(args.id)
            findNavController().popBackStack()
        }
        return binding.root
    }

}