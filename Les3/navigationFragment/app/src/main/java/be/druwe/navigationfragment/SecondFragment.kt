package be.druwe.navigationfragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView


/**
 * A simple [Fragment] subclass.
 * Use the [SecondFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class SecondFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val args = SecondFragmentArgs.fromBundle(requireArguments())
        val view = inflater.inflate(R.layout.fragment_second, container, false)
        view.findViewById<TextView>(R.id.secondFragmentText).text = args.number.toString()

        return view



    }
}