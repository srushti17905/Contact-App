package com.example.my_log_in_page

import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.util.Log
import android.widget.Toast

class Database(var context: Context) : SQLiteOpenHelper(context, "mydb.db", null, 1) {
    override fun onCreate(db: SQLiteDatabase?) {

        val table =
            "CREATE TABLE user ( ID INTEGER Primary key autoincrement ,username text , email text UNIQUE , number text , password text)"
        db?.execSQL(table)

        val c_table =
            "CREATE TABLE c_user (ID INTEGER Primary key autoincrement , name text , contact  UNIQUE , surname text)"
        db?.execSQL(c_table)

    }

    override fun onUpgrade(p0: SQLiteDatabase?, p1: Int, p2: Int) {
        TODO("Not yet implemented")
    }

    fun insertdata(
        username: String,
        email: String,
        number: String,
        pass: String
    ) {

        val insert =
            "INSERT INTO user (username , email , number , password) VALUES ('$username' , '$email' , '$number' , '$pass')"

        try {

            writableDatabase.execSQL(insert)

        } catch (e: Exception) {

            Toast.makeText(context, "plz fill the detail", Toast.LENGTH_SHORT).show()
            Log.d("===>", "insertdata: ${e.localizedMessage}")

        }
    }

    fun c_insertdata(name: String, pnumber: String, surname: String) {

        val c_insert =
            "INSERT INTO c_user (name , contact , surname) VALUES ('$name' , '$pnumber' , '$surname')"

        try {
            writableDatabase.execSQL(c_insert)
        } catch (e: Exception) {
            Log.d("===>", "c_insertdata: ${e.localizedMessage}")
        }

    }


    fun selectData(username: String, pass: String): Cursor {

        val select = "SELECT * FROM user WHERE username = '$username' AND  password = '$pass'"
        val cursur = readableDatabase.rawQuery(select, null)
        return cursur

    }

    fun contactSelect(name: String, surname: String, number: String): Cursor {
        val contactSelect =
            "SELECT * FROM c_user WHERE name = '$name' AND contact = '$number' AND surname = '$surname'"
        val contactCursor = readableDatabase.rawQuery(contactSelect, null)
        return contactCursor
    }


    fun updateData(id: Int, newUsername: String, newNumber: String, newSurname: String) {

        val update =
            "UPDATE c_user SET name = '$newUsername' , contact = '$newNumber' , surname = '$newSurname' WHERE ID = '$id'"
        writableDatabase.execSQL(update)

    }

    fun deleteContact(id: Int) {

        val delete = "DELETE FROM c_user WHERE ID = '$id'"
        writableDatabase.execSQL(delete)

    }


}