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
 * Main fragment contains the starting page for the game
 *
 * Contains two buttons: Play and High Score that sends you to their fragments
 * Contains safe args from the play fragments to populate the [prevPlayerInfo] field when a game
 * has been played. Also updates the [welcomeTextView] after a game has been played.
 *
 * @author Timothy Chan
 */
class MainFragment : Fragment() {
    val TAG = "MainFragment"
    private var _binding: FragmentMainBinding? = null
    private val binding get() = _binding!!
    private var guesses = -1
    private var name = "anonymous"
    private val args: MainFragmentArgs by navArgs()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {

            // safe args are here
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

        /*
         * If prior game has been played, the safe args will make it so guesses
         * is no longer 1. Which allows this to trigger
         */
        if (guesses != -1) {
            var prevPlayerInfo = binding.prevPlayerInfo
            prevPlayerInfo.visibility = View.VISIBLE
            prevPlayerInfo.text = "$name score: $guesses"
            welcomeTextView.text = "Play another game?"
        }


        //These two send you to their fragments
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