package com.example.rollforkotlin.ui.main.classes

class Fighter() : ClassGeneral() {
    override var className = "Fighter"
    override var hitDice = "1d10 per fighter level"
    override var armorProf = "All armor, shields"
    override var weaponProf = "Simple weapons, martial weapons"
    override var toolProf = "None"
    override var savingThrowsProf = "Strength, Constitution"
    override var spellCastingMod = ""
    override var classTraits = arrayListOf("Second Wind\n" +
            "You have a limited well of stamina that you can draw on to protect yourself from harm. On your turn, you can use a bonus action to regain hit points equal to 1d10 + your fighter level.\n" +
            "\n" +
            "Once you use this feature, you must finish a short or long rest before you can use it again.","Action Surge\n" +
            "Starting at 2nd level, you can push yourself beyond your normal limits for a moment. On your turn, you can take one additional action.\n" +
            "\n" +
            "Once you use this feature, you must finish a short or long rest before you can use it again.","","","Extra Attack\n" +
            "Beginning at 5th level, you can attack twice, instead of once, whenever you take the Attack action on your turn.","")
    override var language = 0


    override fun getSavingThrowProf(ability : String): Int {
        return when(ability){
            "strSave" -> 1
            "conSave" -> 1
            else -> 0
        }
    }

    override fun getHitDice(): Int {
        return 10
    }

    override fun getCantripsNumber(lvl : Int): Int {
        return 0
    }

    override fun getSpellLvl1Number(lvl : Int): Int {
        return 0
    }

    override fun getSpellLvl2Number(lvl : Int): Int {
        return 0
    }

    override fun getSpellLvl3Number(lvl : Int): Int {
        return 0
    }

    override fun getSpellCastingModifier(): String {
        return ""
    }
}