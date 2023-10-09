package com.example.midtermapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.midtermapp.databinding.FragmentMainBinding


/**
 * A simple [Fragment] subclass.
 * Use the [MainFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class MainFragment : Fragment() {
    // TODO: Rename and change types of parameters
    val TAG = "MainFragment"
    private var _binding: FragmentMainBinding? = null
    private val binding get() = _binding!!
    private var guesses = -1
    private var name = "anonymous"
    private val args: MainFragmentArgs by navArgs()





    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            if (args.guesses.toInt() != -1) {
                guesses = args.guesses.toInt()
            }
            if (args.playerName != "anonymous") {
                name = args.playerName
            }
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentMainBinding.inflate(inflater, container, false)
        val view = binding.root
        val welcomeTextView = binding.welcomeTextView

        if (guesses != -1) {
            var prevPlayerInfo = binding.prevPlayerInfo
            prevPlayerInfo.visibility = View.VISIBLE
            prevPlayerInfo.text = "$name score: $guesses"
            welcomeTextView.text = "Play another game?"
        }


        var highscore_button = binding.highscoreButton
        highscore_button.setOnClickListener {
            val action = MainFragmentDirections.actionMainFragmentToTasksFragment()
            this.findNavController().navigate(action)
        }

        var play_button = binding.playButton
        play_button.setOnClickListener {
            val action = MainFragmentDirections.actionMainFragmentToPlayFragment()
            this.findNavController().navigate(action)
        }

        return view
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}