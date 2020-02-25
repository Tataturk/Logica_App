package com.example.logicaapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    var correctAnswers = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initView()
    }

    private fun initView()  {
        btnSubmit.setOnClickListener{onClickSubmit()}
    }

    private fun onClickSubmit() {
        val case1 = etCase1.text.toString()
        val case2 = etCase2.text.toString()
        val case3 = etCase3.text.toString()
        val case4 = etCase4.text.toString()

        if (checkInput(case1) and checkInput(case2) and checkInput(case3) and checkInput(case4))    {
            var correct = 0
            if (case1 == "T") correct++
            if (case2 == "F") correct++
            if (case3 == "F") correct++
            if (case4 == "F") correct++
            Toast.makeText(this, getString(R.string.correct_input)+" "+correct, Toast.LENGTH_LONG).show()
        } else {
            Toast.makeText(this, getString(R.string.incorrect_input), Toast.LENGTH_LONG).show()
        }
    }

    private fun checkInput(input: String): Boolean {
        var validInput = input.contains("T") or input.contains("F")
        return validInput
    }
}
