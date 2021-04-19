package com.example.rollforkotlin.ui.main.classes

class Cleric() : ClassGeneral() {
    override var className = "Cleric"
    override var hitDice = 8
    override var armorProf = "Light armor, medium armor, shields"
    override var weaponProf = "All simple weapons"
    override var toolProf = "None"
    override var savingThrowsProf = "Wisdom, Charisma"
    override var spellCastingMod = "Intelligence"
    override var classTraits = arrayListOf("Ritual Casting\n" +
            "You can cast a cleric spell as a ritual if that spell has the ritual tag and you have the spell prepared.","Channel Divinity\n" +
            "At 2nd level, you gain the ability to channel divine energy directly from your deity, using that energy to fuel magical effects. You start with two such effects: Turn Undead and an effect determined by your domain. Some domains grant you additional effects as you advance in levels, as noted in the domain description.\n" +
            "\n" +
            "When you use your Channel Divinity, you choose which effect to create. You must then finish a short or long rest to use your Channel Divinity again.\n" +
            "\n" +
            "Some Channel Divinity effects require saving throws. When you use such an effect from this class, the DC equals your cleric spell save DC.\n"+"Channel Divinity: Turn Undead\n" +
            "As an action, you present your holy symbol and speak a prayer censuring the undead. Each undead that can see or hear you within 30 feet of you must make a Wisdom saving throw. If the creature fails its saving throw, it is turned for 1 minute or until it takes any damage.\n" +
            "\n" +
            "A turned creature must spend its turns trying to move as far away from you as it can, and it can't willingly move to a space within 30 feet of you. It also can't take reactions. For its action, it can use only the Dash action or try to escape from an effect that prevents it from moving. If there's nowhere to move, the creature can use the Dodge action."
                ,"","","Destroy Undead\n" +
            "Starting at 5th level, when an undead fails its saving throw against your Turn Undead feature, the creature is instantly destroyed if its challenge rating is at or below a certain threshold, as shown in the Cleric table above."
                ,"")
    override var language = 0


    override fun getSavingThrowProf(ability : String): Int {
        return when(ability){
            "wisSave" -> 1
            "chaSave" -> 1
            else -> 0
        }
    }
    override fun getCantripsNumber(lvl : Int): Int {
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

    override fun getSpellLvl1Number(lvl : Int): Int {
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

    override fun getSpellLvl2Number(lvl : Int): Int {
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

    override fun getSpellLvl3Number(lvl : Int): Int {
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

}