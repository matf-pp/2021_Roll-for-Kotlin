package com.example.rollforkotlin

public class Character {
    //Basics
    var chName: String = ""
    var chLevel: Int = 0
    var chGender : String = ""
    var chClass : String = ""
    var chRace : String = ""
    var chBackgroud : String = ""
    var chDeity : String = ""
    var chAlignment : String = ""
    var chPoficiencyBonus : Int = 2
    var chArmorClass : Int = 0
    var chPassivePerception : Int = 0
    var chInitiative : Int = 0
    var chAppearance : String = ""
    var chBackstory : String = ""
    var chAdditionalInfo : String = ""
    var chNotes : String = ""
    //Counters
    var chLanguageCounter : Int = 1
    var chProfCounter : Int = 1
    var chToolsCounter : Int = 1
    //HP
    var chCurrentHP : Int = 0
    var chMaxHP : Int = 0
    var chTemporaryHP : Int = 0
    var chHitDice : String = ""
    //Ability Score
    var chStr : Int = 0
    var chDex : Int = 0
    var chCon : Int = 0
    var chInt : Int = 0
    var chWis : Int = 0
    var chCha : Int = 0
    //Stats
    var chArcana : Int = 0
    var chAcrobatics : Int = 0
    var chAnimalH : Int = 0
    var chAthletics : Int = 0
    var chDeception : Int = 0
    var chHistory : Int = 0
    var chInsight : Int = 0
    var chIntimidation : Int = 0
    var chInvestigation : Int = 0
    var chMedicine : Int = 0
    var chNature : Int = 0
    var chPerception : Int = 0
    var chPerformance : Int = 0
    var chPersuasion : Int = 0
    var chReligion : Int = 0
    var chSleightOfHand : Int = 0
    var chStealth : Int = 0
    var chSurvival : Int = 0
    //Stat Prof
    var chArcanaProf : Boolean = false
    var chAcrobaticsProf : Boolean = false
    var chAnimalHProf : Boolean = false
    var chAthleticsProf : Boolean = false
    var chDeceptionProf : Boolean = false
    var chHistoryProf : Boolean = false
    var chInsightProf : Boolean = false
    var chIntimidationProf : Boolean = false
    var chInvestigationProf : Boolean = false
    var chMedicineProf : Boolean = false
    var chNatureProf : Boolean = false
    var chPerceptionProf : Boolean = false
    var chPerformanceProf : Boolean = false
    var chPersuasionProf : Boolean = false
    var chReligionProf : Boolean = false
    var chSleightOfHandProf : Boolean = false
    var chStealthProf : Boolean = false
    var chSurvivalProf : Boolean = false
    //Saving Throws
    var chStrSave : Int = 0
    var chDexSave : Int = 0
    var chConSave : Int = 0
    var chIntSave : Int = 0
    var chWisSave : Int = 0
    var chChaSave : Int = 0
    //Saving Throws Prof
    var chStrSaveProf : Boolean = false
    var chDexSaveProf : Boolean = false
    var chConSaveProf : Boolean = false
    var chIntSaveProf : Boolean = false
    var chWisSaveProf : Boolean = false
    var chChaSaveProf : Boolean = false
    //Traits
    var chSpeedWalk : Int = 0
    var chSpeedFly : Int = 0
    var chSpeedClimb : Int = 0
    var chSpeedSwim : Int = 0
    var chRacialTraits : String = ""
    var chClassTraits : String = ""
    //Spells
    var chSpellAttackBonus : Int = 0
    var chSpellCastingAbility : String = ""
    var chSpellSaveDC : Int = 0
    var chSpellPrepared : Int = 0
    //Gold
    var chCopper : Int = 0
    var chSilver : Int = 0
    var chGold : Int = 0
    var chPlatinum : Int = 0
    //Equipment
    var chArmor : String = ""
    var chShield : String = ""
    var chWeapons : String = ""

    fun setAbilityScores(){
        chArcana = if (chArcanaProf) {
            chInt + chPoficiencyBonus
        } else chInt

        chAcrobatics = if (chAcrobaticsProf) {
            chDex + chPoficiencyBonus
        } else chDex

        chAnimalH = if (chAnimalHProf){
            chWis + chPoficiencyBonus
        }else chWis

        chAthletics = if (chAthleticsProf){
            chStr + chPoficiencyBonus
        } else chStr

        chDeception = if (chDeceptionProf){
            chCha + chPoficiencyBonus
        } else chCha

        chHistory = if (chHistoryProf){
            chInt + chPoficiencyBonus
        } else chInt

        chInsight = if (chInsightProf){
            chWis + chPoficiencyBonus
        } else chWis

        chIntimidation = if (chIntimidationProf){
            chCha + chPoficiencyBonus
        } else chCha

        chInvestigation = if (chInvestigationProf){
            chInt + chPoficiencyBonus
        } else chInt

        chMedicine = if (chMedicineProf){
            chWis + chPoficiencyBonus
        } else chWis

        chNature = if (chNatureProf){
            chInt + chPoficiencyBonus
        } else chInt

        chPerception = if (chPerceptionProf){
            chWis + chPoficiencyBonus
        } else chWis

        chPerformance = if (chPerformanceProf){
            chCha + chPoficiencyBonus
        } else chCha

        chPersuasion = if (chPersuasionProf){
            chCha + chPoficiencyBonus
        } else chCha

        chReligion = if (chReligionProf){
            chInt + chPoficiencyBonus
        } else chInt

        chSleightOfHand = if (chSleightOfHandProf){
            chDex + chPoficiencyBonus
        } else chDex

        chStealth = if (chStealthProf){
            chDex + chPoficiencyBonus
        } else chDex

        chSurvival = if (chSurvivalProf){
            chWis + chPoficiencyBonus
        } else chWis
    }

    fun setSavingThrows(){
        chStrSave = if (chStrSaveProf) {
            chStr + chPoficiencyBonus
        } else chStr

        chDexSave = if (chDexSaveProf) {
            chDex + chPoficiencyBonus
        } else chDex

        chConSave = if (chConSaveProf){
            chCon + chPoficiencyBonus
        }else chCon

        chIntSave = if (chIntSaveProf){
            chInt + chPoficiencyBonus
        } else chInt

        chWisSave = if (chWisSaveProf){
            chWis + chPoficiencyBonus
        } else chWis

        chChaSave = if (chChaSaveProf){
            chCha + chPoficiencyBonus
        } else chCha


    }

}

