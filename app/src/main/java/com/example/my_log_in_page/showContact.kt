package com.example.my_log_in_page

import android.annotation.SuppressLint
import android.content.Intent
import android.database.Cursor
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.focus.focusModifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import com.example.my_log_in_page.ui.theme.My_Log_In_PageTheme


class showContact : ComponentActivity() {

    companion object {

        @SuppressLint("StaticFieldLeak")
        lateinit var contactDatabase: Database
    }

    @SuppressLint("UnusedMaterial3ScaffoldPaddingParameter", "UnrememberedMutableState", "NewApi")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        enableEdgeToEdge()

        contactDatabase = Database(applicationContext)

        setContent {
            My_Log_In_PageTheme {

                val allData = viewContact()


                Column(modifier = Modifier.fillMaxSize()) {

                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(100.dp)
                            .background(color = star.bcream)
                    ) {

                        Row(
                            horizontalArrangement = Arrangement.Center,
                            verticalAlignment = Alignment.Bottom,
                            modifier = Modifier
                                .height(75.dp)
                                .width(80.dp)
                        ) {

                            Image(
                                painter = painterResource(R.drawable.user),
                                contentDescription = null,
                                modifier = Modifier
                                    .height(30.dp)
                                    .width(30.dp)
                                    .clickable {

                                        val intent = Intent(this@showContact, DashBoard::class.java)
                                        startActivity(intent)

                                    }
                            )

                        }

                        Row(
                            horizontalArrangement = Arrangement.Center,
                            verticalAlignment = Alignment.Bottom,
                            modifier = Modifier
                                .height(80.dp)
                                .width(200.dp)
                        ) {

                            Text(text = "Contacts", fontSize = 40.sp, color = Color.White)

                        }

                        Row(
                            horizontalArrangement = Arrangement.Center,
                            verticalAlignment = Alignment.Bottom,
                            modifier = Modifier
                                .height(85.dp)
                                .width(200.dp)
                        ) {

                            Image(
                                painter = painterResource(R.drawable.more1),
                                contentDescription = null,
                                modifier = Modifier
                                    .height(40.dp)
                                    .width(40.dp)
                            )

                        }

                    }

                    Surface(
                        modifier = Modifier
                            .fillMaxSize()
                            .weight(2f)
                    ) {

                        Image(
                            painter = painterResource(R.drawable.dashbord1),
                            contentDescription = null,
                            contentScale = ContentScale.FillBounds
                        )

                        LazyVerticalGrid(
                            modifier = Modifier.padding(20.dp),
                            columns = GridCells.Fixed(1)
                        ) {

                            items(allData.size) { index ->

                                Surface(
                                    modifier = Modifier
                                        .height(180.dp)
                                        .width(120.dp)
                                        .padding(5.dp),
                                    color = star.contactback,
                                    shape = RoundedCornerShape(15.dp)
                                ) {

                                    Column(
                                        horizontalAlignment = Alignment.CenterHorizontally,
                                        modifier = Modifier.fillMaxSize()
                                    ) {

                                        Surface(
                                            modifier = Modifier
                                                .height(90.dp)
                                                .width(300.dp)
                                                .padding(10.dp),
                                            shape = RoundedCornerShape(10.dp),
                                            color = star.contact2
                                        ) {

                                            Column(
                                                horizontalAlignment = Alignment.CenterHorizontally,
                                                verticalArrangement = Arrangement.Center,
                                                modifier = Modifier.fillMaxSize()
                                            ) {

                                                Box(contentAlignment = Alignment.Center) {

                                                    Text(
                                                        text = "${allData[index].firstname} ${allData[index].surname}",
                                                        fontSize = 22.sp,
                                                        color = Color.Black
                                                    )

                                                }

                                                Box(contentAlignment = Alignment.Center) {

                                                    Text(
                                                        text = allData[index].number,
                                                        fontSize = 22.sp,
                                                        color = Color.Black
                                                    )

                                                }

                                            }

                                        }

                                        Row(
                                            horizontalArrangement = Arrangement.Center,
                                            verticalAlignment = Alignment.CenterVertically,
                                            modifier = Modifier
                                                .height(70.dp)
                                                .fillMaxWidth()
                                        ) {

                                            Surface(
                                                modifier = Modifier
                                                    .height(100.dp)
                                                    .padding(5.dp)
                                                    .clickable {

                                                        // edit

                                                        val intent = Intent(this@showContact , Edit_Page::class.java)
                                                        intent.putExtra("contactData" , allData[index])
                                                        startActivity(intent)

                                                    }
                                                    .width(95.dp),
                                                shape = RoundedCornerShape(10.dp),
                                                color = star.contact2
                                            ) {

                                                Image(
                                                    painter = painterResource(R.drawable.pencil),
                                                    contentDescription = null,
                                                    modifier = Modifier.padding(15.dp)
                                                )

                                            }

                                            Surface(
                                                modifier = Modifier
                                                    .height(100.dp)
                                                    .width(30.dp),
                                                color = star.contactback
                                            ) {

                                            }


                                            Surface(
                                                modifier = Modifier
                                                    .height(100.dp)
                                                    .padding(5.dp)
                                                    .clickable {

                                                        // delete

                                                        val intent = Intent(this@showContact , Edit_Page::class.java)
                                                        intent.putExtra("contactData" , allData[0])
                                                        startActivity(intent)

                                                    }
                                                    .width(95.dp),
                                                shape = RoundedCornerShape(10.dp),
                                                color = star.contact2
                                            ) {

                                                Image(
                                                    painter = painterResource(R.drawable.trash),
                                                    contentDescription = null,
                                                    modifier = Modifier.padding(15.dp)
                                                )

                                            }
                                        }

                                    }

                                }

                            }

                        }


                    }

                    Row(
                        modifier = Modifier
                            .height(70.dp)
                            .fillMaxWidth()
                            .background(color = star.bcream)
                    ) {

                        Box(
                            modifier = Modifier
                                .height(70.dp)
                                .width(260.dp)
                        ) {}

                        Box(
                            contentAlignment = Alignment.Center,
                            modifier = Modifier
                                .height(70.dp)
                                .width(100.dp)
                        )
                        {
                            Image(
                                painter = painterResource(R.drawable.plus),
                                contentDescription = null,
                                modifier = Modifier
                                    .height(60.dp)
                                    .width(60.dp)
                                    .clickable {

                                        val intent =
                                            Intent(this@showContact, AddContact::class.java)

                                        AddContact.name.value = ""
                                        AddContact.phonenumber.value = ""
                                        AddContact.surname.value = ""


                                        startActivity(intent)

                                    }
                            )
                        }

                    }
                }

            }

        }
    }

}


private fun viewContact(): ArrayList<ContactDetail> {

    val contactList = ArrayList<ContactDetail>()

    val cursor: Cursor =
        showContact.contactDatabase.readableDatabase.rawQuery("SELECT * FROM c_user", null)

    cursor.use {

        if (it.moveToFirst()) {

            do {
                val id = it.getInt(0)
                val firstname = it.getString(1)
                val number = it.getString(2)
                val surname = it.getString(3)
                val data = ContactDetail(
                    id = id,
                    firstname = firstname,
                    number = number,
                    surname = surname
                )

                contactList.add(data)

            } while (it.moveToNext())

        }
        return contactList
    }

}