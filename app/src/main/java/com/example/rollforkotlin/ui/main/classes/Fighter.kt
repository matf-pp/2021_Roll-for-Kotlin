package com.example.rollforkotlin.ui.main.classes

class Fighter() : ClassGeneral() {
    override var className = "Fighter"
    override var hitDice = 10
    override var armorProf = "All armor, shields"
    override var weaponProf = "Simple weapons, martial weapons"
    override var weaponProfList = arrayListOf<String>("Simp", "Mart")
    override var toolProf = "None"
    override var savingThrowsProf = arrayListOf("strSave","conSave")
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

    override var cantripNumbers = arrayListOf(0)
    override var spell1Numbers = arrayListOf(0)
    override var spell2Numbers = arrayListOf(0)
    override var spell3Numbers = arrayListOf(0)

}