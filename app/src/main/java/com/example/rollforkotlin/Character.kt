package com.example.rollforkotlin

import android.os.Build
import androidx.annotation.RequiresApi
import com.example.rollforkotlin.ui.main.classes.*
import com.example.rollforkotlin.ui.main.backgrounds.*
import com.example.rollforkotlin.ui.main.races.Human
import com.example.rollforkotlin.ui.main.races.RaceGeneral
import kotlin.random.Random
import kotlin.math.*

class Character {
    //Basics
    var chName: String = ""
    var chLevel: Int = 0
    var chGender : String = ""
    var chClass : String = ""
    lateinit var chClassObject : ClassGeneral
    var chRace : String = ""
    lateinit var chRaceObject : RaceGeneral
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
    var chHitDice : String = ""
    //Ability Score
    var chAbilities = mutableMapOf<String,Int>("str" to 0, "dex" to 0,"con" to 0,
                                                "int" to 0,"wis" to 0,"cha" to 0)

    //Skills
    var chSkills = mutableMapOf<String,Int>("dexAcrobatics" to 0,"wisAnimalHandling" to 0,"intArcana" to 0,
                                    "strAthletics" to 0, "chaDeception" to 0,"intHistory" to 0,
                                    "wisInsight" to 0, "chaIntimidation" to 0,"intInvestigation" to 0,
                                    "wisMedicine" to 0, "intNature" to 0,"wisPerception" to 0,
                                    "chaPerformance" to 0, "chaPersuasion" to 0,"intReligion" to 0,
                                    "dexSleightOfHand" to 0, "dexStealth" to 0,"wisSurvival" to 0)

    //Skill Proficiencies
    var chSkillProfs = mutableMapOf<String,Int>("dexAcrobatics" to 0,"wisAnimalHandling" to 0,"intArcana" to 0,
                                                "strAthletics" to 0, "chaDeception" to 0,"intHistory" to 0,
                                                "wisInsight" to 0, "chaIntimidation" to 0,"intInvestigation" to 0,
                                                "wisMedicine" to 0, "intNature" to 0,"wisPerception" to 0,
                                                "chaPerformance" to 0, "chaPersuasion" to 0,"intReligion" to 0,
                                                "dexSleightOfHand" to 0, "dexStealth" to 0,"wisSurvival" to 0)

    //Skill Expertise
    var chSkillExp = mutableMapOf<String,Int>("dexAcrobatics" to 0,"wisAnimalHandling" to 0,"intArcana" to 0,
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
    var chInstruments :ArrayList<String> = arrayListOf()
    var chEquipment : String = ""
    var chHasPotion : Boolean = false
    var chArmor : String = ""
    var chArmorProf : String = ""
    var chWeapons : ArrayList<String> = arrayListOf()
    var chWeaponType = mutableMapOf<String,String>("Dagger" to "fin", "Battleaxe" to "str","CrossbowL" to "dex", "Greataxe" to "str",
                                                    "Greatsword" to "str","Javelin" to "str", "Quarterstaff" to "str", "Shortbow" to "dex",
                                                    "Longsword" to "str", "Rapier" to "fin", "Longbow" to "dex")
    //Weapon type lists
    var simpleWeaponList = arrayListOf<String>("Dagger", "Javelin", "Quarterstaff", "CrossbowL", "Shortbow")
    var martialWeaponList = arrayListOf<String>("Battleaxe","Greataxe", "Greatsword", "Longsword", "Rapier", "Longbow")
    var weaponDamageMap =  mutableMapOf<String,String>("Dagger" to "1d4", "Battleaxe" to "1d8","CrossbowL" to "1d8", "Greataxe" to "1d12",
                                                "Greatsword" to "2d6","Javelin" to "1d6", "Quarterstaff" to "1d6", "Shortbow" to "1d6",
                                                "Longsword" to "1d8", "Rapier" to "1d8", "Longbow" to "1d8")
    var weaponDagameTypeMap =  mutableMapOf<String,String>("Dagger" to "piercing", "Battleaxe" to "slashing","CrossbowL" to "piercing", "Greataxe" to "slashing",
                                                "Greatsword" to "slashing","Javelin" to "piercing", "Quarterstaff" to "bludgeoning", "Shortbow" to "piercing",
                                                "Longsword" to "slashing", "Rapier" to "piercing", "Longbow" to "piercing")
    var chWeaponRange = mutableMapOf<String,String>("Dagger" to "20/60ft", "Battleaxe" to "5ft","CrossbowL" to "80/320ft", "Greataxe" to "5ft",
                                                "Greatsword" to "5ft","Javelin" to "30/120ft", "Quarterstaff" to "5ft", "Shortbow" to "80/320ft",
                                                "Longsword" to "5ft", "Rapier" to "5ft", "Longbow" to "150/600ft")
    var chWeaponToHitBonus = mutableMapOf<String,Int>()
    var chWeaponDamageBonus = mutableMapOf<String,Int>()

    var chWeaponProfTypes: String = ""
    var chWeaponProfList: ArrayList<String> = arrayListOf()
    var chToolProf : String = ""

    fun setSkills() {
        for (pair in chSkills) {
            chSkills[pair.key] = (chAbilities[pair.key.substring(0, 3)]!! - 10) / 2 + chProficiencyBonus * (chSkillProfs[pair.key]!! + chSkillExp[pair.key]!!)
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
        chMaxHP = 0
        chMaxHP += chClassObject.hitDice + ((chAbilities["con"]?.toInt()?.minus(10))?.div(2)  ?: 0)
        for (i in 2..chLevel){
            chMaxHP += Random.nextInt(1, chClassObject.hitDice+1) + ((chAbilities["con"]?.toInt()?.minus(10))?.div(2)  ?: 0)
        }
        chCurrentHP = chMaxHP
        chHitDice = chLevel.toString() + "d" + chClassObject.hitDice.toString()
    }
    fun setLanguages(){
        chLanguageCounter = chClassObject.language + chBackgroundObject.language
    }
    fun setArmorAndWeaponProf(){
        chArmorProf = chClassObject.armorProf
        chWeaponProfTypes = chClassObject.weaponProf
        chToolProf = chClassObject.toolProf
        for (type in chClassObject.weaponProfList){
            when (type){
                "Simp" -> {
                    for (i in simpleWeaponList){
                        chWeaponProfList.add(i)
                    }
                }
                "Mart" -> {
                    for (i in martialWeaponList){
                        chWeaponProfList.add(i)
                    }
                }
                else -> {
                    chWeaponProfList.add(type)
                }
            }
        }
    }
    fun setWeaponBonus(){
        for(weapon in chWeapons){
            if (chWeaponType[weapon] == "fin"){
                chWeaponToHitBonus[weapon] = (max(chAbilities["str"]!!, chAbilities["dex"]!!) - 10) /2 + chProficiencyBonus * checkWeaponProf(weapon)
                chWeaponDamageBonus[weapon] = (max(chAbilities["str"]!!, chAbilities["dex"]!!) - 10) /2
            } else if (chWeaponType[weapon] == "str"){
                chWeaponToHitBonus[weapon] = ((chAbilities["str"]?.toInt()?.minus(10))?.div(2)  ?: 0) + chProficiencyBonus * checkWeaponProf(weapon)
                chWeaponDamageBonus[weapon] = ((chAbilities["str"]?.toInt()?.minus(10))?.div(2)  ?: 0)
            } else {
                chWeaponToHitBonus[weapon] = ((chAbilities["dex"]?.toInt()?.minus(10))?.div(2)  ?: 0) + chProficiencyBonus * checkWeaponProf(weapon)
                chWeaponDamageBonus[weapon] = ((chAbilities["str"]?.toInt()?.minus(10))?.div(2)  ?: 0)
            }
        }
    }
    fun checkWeaponProf(weapon : String): Int{
        if (chWeaponProfList.contains(weapon)){
            return 1
        }
        return 0
    }
    fun setAC(){
        when(chArmor.substring(0,3)){
            "(L)" -> {
                chArmorClass = chArmor.takeLast(2).toInt() + ((chAbilities["dex"]?.toInt()?.minus(10))?.div(2)  ?: 0)
            }
            "(M)" -> {
                chArmorClass = if (((chAbilities["dex"]?.toInt()?.minus(10))?.div(2)  ?: 0) <= 2) {
                    chArmor.takeLast(2).toInt() + ((chAbilities["dex"]?.toInt()?.minus(10))?.div(2)
                            ?: 0)
                } else {
                    chArmor.takeLast(2).toInt() + 2
                }
            }
            "(H)" -> {
                chArmorClass = chArmor.takeLast(2).toInt()
            }
        }
    }
    fun getClassTraits(){
        for (i in 1..chLevel){
            chClassTraits.add(chClassObject.classTraits[i-1])
        }
    }
    fun getBackgroundTraits(){
        for (trait in chBackgroundObject.backgroundTraits){
            chBackgroundTraits.add(trait)
        }
        chEquipment = chBackgroundObject.equipment
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
    fun setRace(){
        when(chRace) {
            "Human" -> {
                chRaceObject = Human()
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

