package com.example.rollforkotlin.ui.main.classes

class Barbarian() : ClassGeneral() {
    override var className = "Barbarian"
    override var hitDice = 12
    override var armorProf = "Light armor, medium armor, shields"
    override var weaponProf = "Simple weapons, martial weapons"
    override var toolProf = "None"
    override var savingThrowsProf = "Strength, Constitution"
    override var spellCastingMod = ""
    override var classTraits = arrayListOf("Rage\n" +
            "In battle, you fight with primal ferocity. On your turn, you can enter a rage as a bonus action.\n" +
            "\n" +
            "While raging, you gain the following benefits if you aren't wearing heavy armor:\n" +
            "\n" +
            "You have advantage on Strength checks and Strength saving throws.\n" +
            "When you make a melee weapon attack using Strength, you gain a bonus to the damage roll that increases as you gain levels as a barbarian, as shown in the Rage Damage column of the Barbarian table.\n" +
            "You have resistance to bludgeoning, piercing, and slashing damage.\n" +
            "If you are able to cast spells, you can't cast them or concentrate on them while raging.\n" +
            "\n" +
            "Your rage lasts for 1 minute. It ends early if you are knocked unconscious or if your turn ends and you haven't attacked a hostile creature since your last turn or taken damage since then. You can also end your rage on your turn as a bonus action.\n" +
            "\n" +
            "Once you have raged the number of times shown for your barbarian level in the Rages column of the Barbarian table, you must finish a long rest before you can rage again.\n" +
            "\n" +
            "Unarmored Defense\n" +
            "While you are not wearing any armor, your armor class equals 10 + your Dexterity modifier + your Constitution modifier. You can use a shield and still gain this benefit.",
             "Danger Sense\n" +
             "At 2nd level, you gain an uncanny sense of when things nearby aren't as they should be, giving you an edge when you dodge away from danger. You have advantage on Dexterity saving throws against effects that you can see, such as traps and spells. To gain this benefit, you can't be blinded, deafened, or incapacitated.\n" +
             "\n" +
             "Reckless Attack\n" +
             "Starting at 2nd level, you can throw aside all concern for defense to attack with fierce desperation. When you make your first attack on your turn, you can decide to attack recklessly. Doing so gives you advantage on melee weapon attack rolls using Strength during this turn, but attack rolls against you have advantage until your next turn.",
             "","","Extra Attack\n" +
            "Beginning at 5th level, you can attack twice, instead of once, whenever you take the Attack action on your turn.\n" +
            "\n" +
            "Fast Movement\n" +
            "Starting at 5th level, your speed increases by 10 feet while you aren't wearing heavy armor.","")
    override var language = 0


    override fun getSavingThrowProf(ability : String): Int {
        return when(ability){
            "strSave" -> 1
            "conSave" -> 1
            else -> 0
        }
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
}