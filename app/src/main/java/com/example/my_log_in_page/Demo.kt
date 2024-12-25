import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.health.connect.datatypes.units.Length
import android.widget.Toast

class demo(var context: Context) : SQLiteOpenHelper(context, "mydb.db", null, 1) {
    override fun onCreate(db: SQLiteDatabase?) {

        val table =
            "CREATE TABLE user (ID INTEGER Primary key autoincrement , username text , email text , number text , password text)"
        db?.execSQL(table)

    }

    override fun onUpgrade(p0: SQLiteDatabase?, p1: Int, p2: Int) {
        TODO("Not yet implemented")
    }

    fun insert(username: String, email: String, number: String, password: String) {

        val insertData =
            "INSERT INTO user (username , email , number , password) VALUES ('$username' , '$email' , '$number' , '$password')"

        try {
            writableDatabase.execSQL(insertData)
        }catch (e : Exception) {

            Toast.makeText(context , "pls fill the fdetail" , Toast.LENGTH_SHORT).show()

        }

    }

    fun select(username : String , pass : String) : Cursor{

        val select =  "SELECT * FROM user WHERE username = '$username' AND '$pass'"
        val cursur = readableDatabase.rawQuery(select , null)
        return cursur

    }


}