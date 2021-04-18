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
            addNewItem(document, "Hit dice : $hitDice", Element.ALIGN_LEFT, valueStyle)

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
            for( i in ActivityScreen1.newCharacter.chSkills)
                addNewItemWithLeftAndRight(document, i.key.substring(3), if(i.value>=0)" +${i.value}" else "${i.value}", valueStyle, valueStyle)

            addLineSpace(document)

            addNewItem(document, "Saving throws  ", Element.ALIGN_LEFT, headingStyle)
            str = ActivityScreen1.newCharacter.chSavingThrows["strSave"]
            dex = ActivityScreen1.newCharacter.chSavingThrows["dexSave"]
            con = ActivityScreen1.newCharacter.chSavingThrows["conSave"]
            int = ActivityScreen1.newCharacter.chSavingThrows["intSave"]
            wis = ActivityScreen1.newCharacter.chSavingThrows["wisSave"]
            cha = ActivityScreen1.newCharacter.chSavingThrows["chaSave"]
            addNewItemWithLeftAndRight(document, "Strength : +$str ", "Dexterity : +$dex ", valueStyle, valueStyle)
            addNewItemWithLeftAndRight(document, "Constitution : +$con ", "Intelligence : +$int ", valueStyle, valueStyle)
            addNewItemWithLeftAndRight(document, "Wisdom : +$wis ", "Charisma : +$cha ", valueStyle, valueStyle)

            addLineSeparation(document)

            //other not important but important stuff
            val init = ActivityScreen1.newCharacter.chInitiative
            addNewItem(document, "Initiative : +$init", Element.ALIGN_LEFT, valueStyle)
            val pasPerc = ActivityScreen1.newCharacter.chPassivePerception
            addNewItem(document, "Passive percepcion : $pasPerc", Element.ALIGN_LEFT, valueStyle)
            val speed = ActivityScreen1.newCharacter.chSpeedWalk
            addNewItem(document, "Movement speed : $speed", Element.ALIGN_LEFT, valueStyle)
            //num of attacks TODO
            //armor, language, tools, weapon prof TODO


            //attacks TODO + spell list and st dc, prepare, spcasting ability

            //class and race traits TODO

            //inventory , money, potions, kits TODO

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