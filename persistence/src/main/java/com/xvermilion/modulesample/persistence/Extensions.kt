package com.xvermilion.modulesample.persistence

import android.content.Context
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import java.io.BufferedReader
import java.io.IOException
import java.io.InputStreamReader

fun RoomDatabase.runInTransactionAsync(body: suspend () -> Unit) {
    runInTransaction {
        GlobalScope.launch(Dispatchers.IO) {
            body()
        }
    }
}

fun SupportSQLiteDatabase.execFromRaw(context: Context, fileId: Int) {
    try {
        val input = context.resources.openRawResource(fileId)
        val reader = BufferedReader(InputStreamReader(input))
        val sqlScript = StringBuilder()

        while (reader.ready())
            sqlScript.append(reader.readLine())
        val s = sqlScript.toString()
        execSQL(s)
    } catch (e: IOException) {
        e.printStackTrace()
    }
}