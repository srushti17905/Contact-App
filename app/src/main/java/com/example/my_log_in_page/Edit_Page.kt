package com.example.my_log_in_page

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.provider.ContactsContract.Data
import android.util.Log
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.annotation.RequiresApi
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.focusModifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.modifier.modifierLocalMapOf
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import com.example.my_log_in_page.ui.theme.My_Log_In_PageTheme

class Edit_Page : ComponentActivity() {
    @RequiresApi(Build.VERSION_CODES.TIRAMISU)
    @SuppressLint("UnrememberedMutableState")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val data = intent.getSerializableExtra("contactData", ContactDetail::class.java)
        val deleteContact = mutableStateOf(false)

        enableEdgeToEdge()

        val username = mutableStateOf("")
        val surname = mutableStateOf("")
        val number = mutableStateOf("")

        setContent {
            My_Log_In_PageTheme {

                if (deleteContact.value) {

                    Dialog(onDismissRequest = { deleteContact.value = false }) {

                        Surface(
                            modifier = Modifier
                                .height(180.dp)
                                .width(250.dp),
                            color = star.contactback,
                            shape = RoundedCornerShape(10.dp)
                        ) {
                            Surface(
                                modifier = Modifier
                                    .height(160.dp)
                                    .width(230.dp)
                                    .padding(5.dp),
                                shape = RoundedCornerShape(10.dp),
                                color = star.bcream
                            ) {

                                Column(modifier = Modifier.fillMaxSize()) {

                                    Row(
                                        horizontalArrangement = Arrangement.Center,
                                        verticalAlignment = Alignment.CenterVertically,
                                        modifier = Modifier
                                            .height(70.dp)
                                            .fillMaxWidth()
                                    ) {

                                        Text(
                                            text = "Delete This Contact ?",
                                            fontSize = 20.sp,
                                            color = Color.White
                                        )

                                    }

                                    HorizontalDivider(
                                        modifier = Modifier,
                                        thickness = 15.dp,
                                        color = star.bcream
                                    )

                                    Row(
                                        modifier = Modifier
                                            .height(100.dp)
                                            .fillMaxWidth()
                                    ) {

                                        Surface(
                                            modifier = Modifier
                                                .height(80.dp)
                                                .width(120.dp), color = star.bcream
                                        ) {

                                            Button(
                                                onClick = {
                                                    deleteContact.value = false
                                                },
                                                modifier = Modifier
                                                    .height(20.dp)
                                                    .width(20.dp)
                                                    .padding(15.dp),
                                                shape = RoundedCornerShape(30.dp),
                                                colors = ButtonDefaults.buttonColors(star.contactback)
                                            ) {
                                                Text(text = "Cancel")
                                            }

                                        }
                                        Surface(
                                            modifier = Modifier
                                                .height(80.dp)
                                                .width(120.dp),
                                            color = star.bcream
                                        ) {
                                            Button(
                                                onClick = {

                                                    val deleteData = Database(applicationContext)
                                                    deleteData.deleteContact(id = data!!.id)

                                                    Toast.makeText(
                                                        this@Edit_Page,
                                                        "Delete SuccessFully",
                                                        Toast.LENGTH_LONG
                                                    ).show()

                                                    val intent = Intent(this@Edit_Page, showContact::class.java)
                                                    startActivity(intent)
                                                    finish()

                                                },
                                                modifier = Modifier
                                                    .height(20.dp)
                                                    .width(20.dp)
                                                    .padding(15.dp),
                                                shape = RoundedCornerShape(30.dp),
                                                colors = ButtonDefaults.buttonColors(star.contactback)
                                            ) {
                                                Text(text = "Delete")
                                            }

                                        }
                                    }

                                }
                            }
                        }

                    }

                }

                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .background(color = star.contact2)
                ) {

                    Row(
                        horizontalArrangement = Arrangement.Center,
                        verticalAlignment = Alignment.Bottom,
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(80.dp)
                            .background(color = star.bcream)
                    ) {
                        Text(text = "Edit & Delete", fontSize = 30.sp, color = Color.White)
                    }

                    Row(
                        modifier = Modifier
                            .height(30.dp)
                            .fillMaxWidth()
                            .background(color = star.bcream)
                    ) {

                    }


                    Row(
                        horizontalArrangement = Arrangement.Center,
                        verticalAlignment = Alignment.CenterVertically,
                        modifier = Modifier
                            .height(150.dp)
                            .fillMaxWidth()
                    ) {

                        Image(
                            painter = painterResource(R.drawable.edit),
                            contentDescription = null,
                            modifier = Modifier
                                .height(60.dp)
                                .width(60.dp)
                        )
                    }



                    Row(
                        horizontalArrangement = Arrangement.Center,
                        verticalAlignment = Alignment.CenterVertically,
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(100.dp)
                    ) {

                        TextField(
                            value = username.value,
                            onValueChange = { username.value = it },
                            modifier = Modifier
                                .height(50.dp)
                                .width(270.dp),
                            label = { Text(text = "Edit Name") },
                            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text),
                            textStyle = TextStyle(Color.Black),
                            colors = TextFieldDefaults.colors(
                                focusedContainerColor = Color.Transparent,
                                unfocusedContainerColor = Color.Transparent,
                                unfocusedIndicatorColor = Color.Black,
                                focusedIndicatorColor = star.bcream,
                                focusedLabelColor = Color.Black,
                                unfocusedLabelColor = star.bcream, cursorColor = Color.Black
                            ), minLines = 1, maxLines = 1
                        )
                    }

                    Row(
                        horizontalArrangement = Arrangement.Center,
                        verticalAlignment = Alignment.CenterVertically,
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(100.dp)
                    ) {

                        TextField(
                            value = number.value,
                            onValueChange = { number.value = it },
                            modifier = Modifier
                                .height(50.dp)
                                .width(270.dp),
                            label = { Text(text = "Edit Number") },
                            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                            textStyle = TextStyle(Color.Black),
                            colors = TextFieldDefaults.colors(
                                focusedContainerColor = Color.Transparent,
                                unfocusedContainerColor = Color.Transparent,
                                unfocusedIndicatorColor = Color.Black,
                                focusedIndicatorColor = star.bcream,
                                focusedLabelColor = Color.Black,
                                unfocusedLabelColor = star.bcream, cursorColor = Color.Black
                            ), minLines = 1, maxLines = 1
                        )

                    }

                    Row(
                        horizontalArrangement = Arrangement.Center,
                        verticalAlignment = Alignment.Bottom,
                        modifier = Modifier
                            .height(90.dp)
                            .fillMaxWidth()
                    ) {

                        Button(
                            onClick = {

                                val contactData = Database(applicationContext)
                                contactData.updateData(
                                    id = data!!.id,
                                    newUsername = username.value,
                                    newNumber = number.value,
                                    newSurname = surname.value
                                )

                                if (username.value != "" && number.value != "") {

                                    val intent = Intent(this@Edit_Page, showContact::class.java)
                                    startActivity(intent)

                                }
                            },
                            modifier = Modifier
                                .height(50.dp)
                                .width(100.dp),
                            shape = RoundedCornerShape(20.dp),
                            border = BorderStroke(2.dp, color = Color.White),
                            colors = ButtonDefaults.buttonColors(containerColor = star.bcream)
                        ) {
                            Text(text = "Save", fontSize = 20.sp, color = Color.White)
                        }

                    }

                    Row(
                        horizontalArrangement = Arrangement.Center,
                        verticalAlignment = Alignment.Bottom,
                        modifier = Modifier
                            .height(50.dp)
                            .fillMaxWidth()
                    ) {

                        Text(text = "Or", fontSize = 20.sp, color = Color.Black)

                    }

                    Row(
                        horizontalArrangement = Arrangement.Center,
                        verticalAlignment = Alignment.CenterVertically,
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(90.dp)
                    ) {

                        Button(
                            onClick = {
                                deleteContact.value = true




                            },
                            modifier = Modifier
                                .height(50.dp)
                                .width(100.dp),
                            shape = RoundedCornerShape(20.dp),
                            border = BorderStroke(2.dp, color = Color.White),
                            colors = ButtonDefaults.buttonColors(containerColor = star.bcream)
                        ) {
                            Text(text = "Delete", fontSize = 20.sp, color = Color.White)
                        }

                    }
                }

            }
        }
    }
}
