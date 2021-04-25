package com.example.rollforkotlin.ui.main.backgrounds

class Soldier() : BackgroundGeneral() {
    override var equipment = "An insignia of rank, a trophy taken from a fallen enemy (a dagger, broken blade, or piece of a banner), a set of bone dice or deck of cards, a set of common clothes, and a belt pouch containing 10gp"
    override var skillProfList = arrayListOf("strAthletics", "chaIntimidation")
    override var toolProfList = arrayListOf("One type of gaming set", "Vehicles")
    override var backgroundTraits = arrayListOf("Military Rank\n" +
            "You have a military rank from your career as a soldier. Soldiers loyal to your former military organization still recognize your authority and influence, and they defer to you if they are of a lower rank. You can invoke your rank to exert influence over other soldiers and requisition simple equipment or horses for temporary use. You can also usually gain access to friendly military encampments and fortresses where your rank is recognized.")
    override var language = 0
    override var instrument = 0
}