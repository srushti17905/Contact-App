package com.example.my_log_in_page

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.BorderStroke
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
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.my_log_in_page.ui.theme.My_Log_In_PageTheme

class AddContact : ComponentActivity() {

    companion object {

        var name = mutableStateOf("")
        var phonenumber = mutableStateOf("")
        var surname = mutableStateOf("")

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {

            My_Log_In_PageTheme {

                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .background(star.contact2)
                ) {

                    Row(
                        horizontalArrangement = Arrangement.Center,
                        verticalAlignment = Alignment.Bottom,
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(100.dp)
                    ) {

                        Text(text = "Add Contact", fontSize = 40.sp, color = star.brown)

                    }
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(50.dp)
                    ) {

                    }

                    Row(
                        horizontalArrangement = Arrangement.Center,
                        verticalAlignment = Alignment.CenterVertically,
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(100.dp)
                    ) {

                        OutlinedTextField(
                            value = name.value,
                            onValueChange = { name.value = it },
                            modifier = Modifier
                                .height(80.dp)
                                .width(320.dp)
                                .padding(10.dp),
                            label = { Text(text = "Enter Your Name", fontSize = 15.sp) },
                            textStyle = TextStyle(fontSize = 20.sp, color = Color.Black),
                            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text),
                            colors = OutlinedTextFieldDefaults.colors(
                                focusedContainerColor = Color.Transparent,
                                unfocusedContainerColor = Color.Transparent,
                                focusedLabelColor = Color.Black,
                                unfocusedLabelColor = Color.Black,
                                focusedBorderColor = Color.White,
                                unfocusedBorderColor = star.brown
                            )
                        )

                    }

                    Row(
                        horizontalArrangement = Arrangement.Center,
                        verticalAlignment = Alignment.CenterVertically,
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(100.dp)
                    ) {

                        OutlinedTextField(
                            value = surname.value,
                            onValueChange = { surname.value = it },
                            modifier = Modifier
                                .height(80.dp)
                                .width(320.dp)
                                .padding(10.dp),
                            label = { Text(text = "Enter Your Surname", fontSize = 15.sp) },
                            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text),
                            textStyle = TextStyle(fontSize = 20.sp, color = Color.Black),
                            colors = OutlinedTextFieldDefaults.colors(
                                focusedContainerColor = Color.Transparent,
                                unfocusedContainerColor = Color.Transparent,
                                focusedLabelColor = Color.Black,
                                unfocusedLabelColor = Color.Black,
                                focusedBorderColor = Color.White,
                                unfocusedBorderColor = star.brown
                            )
                        )

                    }

                    Row(
                        horizontalArrangement = Arrangement.Center,
                        verticalAlignment = Alignment.CenterVertically,
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(100.dp)
                    ) {

                        OutlinedTextField(
                            value = phonenumber.value,
                            onValueChange = { phonenumber.value = it },
                            modifier = Modifier
                                .height(80.dp)
                                .width(320.dp)
                                .padding(10.dp),
                            label = { Text(text = "Enter Your Number", fontSize = 15.sp) },
                            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                            textStyle = TextStyle(fontSize = 20.sp, color = Color.Black),
                            colors = OutlinedTextFieldDefaults.colors(
                                focusedContainerColor = Color.Transparent,
                                unfocusedContainerColor = Color.Transparent,
                                focusedLabelColor = Color.Black,
                                unfocusedLabelColor = Color.Black,
                                focusedBorderColor = Color.White,
                                unfocusedBorderColor = star.brown
                            )
                        )

                    }

                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(100.dp)
                    ) {

                    }

                    Row(
                        horizontalArrangement = Arrangement.Center,
                        verticalAlignment = Alignment.CenterVertically,
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(200.dp)
                    ) {


                        Button(
                            onClick = {

                                val contactDatabase = Database(applicationContext)
                                contactDatabase.c_insertdata(
                                    name = name.value,
                                    pnumber = phonenumber.value,
                                    surname = surname.value
                                )

                                if (name.value != "" && phonenumber.value != "" && surname.value != "") {
                                    val intent = Intent(this@AddContact, showContact::class.java)
                                    startActivity(intent)
                                }
                            },
                            modifier = Modifier
                                .height(70.dp)
                                .width(120.dp),
                            colors = ButtonDefaults.buttonColors(
                                disabledContainerColor = star.lightgray,
                                containerColor = star.brown
                            ),
                            shape = RoundedCornerShape(20.dp),
                            border = BorderStroke(4.dp, color = star.cream)
                        )
                        {
                            Text(text = "SAVE", fontSize = 25.sp, color = Color.White)
                        }

                    }

                }

            }
        }
    }
}


