package com.example.my_log_in_page

import android.content.Intent
import android.media.Image
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.my_log_in_page.ui.theme.My_Log_In_PageTheme

class ThirdPage : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            My_Log_In_PageTheme {

                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .background(color = star.lightcream)
                ) {

                    Row(
                        horizontalArrangement = Arrangement.Center,
                        verticalAlignment = Alignment.Bottom,
                        modifier = Modifier
                            .height(120.dp)
                            .fillMaxWidth()
                    ) {
                        Text(text = "Welcome", fontSize = 40.sp, color = star.brown)
                    }

                    Row(
                        horizontalArrangement = Arrangement.Center,
                        verticalAlignment = Alignment.CenterVertically,
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(40.dp)
                    ) {

                        Text(
                            text = Sign_up_Page.username.value,
                            fontSize = 25.sp,
                            color = star.bcream
                        )

                    }

                    Row(
                        horizontalArrangement = Arrangement.Center,
                        verticalAlignment = Alignment.Top,
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(20.dp)
                    ) {

                        Text(text = "choose option", fontSize = 17.sp, color = Color.White)

                    }

                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(20.dp)
                    ) {


                    }

                    Row(
                        horizontalArrangement = Arrangement.Start,
                        verticalAlignment = Alignment.CenterVertically,
                        modifier = Modifier
                            .fillMaxWidth()
                            .clickable {

                                val intent = Intent(this@ThirdPage, AddContact::class.java)
                                startActivity(intent)

                            }
                            .height(80.dp)
                    ) {

                        Text(
                            text = "           ◉ Create Contact",
                            fontSize = 30.sp,
                            color = star.brown
                        )

                    }

                    Row(
                        horizontalArrangement = Arrangement.Start,
                        verticalAlignment = Alignment.Top,
                        modifier = Modifier
                            .fillMaxWidth()
                            .clickable {

                                val intent = Intent(this@ThirdPage, showContact::class.java)
                                startActivity(intent)

                            }
                            .height(80.dp)
                    ) {

                        Text(
                            text = "           ◉ View Contact List",
                            fontSize = 30.sp,
                            color = star.brown
                        )

                    }

                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(200.dp)
                    ) {

                    }

                    Row(
                        horizontalArrangement = Arrangement.Center,
                        verticalAlignment = Alignment.CenterVertically,
                        modifier = Modifier
                            .width(500.dp)
                            .height(300.dp)
                    ) {

                        Image(
                            painter = painterResource(R.drawable.add3),
                            contentDescription = null,
                            modifier = Modifier
                                .height(200.dp)
                                .width(300.dp)
                        )

                    }

                }

            }
        }
    }
}

