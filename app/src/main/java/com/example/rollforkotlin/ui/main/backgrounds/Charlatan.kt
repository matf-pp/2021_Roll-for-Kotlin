package com.example.rollforkotlin.ui.main.backgrounds

class Charlatan() : BackgroundGeneral() {
    override var equipment = "A set of fine clothes, a disguise kit, tools of the con of your choice (ten stoppered bottles filled with colored liquid, a set of weighted dice, a deck of marked cards, or a signet ring of an imaginary duke), and a belt pouch containing 15 gp"
    override var skillProf = arrayListOf("chaDeception", "dexSleightOfHand")
    override var toolProf = arrayListOf("Disguise kit","Forgery kit")
    override var backgroundTraits = arrayListOf("False Identity\n" +
            "You have created a second identity that includes documentation, established acquaintances, and disguises that allow you to assume that persona. Additionally, you can forge documents including official papers and personal letters, as long as you have seen an example of the kind of document or the handwriting you are trying to copy.")
    override var language = 0
    override var instrument = 0

}