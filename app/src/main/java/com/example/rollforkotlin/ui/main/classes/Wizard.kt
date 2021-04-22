package com.example.rollforkotlin.ui.main.classes

class Wizard() : ClassGeneral() {
    override var className = "Wizard"
    override var hitDice = 6
    override var armorProf = "None"
    override var weaponProf = "Daggers, darts, slings, quarterstaffs, light crossbows"
    override var weaponProfList = arrayListOf<String>("Dagger", "Quarterstaff","CrossbowL")
    override var toolProf = "None"
    override var savingThrowsProf = arrayListOf("intSave","wisSave")
    override var spellCastingMod = "Intelligence"
    override var classTraits = arrayListOf("Arcane Recovery \n Each time you gain a wizard level, you can add two wizard spells of your choice to your spellbook. Each of these spells must be of a level for which you have spell slots, as shown on the Wizard table. On your adventures, you might find other spells that you can add to your spellbook."
                                            ,"","Cantrip Formulas\n" +
                    "At 3rd level, you have scribed a set of arcane formulas in your spellbook that you can use to formulate a cantrip in your mind. Whenever you finish a long rest and consult those formulas in your spellbook, you can replace one wizard cantrip you know with another cantrip from the wizard spell list."
                                            ,"","","")
    override var language = 0

    override var cantripNumbers = arrayListOf(3,3,3,4,4,4)
    override var spell1Numbers = arrayListOf(2,3,4,4,4,4)
    override var spell2Numbers = arrayListOf(0,0,2,3,3,3)
    override var spell3Numbers = arrayListOf(0,0,0,0,2,3)
}