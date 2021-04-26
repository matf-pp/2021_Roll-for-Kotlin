package com.example.rollforkotlin.ui.main.races

class Human: RaceGeneral() {
    override val abilityScoreList = mutableMapOf(   "str" to 1, "dex" to 1,"con" to 1,
                                                    "int" to 1, "wis" to 1,"cha" to 1)
    override val speed = mutableMapOf("walk" to 30, "fly" to 0, "swim" to 0, "climb" to 0)
    override val languageList = arrayListOf("Common")
    override val extraLanguage = 1
    override val skillProfList = arrayListOf<String>()
    override val weaponProficiencyList = arrayListOf<String>()
    override val toolProficiencyNumber = 0
    override val racialFeaturesList = arrayListOf("None")
}