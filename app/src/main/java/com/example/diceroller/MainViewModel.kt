package com.example.diceroller

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlin.random.Random

class MainViewModel: ViewModel(){
    private val _diceNumber = MutableStateFlow(0)
    val diceNumber: StateFlow<Int> get() = _diceNumber

    private val _diceImage = MutableStateFlow(R.drawable.empty_dice)
    val diceImage: StateFlow<Int> get() = _diceImage

    private val _playerName = MutableStateFlow("")
    val playerName: StateFlow<String> get() = _playerName

    fun rollDice(){
        _diceNumber.value = Random.nextInt(6)+1
        _diceImage.value = when(_diceNumber.value){
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            else -> R.drawable.dice_6
        }
    }
}