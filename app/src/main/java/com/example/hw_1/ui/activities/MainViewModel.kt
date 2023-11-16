package com.example.hw_1.ui.activities

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.hw_1.data.repositories.AppModel
import com.example.hw_1.data.repositories.RickAndMortyRepo

class MainViewModel(private val repo: RickAndMortyRepo) : ViewModel() {

//    private val repo = RickAndMortyRepo()
//    private val _charactersData = MutableLiveData<List<Character>>()
//    val charactersData: LiveData<List<Character>> = _charactersData

    fun getCharacters():LiveData<AppModel>{
        return repo.getCharacters()
    }
    
}