package com.example.rollforkotlin

import android.content.Intent
import android.content.res.Resources
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.RadioButton
import androidx.appcompat.app.AlertDialog
import kotlinx.android.synthetic.main.activity_screen1.*

class ActivityScreen1 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_screen1)
        continueButton.setOnClickListener{
            getValues()
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
        val level = spLevel.selectedItem.toString().substring(0,1)
        var gender : String = ""
        val selectedRadioButtonId: Int = radioGroup.checkedRadioButtonId
        if (selectedRadioButtonId != -1) {
            val  selectedRadioButton : RadioButton  = findViewById(selectedRadioButtonId)
            gender = selectedRadioButton.text.toString()
        }
        val name = txtName.text

       /* val builder = AlertDialog.Builder(this)
        builder.setTitle("Androidly Alert")
        builder.setMessage(level)
        builder.show()*/

    }

}


