package com.example.zad1.viewmodels

import android.content.Context
import android.content.SharedPreferences
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.zad1.AnimalCounterApp
import com.example.zad1.R
import com.example.zad1.model.AnimalCounter

class AnimalCounterViewModel(private val animalCounter: AnimalCounter) : ViewModel(){

    private val PREFS_FILENAME = "com.example.zad1.viewmodels"
    private val COLOR_KEY = "color"
    private val COUNT_KEY = "count"
    private val sharedPrefs: SharedPreferences = AnimalCounterApp.application.getSharedPreferences(PREFS_FILENAME, Context.MODE_PRIVATE)

    private var _birdsSeen: MutableLiveData<Int> = MutableLiveData<Int>()
    val birdsSeen: LiveData<Int> = _birdsSeen

    private var _backgroundColor: MutableLiveData<Int> = MutableLiveData<Int>()
    val backgroundColor: LiveData<Int> = _backgroundColor

    fun updateBackgroundColor(color: Int){
        animalCounter.updateBackgroundColor(color)
        _backgroundColor.postValue(animalCounter.backgroundColor)
    }
    fun seeBird(){
        animalCounter.seeBird()
        _birdsSeen.postValue(animalCounter.birdsSeen)
    }
    fun reset(){
        animalCounter.reset()
        _birdsSeen.postValue(animalCounter.birdsSeen)
        _backgroundColor.postValue(R.color.white)
    }

    fun loadFromSharedPrefs(){
        animalCounter.loadFromSharedPrefs(sharedPrefs.getInt(COUNT_KEY, 0),sharedPrefs.getInt(COLOR_KEY, R.color.white))
        _birdsSeen.postValue(animalCounter.birdsSeen)
        _backgroundColor.postValue(animalCounter.backgroundColor)
    }

    fun saveToSharedPrefs(){
        sharedPrefs.edit().also {
            it.putInt(COUNT_KEY, animalCounter.birdsSeen)
            it.putInt(COLOR_KEY, animalCounter.backgroundColor)
        }.apply()
    }
}