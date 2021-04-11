package com.example.rollforkotlin.ui.main.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import androidx.lifecycle.Transformations.map
import com.example.rollforkotlin.R
import kotlinx.android.synthetic.main.fragment_tools.*


class ToolsFragment : Fragment() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_tools, container, false)
    }

    override fun onStop() {
        super.onStop()
        getValues()
    }

    fun getValues() {
        val list = arrayListOf<String>()
        if(cbAcrobatics.isChecked){
            list.add(cbAcrobatics.text.toString())
        }
        if(cbAlchemistS.isChecked){
            list.add(cbAlchemistS.text.toString())
        }
        if(cbAnimalH.isChecked){
            list.add(cbAnimalH.text.toString())
        }
        if(cbArcana.isChecked){
            list.add(cbArcana.text.toString())
        }
        if(cbAthletics.isChecked){
            list.add(cbAthletics.text.toString())
        }
        if(cbCartographerT.isChecked){
            list.add(cbCartographerT.text.toString())
        }
        if(cbCommon.isChecked){
            list.add(cbCommon.text.toString())
        }
        if(cbCookU.isChecked){
            list.add(cbCookU.text.toString())
        }
        if(cbDeception.isChecked){
            list.add(cbDeception.text.toString())
        }
        if(cbDwarvish.isChecked){
            list.add(cbDwarvish.text.toString())
        }
        if(cbElvish.isChecked){
            list.add(cbElvish.text.toString())
        }
        if(cbGnomish.isChecked){
            list.add(cbGnomish.text.toString())
        }
        if(cbGoblin.isChecked){
            list.add(cbGoblin.text.toString())
        }
        if(cbHalfling.isChecked){
            list.add(cbHalfling.text.toString())
        }
        if(cbHistory.isChecked){
            list.add(cbHistory.text.toString())
        }
        if(cbInfernal.isChecked){
            list.add(cbInfernal.text.toString())
        }
        if(cbInsight.isChecked){
            list.add(cbInsight.text.toString())
        }
        if(cbIntimidation.isChecked){
            list.add(cbIntimidation.text.toString())
        }
        if(cbInvestigation.isChecked){
            list.add(cbInvestigation.text.toString())
        }
        if(cbJewelerT.isChecked){
            list.add(cbJewelerT.text.toString())
        }
        if(cbMedicine.isChecked){
            list.add(cbMedicine.text.toString())
        }
        if(cbNature.isChecked){
            list.add(cbNature.text.toString())
        }
        if(cbPerception.isChecked){
            list.add(cbPerception.text.toString())
        }
        if(cbPerformance.isChecked){
            list.add(cbPerformance.text.toString())
        }
        if(cbPersuasion.isChecked){
            list.add(cbPersuasion.text.toString())
        }
        if(cbReligion.isChecked){
            list.add(cbReligion.text.toString())
        }
        if(cbSleightOfHand.isChecked){
            list.add(cbSleightOfHand.text.toString())
        }
        if(cbStealth_.isChecked){
            list.add(cbStealth_.text.toString())
        }
        if(cbSurvival.isChecked){
            list.add(cbSurvival.text.toString())
        }
        if(cbSylvan.isChecked){
            list.add(cbSylvan.text.toString())
        }
        if(cbThievesT.isChecked){
            list.add(cbThievesT.text.toString())
        }
        if(cbTinkerT.isChecked){
            list.add(cbTinkerT.text.toString())
        }
        if(cbWoodcarverT.isChecked){
            list.add(cbWoodcarverT.text.toString())
        }

    }



    }
