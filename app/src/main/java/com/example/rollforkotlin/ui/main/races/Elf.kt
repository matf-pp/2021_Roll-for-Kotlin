package com.example.rollforkotlin.ui.main.races

class Elf: RaceGeneral() {
    override val abilityScoreList = mutableMapOf("dex" to 2)
    override val speed = mutableMapOf("walk" to 30, "fly" to 0, "swim" to 0, "climb" to 0)
    override val languageList = arrayListOf("Common", "Elvish")
    override val extraLanguage = 0
    override val proficienciesList = arrayListOf("wisPerception")
    override val weaponProficiencyList = arrayListOf<String>()
    override val toolProficiencyNumber = 0
    override val racialFeaturesList = arrayListOf("Darkvision\n " +
                                                "Accustomed to twilit forests and the night sky, you have superior vision in dark and dim conditions. You can see in dim light within 60 feet of you as if it were bright light, and in darkness as if it were dim light. You can't discern color in darkness, only shades of gray.",
                                                "Fey Ancestry\n" +
                                                "You have advantage on saving throws against being charmed, and magic can't put you to sleep.",
                                                "Trance\n " +
                                                "Elves do not sleep. Instead they meditate deeply, remaining semi-conscious, for 4 hours a day. The Common word for this meditation is \"trance.\" While meditating, you dream after a fashion; such dreams are actually mental exercises that have become reflexive after years of practice. After resting in this way, you gain the same benefit a human would from 8 hours of sleep.")
}