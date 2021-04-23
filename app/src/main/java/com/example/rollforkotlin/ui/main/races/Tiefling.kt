package com.example.rollforkotlin.ui.main.races

class Tiefling: RaceGeneral() {
    override val abilityScoreList = mutableMapOf("cha" to 2)
    override val speed = mutableMapOf("walk" to 30, "fly" to 0, "swim" to 0, "climb" to 0)
    override val languageList = arrayListOf("Common", "Infernal")
    override val extraLanguage = 0
    override val proficienciesList = arrayListOf<String>()
    override val weaponProficiencyList = arrayListOf<String>()
    override val toolProficiencyNumber = 0
    override val racialFeaturesList = arrayListOf("Darkvision\n " +
                                                "Thanks to your infernal heritage, you have superior vision in dark and dim conditions. You can see in dim light within 60 feet of you as if it were bright light, and in darkness as if it were dim light. You can’t discern color in darkness, only shades of gray.",
                                                "Hellish Resistance\n " +
                                                "You have resistance to fire damage.")
}