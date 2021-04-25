package com.example.rollforkotlin.ui.main.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import androidx.fragment.app.Fragment
import com.example.rollforkotlin.ActivityScreen1
import com.example.rollforkotlin.R
import kotlinx.android.synthetic.main.fragment_tools.*


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
                cbPrMedicineExp, cbPrNatureExp, cbPrPerceptionExp, cbPrPerformanceExp, cbPrPersuasionExp, cbPrReligionExp, cbPrSleightOfHandExp, cbPrStealthExp, cbPrSurvivalExp)

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
        reset()
        lbLgCount.text = languageCounter.toString()
        lbPrCount.text = profCounter.toString()
        lbTlCount.text = toolsCounter.toString()
        lbExpCount.text = expertiseCounter.toString()
        hasExpertise = checkHasExpertise()
        setExpertiseVisibility()
    }

    //Promenljive
    private var languageCounter = 0
    private var profCounter = 0
    private var toolsCounter = 0
    private var expertiseCounter = 0
    private var allCBList: ArrayList<CheckBox>? = null
    private var profCBList: ArrayList<CheckBox>? = null
    private var hasExpertise = false
    private var oldClass = ""
    private var oldRace = ""
    private var oldBackground = ""


    override fun onClick(v: View?) {
        v as CheckBox
        val name = v.resources.getResourceEntryName(v.id)
        when(checkCBGroup(name)){
            'l' -> {
                if (languageCounter == 0 && v.isChecked) {
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
        if(cbLgUndercommon.isChecked){
            list.add(cbLgUndercommon.text.toString())
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
        if(cbLgInfernal.isChecked){
            list.add(cbLgInfernal.text.toString())
        }
        if(cbLgSylvan.isChecked){
            list.add(cbLgSylvan.text.toString())
        }
        ActivityScreen1.newCharacter.chLanguageList = arrayListOf()
        ActivityScreen1.newCharacter.chLanguageList.addAll(ActivityScreen1.newCharacter.chRaceLanguageList)
        ActivityScreen1.newCharacter.chLanguageList.addAll(list)
        //Proficiencies
        if(cbPrAcrobatics.isChecked){
            list.add(cbPrAcrobatics.text.toString())
            ActivityScreen1.newCharacter.chSkillProfs["dexAcrobatics"] = 1
        } else ActivityScreen1.newCharacter.chSkillProfs["dexAcrobatics"] = 0
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
        if(cbPrDeception.isChecked){
            list.add(cbPrDeception.text.toString())
            ActivityScreen1.newCharacter.chSkillProfs["chaDeception"] = 1
        } else ActivityScreen1.newCharacter.chSkillProfs["chaDeception"] = 0
        if(cbPrHistory.isChecked){
            list.add(cbPrHistory.text.toString())
            ActivityScreen1.newCharacter.chSkillProfs["intHistory"] = 1
        } else ActivityScreen1.newCharacter.chSkillProfs["intHistory"] = 0
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

        //Tools
        if(cbTlAlchemistS.isChecked){
            list.add(cbTlAlchemistS.text.toString())
        }
        if(cbTlCartographerT.isChecked){
            list.add(cbTlCartographerT.text.toString())
        }
        if(cbTlCookU.isChecked){
            list.add(cbTlCookU.text.toString())
        }
        if(cbTlJewelerT.isChecked){
            list.add(cbTlJewelerT.text.toString())
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

        //Expertise
        if(cbPrAcrobaticsExp.isChecked){
            list.add(cbPrAcrobaticsExp.text.toString())
            ActivityScreen1.newCharacter.chSkillExp["dexAcrobatics"] = 1
        } else ActivityScreen1.newCharacter.chSkillExp["dexAcrobatics"] = 0
        if(cbPrAnimalHExp.isChecked){
            list.add(cbPrAnimalHExp.text.toString())
            ActivityScreen1.newCharacter.chSkillExp["wisAnimalHandling"] = 1
        } else ActivityScreen1.newCharacter.chSkillExp["wisAnimalHandling"] = 0
        if(cbPrArcanaExp.isChecked){
            list.add(cbPrArcanaExp.text.toString())
            ActivityScreen1.newCharacter.chSkillExp["intArcana"] = 1
        } else ActivityScreen1.newCharacter.chSkillExp["intArcana"] = 0
        if(cbPrAthleticsExp.isChecked){
            list.add(cbPrAthleticsExp.text.toString())
            ActivityScreen1.newCharacter.chSkillExp["strAthletics"] = 1
        } else ActivityScreen1.newCharacter.chSkillExp["strAthletics"] = 0
        if(cbPrDeceptionExp.isChecked){
            list.add(cbPrDeceptionExp.text.toString())
            ActivityScreen1.newCharacter.chSkillExp["chaDeception"] = 1
        } else ActivityScreen1.newCharacter.chSkillExp["chaDeception"] = 0
        if(cbPrHistoryExp.isChecked){
            list.add(cbPrHistoryExp.text.toString())
            ActivityScreen1.newCharacter.chSkillExp["intHistory"] = 1
        } else ActivityScreen1.newCharacter.chSkillExp["intHistory"] = 0
        if(cbPrInsightExp.isChecked) {
            list.add(cbPrInsightExp.text.toString())
            ActivityScreen1.newCharacter.chSkillExp["wisInsight"] = 1
        } else ActivityScreen1.newCharacter.chSkillExp["wisInsight"] = 0
        if(cbPrIntimidationExp.isChecked){
            list.add(cbPrIntimidationExp.text.toString())
            ActivityScreen1.newCharacter.chSkillExp["chaIntimidation"] = 1
        } else ActivityScreen1.newCharacter.chSkillExp["chaIntimidation"] = 0
        if(cbPrInvestigationExp.isChecked){
            list.add(cbPrInvestigationExp.text.toString())
            ActivityScreen1.newCharacter.chSkillExp["intInvestigation"] = 1
        } else ActivityScreen1.newCharacter.chSkillExp["intInvestigation"] = 0
        if(cbPrMedicineExp.isChecked){
            list.add(cbPrMedicineExp.text.toString())
            ActivityScreen1.newCharacter.chSkillExp["wisMedicine"] = 1
        } else ActivityScreen1.newCharacter.chSkillExp["wisMedicine"] = 0
        if(cbPrNatureExp.isChecked){
            list.add(cbPrNatureExp.text.toString())
            ActivityScreen1.newCharacter.chSkillExp["intNature"] = 1
        } else ActivityScreen1.newCharacter.chSkillExp["intNature"] = 0
        if(cbPrPerceptionExp.isChecked){
            list.add(cbPrPerceptionExp.text.toString())
            ActivityScreen1.newCharacter.chSkillExp["wisPerception"] = 1
        } else ActivityScreen1.newCharacter.chSkillExp["wisPerception"] = 0
        if(cbPrPerformanceExp.isChecked){
            list.add(cbPrPerformanceExp.text.toString())
            ActivityScreen1.newCharacter.chSkillExp["chaPerformance"] = 1
        } else ActivityScreen1.newCharacter.chSkillExp["chaPerformance"] = 0
        if(cbPrPersuasionExp.isChecked){
            list.add(cbPrPersuasionExp.text.toString())
            ActivityScreen1.newCharacter.chSkillExp["chaPersuasion"] = 1
        } else ActivityScreen1.newCharacter.chSkillExp["chaPersuasion"] = 0
        if(cbPrReligionExp.isChecked){
            list.add(cbPrReligionExp.text.toString())
            ActivityScreen1.newCharacter.chSkillExp["intReligion"] = 1
        } else ActivityScreen1.newCharacter.chSkillExp["intReligion"] = 0
        if(cbPrSleightOfHandExp.isChecked){
            list.add(cbPrSleightOfHandExp.text.toString())
            ActivityScreen1.newCharacter.chSkillExp["dexSleightOfHand"] = 1
        } else ActivityScreen1.newCharacter.chSkillExp["dexSleightOfHand"] = 0
        if(cbPrStealthExp.isChecked){
            list.add(cbPrStealthExp.text.toString())
            ActivityScreen1.newCharacter.chSkillExp["dexStealth"] = 1
        } else ActivityScreen1.newCharacter.chSkillExp["dexStealth"] = 0
        if(cbPrSurvivalExp.isChecked){
            list.add(cbPrSurvivalExp.text.toString())
            ActivityScreen1.newCharacter.chSkillExp["wisSurvival"] = 1
        } else ActivityScreen1.newCharacter.chSkillExp["wisSurvival"] = 0
    }

    private fun checkHasExpertise(): Boolean{
        return ActivityScreen1.newCharacter.chClass == "Rogue" || (ActivityScreen1.newCharacter.chClass == "Bard" && ActivityScreen1.newCharacter.chLevel >= 3)
    }

    private fun setExpertiseVisibility() {
        if (hasExpertise) {
            lbExpertise.visibility = View.VISIBLE
            lbSelectExp.visibility = View.VISIBLE
            lbExpCount.visibility = View.VISIBLE
            for (sk in ActivityScreen1.newCharacter.chSkillProfs) {
                if (sk.value == 1) {
                    val name = "cbPr${sk.key.substring(3)}Exp"
                    val idTmp = resources.getIdentifier(name, "id", this.resources.getResourcePackageName(this.id))
                    val vTmp = view?.findViewById<CheckBox>(idTmp)
                    if (vTmp?.isChecked == false) {
                        vTmp?.visibility = View.VISIBLE
                    }
                }
            }
        }
    }

    private fun reset(){
        if(ActivityScreen1.newCharacter.chClass != oldClass || ActivityScreen1.newCharacter.chRace != oldRace || ActivityScreen1.newCharacter.chBackground != oldBackground) {
            oldClass = ActivityScreen1.newCharacter.chClass
            oldRace = ActivityScreen1.newCharacter.chRace
            oldBackground = ActivityScreen1.newCharacter.chBackground
            for (cb in allCBList!!) {
                cb.isChecked = false
            }
            setCounters()
        }
        setRestrictions()
    }

    private fun setCounters(){
        ActivityScreen1.newCharacter.setLanguageCount()
        languageCounter = ActivityScreen1.newCharacter.chLanguageCounter
        ActivityScreen1.newCharacter.setProficiencyCount()
        profCounter = ActivityScreen1.newCharacter.chProfCounter
        ActivityScreen1.newCharacter.setToolsCount()
        toolsCounter = ActivityScreen1.newCharacter.chToolsCounter
        expertiseCounter = 2
    }

    private fun setRestrictions(){
        for (lg in ActivityScreen1.newCharacter.chRaceLanguageList){
            if(lg != "Common"){
                val name = "cbLg$lg"
                val idTmp = resources.getIdentifier(name, "id", this.resources.getResourcePackageName(this.id))
                val vTmp = view?.findViewById<CheckBox>(idTmp)
                vTmp?.visibility = View.GONE
            }
        }
        for (sk in ActivityScreen1.newCharacter.chBackgroundObject!!.skillProfList){
            if(ActivityScreen1.newCharacter.chSkillProfs[sk] == 1){
                val name = "cbPr${sk.substring(3)}"
                val idTmp = resources.getIdentifier(name, "id", this.resources.getResourcePackageName(this.id))
                val vTmp = view?.findViewById<CheckBox>(idTmp)
                vTmp?.isChecked = true
                vTmp?.visibility = View.GONE
            }
        }
        if(ActivityScreen1.newCharacter.chRace == "Elf"){
            cbPrPerception.isChecked = true
            cbPrPerception.visibility = View.GONE
        }
        if (ActivityScreen1.newCharacter.chClass == "Rogue" || ActivityScreen1.newCharacter.chBackground == "Criminal"){
            cbTlThievesT.isChecked = true
            cbTlThievesT.visibility = View.GONE
        }
    }
}