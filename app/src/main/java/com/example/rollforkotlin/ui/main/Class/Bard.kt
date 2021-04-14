package com.example.rollforkotlin.ui.main.Class

class Bard() : ClassGeneral() {
    override var className = "Bard"
    override var hitDice = "1d8 per bard level"
    override var armorProf = "Light armor"
    override var weaponProf = "Simple weapons, hand crossbows, longswords, rapiers, shortswords"
    override var toolProf = "Three musical instruments of your choice"
    override var savingThrowsProf = "Dexterity, Charisma"
    override var spellCastingMod = "Charisma"
    override var skillsLvl1 = "Bardic Inspiration\n" +
            "You can inspire others through stirring words or music. To do so, you use a bonus action on your turn to choose one creature other than yourself within 60 feet of you who can hear you. That creature gains one Bardic Inspiration die, a d6.\n" +
            "\n" +
            "Once within the next 10 minutes, the creature can roll the die and add the number rolled to one ability check, attack roll, or saving throw it makes. The creature can wait until after it rolls the d20 before deciding to use the Bardic Inspiration die, but must decide before the DM says whether the roll succeeds or fails. Once the Bardic Inspiration die is rolled, it is lost. A creature can have only one Bardic Inspiration die at a time.\n" +
            "\n" +
            "You can use this feature a number of times equal to your Charisma modifier (a minimum of once). You regain any expended uses when you finish a long rest.\n" +
            "\n" +
            "Your Bardic Inspiration die changes when you reach certain levels in this class. The die becomes a d8 at 5th level"
    override var skillsLvl2 = "Jack of All Trades\n" +
            "Starting at 2nd level, you can add half your proficiency bonus, rounded down, to any ability check you make that doesn't already include your proficiency bonus.\n"+
            "Song of Rest\n" +
            "Beginning at 2nd level, you can use soothing music or oration to help revitalize your wounded allies during a short rest. If you or any friendly creatures who can hear your performance spend one or more Hit Dice to regain hit points at the end of the short rest, each of those creatures regains an extra 1d6 hit points.\n" +
            "\n" +
            "The extra Hit Points increase when you reach certain levels in this class: to 1d8 at 9th level, to 1d10 at 13th level, and to 1d12 at 17th level."
    override var skillsLvl3 = "Expertise\n" +
            "At 3rd level, choose two of your skill proficiencies. Your proficiency bonus is doubled for any ability check you make that uses either of the chosen proficiencies."
    override var skillsLvl4 = ""
    override var skillsLvl5 = "Font of Inspiration\n" +
            "Beginning when you reach 5th level, you regain all of your expended uses of Bardic Inspiration when you finish a short or long rest."
    override var skillsLvl6 = "Countercharm\n" +
            "At 6th level, you gain the ability to use musical notes or words of power to disrupt mind-influencing effects. As an action, you can start a performance that lasts until the end of your next turn. During that time, you and any friendly creatures within 30 feet of you have advantage on saving throws against being frightened or charmed. A creature must be able to hear you to gain this benefit. The performance ends early if you are incapacitated or silenced or if you voluntarily end it (no action required)."
    override var language = 0

    override fun getSavingThrowProf(ability : String): Boolean {
        when(ability){
            "chStr" -> false
            "chDex" -> true
            "chCon" -> false
            "chInt" -> false
            "chWis" -> false
            "chCha" -> true
        }
        return false
    }

    override fun getHitDice(lvl : Int): String {
        when (lvl){
            1 -> return "1d8"
            2 -> return "2d8"
            3 -> return "3d8"
            4 -> return "4d8"
            5 -> return "5d8"
            6 -> return "6d8"
        }
        return ""
    }

    override fun getCantrips(lvl : Int): Int {
        when (lvl){
            1 -> return 2
            2 -> return 2
            3 -> return 2
            4 -> return 3
            5 -> return 3
            6 -> return 3
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
        return "Cha"
    }
}