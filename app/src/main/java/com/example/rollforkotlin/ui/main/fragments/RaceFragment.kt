package com.example.rollforkotlin.ui.main.fragments

import android.app.AlertDialog
import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.RadioButton
import android.widget.Spinner
import androidx.annotation.MainThread
import com.example.rollforkotlin.ActivityScreen1
import com.example.rollforkotlin.MainActivity
import com.example.rollforkotlin.R
import kotlinx.android.synthetic.main.activity_screen1.*
import kotlinx.android.synthetic.main.fragment_race.*
import kotlinx.android.synthetic.main.fragment_race.view.*


class RaceFragment : Fragment(){
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
        val listener = object :AdapterView.OnItemSelectedListener{
            override fun onNothingSelected(parent: AdapterView<*>?) {
            }
            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                getValues()
            }
        }
        spClass?.onItemSelectedListener = listener
        spRace?.onItemSelectedListener = listener
        spBackground?.onItemSelectedListener = listener
    }

    fun getValues() {

        val race = spRace.selectedItem.toString()
        val klasa = spClass.selectedItem.toString()
        val background = spBackground.selectedItem.toString()

        //##################### DODATO CISCENJE LISTA DA KADA SE OSTANE U APLIKACIJI NE DUPLIRAJU SE TRAITS ###########################

        ActivityScreen1.newCharacter.chWeaponProfList = arrayListOf()
        ActivityScreen1.newCharacter.chToolProfList = arrayListOf()
        ActivityScreen1.newCharacter.chRace = race
        ActivityScreen1.newCharacter.setRace()
        ActivityScreen1.newCharacter.chClass = klasa
        ActivityScreen1.newCharacter.chClassTraits = arrayListOf()
        ActivityScreen1.newCharacter.setClass()
        ActivityScreen1.newCharacter.chBackground = background
        ActivityScreen1.newCharacter.chBackgroundTraits = arrayListOf()
        ActivityScreen1.newCharacter.setBackground()
        //Uzimanja broja spell-ova
        ActivityScreen1.newCharacter.getSpellNumbers()

//        val builder = AlertDialog.Builder(requireActivity())
//        builder.setTitle("Androidly Alert")
//        builder.setMessage(ActivityScreen1.newCharacter.chBackground
//                            +"\n"+ActivityScreen1.newCharacter.chRaceObject!!.extraLanguage.toString())
//        builder.show()
    }
}

