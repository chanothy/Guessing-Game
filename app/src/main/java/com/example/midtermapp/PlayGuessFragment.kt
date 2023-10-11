package com.example.midtermapp

import android.media.MediaPlayer
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.midtermapp.databinding.FragmentPlayGuessBinding
import kotlin.random.Random



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


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentPlayGuessBinding.inflate(inflater, container, false)
        val view = binding.root
        val activity = requireActivity() as MainActivity
        viewModel = activity.sharedViewModel
        viewModel.guessAttempts.value = "0"
        binding.viewModel = viewModel
        binding.lifecycleOwner = viewLifecycleOwner


        val plusButton = binding.plusButton
        val minusButton = binding.minusButton
        val guessEditText = binding.guessEditText
        var okButton = binding.okButton

        // random number generator
        val minValue = 1
        val maxValue = 100
        val correctNumber = Random.nextInt(minValue, maxValue + 1)
        Log.d("correct number", correctNumber.toString())

        // click buttons
        plusButton.setOnClickListener {
            if (guessEditText.text.toString() != "") {
                guessEditText.setText(guessEditText.text.toString().toInt().plus(1).toString())
            }
        }

        minusButton.setOnClickListener {
            if (guessEditText.text.toString() != "") {
                guessEditText.setText(guessEditText.text.toString().toInt().minus(1).toString())
            }
        }

        // toast and noise cue code
        okButton.setOnClickListener {
            viewModel.playerName.value = binding.enterPlayerName.text.toString()
            var result: String
            if (guessEditText.text.toString() != "" && guessEditText.text.toString().toInt() > correctNumber) {
                result = "higher"
            }
            else {
                result = "lower"
            }
            /*
            if wrong answer, else if correct answer
            Code will iterate the guess attempts in the viewModel here
             */
            if (correctNumber.toString() != guessEditText.text.toString()) {
                viewModel.guessAttempts.value = viewModel.guessAttempts.value?.toInt()?.plus(1).toString()
                Log.d("guess attempts", viewModel.guessAttempts.value.toString())
                guessEditText.setText("")
                val text = "Your guess was $result than the answer"
                val duration = Toast.LENGTH_SHORT
                Toast.makeText(context, text, duration).show()
                var mediaPlayer = MediaPlayer.create(context, R.raw.wrong)
                mediaPlayer.start()
            }
            else if (correctNumber.toString() == guessEditText.text.toString()) {
                viewModel.guessAttempts.value = viewModel.guessAttempts.value?.toInt()?.plus(1).toString()
                val action = PlayFragmentDirections.actionPlayFragmentToMainFragment().apply {
                    playerName = viewModel.playerName.value.toString()
                    guesses = viewModel.guessAttempts.value.toString()
                }
                Log.d("actions","play to main")
                viewModel.addTask()
                this.findNavController().navigate(action)
            }
        }

        return view
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}