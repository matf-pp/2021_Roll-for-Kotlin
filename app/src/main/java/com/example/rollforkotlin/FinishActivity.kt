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
            val headingFontSize = 20.0f
            val valueFontSize = 20.0f

            //Custom font

            val fontName = BaseFont.createFont(
                "res/font/percy_goth.ttf",
                "UTF-8",
                BaseFont.EMBEDDED
            )

            //Add title to document

            val titleStyle = Font(fontName, 32.0f, Font.NORMAL, BaseColor.BLACK)
            addNewItem(document, "Character DnD", Element.ALIGN_CENTER, titleStyle)

            addLineSeparation(document)

            val headingStyle = Font(fontName, headingFontSize, Font.NORMAL, colorAccent)
            addNewItem(document, "Character No: #1", Element.ALIGN_LEFT, headingStyle)
            val valueStyle = Font(fontName, valueFontSize, Font.NORMAL, BaseColor.BLACK)
         //   addNewItem(document, "#1", Element.ALIGN_LEFT, valueStyle)

            addLineSeparation(document)

            val datum = LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd.MM.yyyy"))

            addNewItem(document, "Date : $datum", Element.ALIGN_LEFT, valueStyle)

            addLineSeparation(document)



            //TODO dodavati elemente klase provera uslova postoje li ili ne
            val name = ActivityScreen1.newCharacter.chName
            addNewItem(document, "Name : $name ", Element.ALIGN_LEFT, valueStyle)




            addLineSeparation(document)


            document.close()

            //dodati da ispisuje path umesto success
            Toast.makeText(this@FinishActivity, path, Toast.LENGTH_SHORT).show()

          //  savePDF()


        }
        catch (e: Exception){
            Log.e("", e.message)
        }
    }

    private fun savePDF() {
        //
    }

    private fun addLineSeparation(document: Document) {
        val lineSeparator = LineSeparator()
        lineSeparator.lineColor = BaseColor(0, 0, 0, 68)
        addLineSpace(document)
        document.add(Chunk(lineSeparator))
        addLineSpace(document)
    }

    private fun addLineSpace(document: Document) {
        document.add(Paragraph(""))

    }

    @Throws(DocumentException::class)
    private fun addNewItem(document: Document, text: String, align: Int, style: Font) {
        val chunk = Chunk(text, style)
        val p = Paragraph(chunk)
        p.alignment = align
        document.add(p)

    }


}