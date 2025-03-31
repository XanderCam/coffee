package com.example.coffeecounter

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.coffeecounter.databinding.FragmentMusicBinding

class MusicFragment : Fragment() {
    private var _binding: FragmentMusicBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentMusicBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        
        setupClickListeners()
        observePlayerState()
    }

    private fun setupClickListeners() {
        binding.btnConnectSpotify.setOnClickListener {
            SpotifyManager.connect(requireActivity())
        }

        binding.btnPlay.setOnClickListener {
            SpotifyManager.playCoffeePlaylist()
        }

        binding.btnPause.setOnClickListener {
            SpotifyManager.pausePlayback()
        }
    }

    private fun observePlayerState() {
        SpotifyManager.getCurrentTrack { track ->
            track?.let {
                binding.tvCurrentTrack.text = "${it.name} - ${it.artist.name}"
            } ?: run {
                binding.tvCurrentTrack.text = getString(R.string.no_track_playing)
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}