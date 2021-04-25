package com.example.rollforkotlin.ui.main.races

class Halfling: RaceGeneral() {
    override val abilityScoreList = mutableMapOf("dex" to 2)
    override val speed = mutableMapOf("walk" to 25, "fly" to 0, "swim" to 0, "climb" to 0)
    override val languageList = arrayListOf("Common", "Halfling")
    override val extraLanguage = 0
    override val skillProfList = arrayListOf<String>()
    override val weaponProficiencyList = arrayListOf<String>()
    override val toolProficiencyNumber = 0
    override val racialFeaturesList = arrayListOf("Lucky\n " +
                                                    "When you roll a 1 on an attack roll, ability check, or saving throw, you can reroll the die. You must use the new result, even if it is a 1.",
                                                    "Brave\n " +
                                                    "You have advantage on saving throws against being frightened.",
                                                    "Nimble\n " +
                                                    "You can move through the space of any creature that is of a size larger than yours.")
}