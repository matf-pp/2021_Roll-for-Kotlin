package com.example.rollforkotlin.ui.main.fragments

import android.app.AlertDialog
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import com.example.rollforkotlin.R
import kotlinx.android.synthetic.main.fragment_tools.*
import kotlinx.android.synthetic.main.fragment_tools.view.*


class ToolsFragment : Fragment(), View.OnClickListener {
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

    override fun onViewCreated(view: View, savedInstanceState: Bundle?){
        //Languages
        view.cbLgDwarvish.setOnClickListener(this)
        view.cbLgElvish.setOnClickListener(this)
        view.cbLgGnomish.setOnClickListener(this)
        view.cbLgGoblin.setOnClickListener(this)
        view.cbLgHalfling.setOnClickListener(this)
        view.cbLgInfernal.setOnClickListener(this)
        view.cbLgSylvan.setOnClickListener(this)
        view.cbLgUndercommon.setOnClickListener(this)

        //Proficiencies
        view.cbPrAcrobatics.setOnClickListener(this)
        view.cbPrAnimalH.setOnClickListener(this)
        view.cbPrArcana.setOnClickListener(this)
        view.cbPrAthletics.setOnClickListener(this)
        view.cbPrDeception.setOnClickListener(this)
        view.cbPrHistory.setOnClickListener(this)
        view.cbPrInsight.setOnClickListener(this)
        view.cbPrIntimidation.setOnClickListener(this)
        view.cbPrInvestigation.setOnClickListener(this)
        view.cbPrMedicine.setOnClickListener(this)
        view.cbPrNature.setOnClickListener(this)
        view.cbPrPerception.setOnClickListener(this)
        view.cbPrPerformance.setOnClickListener(this)
        view.cbPrPersuasion.setOnClickListener(this)
        view.cbPrReligion.setOnClickListener(this)
        view.cbPrSleightOfHand.setOnClickListener(this)
        view.cbPrStealth.setOnClickListener(this)
        view.cbPrSurvival.setOnClickListener(this)

        //Tools
        view.cbTlAlchemistS.setOnClickListener(this)
        view.cbTlCartographerT.setOnClickListener(this)
        view.cbTlCookU.setOnClickListener(this)
        view.cbTlJewelerT.setOnClickListener(this)
        view.cbTlThievesT.setOnClickListener(this)
        view.cbTlTinkerT.setOnClickListener(this)
        view.cbTlWoodcarverT.setOnClickListener(this)
        view.txtLgCount.text = languageCounter.toString()
        view.txtPrCount.text = profCounter.toString()
        view.txtTlCount.text = toolsCounter.toString()
    }

    //Podesavanje limita za proficiency-e
    private var languageCounter = 2;
    private var profCounter = 3;
    private var toolsCounter = 2;

    override fun onClick(v: View?) {
        v as CheckBox
        val name = v.resources.getResourceName(v.id)
        val builder = AlertDialog.Builder(activity)
        builder.setTitle("Androidly Alert")
        builder.setMessage("Too many items selected")
        when(checkCBGroup(name)){
            'l' -> {
                if (languageCounter == 0 && v.isChecked){
                //builder.show()
                    v.isChecked = false
                }
                else if (v.isChecked){
                    --languageCounter
                }
                else {
                    ++languageCounter
                }
                txtLgCount.text = languageCounter.toString()
                }

            'p' -> {
                if (profCounter == 0 && v.isChecked){
                    //builder.show()
                    v.isChecked = false
                }
                else if (v.isChecked){
                    --profCounter
                }
                else {
                    ++profCounter
                }
                txtPrCount.text = profCounter.toString()
            }

            't' -> {
                if (toolsCounter == 0 && v.isChecked){
                    builder.show()
                    v.isChecked = false
                }
                else if (v.isChecked){
                    --toolsCounter
                }
                else {
                    ++toolsCounter
                }
                txtTlCount.text = toolsCounter.toString()
            }

        }
    }
    private fun checkCBGroup(id: String): Char? {
        if(id.startsWith("com.example.rollforkotlin:id/cbLg")) {
            return 'l'
        }
        if(id.startsWith("com.example.rollforkotlin:id/cbPr")) {
            return 'p'
        }
        if(id.startsWith("com.example.rollforkotlin:id/cbTl")) {
            return 't'
        }
        return null
    }

    fun getValues() {
        val list = arrayListOf<String>()
        if(cbPrAcrobatics.isChecked){
            list.add(cbPrAcrobatics.text.toString())
        }
        if(cbTlAlchemistS.isChecked){
            list.add(cbTlAlchemistS.text.toString())
        }
        if(cbPrAnimalH.isChecked){
            list.add(cbPrAnimalH.text.toString())
        }
        if(cbPrArcana.isChecked){
            list.add(cbPrArcana.text.toString())
        }
        if(cbPrAthletics.isChecked){
            list.add(cbPrAthletics.text.toString())
        }
        if(cbTlCartographerT.isChecked){
            list.add(cbTlCartographerT.text.toString())
        }
        if(cbLgUndercommon.isChecked){
            list.add(cbLgUndercommon.text.toString())
        }
        if(cbTlCookU.isChecked){
            list.add(cbTlCookU.text.toString())
        }
        if(cbPrDeception.isChecked){
            list.add(cbPrDeception.text.toString())
        }
        if(cbLgDwarvish.isChecked){
            list.add(cbLgDwarvish.text.toString())
        }
        if(cbLgElvish.isChecked){
            list.add(cbLgElvish.text.toString())
        }
        if(cbLgGnomish.isChecked){
            list.add(cbLgGnomish.text.toString())
        }
        if(cbLgGoblin.isChecked){
            list.add(cbLgGoblin.text.toString())
        }
        if(cbLgHalfling.isChecked){
            list.add(cbLgHalfling.text.toString())
        }
        if(cbPrHistory.isChecked){
            list.add(cbPrHistory.text.toString())
        }
        if(cbLgInfernal.isChecked){
            list.add(cbLgInfernal.text.toString())
        }
        if(cbPrInsight.isChecked){
            list.add(cbPrInsight.text.toString())
        }
        if(cbPrIntimidation.isChecked){
            list.add(cbPrIntimidation.text.toString())
        }
        if(cbPrInvestigation.isChecked){
            list.add(cbPrInvestigation.text.toString())
        }
        if(cbTlJewelerT.isChecked){
            list.add(cbTlJewelerT.text.toString())
        }
        if(cbPrMedicine.isChecked){
            list.add(cbPrMedicine.text.toString())
        }
        if(cbPrNature.isChecked){
            list.add(cbPrNature.text.toString())
        }
        if(cbPrPerception.isChecked){
            list.add(cbPrPerception.text.toString())
        }
        if(cbPrPerformance.isChecked){
            list.add(cbPrPerformance.text.toString())
        }
        if(cbPrPersuasion.isChecked){
            list.add(cbPrPersuasion.text.toString())
        }
        if(cbPrReligion.isChecked){
            list.add(cbPrReligion.text.toString())
        }
        if(cbPrSleightOfHand.isChecked){
            list.add(cbPrSleightOfHand.text.toString())
        }
        if(cbPrStealth.isChecked){
            list.add(cbPrStealth.text.toString())
        }
        if(cbPrSurvival.isChecked){
            list.add(cbPrSurvival.text.toString())
        }
        if(cbLgSylvan.isChecked){
            list.add(cbLgSylvan.text.toString())
        }
        if(cbTlThievesT.isChecked){
            list.add(cbTlThievesT.text.toString())
        }
        if(cbTlTinkerT.isChecked){
            list.add(cbTlTinkerT.text.toString())
        }
        if(cbTlWoodcarverT.isChecked){
            list.add(cbTlWoodcarverT.text.toString())
        }

    }


}
