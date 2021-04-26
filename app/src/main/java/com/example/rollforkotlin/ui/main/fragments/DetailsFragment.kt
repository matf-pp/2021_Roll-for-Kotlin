package com.example.rollforkotlin.ui.main.fragments

import android.app.AlertDialog
import android.content.Intent
import android.graphics.pdf.PdfDocument
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import androidx.fragment.app.Fragment
import com.example.rollforkotlin.*
import kotlinx.android.synthetic.main.fragment_details.*


class DetailsFragment : Fragment() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
        }

    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_details, container, false)

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Create an ArrayAdapter
        val adapter = ArrayAdapter.createFromResource( requireActivity(),
                R.array.alignment, R.layout.spinner_item2)

        // Specify the layout to use when the list of choices appears
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        // Apply the adapter to the spinner
        spAlignment.adapter = adapter

        btnFinish.setOnClickListener {
            ActivityScreen1.newCharacter.getAllHPVariables()
            ActivityScreen1.newCharacter.setSavingThrows()
            ActivityScreen1.newCharacter.getClassTraits()
            ActivityScreen1.newCharacter.setSkills()
            ActivityScreen1.newCharacter.setAC()
            ActivityScreen1.newCharacter.setArmorAndWeaponProf()
            ActivityScreen1.newCharacter.setWeaponBonus()
            ActivityScreen1.newCharacter.getBackgroundTraits()
            ActivityScreen1.newCharacter.getSpellInfo()

            activity?.let{
                val i = Intent (it, FinishActivity::class.java)
                it.startActivity(i)
            }
        }
    }


    override fun onStop() {
        super.onStop()
        getValues()
    }

    fun getValues() {

        val alignment = spAlignment.selectedItem.toString()
        val deity = txtDiety.text.toString()
        val backstory = txtBackstory.text.toString()
        val appearance = txtAppearance.text.toString()
        val additional = txtAdditional.text.toString()

        ActivityScreen1.newCharacter.chAlignment = alignment
        ActivityScreen1.newCharacter.chDeity = deity
        ActivityScreen1.newCharacter.chBackstory = backstory
        ActivityScreen1.newCharacter.chAppearance = appearance
        ActivityScreen1.newCharacter.chAdditionalInfo = additional
    }
}