package com.example.rollforkotlin.ui.main.backgrounds

class Sailor() : BackgroundGeneral() {
    override var equipment = " A belaying pin (club), 50 feet of silk rope, a lucky charm such as a rabbit foot or a small stone with a hole in the center (or you may roll for a random trinket on the Trinkets table in chapter 5), a set of common clothes, and a belt pouch containing 10gp"
    override var skillProf = arrayListOf("Athletics", "Perception")
    override var toolProf = arrayListOf("Navigator's tools", "Vehicles")
    override var backgroundTraits = arrayListOf("Ship's Passage\n" +
            "When you need to, you can secure free passage on a sailing ship for yourself and your adventuring companions. You might sail on the ship you served on, or another ship you have good relations with (perhaps one captained by a former crewmate). Because you're calling in a favor, you can't be certain of a schedule or route that will meet your every need. Your DM will determine how long it takes to get where you need to go. In return for your free passage, you and your companions are expected to assist the crew during the voyage.\n" +
            "\n" +
            "Alternative: Bad Reputation\n" +
            "If your character has a pirate background, you may select this background feature instead of Ship's Passage.\n" +
            "\n" +
            "No matter where you go, people are afraid of you due to your reputation. When you are in a civilized settlement, you can get away with minor criminal offenses, such as refusing to pay for food at a tavern or breaking down doors at a local shop, since most people will not report your activity to the authorities.")
    override var language = 0
    override var instrument = 0

    override fun getSkillProf(ability : String): Int {
        return when(ability){
            "strAthletics" -> 1
            "wisPerception" -> 1
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