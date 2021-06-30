package com.example.mycalc.formatchecker


import com.example.mycalc.databinding.ActivityMainBinding


private val regexMultiSigns = """\+{2,}|\++[\/\*]+|\*{2,}|\*+[\/\+]+|\/{2,}|\/+[\*\+]+""".toRegex()
private val regexStartEnd = """^[^0-9-]|[^0-9]${'$'}""".toRegex()


fun isEquationFormatCorrect(binding: ActivityMainBinding):Boolean{
    val currentEquation = binding.resultText.text.toString()
    if(regexMultiSigns.containsMatchIn(currentEquation) or regexStartEnd.containsMatchIn(currentEquation)) {
        return false
    }
    return true
}
