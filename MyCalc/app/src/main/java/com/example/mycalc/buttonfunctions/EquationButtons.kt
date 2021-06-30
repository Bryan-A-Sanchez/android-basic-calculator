package com.example.mycalc.buttonfunctions

import com.example.mycalc.databinding.ActivityMainBinding

fun addToEquationText(numberOrSymbol: String, binding: ActivityMainBinding) {

    //selection start returns position of cursor. ex. hel|lo would return 3
    val currentCursor = binding.resultText.selectionStart
    val currentEquation = binding.resultText.text.toString()
    var newEquation = currentEquation.substring(0,currentCursor) + numberOrSymbol +
            currentEquation.substring(currentCursor)
    binding.resultText.setText(newEquation)
    binding.resultText.setSelection(currentCursor+1)
}