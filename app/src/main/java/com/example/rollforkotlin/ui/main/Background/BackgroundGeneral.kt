package com.example.rollforkotlin.ui.main.Background

abstract class BackgroundGeneral {
    abstract var equipment : String
    abstract var skillProf : ArrayList<String>
    abstract var toolProf : ArrayList<String>
    abstract var backgroundTraits : ArrayList<String>
    abstract var language : Int
    abstract var instrument : Int

    abstract fun getSkillProf(ability : String) : Int
    abstract fun getLanguageInstrumentNumber() : Pair<Int,Int>
    abstract fun getToolList(): ArrayList<String>
    abstract fun getTraits(): ArrayList<String>
    abstract fun addEquipment(): String

}