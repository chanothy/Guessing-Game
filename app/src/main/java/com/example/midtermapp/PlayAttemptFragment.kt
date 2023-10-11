package com.example.midtermapp

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.midtermapp.databinding.FragmentPlayAttemptBinding
import com.example.midtermapp.databinding.FragmentPlayGuessBinding

/**
 * Play attempt fragment is where the amount of attempts are shown to the player
 */
class PlayAttemptFragment : Fragment() {
    private var _binding: FragmentPlayAttemptBinding? = null
    private val binding get() = _binding!!
    private lateinit var viewModel: PlayViewModel


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentPlayAttemptBinding.inflate(inflater, container, false)
        val view = binding.root
        val activity = requireActivity() as MainActivity
        viewModel = activity.sharedViewModel

        var attemptNumber = binding.attemptNumber

        // This observes the attempt number in the viewModel and updates reactively
        viewModel.guessAttempts.observe(viewLifecycleOwner, Observer {
            attemptNumber.text = viewModel.guessAttempts.value.toString()
            Log.d("Play Attempt Fragment",viewModel.guessAttempts.value.toString())
        })

        return view
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}