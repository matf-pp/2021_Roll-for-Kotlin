package com.example.rollforkotlin.ui.main.races

class Dwarf: RaceGeneral() {
    override val abilityScoreList = mutableMapOf("con" to 2)
    override val speed = mutableMapOf("walk" to 25, "fly" to 0, "swim" to 0, "climb" to 0)
    override val languageList = arrayListOf("Common", "Dwarvish")
    override val extraLanguage = 0
    override val proficienciesList = arrayListOf<String>()
    override val weaponProficiencyList = arrayListOf("Battleaxe")
    override val toolProficiencyNumber = 1
    override val racialFeaturesList = arrayListOf("Dwarven Resilience\n " +
                                                    "You have advantage on saving throws against poison, and you have resistance against poison damage",
                                                    "Stonecunning\n" +
                                                    "Whenever you make an Intelligence (History) check related to the origin of stonework, you are considered proficient in the History skill and add double your proficiency bonus to the check, instead of your normal proficiency bonus.")
}