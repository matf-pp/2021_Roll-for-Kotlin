package com.example.rollforkotlin.ui.main.classes

class Ranger() : ClassGeneral() {
    override var className = "Ranger"
    override var hitDice = 10
    override var armorProf = "Light armor, medium armor, shields"
    override var weaponProf = " Simple weapons, martial weapons"
    override var toolProf = "None"
    override var savingThrowsProf = "Strength, Dexterity"
    override var spellCastingMod = "Wisdom"
    override var classTraits = arrayListOf("Favored Enemy\n" +
            "Beginning at 1st level, you have significant experience studying, tracking, hunting, and even talking to a certain type of enemy.\n" +
            "\n" +
            "Choose a type of favored enemy: aberrations, beasts, celestials, constructs, dragons, elementals, fey, fiends, giants, monstrosities, oozes, plants, or undead. Alternatively, you can select two races of humanoid (such as gnolls and orcs) as favored enemies.\n" +
            "\n" +
            "You have advantage on Wisdom (Survival) checks to track your favored enemies, as well as on Intelligence checks to recall information about them." +
            "Natural Explorer\n" +
            "Also at 1st level, you are particularly familiar with one type of natural environment and are adept at traveling and surviving in such regions. Choose one type of favored terrain: arctic, coast, desert, forest, grassland, mountain, swamp, or the Underdark. When you make an Intelligence or Wisdom check related to your favored terrain, your proficiency bonus is doubled if you are using a skill that you’re proficient in.\n" +
            "\n" +
            "While traveling for an hour or more in your favored terrain, you gain the following benefits:\n" +
            "\n" +
            "Difficult terrain doesn’t slow your group’s travel.\n" +
            "Your group can’t become lost except by magical means.\n" +
            "Even when you are engaged in another activity while traveling (such as foraging, navigating, or tracking), you remain alert to danger.\n" +
            "If you are traveling alone, you can move stealthily at a normal pace.\n" +
            "When you forage, you find twice as much food as you normally would.\n" +
            "While tracking other creatures, you also learn their exact number, their sizes, and how long ago they passed through the area.","","","","Extra Attack\n" +
            "Beginning at 5th level, you can attack twice, instead of once, whenever you take the Attack action on your turn.","")
    override var language = 1


    override fun getSavingThrowProf(ability : String): Int {
        return when(ability){
            "strSave" -> 1
            "dexSave" -> 1
            else -> 0
        }
    }
    override fun getCantripsNumber(lvl : Int): Int {
        when (lvl){
            1 -> return 0
            2 -> return 2
            3 -> return 3
            4 -> return 3
            5 -> return 4
            6 -> return 4
        }
        return 0
    }

    override fun getSpellLvl1Number(lvl : Int): Int {
        when (lvl){
            1 -> return 0
            2 -> return 2
            3 -> return 3
            4 -> return 3
            5 -> return 4
            6 -> return 4
        }
        return 0
    }

    override fun getSpellLvl2Number(lvl : Int): Int {
        when (lvl){
            1 -> return 0
            2 -> return 0
            3 -> return 0
            4 -> return 0
            5 -> return 2
            6 -> return 2
        }
        return 0
    }

    override fun getSpellLvl3Number(lvl : Int): Int {
        when (lvl){
            1 -> return 0
            2 -> return 0
            3 -> return 0
            4 -> return 0
            5 -> return 0
            6 -> return 0
        }
        return 0
    }

}