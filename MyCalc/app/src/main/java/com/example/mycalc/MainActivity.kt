package com.example.mycalc

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.mycalc.buttonfunctions.addToEquationText
import com.example.mycalc.buttonfunctions.crunchNumbers
import com.example.mycalc.buttonfunctions.deleteSingleChar
import com.example.mycalc.databinding.ActivityMainBinding
import com.example.mycalc.formatchecker.isEquationFormatCorrect


class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.resultText.text.clear()
        binding.resultText.showSoftInputOnFocus = false

        binding.zero.setOnClickListener { addToEquationText("0", binding) }
        binding.one.setOnClickListener { addToEquationText("1", binding) }
        binding.two.setOnClickListener { addToEquationText("2", binding) }
        binding.three.setOnClickListener { addToEquationText("3", binding) }
        binding.four.setOnClickListener { addToEquationText("4", binding) }
        binding.five.setOnClickListener { addToEquationText("5", binding) }
        binding.six.setOnClickListener { addToEquationText("6", binding) }
        binding.seven.setOnClickListener { addToEquationText("7", binding) }
        binding.eight.setOnClickListener { addToEquationText("8", binding) }
        binding.nine.setOnClickListener { addToEquationText("9", binding) }
        binding.add.setOnClickListener { addToEquationText("+", binding) }
        binding.minus.setOnClickListener { addToEquationText("-", binding) }
        binding.multiply.setOnClickListener { addToEquationText("*", binding) }
        binding.divide.setOnClickListener { addToEquationText("/", binding) }
        binding.equal.setOnClickListener { calculate() }
        binding.delete.setOnClickListener { deleteSingleChar(binding) }


    }

    private fun calculate() {
        if (isEquationFormatCorrect(binding)) {
            binding.resultText.setText(crunchNumbers(binding).toString())
            binding.resultText.setSelection(binding.resultText.text.length)
            return
        }
        Toast.makeText(this, "Invalid Format!", Toast.LENGTH_SHORT).show()
    }


}

/*
TODOS:
>Think of other ways to break format and fix with regex
>Add clear all button
>Add more features?
 */

/*
FINISHED TODOS:
>Implement function calculate: Add->DONE; Subtract->DONE; MULTIPLY/DIVIDE->IN PROGRESS
 */