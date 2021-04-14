package com.example.rollforkotlin.ui.main.Class

abstract class ClassGeneral {
    abstract var className : String
    abstract var hitDice : String
    abstract var armorProf : String
    abstract var weaponProf : String
    abstract var toolProf : String
    abstract var savingThrowsProf : String
    abstract var spellCastingMod : String
    abstract var skillsLvl1 : String
    abstract var skillsLvl2 : String
    abstract var skillsLvl3 : String
    abstract var skillsLvl4 : String
    abstract var skillsLvl5 : String
    abstract var skillsLvl6 : String
    abstract var language : Int

    abstract fun getSavingThrowProf(ability : String) : Boolean
    abstract fun getHitDice(lvl : Int) : String
    abstract fun getCantrips(lvl : Int) : Int
    abstract fun getSpellLvl1(lvl : Int) : Int
    abstract fun getSpellLvl2(lvl : Int) : Int
    abstract fun getSpellLvl3(lvl : Int) : Int
    abstract fun getSpellCastingModifier() : String
}