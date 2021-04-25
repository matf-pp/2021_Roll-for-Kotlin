package com.example.rollforkotlin.ui.main.races

class Gnome: RaceGeneral() {
    override val abilityScoreList = mutableMapOf("int" to 2)
    override val speed = mutableMapOf("walk" to 25, "fly" to 0, "swim" to 0, "climb" to 0)
    override val languageList = arrayListOf("Common", "Gnomish")
    override val extraLanguage = 0
    override val skillProfList = arrayListOf<String>()
    override val weaponProficiencyList = arrayListOf<String>()
    override val toolProficiencyNumber = 0
    override val racialFeaturesList = arrayListOf("Darkvision\n " +
                                                    "Accustomed to life underground, you have superior vision in dark and dim conditions. You can see in dim light within 60 feet of you as if it were bright light, and in darkness as if it were dim light. You can't discern color in darkness, only shades of gray.",
                                                    "Gnome Cunning\n " +
                                                    "You have advantage on all Intelligence, Wisdom, and Charisma saves against magic.")
}