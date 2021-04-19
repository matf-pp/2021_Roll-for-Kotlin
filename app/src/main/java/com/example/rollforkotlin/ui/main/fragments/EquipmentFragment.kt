package com.example.rollforkotlin.ui.main.fragments

import android.app.AlertDialog
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import com.example.rollforkotlin.ActivityScreen1
import com.example.rollforkotlin.R
import kotlinx.android.synthetic.main.fragment_equipment.*
import kotlinx.android.synthetic.main.fragment_race.*
import kotlin.random.Random


class EquipmentFragment : Fragment() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_equipment, container, false)
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?){
        btnCopper.setOnClickListener {
            btnCopper.text = Random.nextInt(20, 61).toString()
        }
        btnSilver.setOnClickListener {
            btnSilver.text = Random.nextInt(10, 31).toString()
        }
        btnGold.setOnClickListener {
            btnGold.text = Random.nextInt(7, 21).toString()
        }
        btnPlatinum.setOnClickListener {
            btnPlatinum.text = Random.nextInt(0, 3).toString()
        }
        // Create an ArrayAdapter
        val adapterA = ArrayAdapter.createFromResource( requireActivity(),
                R.array.armor, R.layout.spinner_item2)
        // Specify the layout to use when the list of choices appears
        adapterA.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        // Apply the adapter to the spinner
        spArmor.adapter = adapterA
        val listener = object : AdapterView.OnItemSelectedListener{
            override fun onNothingSelected(parent: AdapterView<*>?) {
            }
            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                getValues()
            }
        }
        spArmor.onItemSelectedListener = listener
    }

    fun getValues() {
        ActivityScreen1.newCharacter.chArmor = spArmor.selectedItem.toString()
        ActivityScreen1.newCharacter.setAC()
    }

}