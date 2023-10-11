package com.example.midtermapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.midtermapp.databinding.FragmentMainBinding
import com.example.midtermapp.databinding.FragmentPlayBinding

/**
 * Play fragment is the fragment that holds the
 * [PlayGuessFragment] and [PlayAttemptFragment]
 * fragment views.
 */
class PlayFragment : Fragment() {
    private var _binding: FragmentPlayBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentPlayBinding.inflate(inflater, container, false)
        val view = binding.root
        return view
    }
}