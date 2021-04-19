package com.example.rollforkotlin.ui.main.fragments

import android.app.AlertDialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import androidx.fragment.app.Fragment
import com.example.rollforkotlin.ActivityScreen1
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
        allCBList = arrayListOf(
                //Languages
                cbLgDwarvish, cbLgElvish, cbLgGnomish, cbLgGoblin, cbLgHalfling, cbLgInfernal, cbLgSylvan, cbLgUndercommon,
                //Proficiencies
                cbPrAcrobatics, cbPrAnimalH, cbPrArcana, cbPrAthletics, cbPrDeception, cbPrHistory, cbPrInsight, cbPrIntimidation, cbPrInvestigation,
                cbPrMedicine, cbPrNature, cbPrPerception, cbPrPerformance, cbPrPersuasion, cbPrReligion, cbPrSleightOfHand, cbPrStealth, cbPrSurvival,
                //Tools
                cbTlAlchemistS, cbTlCartographerT, cbTlCookU, cbTlJewelerT, cbTlThievesT, cbTlTinkerT, cbTlWoodcarverT,
                //Expertise
                cbPrAcrobaticsExp, cbPrAnimalHExp, cbPrArcanaExp, cbPrAthleticsExp, cbPrDeceptionExp, cbPrHistoryExp, cbPrInsightExp, cbPrIntimidationExp, cbPrInvestigationExp,
                cbPrMedicineExp, cbPrNatureExp, cbPrPerceptionExp, cbPrPerformanceExp, cbPrPersuasionExp, cbPrReligionExp, cbPrSleightOfHandExp, cbPrStealth, cbPrSurvivalExp)

        profCBList = arrayListOf( cbPrAcrobatics, cbPrAnimalH, cbPrArcana, cbPrAthletics, cbPrDeception, cbPrHistory, cbPrInsight, cbPrIntimidation, cbPrInvestigation,
                cbPrMedicine, cbPrNature, cbPrPerception, cbPrPerformance, cbPrPersuasion, cbPrReligion, cbPrSleightOfHand, cbPrStealth, cbPrSurvival)
        lbLgCount.text = languageCounter.toString()
        lbPrCount.text = profCounter.toString()
        lbTlCount.text = toolsCounter.toString()
        lbExpCount.text = expertiseCounter.toString()
        for (cb in allCBList!!) cb.setOnClickListener(this)
    }

    override fun onStart() {
        super.onStart()
        hasExpertise = checkHasExpertise()
        reset()
        lbLgCount.text = languageCounter.toString()
        lbPrCount.text = profCounter.toString()
        lbTlCount.text = toolsCounter.toString()
        lbExpCount.text = expertiseCounter.toString()
        setExpertiseVisibility()
    }

    //Promenljive
    private var languageCounter = 3
    private var profCounter = 4
    private var toolsCounter = 2
    private var expertiseCounter = 2
    private var allCBList: ArrayList<CheckBox>? = null
    private var profCBList: ArrayList<CheckBox>? = null
    private var hasExpertise = false
    private var oldClass = ""
    private var oldRace = ""
    private var oldBackground = ""


    override fun onClick(v: View?) {
        v as CheckBox
        val name = v.resources.getResourceEntryName(v.id)
        val builder = AlertDialog.Builder(activity)
        builder.setTitle("Androidly Alert")
        builder.setMessage(v.resources.getResourceEntryName(v.id))
        when(checkCBGroup(name)){
            'l' -> {
                if (languageCounter == 0 && v.isChecked) {
                    //builder.show()
                    v.isChecked = false
                } else if (v.isChecked) {
                    --languageCounter
                } else {
                    ++languageCounter
                }
                lbLgCount.text = languageCounter.toString()
            }

            'p' -> {
                if (profCounter == 0 && v.isChecked) {
                    //builder.show()
                    v.isChecked = false
                } else if (v.isChecked) {
                    --profCounter
                    if (hasExpertise) {
                        val expTmp = name + "Exp"
                        val idTmp = resources.getIdentifier(expTmp, "id", v.resources.getResourcePackageName(v.id))
                        val vTmp = view?.findViewById<CheckBox>(idTmp)
                        vTmp?.visibility = View.VISIBLE
                    }
                } else {
                    ++profCounter
                    if (hasExpertise) {
                        val expTmp = name + "Exp"
                        val idTmp = resources.getIdentifier(expTmp, "id", v.resources.getResourcePackageName(v.id))
                        val vTmp = view?.findViewById<CheckBox>(idTmp)
                        vTmp?.visibility = View.GONE
                    }
                }
                lbPrCount.text = profCounter.toString()
            }

            't' -> {
                if (toolsCounter == 0 && v.isChecked) {
                    //builder.show()
                    v.isChecked = false
                } else if (v.isChecked) {
                    --toolsCounter
                } else {
                    ++toolsCounter
                }
                lbTlCount.text = toolsCounter.toString()
            }

            'e' -> {
                if (expertiseCounter == 0 && v.isChecked) {
                    //builder.show()
                    v.isChecked = false
                } else if (v.isChecked) {
                    --expertiseCounter
                } else {
                    ++expertiseCounter
                }
                lbExpCount.text = expertiseCounter.toString()
            }

        }
    }
    private fun checkCBGroup(id: String): Char? {
        if(id.startsWith("cbLg")) {
            return 'l'
        }
        if(id.startsWith("cbPr")) {
            return if(id.endsWith("Exp")) {
                'e'
            } else {
                'p'
            }
        }
        if(id.startsWith("cbTl")) {
            return 't'
        }
        return null
    }

    private fun getValues() {
        val list = arrayListOf<String>()
        if(cbPrAcrobatics.isChecked){
            list.add(cbPrAcrobatics.text.toString())
            ActivityScreen1.newCharacter.chSkillProfs["dexAcrobatics"] = 1
        } else ActivityScreen1.newCharacter.chSkillProfs["dexAcrobatics"] = 0
        if(cbTlAlchemistS.isChecked){
            list.add(cbTlAlchemistS.text.toString())
        }
        if(cbPrAnimalH.isChecked){
            list.add(cbPrAnimalH.text.toString())
            ActivityScreen1.newCharacter.chSkillProfs["wisAnimalHandling"] = 1
        } else ActivityScreen1.newCharacter.chSkillProfs["wisAnimalHandling"] = 0
        if(cbPrArcana.isChecked){
            list.add(cbPrArcana.text.toString())
            ActivityScreen1.newCharacter.chSkillProfs["intArcana"] = 1
        } else ActivityScreen1.newCharacter.chSkillProfs["intArcana"] = 0
        if(cbPrAthletics.isChecked){
            list.add(cbPrAthletics.text.toString())
            ActivityScreen1.newCharacter.chSkillProfs["strAthletics"] = 1
        } else ActivityScreen1.newCharacter.chSkillProfs["strAthletics"] = 0
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
            ActivityScreen1.newCharacter.chSkillProfs["chaDeception"] = 1
        } else ActivityScreen1.newCharacter.chSkillProfs["chaDeception"] = 0
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
            ActivityScreen1.newCharacter.chSkillProfs["intHistory"] = 1
        } else ActivityScreen1.newCharacter.chSkillProfs["intHistory"] = 0
        if(cbLgInfernal.isChecked){
            list.add(cbLgInfernal.text.toString())
        }
        if(cbPrInsight.isChecked) {
            list.add(cbPrInsight.text.toString())
            ActivityScreen1.newCharacter.chSkillProfs["wisInsight"] = 1
        } else ActivityScreen1.newCharacter.chSkillProfs["wisInsight"] = 0
        if(cbPrIntimidation.isChecked){
            list.add(cbPrIntimidation.text.toString())
            ActivityScreen1.newCharacter.chSkillProfs["chaIntimidation"] = 1
        } else ActivityScreen1.newCharacter.chSkillProfs["chaIntimidation"] = 0
        if(cbPrInvestigation.isChecked){
            list.add(cbPrInvestigation.text.toString())
            ActivityScreen1.newCharacter.chSkillProfs["intInvestigation"] = 1
        } else ActivityScreen1.newCharacter.chSkillProfs["intInvestigation"] = 0
        if(cbTlJewelerT.isChecked){
            list.add(cbTlJewelerT.text.toString())
        }
        if(cbPrMedicine.isChecked){
            list.add(cbPrMedicine.text.toString())
            ActivityScreen1.newCharacter.chSkillProfs["wisMedicine"] = 1
        } else ActivityScreen1.newCharacter.chSkillProfs["wisMedicine"] = 0
        if(cbPrNature.isChecked){
            list.add(cbPrNature.text.toString())
            ActivityScreen1.newCharacter.chSkillProfs["intNature"] = 1
        } else ActivityScreen1.newCharacter.chSkillProfs["intNature"] = 0
        if(cbPrPerception.isChecked){
            list.add(cbPrPerception.text.toString())
            ActivityScreen1.newCharacter.chSkillProfs["wisPerception"] = 1
        } else ActivityScreen1.newCharacter.chSkillProfs["wisPerception"] = 0
        if(cbPrPerformance.isChecked){
            list.add(cbPrPerformance.text.toString())
            ActivityScreen1.newCharacter.chSkillProfs["chaPerformance"] = 1
        } else ActivityScreen1.newCharacter.chSkillProfs["chaPerformance"] = 0
        if(cbPrPersuasion.isChecked){
            list.add(cbPrPersuasion.text.toString())
            ActivityScreen1.newCharacter.chSkillProfs["chaPersuasion"] = 1
        } else ActivityScreen1.newCharacter.chSkillProfs["chaPersuasion"] = 0
        if(cbPrReligion.isChecked){
            list.add(cbPrReligion.text.toString())
            ActivityScreen1.newCharacter.chSkillProfs["intReligion"] = 1
        } else ActivityScreen1.newCharacter.chSkillProfs["intReligion"] = 0
        if(cbPrSleightOfHand.isChecked){
            list.add(cbPrSleightOfHand.text.toString())
            ActivityScreen1.newCharacter.chSkillProfs["dexSleightOfHand"] = 1
        } else ActivityScreen1.newCharacter.chSkillProfs["dexSleightOfHand"] = 0
        if(cbPrStealth.isChecked){
            list.add(cbPrStealth.text.toString())
            ActivityScreen1.newCharacter.chSkillProfs["dexStealth"] = 1
        } else ActivityScreen1.newCharacter.chSkillProfs["dexStealth"] = 0
        if(cbPrSurvival.isChecked){
            list.add(cbPrSurvival.text.toString())
            ActivityScreen1.newCharacter.chSkillProfs["wisSurvival"] = 1
        } else ActivityScreen1.newCharacter.chSkillProfs["wisSurvival"] = 0
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

    private fun checkHasExpertise(): Boolean{
        return ActivityScreen1.newCharacter.chClass == "Rogue" || (ActivityScreen1.newCharacter.chClass == "Bard" && ActivityScreen1.newCharacter.chLevel >= 3)
    }

    private fun setExpertiseVisibility() {
        if(hasExpertise) {
            lbExpertise.visibility = View.VISIBLE
            lbSelectExp.visibility = View.VISIBLE
            lbExpCount.visibility = View.VISIBLE
            for(cb in profCBList!!){
                if(cb.isChecked){
                    val name = cb.resources.getResourceEntryName(cb.id)
                    val expTmp = name + "Exp"
                    val idTmp = resources.getIdentifier(expTmp, "id", cb.resources.getResourcePackageName(cb.id))
                    val vTmp = view?.findViewById<CheckBox>(idTmp)
                    vTmp?.visibility = View.VISIBLE
                }
            }
        }
    }

    private fun reset(){
        if(ActivityScreen1.newCharacter.chClass != oldClass || ActivityScreen1.newCharacter.chRace != oldRace || ActivityScreen1.newCharacter.chBackgroud != oldBackground) {
            oldClass = ActivityScreen1.newCharacter.chClass
            oldRace = ActivityScreen1.newCharacter.chRace
            oldBackground = ActivityScreen1.newCharacter.chBackgroud
            for (cb in allCBList!!) {
                cb.isChecked = false
            }
            setRestrictions()
        }
    }

    private fun setRestrictions(){
        languageCounter = 3
        profCounter = 4
        toolsCounter = 2
        expertiseCounter = 2
    }
}