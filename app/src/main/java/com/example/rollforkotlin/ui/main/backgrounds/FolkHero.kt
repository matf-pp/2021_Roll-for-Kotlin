package com.example.rollforkotlin.ui.main.backgrounds

class FolkHero() : BackgroundGeneral() {
    override var equipment = "A set of artisan's tools, a shovel, an iron pot, a set of common clothes, and a belt pouch containing 10gp"
    override var skillProf = arrayListOf("Animal Handling", "Survival")
    override var toolProf = arrayListOf("Vehicles")
    override var backgroundTraits = arrayListOf("Rustic Hospitality\n" +
            "Since you come from the ranks of the common folk, you fit in among them with ease. You can find a place to hide, rest, or recuperate among other commoners, unless you have shown yourself to be a danger to them. They will shield you from the law or anyone else searching for you, though they will not risk their lives for you.")
    override var language = 0
    override var instrument = 0

    override fun getSkillProf(ability : String): Int {
        return when(ability){
            "wisAnimalHandling" -> 1
            "wisSurvival" -> 1
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