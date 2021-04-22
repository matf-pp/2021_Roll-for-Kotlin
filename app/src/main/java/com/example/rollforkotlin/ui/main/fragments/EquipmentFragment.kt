package com.example.rollforkotlin.ui.main.fragments

import android.app.AlertDialog
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.CheckBox
import com.example.rollforkotlin.ActivityScreen1
import com.example.rollforkotlin.R
import kotlinx.android.synthetic.main.fragment_equipment.*
import kotlinx.android.synthetic.main.fragment_race.*
import kotlinx.android.synthetic.main.fragment_tools.*
import kotlin.random.Random


class EquipmentFragment : Fragment(), View.OnClickListener {
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

        allCBList = arrayListOf(
                //Potions
                cbHealingPotion
                //Weapons
                ,cbWpDagger,cbWpBattleaxe,cbWpCrossbowL,cbWpGreataxe,cbWpGreatsword,cbWpJavelin,cbWpQuarterstaff,cbWpShortbow,cbWpLongsword,cbWpRapier,cbWpLongbow
                //Instruments
                ,cbInDrum,cbInFlute,cbInLyre,cbInHorn,cbInPanFlute
                )
        weaponCBList = arrayListOf(cbWpDagger,cbWpBattleaxe,cbWpCrossbowL,cbWpGreataxe,cbWpGreatsword,cbWpJavelin,cbWpQuarterstaff,cbWpShortbow,cbWpLongsword,cbWpRapier,cbWpLongbow)
        instrumentCBList = arrayListOf(cbInDrum,cbInFlute,cbInLyre,cbInHorn,cbInPanFlute)
        for (cb in allCBList!!) cb.setOnClickListener(this)
    }
    //Promenljive
    private var allCBList: ArrayList<CheckBox>? = null
    private var weaponCBList: ArrayList<CheckBox>? = null
    private var instrumentCBList: ArrayList<CheckBox>? = null

    override fun onClick(v: View?) {
        v as CheckBox
        val name = v.resources.getResourceEntryName(v.id)
        when(checkCBGroup(name)){
            'w' -> {
                if(v.isChecked){
                    ActivityScreen1.newCharacter.chWeapons?.add(name.substring(4))
                } else  {
                    ActivityScreen1.newCharacter.chWeapons?.remove(name.substring(4))
                }
            }
            'i' -> {
                if(v.isChecked){
                    ActivityScreen1.newCharacter.chInstruments?.add(name.substring(4))
                } else  {
                    ActivityScreen1.newCharacter.chInstruments?.remove(name.substring(4))
                }
            }
            else -> {
                ActivityScreen1.newCharacter.chHasPotion = v.isChecked
            }
        }
    }

    private fun checkCBGroup(id: String): Char? {
        if(id.startsWith("cbWp")) {
            return 'w'
        }
        if(id.startsWith("cbIn")) {
            return 'i'
        }
        return null
    }

    override fun onStop() {
        super.onStop()
        getValues()
    }

    fun getValues() {
        //Uzimanje armora
        ActivityScreen1.newCharacter.chArmor = spArmor.selectedItem.toString()
        //Uzimanje vrednosti novca
        ActivityScreen1.newCharacter.chCopper = btnCopper.text.toString().toInt()
        ActivityScreen1.newCharacter.chSilver = btnSilver.text.toString().toInt()
        ActivityScreen1.newCharacter.chGold = btnGold.text.toString().toInt()
        ActivityScreen1.newCharacter.chPlatinum = btnPlatinum.text.toString().toInt()

    }
}