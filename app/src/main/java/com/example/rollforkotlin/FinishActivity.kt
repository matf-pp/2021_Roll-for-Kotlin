package com.example.rollforkotlin

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import com.androidbuffer.kotlinfilepicker.*
import com.itextpdf.text.*
import com.itextpdf.text.pdf.BaseFont
import com.itextpdf.text.pdf.PdfWriter
import com.itextpdf.text.pdf.draw.LineSeparator
import com.itextpdf.text.pdf.draw.VerticalPositionMark
import com.karumi.dexter.Dexter
import com.karumi.dexter.PermissionToken
import com.karumi.dexter.listener.PermissionDeniedResponse
import com.karumi.dexter.listener.PermissionGrantedResponse
import com.karumi.dexter.listener.PermissionRequest
import com.karumi.dexter.listener.single.PermissionListener
import kotlinx.android.synthetic.main.activity_finish.*
import java.io.File
import java.io.FileOutputStream
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import java.util.*


class FinishActivity : AppCompatActivity() {

    val file_name : String = "character.pdf"


    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_finish)


        btnSave.setOnClickListener {
            val putanja : String = Common.getAppPath(this@FinishActivity) + file_name
            lbThankYou.text =  "Thank you for using our app ! \n Your file is saved at : \n\n $putanja"
            createPDFFile(Common.getAppPath(this@FinishActivity) + file_name)
        }

        Dexter.withActivity(this).
                withPermission(android.Manifest.permission.WRITE_EXTERNAL_STORAGE).
                withListener(object : PermissionListener {
                    override fun onPermissionGranted(response: PermissionGrantedResponse?) {
                    }

                    override fun onPermissionRationaleShouldBeShown(
                        permission: PermissionRequest?,
                        token: PermissionToken?
                    ) {

                    }

                    override fun onPermissionDenied(response: PermissionDeniedResponse?) {
                    }
                })

    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (requestCode == 111 && resultCode == RESULT_OK) {
            val selectedFile = data?.data //The uri with the location of the file
        }
    }

    @RequiresApi(Build.VERSION_CODES.O)
    private fun createPDFFile(path: String) {
            if(File(path).exists())
                File(path).delete()
        try {
            val document = Document()
            //Save
            PdfWriter.getInstance(document, FileOutputStream(path))
            //open to write
            document.open()

            //setting
            document.pageSize = PageSize.A4
            document.addCreationDate()
            document.addAuthor("Avanturisti")
            document.addCreator("Tatjana Knezevic")
            document.addCreator("Divna Micic")
            document.addCreator("Aleksandar Sarbajic")

            //Font Setting

            val colorAccent = BaseColor(150, 14, 14, 255)
            val headingFontSize = 32.0f
            val valueFontSize = 28.0f

            //Custom font
            val fontName = BaseFont.createFont(
                "res/font/percy_goth.ttf",
                "UTF-8",
                BaseFont.EMBEDDED
            )
            val fontName2 = BaseFont.createFont(
                    "res/font/augusta.ttf",
                    "UTF-8",
                    BaseFont.EMBEDDED
            )

            //Add title to document
            val titleStyle = Font(fontName, 32.0f, Font.NORMAL, BaseColor.BLACK)
            addNewItem(document, "Character DnD", Element.ALIGN_CENTER, titleStyle)
            addLineSpace(document)

            //header
            val headingStyle = Font(fontName2, headingFontSize, Font.NORMAL, colorAccent)
            //date
            val datum = LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd.MM.yyyy"))
            val valueStyle = Font(fontName2, valueFontSize, Font.NORMAL, BaseColor.BLACK)
            val redValueStyle = Font(fontName2, valueFontSize, Font.NORMAL, colorAccent)

            addNewItemWithLeftAndRight(document, "Character No: #1", "Date : $datum", redValueStyle, valueStyle)
            addLineSeparation(document)


            //TODO dodavati elemente klase provera uslova postoje li ili ne

            //name and level
            addNewItem(document, "Character level, race, & class", Element.ALIGN_LEFT, headingStyle)
            val name = ActivityScreen1.newCharacter.chName
            val lvl = ActivityScreen1.newCharacter.chLevel
            addNewItemWithLeftAndRight(document, "Name : $name ", "Level : $lvl ", valueStyle, valueStyle)
            //race class
            val klasa = ActivityScreen1.newCharacter.chClass
            val race = ActivityScreen1.newCharacter.chRace
            addNewItemWithLeftAndRight(document, "Race : $race ", "Class : $klasa ", valueStyle, valueStyle)
            //backgroung gender
            val background = ActivityScreen1.newCharacter.chBackgroud
            val gender = ActivityScreen1.newCharacter.chGender
            addNewItemWithLeftAndRight(document, "Background : $background ", "Gender : $gender ", valueStyle, valueStyle)

            addLineSeparation(document)

            //important font
            val importantStyle = Font(fontName2, 32.0f, Font.NORMAL, colorAccent)
            val  ac = ActivityScreen1.newCharacter.chArmorClass
            val hp = ActivityScreen1.newCharacter.chMaxHP
            addNewItemWithLeftAndRight(document, "HP : $hp ", "AC : $ac ", importantStyle, importantStyle)
            val hitDice = ActivityScreen1.newCharacter.chHitDice
            val armor = ActivityScreen1.newCharacter.chArmor.split(" ")
            var arm = ""
            if(armor.size > 4)
                arm = armor[1] + " " + armor[2]
            else
                arm = armor[1]
            addNewItemWithLeftAndRight(document, "Hit dice : $hitDice", "Armor : $arm ", valueStyle, valueStyle)

            addLineSeparation(document)

            //abilities and skills
            val prof = ActivityScreen1.newCharacter.chProficiencyBonus
            addNewItemWithLeftAndRight(document, "Abilities & skills ", "Proficency : +$prof", headingStyle, valueStyle)
            var str = ActivityScreen1.newCharacter.chAbilities["str"]
            var dex = ActivityScreen1.newCharacter.chAbilities["dex"]
            var con = ActivityScreen1.newCharacter.chAbilities["con"]
            var int = ActivityScreen1.newCharacter.chAbilities["int"]
            var wis = ActivityScreen1.newCharacter.chAbilities["wis"]
            var cha = ActivityScreen1.newCharacter.chAbilities["cha"]
            addNewItemWithLeftAndRight(document, "Strength : $str ", "Dexterity : $dex", importantStyle, importantStyle)
            addNewItemWithLeftAndRight(document, "Constitution : $con ", "Intelligence : $int", importantStyle, importantStyle)
            addNewItemWithLeftAndRight(document, "Wisdom : $wis ", "Charisma : $cha", importantStyle, importantStyle)
            addLineSpace(document)
            for( i in ActivityScreen1.newCharacter.chSkills) {
                if (ActivityScreen1.newCharacter.chSkillProfs[i.key] != 0 && ActivityScreen1.newCharacter.chSkillExp[i.key] != 0) {
                    addNewItemWithLeftAndRight(document, i.key.substring(3) + "**", if (i.value >= 0) " +${i.value}" else "${i.value}", valueStyle, valueStyle)
                }
                else if(ActivityScreen1.newCharacter.chSkillProfs[i.key] != 0)
                    addNewItemWithLeftAndRight(document, i.key.substring(3) + "*", if (i.value >= 0) " +${i.value}" else "${i.value}", valueStyle, valueStyle)
                else
                    addNewItemWithLeftAndRight(document, i.key.substring(3) , if (i.value >= 0) " +${i.value}" else "${i.value}", valueStyle, valueStyle)
            }

            addLineSpace(document)

            addNewItem(document, "Saving throws  ", Element.ALIGN_LEFT, headingStyle)
            str = ActivityScreen1.newCharacter.chSavingThrows["strSave"]
            dex = ActivityScreen1.newCharacter.chSavingThrows["dexSave"]
            con = ActivityScreen1.newCharacter.chSavingThrows["conSave"]
            int = ActivityScreen1.newCharacter.chSavingThrows["intSave"]
            wis = ActivityScreen1.newCharacter.chSavingThrows["wisSave"]
            cha = ActivityScreen1.newCharacter.chSavingThrows["chaSave"]
            addNewItemWithLeftAndRight(document, "Strength : " + if(str!! >=0) "+$str" else "$str" , "Dexterity : " +  if(dex!! >=0) "+$dex" else "$dex", valueStyle, valueStyle)
            addNewItemWithLeftAndRight(document, "Constitution : "+ if(con!! >=0) "+$con" else "$con", "Intelligence : "+ if(int!! >=0) "+$int" else "$int", valueStyle, valueStyle)
            addNewItemWithLeftAndRight(document, "Wisdom : "+ if(wis!! >=0) "+$wis" else "$wis" , "Charisma : "+ if(cha!! >=0) "+$cha" else "$cha", valueStyle, valueStyle)

            addLineSeparation(document)

            //other not important but important stuff
            val init = ActivityScreen1.newCharacter.chInitiative
            addNewItem(document, "Initiative : +$init", Element.ALIGN_LEFT, valueStyle)
            val pasPerc = ActivityScreen1.newCharacter.chPassivePerception
            addNewItem(document, "Passive percepcion : $pasPerc", Element.ALIGN_LEFT, valueStyle)
            val speed = ActivityScreen1.newCharacter.chSpeed["walk"]
            addNewItem(document, "Movement speed : $speed", Element.ALIGN_LEFT, valueStyle)

            addLineSeparation(document)

            //num of attacks TODO
            addNewItem(document, "Attacks", Element.ALIGN_LEFT, headingStyle)
            var w = ""
            for(weapon1 in ActivityScreen1.newCharacter.chWeapons){
                w = weapon1
                val w2 = ActivityScreen1.newCharacter.chWeaponRange[w]
                val w3 = ActivityScreen1.newCharacter.chWeaponToHitBonus[w]
                val w4 = ActivityScreen1.newCharacter.weaponDamageMap[w]
                val w5 = ActivityScreen1.newCharacter.chWeaponDamageBonus[w]
                val w6 = ActivityScreen1.newCharacter.weaponDagameTypeMap[w]

                w = "$w $w2"
                w = "$w   to hit " + if (w3!! >= 0) "+$w3" else "$w3"
                w = "$w $w4"
                w = "$w" + if (w5!! >= 0) "+$w5" else "$w5"
                w = "$w $w6"

                addNewItem(document,  w, Element.ALIGN_LEFT, valueStyle)
            }

            addLineSeparation(document)

            //armor, language, tools, weapon prof TODO
            addNewItem(document, "Proficiencies", Element.ALIGN_LEFT, headingStyle)
            val armorProf = ActivityScreen1.newCharacter.chArmorProf
            addNewItem(document, "Armor proficency : $armorProf", Element.ALIGN_LEFT, valueStyle)
            val weapProf = ActivityScreen1.newCharacter.chWeaponProfTypes
            addNewItem(document, "Weapon proficency : $weapProf", Element.ALIGN_LEFT, valueStyle)
            val toolProf = ActivityScreen1.newCharacter.chToolProf
            addNewItem(document, "Tool proficency : $toolProf", Element.ALIGN_LEFT, valueStyle)

            addLineSeparation(document)

            //spell attacks
            addNewItem(document, "Spells", Element.ALIGN_LEFT, headingStyle)
            val spellCast = ActivityScreen1.newCharacter.chSpellCastingAbility
            addNewItem(document, "Spellcasting ability : $spellCast", Element.ALIGN_LEFT, valueStyle)
            val spellBonus = ActivityScreen1.newCharacter.chSpellAttackBonus
            addNewItem(document, "Spell attack bonus : "+ if(spellBonus!! >=0) "+$spellBonus" else "$spellBonus" , Element.ALIGN_LEFT, valueStyle)
            val spellDC = ActivityScreen1.newCharacter.chSpellSaveDC
            addNewItem(document, "Saving throw DC : $spellDC", Element.ALIGN_LEFT, valueStyle)
            if(klasa == "Cleric") {
                val prepare = ActivityScreen1.newCharacter.chSpellLvl1Counter + ActivityScreen1.newCharacter.chSpellLvl2Counter + ActivityScreen1.newCharacter.chSpellLvl3Counter
                addNewItem(document, "Prepare : $prepare", Element.ALIGN_LEFT, valueStyle)
            }
            addNewItem(document, "Cantrips :", Element.ALIGN_LEFT, redValueStyle)
            val cantrip = ActivityScreen1.newCharacter.chSpellCantripList.joinToString(", ")
            addNewItem(document,  cantrip, Element.ALIGN_LEFT, valueStyle)
            addNewItem(document, "1st lvl spells :", Element.ALIGN_LEFT, redValueStyle)
            val first = ActivityScreen1.newCharacter.chSpellLvl1List.joinToString(", ")
            addNewItem(document,  first, Element.ALIGN_LEFT, valueStyle)
            addNewItem(document, "2nd lvl spells :", Element.ALIGN_LEFT, redValueStyle)
            val second = ActivityScreen1.newCharacter.chSpellLvl2List.joinToString(", ")
            addNewItem(document,  second, Element.ALIGN_LEFT, valueStyle)
            addNewItem(document, "3rd lvl spells :", Element.ALIGN_LEFT, redValueStyle)
            val third = ActivityScreen1.newCharacter.chSpellLvl3List.joinToString(", ")
            addNewItem(document,  third, Element.ALIGN_LEFT, valueStyle)


            addLineSeparation(document)

            //class and race traits TODO
            addNewItem(document, "Class, race & background traits", Element.ALIGN_LEFT, headingStyle)
            val classTraits = ActivityScreen1.newCharacter.chClassTraits.joinToString("\n")
            addNewItem(document, "Class traits ", Element.ALIGN_LEFT, redValueStyle)
            addNewItem(document, classTraits, Element.ALIGN_LEFT, valueStyle)
          /*  val raceTraits = ActivityScreen1.newCharacter.chRacialTraits.joinToString("\n")
            addNewItem(document, "Racial traits ", Element.ALIGN_LEFT, redValueStyle)
            addNewItem(document, raceTraits, Element.ALIGN_LEFT, valueStyle)*/
            val bckgTraits = ActivityScreen1.newCharacter.chBackgroundTraits.joinToString("\n")
            addNewItem(document, "Background traits", Element.ALIGN_LEFT, redValueStyle)
            addNewItem(document, bckgTraits, Element.ALIGN_LEFT, valueStyle)

            addLineSeparation(document)

            //inventory , money, potions, kits TODO
            addNewItem(document, "Equipment", Element.ALIGN_LEFT, headingStyle)
            val gp = ActivityScreen1.newCharacter.chGold
            val pp = ActivityScreen1.newCharacter.chPlatinum
            val sp = ActivityScreen1.newCharacter.chSilver
            val cp = ActivityScreen1.newCharacter.chCopper
            addNewItemWithLeftAndRight(document, "Platinum : $pp" , "Gold : $gp", importantStyle, importantStyle)
            addNewItemWithLeftAndRight(document, "Silver : $sp" , "Copper : $cp", importantStyle, importantStyle)
            if(ActivityScreen1.newCharacter.chHasPotion)
                addNewItem(document, "Healing potion : 1d4 + 4", Element.ALIGN_LEFT, valueStyle)
            val equip = ActivityScreen1.newCharacter.chEquipment
            addNewItem(document, "Inventory : $equip", Element.ALIGN_LEFT, valueStyle)
            val instru = ActivityScreen1.newCharacter.chInstruments.joinToString(", ")
            addNewItem(document, "Instruments : $instru", Element.ALIGN_LEFT, valueStyle)


            //spells and cantrips details TODO

            //background, traits, description, deity, organisaton.. TODO
            addLineSeparation(document)

            addNewItem(document, "Character details & other", Element.ALIGN_LEFT, headingStyle)
            val deity = ActivityScreen1.newCharacter.chDeity
            addNewItem(document, "Deity : $deity", Element.ALIGN_LEFT, valueStyle)
            val appearance = ActivityScreen1.newCharacter.chAppearance
            addNewItem(document, "Appearance : $appearance", Element.ALIGN_LEFT, valueStyle)
            val info = ActivityScreen1.newCharacter.chAdditionalInfo
            addNewItem(document, "Additional info : $info", Element.ALIGN_LEFT, valueStyle)
            val story = ActivityScreen1.newCharacter.chBackstory
            addNewItem(document, "Backstory : $story", Element.ALIGN_LEFT, valueStyle)


            document.close()

            //dodati da ispisuje path umesto success
            Toast.makeText(this@FinishActivity, path, Toast.LENGTH_SHORT).show()

        }
        catch (e: Exception){
            Log.e("", e.message)
        }
    }

    @Throws(DocumentException::class)
    private fun addNewItemWithLeftAndRight(document: Document, textLeft: String, textRight: String, leftStyle: Font, rightStyle: Font) {
        val chunkTextLeft = Chunk(textLeft, leftStyle)
        val chunkTextRight = Chunk(textRight, rightStyle)
        val p = Paragraph(chunkTextLeft)
        p.add(Chunk(VerticalPositionMark()))
        p.add(chunkTextRight)
        document.add(p)
    }

    @Throws(DocumentException::class)
    private fun addLineSeparation(document: Document) {
        val lineSeparator = LineSeparator()
        lineSeparator.lineColor = BaseColor(150, 14, 14, 68)
        addLineSpace(document)
        document.add(Chunk(lineSeparator))
        addLineSpace(document)
    }

    @Throws(DocumentException::class)
    private fun addLineSpace(document: Document) {
        document.add(Paragraph("\n"))
    }

    @Throws(DocumentException::class)
    private fun addNewItem(document: Document, text: String, align: Int, style: Font) {
        val chunk = Chunk(text, style)
        val p = Paragraph(chunk)
        p.alignment = align
        document.add(p)

    }


}