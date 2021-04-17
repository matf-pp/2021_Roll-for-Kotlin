package com.example.rollforkotlin.ui.main.Background

class Criminal() : BackgroundGeneral() {
    override var equipment = "A crowbar, a set of dark common clothes including a hood, and a belt pouch containing 15gp"
    override var skillProf = arrayListOf("Deception", "Stealth")
    override var toolProf = arrayListOf("One gaming set", "Thieves' tools")
    override var backgroundTraits = arrayListOf("Criminal Contact\n" +
            "You have a reliable and trustworthy contact who acts as your liaison to a network of other criminals. You know how to get messages to and from your contact, even over great distances; specifically, you know the local messengers, corrupt caravan masters, and seedy sailors who can deliver messages for you.")
    override var language = 0
    override var instrument = 0

    override fun getSkillProf(ability : String): Int {
        return when(ability){
            "chaDeception" -> 1
            "dexStealth" -> 1
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