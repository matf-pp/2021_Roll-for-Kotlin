package com.example.rollforkotlin

import android.app.Activity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.itextpdf.text.*
import com.itextpdf.text.pdf.BaseFont
import com.itextpdf.text.pdf.PdfWriter
import com.itextpdf.text.pdf.draw.LineSeparator
import com.itextpdf.text.pdf.parser.LineSegment
import kotlinx.android.synthetic.main.activity_finish.*
import java.util.*

import com.karumi.dexter.Dexter
import com.karumi.dexter.PermissionToken
import com.karumi.dexter.listener.PermissionDeniedResponse
import com.karumi.dexter.listener.PermissionGrantedResponse
import com.karumi.dexter.listener.PermissionRequest
import com.karumi.dexter.listener.single.PermissionListener
import java.io.File
import java.io.FileOutputStream
import java.time.LocalDate
import java.time.LocalDateTime
import java.time.format.DecimalStyle
import java.util.jar.Manifest


class FinishActivity : AppCompatActivity() {

    val file_name : String = "character.pdf"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_finish)


        btnProba.setOnClickListener {
            createPDFFile(Common.getAppPath(this@FinishActivity) + file_name)
        }

        Dexter.withActivity(this).
                withPermission(android.Manifest.permission.WRITE_EXTERNAL_STORAGE).
                withListener(object :PermissionListener{
                    override fun onPermissionGranted(response: PermissionGrantedResponse?) {


                    }

                    override fun onPermissionRationaleShouldBeShown(permission: PermissionRequest?, token: PermissionToken?) {

                    }

                    override fun onPermissionDenied(response: PermissionDeniedResponse?) {

                    }
                })



    }

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

            val colorAccent = BaseColor(0, 153, 204, 255)
            val headingFontSize = 20.0f
            val valueFontSize = 26.0f

            //Custom font

            val fontName = BaseFont.createFont("res/font/percy_goth.ttf", "UTF-8", BaseFont.EMBEDDED)

            //Add title to document

            val titleStyle = Font(fontName, 36.0f, Font.NORMAL, BaseColor.BLACK)
            addNewItem(document, "Character D&D", Element.ALIGN_CENTER, titleStyle)

            val headingStyle = Font(fontName, headingFontSize, Font.NORMAL, colorAccent)
            addNewItem(document, "Character No:", Element.ALIGN_LEFT, headingStyle)
            val valueStyle = Font(fontName, valueFontSize, Font.NORMAL, BaseColor.BLACK)
            addNewItem(document, "#1", Element.ALIGN_LEFT, valueStyle)

            addLineSeparation(document)

            addNewItem(document, "Date", Element.ALIGN_LEFT, valueStyle)
            addNewItem(document, "15.04.2021", Element.ALIGN_LEFT, valueStyle)
            //LocalDateTime.now().toString() TODO

            addLineSeparation(document)


            document.close()

            Toast.makeText(this@FinishActivity, "Success", Toast.LENGTH_SHORT).show()

          //  savePDF()


        }
        catch (e : Exception){
            Log.e("", e.message)
        }
    }

    private fun savePDF() {
        //
    }

    private fun addLineSeparation(document: Document) {
        val lineSeparator = LineSeparator()
        lineSeparator.lineColor = BaseColor(0,0,0,68)
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