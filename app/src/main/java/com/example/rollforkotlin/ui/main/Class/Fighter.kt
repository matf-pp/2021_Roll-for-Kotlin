package com.example.rollforkotlin.ui.main.Class

class Fighter() : ClassGeneral() {
    override var className = "Fighter"
    override var hitDice = "1d10 per fighter level"
    override var armorProf = "All armor, shields"
    override var weaponProf = "Simple weapons, martial weapons"
    override var toolProf = "None"
    override var savingThrowsProf = "Strength, Constitution"
    override var spellCastingMod = ""
    override var skillsLvl1 = "Second Wind\n" +
            "You have a limited well of stamina that you can draw on to protect yourself from harm. On your turn, you can use a bonus action to regain hit points equal to 1d10 + your fighter level.\n" +
            "\n" +
            "Once you use this feature, you must finish a short or long rest before you can use it again."
    override var skillsLvl2 = "Action Surge\n" +
            "Starting at 2nd level, you can push yourself beyond your normal limits for a moment. On your turn, you can take one additional action.\n" +
            "\n" +
            "Once you use this feature, you must finish a short or long rest before you can use it again."
    override var skillsLvl3 = ""
    override var skillsLvl4 = ""
    override var skillsLvl5 = "Extra Attack\n" +
            "Beginning at 5th level, you can attack twice, instead of once, whenever you take the Attack action on your turn."
    override var skillsLvl6 = ""
    override var language = 0


    override fun getSavingThrowProf(ability : String): Boolean {
        when(ability){
            "chStr" -> true
            "chDex" -> false
            "chCon" -> true
            "chInt" -> false
            "chWis" -> false
            "chCha" -> false
        }
        return false
    }

    override fun getHitDice(lvl : Int): String {
        when (lvl){
            1 -> return "1d10"
            2 -> return "2d10"
            3 -> return "3d10"
            4 -> return "4d10"
            5 -> return "5d10"
            6 -> return "6d10"
        }
        return ""
    }

    override fun getCantrips(lvl : Int): Int {
        return 0
    }

    override fun getSpellLvl1(lvl : Int): Int {
        return 0
    }

    override fun getSpellLvl2(lvl : Int): Int {
        return 0
    }

    override fun getSpellLvl3(lvl : Int): Int {
        return 0
    }

    override fun getSpellCastingModifier(): String {
        return ""
    }
}