package com.example.zad1.model

import com.example.zad1.R

class AnimalCounter {

    var birdsSeen = 0
        private set
    var backgroundColor = R.color.white

    fun updateBackgroundColor(color: Int){
        backgroundColor = color
    }

    fun seeBird(){
        birdsSeen++
    }

    fun reset(){
        birdsSeen = 0
        backgroundColor = R.color.white
    }

    fun loadFromSharedPrefs(numberOfBirds: Int,color: Int){
        birdsSeen = numberOfBirds
        backgroundColor = color
    }
}