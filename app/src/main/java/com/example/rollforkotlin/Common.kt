package com.example.rollforkotlin

import android.content.Context
import java.io.File

object Common {

    fun getAppPath(context: Context) :String{

       /* val path: File = android.os.Environment.getExternalStorageDirectory()

        val file = File(path, "character.pdf")*/

      /* val dir = File(
            android.os.Environment.getExternalStorageDirectory().toString()
                    + File.separator
                    + context.resources.getString(R.string.app_name)
                    + File.separator
        )*/

        val dir = File(
            context.getExternalFilesDir(null).toString()
                    + File.separator
                    + context.resources.getString(R.string.app_name)
                    + File.separator)
        if(!dir.exists())
            dir.mkdirs()
        return  dir.path+File.separator
    }
}