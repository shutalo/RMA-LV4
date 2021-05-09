package com.example.zad1.activities

import android.content.Context
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.example.zad1.AnimalCounterApp
import com.example.zad1.R
import com.example.zad1.databinding.ActivityAnimalCounterBinding
import com.example.zad1.viewmodels.AnimalCounterViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class AnimalCounterActivity : AppCompatActivity() {

    private lateinit var animalCounterBinding: ActivityAnimalCounterBinding
    private val animalCounterViewModel by viewModel<AnimalCounterViewModel>()
    private var backgroundColor = R.color.white

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        animalCounterBinding = ActivityAnimalCounterBinding.inflate(layoutInflater)
        setContentView(animalCounterBinding.root)

        animalCounterViewModel.loadFromSharedPrefs()

        animalCounterBinding.redButton.setOnClickListener{
            animalCounterViewModel.seeBird()
            animalCounterViewModel.updateBackgroundColor(R.color.red)
        }
        animalCounterBinding.greenButton.setOnClickListener{
            animalCounterViewModel.seeBird()
            animalCounterViewModel.updateBackgroundColor(R.color.green)
        }
        animalCounterBinding.yellowButton.setOnClickListener{
            animalCounterViewModel.seeBird()
            animalCounterViewModel.updateBackgroundColor(R.color.yellow)
        }
        animalCounterBinding.blueButton.setOnClickListener{
            animalCounterViewModel.seeBird()
            animalCounterViewModel.updateBackgroundColor(R.color.blue)
        }
        animalCounterBinding.resetButton.setOnClickListener {
            animalCounterViewModel.reset()
        }

        animalCounterViewModel.birdsSeen.observe(this){
            animalCounterBinding.numberOfBirdsTV.text = it.toString()
        }

        animalCounterViewModel.backgroundColor.observe(this){
            animalCounterBinding.numberOfBirdsTV.setBackgroundResource(it)
        }
    }

    override fun onPause() {
        super.onPause()
        animalCounterViewModel.saveToSharedPrefs()
    }
}