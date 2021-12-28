package com.afaf.notesaveretrieve

import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.util.Log

class DBHelper(ctx: Context): SQLiteOpenHelper(ctx, "notes.db", null, 2) {

    private val sqLite: SQLiteDatabase = writableDatabase
    private val sqLiteRead: SQLiteDatabase = readableDatabase


    override fun onCreate(db: SQLiteDatabase?) {
        db?.execSQL("create table notes (note Text)")
    }

    override fun onUpgrade(db: SQLiteDatabase?, p1: Int, p2: Int) {
        db!!.execSQL("DROP TABLE IF EXISTS notes")
        onCreate(db)
    }

    fun addNotes(note: String): Long{
        val cv = ContentValues()
        cv.put("note", note)
        val su = sqLite.insert("notes", null, cv)
        return su
    }

    fun retrieveNotes(): MutableList<String>{
        val res = mutableListOf<String>()

        val c: Cursor = sqLiteRead.rawQuery("select * from notes", null)
        c.moveToFirst()
        res.add(c.getString(0).toString())
        while (c.moveToNext()){
            res.add(c.getString(0))
        }

        return res
    }

}