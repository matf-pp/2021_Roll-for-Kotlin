package com.example.rollforkotlin

import com.example.rollforkotlin.ui.main.classes.*
import kotlin.random.Random

class Character {
    //Basics
    var chName: String = ""
    var chLevel: Int = 0
    var chGender : String = ""
    var chClass : String = ""
    var chRace : String = ""
    var chBackgroud : String = ""
    var chDeity : String = ""
    var chAlignment : String = ""
    var chProficiencyBonus : Int = 2
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
    var chAbilities = mutableMapOf<String,Int>("str" to 0, "dex" to 0,"con" to 0,
                                                "int" to 0,"wis" to 0,"cha" to 0)

    //Stats
    var chSkills = mutableMapOf<String,Int>("dexAcrobatics" to 0,"wisAnimalHandling" to 0,"intArcana" to 0,
                                    "strAthletics" to 0, "chaDeception" to 0,"intHistory" to 0,
                                    "wisInsight" to 0, "chaIntimidation" to 0,"intInvestigation" to 0,
                                    "wisMedicine" to 0, "intNature" to 0,"wisPerception" to 0,
                                    "chaPerformance" to 0, "chaPersuasion" to 0,"intReligion" to 0,
                                    "dexSleightOfHand" to 0, "dexStealth" to 0,"wisSurvival" to 0)

    //Stat Prof
    var chSkillProfs = mutableMapOf<String,Int>("dexAcrobatics" to 0,"wisAnimalHandling" to 0,"intArcana" to 0,
                                                "strAthletics" to 0, "chaDeception" to 0,"intHistory" to 0,
                                                "wisInsight" to 0, "chaIntimidation" to 0,"intInvestigation" to 0,
                                                "wisMedicine" to 0, "intNature" to 0,"wisPerception" to 0,
                                                "chaPerformance" to 0, "chaPersuasion" to 0,"intReligion" to 0,
                                                "dexSleightOfHand" to 0, "dexStealth" to 0,"wisSurvival" to 0)

    //Saving Throws
    var chSavingThrows = mutableMapOf<String,Int>("strSave" to 0, "dexSave" to 0,"conSave" to 0,
                                                    "intSave" to 0,"wisSave" to 0,"chaSave" to 0)

    //Saving Throws Prof
    var chSavingThrowProfs = mutableMapOf<String,Int>("strSave" to 0, "dexSave" to 0,"conSave" to 0,
                                                        "intSave" to 0,"wisSave" to 0,"chaSave" to 0)

    //Race traits
    var chSpeedWalk : Int = 0
    var chSpeedFly : Int = 0
    var chSpeedClimb : Int = 0
    var chSpeedSwim : Int = 0
    lateinit var chRacialTraits : ArrayList<String>
    //Class traits
    var chClassTraits : ArrayList<String> = ArrayList()
    //Spells
    var chSpellAttackBonus : Int = 0
    var chSpellCastingAbility : String = ""
    var chSpellSaveDC : Int = 0
    var chSpellPrepared : Int = 0
    var chSpellCantripCounter : Int = 0
    var chSpellLvl1Counter : Int = 0
    var chSpellLvl2Counter : Int = 0
    var chSpellLvl3Counter : Int = 0
    //Gold
    var chCopper : Int = 0
    var chSilver : Int = 0
    var chGold : Int = 0
    var chPlatinum : Int = 0
    //Equipment
    var chArmor : String = ""
    var chShield : String = ""
    var chWeapons : String = ""

    fun setSkills() {
        for (pair in chSkills) {
            chSkills[pair.key] = (chAbilities[pair.key.substring(0, 3)]!! - 10) / 2 + chProficiencyBonus * chSkillProfs[pair.key]!!
        }
    }
    fun setSavingThrows(){
        var classInfo = getClass()
        for(pair in chSavingThrows) {
            chSavingThrowProfs[pair.key] = classInfo.getSavingThrowProf(pair.key)
            chSavingThrows[pair.key] = (chAbilities[pair.key.substring(0,3)]!! - 10 ) /2 + chProficiencyBonus*chSavingThrowProfs[pair.key]!!
        }
    }
    fun getAllHPVariables(){
        var hitDice = getClass().getHitDice()
        for (i in 1..chLevel){
            chMaxHP += Random.nextInt(1, hitDice) + ((chAbilities["con"]?.toInt()?.minus(10))?.div(2)  ?: 0)
        }
        chCurrentHP = chMaxHP
        chHitDice = chLevel.toString() + "d" + hitDice.toString()
    }
    fun getClassTraits(){
        var classInfo = getClass()
        for (i in 1..chLevel){
            chClassTraits.add(classInfo.classTraits[i])
        }
    }
    fun getSpellNumbers(){
        var classInfo : ClassGeneral
        when(chClass){
            "Wizard" -> {
                classInfo = Wizard()
                chSpellCantripCounter = classInfo.getCantripsNumber(chLevel)
                chSpellLvl1Counter = classInfo.getSpellLvl1Number(chLevel)
                chSpellLvl2Counter = classInfo.getSpellLvl2Number(chLevel)
                chSpellLvl3Counter= classInfo.getSpellLvl3Number(chLevel)
            }
            "Bard" -> {
                classInfo = Bard()
                chSpellCantripCounter = classInfo.getCantripsNumber(chLevel)
                chSpellLvl1Counter = classInfo.getSpellLvl1Number(chLevel)
                chSpellLvl2Counter = classInfo.getSpellLvl2Number(chLevel)
                chSpellLvl3Counter= classInfo.getSpellLvl3Number(chLevel)
            }
            "Ranger" -> {
                classInfo = Ranger()
                chSpellCantripCounter = classInfo.getCantripsNumber(chLevel)
                chSpellLvl1Counter = classInfo.getSpellLvl1Number(chLevel)
                chSpellLvl2Counter = classInfo.getSpellLvl2Number(chLevel)
                chSpellLvl3Counter= classInfo.getSpellLvl3Number(chLevel)
            }
            "Cleric" -> {
                classInfo = Cleric()
                chSpellCantripCounter = classInfo.getCantripsNumber(chLevel)
                chSpellLvl1Counter = classInfo.getSpellLvl1Number(chLevel)
                chSpellLvl2Counter = classInfo.getSpellLvl2Number(chLevel)
                chSpellLvl3Counter= classInfo.getSpellLvl3Number(chLevel)
            }
            else -> {
                chSpellCantripCounter = 0
                chSpellLvl1Counter = 0
                chSpellLvl2Counter = 0
                chSpellLvl3Counter = 0
            }
        }
    }
    fun getClass() : ClassGeneral {
        when(chClass) {
            "Wizard" -> {
               return Wizard()
            }
            "Bard" -> {
                return Bard()
            }
            "Ranger" -> {
                return Ranger()
            }
            "Cleric" -> {
                return Cleric()
            }
            "Fighter" -> {
                return Fighter()
            }
            "Rogue" -> {
                return Rogue()
            }
        }
        return Barbarian()
    }

}

