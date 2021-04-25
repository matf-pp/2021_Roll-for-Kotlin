package com.example.rollforkotlin.ui.main.backgrounds

class Entertainer() : BackgroundGeneral() {
    override var equipment = "The favor of an admirer (love letter, lock of hair, or trinket), a costume, and a belt pouch containing 15gp"
    override var skillProfList = arrayListOf("dexAcrobatics", "chaPerformance")
    override var toolProfList = arrayListOf("Disguise kit")
    override var backgroundTraits = arrayListOf("By Popular Demand\n" +
            "You can always find a place to perform, usually in an inn or tavern but possibly with a circus, at a theater, or even in a noble's court. At such a place, you receive free lodging and food of a modest or comfortable standard (depending on the quality of the establishment), as long as you perform each night. In addition, your performance makes you something of a local figure. When strangers recognize you in a town where you have performed, they typically take a liking to you.")
    override var language = 0
    override var instrument = 1

}