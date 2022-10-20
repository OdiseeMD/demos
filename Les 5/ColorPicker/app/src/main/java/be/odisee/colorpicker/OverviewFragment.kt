package be.odisee.colorpicker

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import be.odisee.colorpicker.database.ColorDatabase
import be.odisee.colorpicker.databinding.FragmentOverviewBinding

/**
 * A simple [Fragment] subclass.
 * Use the [OverviewFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class OverviewFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val binding = DataBindingUtil.inflate<FragmentOverviewBinding>(
            inflater,
            R.layout.fragment_overview,
            container,
            false
        )

        binding.addButton.setOnClickListener {
            findNavController().navigate(OverviewFragmentDirections.actionOverviewFragmentToColorInputFragment())
        }
        val colorDao = ColorDatabase.getInstance(requireActivity().application).colorDao()
        val viewModel = ViewModelProvider(
            this,
            OverviewViewModelFactory(colorDao)
        ).get(OverviewViewModel::class.java)
        val manager = GridLayoutManager(requireContext(), 3)
        manager.spanSizeLookup = object : GridLayoutManager.SpanSizeLookup() {
            override fun getSpanSize(position: Int): Int {
                return when (position) {
                    0, 1, 2 -> 1
                    else -> 3
                }
            }

        }

        binding.colorRecyclerView.layoutManager = manager
        val adapter = ColorAdapter {
            findNavController().navigate(
                OverviewFragmentDirections.actionOverviewFragmentToColorDetail(
                    it
                )
            )
        }
        binding.colorRecyclerView.adapter = adapter
        viewModel.getColors().observe(viewLifecycleOwner) {
            adapter.submitList(it.toList())
        }
        return binding.root
    }
}