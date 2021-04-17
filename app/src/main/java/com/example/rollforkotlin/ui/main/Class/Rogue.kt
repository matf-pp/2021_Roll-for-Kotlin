package com.example.rollforkotlin.ui.main.Class

class Rogue() : ClassGeneral() {
    override var className = "Rouge"
    override var hitDice = "1d8 per rogue level"
    override var armorProf = "Light armor"
    override var weaponProf = "Simple weapons, hand crossbows, longswords, rapiers, shortswords"
    override var toolProf = "Thieves' tools"
    override var savingThrowsProf = "Dexterity, Intelligence"
    override var spellCastingMod = ""
    override var classTraits = arrayListOf("Expertise\n" +
            "At 1st level, choose two of your skill proficiencies, or one of your skill proficiencies and your proficiency with thieves' tools. Your proficiency bonus is doubled for any ability check you make that uses either of the chosen proficiencies."
                + "Sneak Attack\n" +
            "Beginning at 1st level, you know how to strike subtly and exploit a foe's distraction. Once per turn, you can deal an extra 1d6 damage to one creature you hit with an attack if you have advantage on the attack roll. The attack must use a finesse or a ranged weapon.\n" +
            "\n" +
            "You don't need advantage on the attack roll if another enemy of the target is within 5 feet of it, that enemy isn't incapacitated, and you don't have disadvantage on the attack roll.\n" +
            "\n" +
            "The amount of the extra damage increases as you gain levels in this class, as shown in the Sneak Attack column of the Rogue table." + "Thieves' Cant\n" +
            "During your rogue training you learned thieves' cant, a secret mix of dialect, jargon, and code that allows you to hide messages in seemingly normal conversation. Only another creature that knows thieves' cant understands such messages. It takes four times longer to convey such a message than it does to speak the same idea plainly.\n" +
            "\n" +
            "In addition, you understand a set of secret signs and symbols used to convey short, simple messages, such as whether an area is dangerous or the territory of a thieves' guild, whether loot is nearby, or whether the people in an area are easy marks or will provide a safe house for thieves on the run.",
            "Cunning Action\n" +
            "Starting at 2nd level, your quick thinking and agility allow you to move and act quickly. You can take a bonus action on each of your turns in combat. This action can be used only to take the Dash, Disengage, or Hide action.",
            "","","Uncanny Dodge\n" +
            "Starting at 5th level, when an attacker that you can see hits you with an attack, you can use your reaction to halve the attack's damage against you.","")
    override var language = 0


    override fun getSavingThrowProf(ability : String): Int {
        return when(ability){
            "dexSave" -> 1
            "intSave" -> 1
            else -> 0
        }
    }

    override fun getHitDice(): Int {
        return 8
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