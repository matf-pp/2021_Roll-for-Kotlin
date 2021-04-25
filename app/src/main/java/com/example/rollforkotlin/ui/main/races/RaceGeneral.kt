package com.example.rollforkotlin.ui.main.races

abstract class RaceGeneral {
    abstract val abilityScoreList : MutableMap<String,Int>
    abstract val speed : MutableMap<String,Int>
    abstract val languageList : ArrayList<String>
    abstract val extraLanguage : Int
    abstract val skillProfList : ArrayList<String>
    abstract val weaponProficiencyList: ArrayList<String>
    abstract val toolProficiencyNumber : Int
    abstract val racialFeaturesList : ArrayList<String>
}