package com.example.midtermapp

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.midtermapp.databinding.FragmentMainBinding
import com.example.midtermapp.databinding.FragmentPlayGuessBinding
import kotlin.random.Random

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [PlayGuessFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class PlayGuessFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null
    private var _binding: FragmentPlayGuessBinding? = null
    private val binding get() = _binding!!
    lateinit var viewModel: PlayViewModel



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentPlayGuessBinding.inflate(inflater, container, false)
        val view = binding.root
        viewModel = ViewModelProvider(requireActivity()).get(PlayViewModel::class.java)

        val minValue = 1
        val maxValue = 100
//        val correctNumber = Random.nextInt(minValue, maxValue + 1) // Add 1 to include the maxValue
        val correctNumber = 1

        var guessEditText = binding.guessEditText
        var okButton = binding.okButton
        okButton.setOnClickListener {
            viewModel.playerName.value = binding.enterPlayerName.text.toString()
            if (correctNumber.toString() != guessEditText.text.toString()) {
                viewModel.guessAttempts.value = viewModel.guessAttempts.value?.toInt()?.plus(1).toString()
                guessEditText.setText("")
            }
            else if (correctNumber.toString() == guessEditText.text.toString()) {

                val action = PlayFragmentDirections.actionPlayFragmentToMainFragment().apply {
                    playerName = viewModel.playerName.value.toString()
                    guesses = viewModel.guessAttempts.value.toString()
                }
                Log.d("actions","play to main")
                this.findNavController().navigate(action)
            }
        }



        return view
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment PlayGuessFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            PlayGuessFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}