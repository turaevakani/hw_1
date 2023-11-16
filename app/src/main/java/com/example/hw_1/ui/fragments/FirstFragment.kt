package com.example.hw_1.ui.fragments

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.hw_1.R
import com.example.hw_1.data.repositories.AppModel
import com.example.hw_1.data.repositories.Result
import com.example.hw_1.data.repositories.RickAndMortyRepo
import com.example.hw_1.databinding.FragmentFirstBinding
import com.example.hw_1.ui.activities.MainViewModel
import com.example.hw_1.ui.adapters.RickAndMortyAdapter

class FirstFragment : Fragment() {

    private lateinit var binding: FragmentFirstBinding
    private val viewModel =MainViewModel(RickAndMortyRepo())
    private  var adapter = RickAndMortyAdapter(this::onClick)


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentFirstBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initLiveData()


    }

    private fun initLiveData() {
        viewModel.getCharacters().observe(viewLifecycleOwner) {
            it.let { characterList ->
                adapter.addData(characterList.results)
                binding.rvRickAndMorty.adapter = adapter
                Log.e("ololo", "initLiveData: $characterList", )
            }
        }

    }

    fun onClick(baseResponse: Result) {
        findNavController().navigate(R.id.secondFragment, bundleOf("key" to baseResponse))
    }
}

