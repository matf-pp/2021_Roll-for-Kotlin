package com.example.rollforkotlin

import com.example.rollforkotlin.ui.main.classes.*
import com.example.rollforkotlin.ui.main.backgrounds.*
import kotlin.random.Random

class Character {
    //Basics
    var chName: String = ""
    var chLevel: Int = 0
    var chGender : String = ""
    var chClass : String = ""
    lateinit var chClassObject : ClassGeneral
    var chRace : String = ""
    var chBackgroud : String = ""
    lateinit var chBackgroundObject: BackgroundGeneral
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
    //Background traits
    var chBackgroundTraits : ArrayList<String> = ArrayList()
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
    var chArmorProf : String = ""
    var chShield : String = ""
    var chWeapons : String = ""
    var chWeaponProf : String = ""
    var chToolProf : String = ""

    fun setSkills() {
        for (pair in chSkills) {
            chSkills[pair.key] = (chAbilities[pair.key.substring(0, 3)]!! - 10) / 2 + chProficiencyBonus * chSkillProfs[pair.key]!!
        }
    }
    fun setSavingThrows(){
        for(pair in chSavingThrows) {
            if (chClassObject.savingThrowsProf.contains(pair.key))
                chSavingThrowProfs[pair.key] = 1
            chSavingThrows[pair.key] = (chAbilities[pair.key.substring(0,3)]!! - 10 ) /2 + chProficiencyBonus*chSavingThrowProfs[pair.key]!!
        }
    }
    fun getAllHPVariables(){
        for (i in 1..chLevel){
            chMaxHP += Random.nextInt(1, chClassObject.hitDice) + ((chAbilities["con"]?.toInt()?.minus(10))?.div(2)  ?: 0)
        }
        chCurrentHP = chMaxHP
        chHitDice = chLevel.toString() + "d" + chClassObject.hitDice.toString()
    }
    fun setLanguages(){
        chLanguageCounter = chClassObject.language + chBackgroundObject.language
    }
    fun setArmorAndWeaponProf(){
        chArmorProf = chClassObject.armorProf
        chWeaponProf = chClassObject.weaponProf
        chToolProf = chClassObject.toolProf
    }
    fun setAC(){
        when(chArmor.substring(0,3)){
            "(L)" -> {
                chArmorClass = chArmor.takeLast(2).toInt() + ((chAbilities["dex"]?.toInt()?.minus(10))?.div(2)  ?: 0)
            }
            "(M)" -> {
                if (((chAbilities["dex"]?.toInt()?.minus(10))?.div(2)  ?: 0) <= 2)
                    chArmorClass = chArmor.takeLast(2).toInt() + ((chAbilities["dex"]?.toInt()?.minus(10))?.div(2)  ?: 0)
                else chArmorClass = chArmor.takeLast(2).toInt()
            }
            "(H)" -> {
                chArmorClass = chArmor.takeLast(2).toInt()
            }
        }
    }
    fun getClassTraits(){
        for (i in 1..chLevel){
            chClassTraits.add(chClassObject.classTraits[i])
        }
    }
    fun getBackgroundTraits(){
        for (trait in chBackgroundObject.backgroundTraits){
            chBackgroundTraits.add(trait)
        }
    }
    fun getSpellNumbers(){
        when(chClass){
            "Wizard", "Bard", "Cleric"-> {
                chSpellCantripCounter = chClassObject.cantripNumbers[chLevel-1]
                chSpellLvl1Counter    = chClassObject.spell1Numbers[chLevel-1]
                chSpellLvl2Counter    = chClassObject.spell2Numbers[chLevel-1]
                chSpellLvl3Counter    = chClassObject.spell3Numbers[chLevel-1]
            }
            "Ranger" -> {
                chSpellCantripCounter = 0
                chSpellLvl1Counter    = chClassObject.spell1Numbers[chLevel-1]
                chSpellLvl2Counter    = chClassObject.spell2Numbers[chLevel-1]
                chSpellLvl3Counter    = chClassObject.spell3Numbers[chLevel-1]
            }
            else -> {
                chSpellCantripCounter = 0
                chSpellLvl1Counter    = 0
                chSpellLvl2Counter    = 0
                chSpellLvl3Counter    = 0
            }
        }
    }
    fun setClass(){
        when(chClass) {
            "Wizard" -> {
               chClassObject = Wizard()
            }
            "Bard" -> {
                chClassObject = Bard()
            }
            "Ranger" -> {
                chClassObject = Ranger()
            }
            "Cleric" -> {
                chClassObject = Cleric()
            }
            "Fighter" -> {
                chClassObject = Fighter()
            }
            "Rogue" -> {
                chClassObject = Rogue()
            }
            "Barbarian" -> {
                chClassObject = Barbarian()
            }
        }
    }

    fun setBackground() {
        when(chBackgroud) {
            "Acolyte" -> {
                chBackgroundObject = Acolyte()
            }
            "Charlatan" -> {
                chBackgroundObject = Charlatan()
            }
            "Criminal" -> {
                chBackgroundObject = Criminal()
            }
            "Entertainer" -> {
                chBackgroundObject = Entertainer()
            }
            "FolkHero" -> {
                chBackgroundObject = FolkHero()
            }
            "Knight" -> {
                chBackgroundObject = Knight()
            }
            "Noble" -> {
                chBackgroundObject = Noble()
            }
            "Sailor" -> {
                chBackgroundObject = Sailor()
            }
            "Soldier" -> {
                chBackgroundObject = Soldier()
            }
        }
    }
}

