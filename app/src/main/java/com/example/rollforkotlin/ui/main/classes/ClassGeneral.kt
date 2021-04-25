package com.example.rollforkotlin.ui.main.classes

abstract class ClassGeneral {
    abstract var className : String
    abstract var hitDice : Int
    abstract var skillProfCounter: Int
    abstract var armorProf : String
    abstract var weaponProf : String
    abstract var weaponProfList : ArrayList<String>
    abstract var toolProf : String
    abstract var savingThrowsProf : ArrayList<String>
    abstract var spellCastingMod : String
    abstract var classTraits : ArrayList<String>
    abstract var language : Int

    abstract var cantripNumbers : ArrayList<Int>
    abstract var spell1Numbers : ArrayList<Int>
    abstract var spell2Numbers : ArrayList<Int>
    abstract var spell3Numbers : ArrayList<Int>

}