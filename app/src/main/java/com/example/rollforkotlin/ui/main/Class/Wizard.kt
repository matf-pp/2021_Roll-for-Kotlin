package com.example.rollforkotlin.ui.main.Class

class Wizard() : ClassGeneral() {
    override var className = "Wizard"
    override var hitDice = "1d6 per wizard level"
    override var armorProf = "None"
    override var weaponProf = "Daggers, darts, slings, quarterstaffs, light crossbows"
    override var toolProf = "None"
    override var savingThrowsProf = "Intelligence, Wisdom"
    override var spellCastingMod = "Intelligence"
    override var skillsLvl1 = "Arcane Recovery \n Each time you gain a wizard level, you can add two wizard spells of your choice to your spellbook. Each of these spells must be of a level for which you have spell slots, as shown on the Wizard table. On your adventures, you might find other spells that you can add to your spellbook."
    override var skillsLvl2 = ""
    override var skillsLvl3 = "Cantrip Formulas\n" +
            "At 3rd level, you have scribed a set of arcane formulas in your spellbook that you can use to formulate a cantrip in your mind. Whenever you finish a long rest and consult those formulas in your spellbook, you can replace one wizard cantrip you know with another cantrip from the wizard spell list."
    override var skillsLvl4 = ""
    override var skillsLvl5 = ""
    override var skillsLvl6 = ""
    override var language = 0


    override fun getSavingThrowProf(ability : String): Boolean {
        when(ability){
            "chStr" -> false
            "chDex" -> false
            "chCon" -> false
            "chInt" -> true
            "chWis" -> true
            "chCha" -> false
        }
        return false
    }

    override fun getHitDice(lvl : Int): String {
        when (lvl){
            1 -> return "1d6"
            2 -> return "2d6"
            3 -> return "3d6"
            4 -> return "4d6"
            5 -> return "5d6"
            6 -> return "6d6"
        }
        return ""
    }

    override fun getCantrips(lvl : Int): Int {
        when (lvl){
            1 -> return 3
            2 -> return 3
            3 -> return 3
            4 -> return 4
            5 -> return 4
            6 -> return 4
        }
        return 0
    }

    override fun getSpellLvl1(lvl : Int): Int {
        when (lvl){
            1 -> return 2
            2 -> return 3
            3 -> return 4
            4 -> return 4
            5 -> return 4
            6 -> return 4
        }
        return 0
    }

    override fun getSpellLvl2(lvl : Int): Int {
        when (lvl){
            1 -> return 0
            2 -> return 0
            3 -> return 2
            4 -> return 3
            5 -> return 3
            6 -> return 3
        }
        return 0
    }

    override fun getSpellLvl3(lvl : Int): Int {
        when (lvl){
            1 -> return 0
            2 -> return 0
            3 -> return 0
            4 -> return 0
            5 -> return 2
            6 -> return 3
        }
        return 0
    }

    override fun getSpellCastingModifier(): String {
        return "Int"
    }
}