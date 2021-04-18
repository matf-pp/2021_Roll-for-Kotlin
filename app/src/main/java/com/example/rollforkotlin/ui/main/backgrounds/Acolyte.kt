package com.example.rollforkotlin.ui.main.backgrounds

class Acolyte() : BackgroundGeneral() {
    override var equipment = "A holy symbol (a gift to you when you entered the priesthood), a prayer book or prayer wheel, 5 sticks of incense, vestments, a set of common clothes, and a belt pouch containing 15gp"
    override var skillProf = arrayListOf("Insight", "Religion")
    override var toolProf = arrayListOf("")
    override var backgroundTraits = arrayListOf("Shelter of the Faithful\n" +
            "As an acolyte, you command the respect of those who share your faith, and you can perform the religious ceremonies of your deity. You and your adventuring companions can expect to receive free healing and care at a temple, shrine, or other established presence of your faith, though you must provide any material components needed for spells. Those who share your religion will support you (but only you) at a modest lifestyle.\n" +
            "\n" +
            "You might also have ties to a specific temple dedicated to your chosen deity or pantheon, and you have a residence there. This could be the temple where you used to serve, if you remain on good terms with it, or a temple where you have found a new home. While near your temple, you can call upon the priests for assistance, provided the assistance you ask for is not hazardous and you remain in good standing with your temple.")
    override var language = 2
    override var instrument = 0

    override fun getSkillProf(ability: String): Int {
        return when (ability) {
            "intReligion" -> 1
            "wisInsight" -> 1
            else -> 0
        }
    }
    override fun getLanguageInstrumentNumber(): Pair<Int, Int> {
        return Pair(language,instrument)
    }
    override fun getToolList(): ArrayList<String> {
       return toolProf
    }

    override fun getTraits(): ArrayList<String> {
        return backgroundTraits
    }
    override fun addEquipment(): String {
        return equipment
    }
}