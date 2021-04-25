package com.example.rollforkotlin.ui.main.backgrounds

class Criminal() : BackgroundGeneral() {
    override var equipment = "A crowbar, a set of dark common clothes including a hood, and a belt pouch containing 15gp"
    override var skillProfList = arrayListOf("chaDeception", "dexStealth")
    override var toolProfList = arrayListOf("One gaming set", "Thieves' tools")
    override var backgroundTraits = arrayListOf("Criminal Contact\n" +
            "You have a reliable and trustworthy contact who acts as your liaison to a network of other criminals. You know how to get messages to and from your contact, even over great distances; specifically, you know the local messengers, corrupt caravan masters, and seedy sailors who can deliver messages for you.")
    override var language = 0
    override var instrument = 0

}