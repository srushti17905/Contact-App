package com.example.my_log_in_page

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.focusable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.focusModifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.my_log_in_page.Sign_up_Page.Companion.email
import com.example.my_log_in_page.ui.theme.My_Log_In_PageTheme

class DashBoard : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            My_Log_In_PageTheme {


                Column(modifier = Modifier.fillMaxSize()) {

                    Row(
                        horizontalArrangement = Arrangement.Center,
                        verticalAlignment = Alignment.CenterVertically,
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(100.dp)
                            .background(color = star.bcream)
                    ) {

                        Text(text = "User Info", fontSize = 35.sp, color = Color.White)

                    }

                    Surface(modifier = Modifier.fillMaxSize()) {

                        Image(
                            painter = painterResource(R.drawable.dashbord1),
                            contentDescription = null,
                            contentScale = ContentScale.FillBounds
                        )

                        Column(modifier = Modifier.fillMaxSize()) {

                            Row(modifier = Modifier
                                .fillMaxWidth()
                                .height(20.dp)) {

                            }

                            Row(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .height(60.dp)
                            ) {

                                Row(
                                    horizontalArrangement = Arrangement.Center,
                                    verticalAlignment = Alignment.CenterVertically,
                                    modifier = Modifier
                                        .height(80.dp)
                                        .width(80.dp)
                                ) {

                                    Image(
                                        painter = painterResource(R.drawable.group),
                                        contentDescription = null,
                                        modifier = Modifier
                                            .height(30.dp)
                                            .width(50.dp)
                                    )

                                }

                                Row(
                                    horizontalArrangement = Arrangement.Start,
                                    verticalAlignment = Alignment.CenterVertically,
                                    modifier = Modifier
                                        .fillMaxHeight()
                                        .width(300.dp)
                                ) {

                                    Text(
                                        text = Sign_up_Page.username.value,
                                        fontSize = 20.sp,
                                        color = Color.Black
                                    )

                                }

                            }

                            Row(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .height(60.dp)
                            ) {

                                Row(
                                    horizontalArrangement = Arrangement.Center,
                                    verticalAlignment = Alignment.CenterVertically,
                                    modifier = Modifier
                                        .height(80.dp)
                                        .width(80.dp)
                                ) {

                                    Image(
                                        painter = painterResource(R.drawable.phone),
                                        contentDescription = null,
                                        modifier = Modifier
                                            .height(30.dp)
                                            .width(50.dp)
                                    )

                                }

                                Row(
                                    horizontalArrangement = Arrangement.Start,
                                    verticalAlignment = Alignment.CenterVertically,
                                    modifier = Modifier
                                        .fillMaxHeight()
                                        .width(300.dp)
                                ) {

                                    Text(
                                        text = Sign_up_Page.pnumber.value,
                                        fontSize = 20.sp,
                                        color = Color.Black
                                    )

                                }
                            }

                            Row(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .height(60.dp)
                            ) {

                                Row(
                                    horizontalArrangement = Arrangement.Center,
                                    verticalAlignment = Alignment.CenterVertically,
                                    modifier = Modifier
                                        .height(80.dp)
                                        .width(80.dp)
                                ) {

                                    Image(
                                        painter = painterResource(R.drawable.email),
                                        contentDescription = null,
                                        modifier = Modifier
                                            .height(30.dp)
                                            .width(50.dp)
                                    )
                                }

                                Row(
                                    horizontalArrangement = Arrangement.Start,
                                    verticalAlignment = Alignment.CenterVertically,
                                    modifier = Modifier
                                        .fillMaxHeight()
                                        .width(300.dp)
                                ) {

                                    Text(
                                        text = MainActivity.username.value,
                                        fontSize = 20.sp,
                                        color = Color.Black
                                    )

                                }

                            }

                        }

                    }

                }

            }
        }
    }
}

