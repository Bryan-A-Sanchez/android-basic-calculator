package com.example.mycalc.buttonfunctions

import com.example.mycalc.databinding.ActivityMainBinding

fun deleteSingleChar(binding:ActivityMainBinding){
    val currentEquation = binding.resultText.text.toString()
    if(currentEquation.isNotEmpty()) {
        val currentCursor = binding.resultText.selectionStart
        var newEquation =
            currentEquation.substring(0, currentCursor - 1) + currentEquation.substring(
                currentCursor
            )
        binding.resultText.setText(newEquation)
        binding.resultText.setSelection(currentCursor - 1)
    }

}