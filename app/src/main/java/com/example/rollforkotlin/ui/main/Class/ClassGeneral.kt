package com.example.rollforkotlin.ui.main.Class

abstract class ClassGeneral {
    abstract var className : String
    abstract var hitDice : String
    abstract var armorProf : String
    abstract var weaponProf : String
    abstract var toolProf : String
    abstract var savingThrowsProf : String
    abstract var spellCastingMod : String
    abstract var classTraits : ArrayList<String>
    abstract var language : Int

    abstract fun getSavingThrowProf(ability : String) : Boolean
    abstract fun getHitDice(lvl : Int) : String
    abstract fun getCantripsNumber(lvl : Int) : Int
    abstract fun getSpellLvl1Number(lvl : Int) : Int
    abstract fun getSpellLvl2Number(lvl : Int) : Int
    abstract fun getSpellLvl3Number(lvl : Int) : Int
    abstract fun getSpellCastingModifier() : String
}