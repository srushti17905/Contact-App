package com.example.my_log_in_page

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.my_log_in_page.Sign_up_Page.Companion.username
import com.example.my_log_in_page.ui.theme.My_Log_In_PageTheme

class Sign_up_Page : ComponentActivity() {

    companion object {

        val username = mutableStateOf("")
        val email = mutableStateOf("")
        val pnumber = mutableStateOf("")
        val password = mutableStateOf("")


    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            My_Log_In_PageTheme {

                Surface(
                    modifier = Modifier.fillMaxSize()

                ) {
                    Image(
                        painter = painterResource(R.drawable.logback15),
                        contentDescription = null, contentScale = ContentScale.FillBounds
                    )

                    Column(modifier = Modifier.fillMaxSize()) {

                        Row(
                            horizontalArrangement = Arrangement.Center,
                            verticalAlignment = Alignment.Bottom,
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(130.dp)
                        ) {

                            Text(text = "Sign In", fontSize = 50.sp, color = star.brown)

                        }
                        Row(
                            horizontalArrangement = Arrangement.Center,
                            verticalAlignment = Alignment.Top,
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(60.dp)
                        ) {

                            Text(
                                text = "enter your credential",
                                fontSize = 15.sp,
                                color = Color.Black
                            )

                        }

                        Row(
                            horizontalArrangement = Arrangement.Center,
                            verticalAlignment = Alignment.CenterVertically,
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(80.dp)
                        ) {

                            TextField(
                                value = username.value,
                                onValueChange = {

                                    username.value = it


                                }, label = { Text(text = "Username", fontSize = 18.sp) },
                                enabled = true,
                                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text),
                                modifier = Modifier
                                    .height(80.dp)
                                    .width(330.dp)
                                    .padding(10.dp),
                                shape = RoundedCornerShape(15.dp),
                                textStyle = TextStyle(fontSize = 20.sp, color = Color.Black),
                                colors = OutlinedTextFieldDefaults.colors(
                                    focusedContainerColor = star.cream,
                                    unfocusedContainerColor = star.lightcream,
                                    focusedLabelColor = Color.White,
                                    unfocusedLabelColor = star.brown
                                ),
                                minLines = 1, maxLines = 1
                            )


                        }
                        Row(
                            horizontalArrangement = Arrangement.Center,
                            verticalAlignment = Alignment.CenterVertically,
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(80.dp)
                        ) {

                            TextField(
                                value = email.value,
                                onValueChange = {

                                    email.value = it


                                }, label = { Text(text = "Email", fontSize = 18.sp) },
                                enabled = true,
                                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email),
                                modifier = Modifier
                                    .height(80.dp)
                                    .width(330.dp)
                                    .padding(10.dp),
                                shape = RoundedCornerShape(15.dp),
                                textStyle = TextStyle(fontSize = 20.sp, color = Color.Black),
                                colors = OutlinedTextFieldDefaults.colors(
                                    focusedContainerColor = star.cream,
                                    unfocusedContainerColor = star.lightcream,
                                    focusedLabelColor = Color.White,
                                    unfocusedLabelColor = star.brown
                                ),
                                minLines = 1, maxLines = 1
                            )



                        }
                        Row(
                            horizontalArrangement = Arrangement.Center,
                            verticalAlignment = Alignment.CenterVertically,
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(80.dp)
                        ) {

                            TextField(
                                value = pnumber.value,
                                onValueChange = {

                                    pnumber.value = it


                                }, label = { Text(text = "Phone Number", fontSize = 18.sp) },
                                enabled = true,
                                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Phone),
                                modifier = Modifier
                                    .height(80.dp)
                                    .width(330.dp)
                                    .padding(10.dp),
                                shape = RoundedCornerShape(15.dp),
                                textStyle = TextStyle(fontSize = 20.sp, color = Color.Black),
                                colors = OutlinedTextFieldDefaults.colors(
                                    focusedContainerColor = star.cream,
                                    unfocusedContainerColor = star.lightcream,
                                    focusedLabelColor = Color.White,
                                    unfocusedLabelColor = star.brown
                                ),
                                minLines = 1, maxLines = 1
                            )


                        }
                        Row(
                            horizontalArrangement = Arrangement.Center,
                            verticalAlignment = Alignment.CenterVertically,
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(80.dp)
                        ) {

                            TextField(
                                value = password.value,
                                onValueChange = {

                                    password.value = it

                                }, label = { Text(text = "Password", fontSize = 18.sp) },
                                enabled = true,
                                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
                                modifier = Modifier
                                    .height(80.dp)
                                    .width(330.dp)
                                    .padding(10.dp),
                                shape = RoundedCornerShape(15.dp),
                                textStyle = TextStyle(fontSize = 20.sp, color = Color.Black),
                                colors = OutlinedTextFieldDefaults.colors(
                                    focusedContainerColor = star.cream,
                                    unfocusedContainerColor = star.lightcream,
                                    focusedLabelColor = Color.White,
                                    unfocusedLabelColor = star.brown
                                ),
                                minLines = 1, maxLines = 1
                            )

                        }

                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(110.dp)
                        ) {

                            Column(
                                horizontalAlignment = Alignment.CenterHorizontally,
                                verticalArrangement = Arrangement.Center,
                                modifier = Modifier
                                    .fillMaxHeight()
                                    .width(170.dp)
                            ) {

                                Button(
                                    onClick = {

                                        val mydatabase = Database(applicationContext)
                                        mydatabase.insertdata(
                                            username = username.value,
                                            email = email.value,
                                            number = pnumber.value,
                                            pass = password.value

                                        )

                                        if (username.value != "" && email.value != "" && pnumber.value != "" && password.value != "") {

                                            val intent =
                                                Intent(this@Sign_up_Page, MainActivity::class.java)
                                            startActivity(intent)
                                        }


                                    },
                                    modifier = Modifier
                                        .height(60.dp)
                                        .width(110.dp),
                                    shape = RoundedCornerShape(26.dp),
                                    colors = ButtonDefaults.buttonColors(star.brown),
                                    border = BorderStroke(3.dp, color = star.lightcream)
                                ) {
                                    Text(text = "submit", fontSize = 20.sp, color = Color.White)
                                }

                            }

                        }

                        Row(
                            horizontalArrangement = Arrangement.Center,
                            verticalAlignment = Alignment.Bottom,
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(175.dp)
                        ) {
                            Text(
                                text = "already have an account. LogIn",
                                fontSize = 15.sp,
                                color = star.brown, modifier = Modifier.clickable {
                                    val intent =
                                        Intent(this@Sign_up_Page, MainActivity::class.java)
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

@Composable
fun Editfield(text: String, keyboardType: KeyboardType, onChangeValue: (String) -> Unit) {

    var fill by remember { mutableStateOf("") }

    TextField(
        value = fill,
        onValueChange = {

            fill = it
            onChangeValue(it)


        }, label = { Text(text = text, fontSize = 18.sp) },
        enabled = true,
        keyboardOptions = KeyboardOptions(keyboardType = keyboardType),
        modifier = Modifier
            .height(80.dp)
            .width(330.dp)
            .padding(10.dp),
        shape = RoundedCornerShape(15.dp),
        textStyle = TextStyle(fontSize = 20.sp, color = Color.Black),
        colors = OutlinedTextFieldDefaults.colors(
            focusedContainerColor = star.cream,
            unfocusedContainerColor = star.lightcream,
            focusedLabelColor = Color.White,
            unfocusedLabelColor = star.brown
        ),
        minLines = 1, maxLines = 1
    )

}
