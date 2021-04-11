package com.example.rollforkotlin.ui.main.fragments

import android.app.AlertDialog
import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.RadioButton
import androidx.annotation.MainThread
import com.example.rollforkotlin.ActivityScreen1
import com.example.rollforkotlin.MainActivity
import com.example.rollforkotlin.R
import kotlinx.android.synthetic.main.activity_screen1.*
import kotlinx.android.synthetic.main.fragment_race.*


class RaceFragment : Fragment() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
        }

    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_race, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Create an ArrayAdapter
        val adapterR = ArrayAdapter.createFromResource( requireActivity(),
                R.array.races, R.layout.spinner_item2)
        // Specify the layout to use when the list of choices appears
        adapterR.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        // Apply the adapter to the spinner
        spRace.adapter = adapterR

        // Create an ArrayAdapter
        val adapterC = ArrayAdapter.createFromResource( requireActivity(),
                R.array.classes, R.layout.spinner_item2)
        // Specify the layout to use when the list of choices appears
        adapterC.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        // Apply the adapter to the spinner
        spClass.adapter = adapterC

        // Create an ArrayAdapter
        val adapterB = ArrayAdapter.createFromResource( requireActivity(),
                R.array.backgrounds, R.layout.spinner_item2)
        // Specify the layout to use when the list of choices appears
        adapterB.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        // Apply the adapter to the spinner
        spBackground.adapter = adapterB


    }


   /* override fun onResume() {
        super.onResume()
        getValues()
    }*/

    override fun onStop() {
        super.onStop()
        getValues()
    }

    fun getValues() {

        val race = spRace.selectedItem.toString()
        val klasa = spClass.selectedItem.toString()
        val background = spBackground.selectedItem.toString()
        ActivityScreen1.newCharacter.chRace = race
        ActivityScreen1.newCharacter.chClass = klasa
        ActivityScreen1.newCharacter.chBackgroud = background
        /*val builder = AlertDialog.Builder(requireActivity())
        builder.setTitle("Androidly Alert")
        builder.setMessage(ActivityScreen1.newCharacter.chRace)
        builder.show()*/

    }


}

