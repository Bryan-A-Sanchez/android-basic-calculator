package com.example.mycalc.buttonfunctions

import com.example.mycalc.databinding.ActivityMainBinding

// Algorithm to calculate numbers. runs in O(n) time
fun crunchNumbers(binding: ActivityMainBinding): Double {
    val equation = parseIntoList(binding.resultText.text.toString())
    var index = 0
    var answer = 0.0
    var tempMultiplyDivide: Double? = null //? means that the type can be null


    while (index < equation.size) {
        var nextElement = when (index != equation.size - 1) {//making sure within index range
            true -> equation[index + 1].toDoubleOrNull()
            false -> {
                answer += tempMultiplyDivide ?: equation[index].toDouble()
                return answer
            }
        }
        if (nextElement != null) {//this means that the current number must be added to answer
            when (tempMultiplyDivide == null) {
                true -> answer += equation[index].toDouble()
                false -> {
                    answer += tempMultiplyDivide; tempMultiplyDivide = null
                }
            }
            index++
        } else {//this means there a * or / symbol
            tempMultiplyDivide = if (equation[index + 1] == "*") {
                when (tempMultiplyDivide == null) {
                    true -> equation[index].toDouble() * equation[index + 2].toDouble()
                    false -> tempMultiplyDivide * equation[index + 2].toDouble()
                }
            } else {
                when (tempMultiplyDivide == null) {
                    true -> equation[index].toDouble() / equation[index + 2].toDouble()
                    false -> tempMultiplyDivide / equation[index + 2].toDouble()
                }
            }

            index += 2
        }

    }

    return answer
}

/*
Parses string equation so it goes from this "67+1-10*3/-4" to [67,1,-10,*,3,/,-4]
Makes it easier for the calculate algo. to do the calculate and not worry about formatting
 */
private fun parseIntoList(equation: String): MutableList<String> {
    val parsedEquation = mutableListOf<String>()
    var currentNumber = ""

    for (item in equation) {
        if (currentNumber.isEmpty() && item == '-') {
            currentNumber += item
        } else if (item == '-') {
            parsedEquation.add(currentNumber)
            currentNumber = "-"
        } else if (item.isDigit() || item == '.') {//making sure we catch decimal numbers with the .
            currentNumber += item
        } else if (item == '*' || item == '/') {
            parsedEquation.add(currentNumber)
            currentNumber = ""
            parsedEquation.add(item.toString())
        } else {
            parsedEquation.add(currentNumber)
            currentNumber = ""
        }

    }
    parsedEquation.add(currentNumber)
    return parsedEquation
}


/*************************** CURRENT BUGS***********************
 * pushing equal with nothing inputted causes app to crash
 * having 2 minus signs also crashes app. easy fix with regex
 * More of format issue but answers come out as decimal all the time. Not when needed.
 */