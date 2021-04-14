package com.example.rollforkotlin

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ArrayAdapter
import android.widget.RadioButton
import androidx.appcompat.app.AlertDialog
import kotlinx.android.synthetic.main.activity_screen1.*


class ActivityScreen1 : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_screen1)

        //newCharacter = Character()

        continueButton.setOnClickListener{
            getValues( )
            val i = Intent(this, MainActivity::class.java)
            startActivity(i)
        }

        // Create an ArrayAdapter
        val adapter = ArrayAdapter.createFromResource(this,
                R.array.levels, R.layout.spinner_item)
        // Specify the layout to use when the list of choices appears
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        //R.style.SpinnerTheme
        // Apply the adapter to the spinner
        spLevel.adapter = adapter

    }

    fun getValues() {
        val level = spLevel.selectedItem.toString().substring(0,1).toInt()
        var gender : String = ""
        val selectedRadioButtonId: Int = radioGroup.checkedRadioButtonId
        if (selectedRadioButtonId != -1) {
            val  selectedRadioButton : RadioButton  = findViewById(selectedRadioButtonId)
            gender = selectedRadioButton.text.toString()
        }
        val name = txtName.text.toString()

        newCharacter.chName = name
        newCharacter.chGender = gender
        newCharacter.chLevel = level

        when (level) {
            in 1..4 -> newCharacter.chProficiencyBonus = 2
            in 5..8 -> newCharacter.chProficiencyBonus = 3
            in 9..12 -> newCharacter.chProficiencyBonus = 4
            in 13..16 -> newCharacter.chProficiencyBonus = 5
            else -> newCharacter.chProficiencyBonus = 6
        }

        /*val builder = AlertDialog.Builder(this)
        builder.setTitle("Androidly Alert")
        builder.setMessage(newCharacter.chLevel)
        builder.show()*/
    }
    companion object {
        @JvmField
        var newCharacter: Character =  Character()
    }

}





