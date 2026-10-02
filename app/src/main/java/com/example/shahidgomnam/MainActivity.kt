package com.example.shahidgomnam

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent { App() }
    }
}

private val Green = Color(0xFF18251E)
private val Gold = Color(0xFFC9A45C)
private val Cream = Color(0xFFF4EFE4)

@Composable
fun App() {
    var page by remember { mutableStateOf("home") }
    var dark by remember { mutableStateOf(false) }

    MaterialTheme(
        colorScheme = if (dark) darkColorScheme() else lightColorScheme()
    ) {
        if (page == "home") {
            Home(
                dark = dark,
                onDark = { dark = !dark },
                onRead = { page = "toc" }
            )
        } else {
            Toc(onBack = { page = "home" })
        }
    }
}

@Composable
fun Home(
    dark: Boolean,
    onDark: () -> Unit,
    onRead: () -> Unit
) {
    Surface(modifier = Modifier.fillMaxSize()) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(Green)
                .padding(24.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Spacer(Modifier.height(55.dp))

            Text("✦", color = Gold, fontSize = 48.sp)

            Text(
                "ما و شهید گمنام",
                color = Color.White,
                fontSize = 34.sp,
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Center
            )

            Spacer(Modifier.height(10.dp))

            Text(
                "روایتِ مهدی عسکری از تولد یک گروه جهادی",
                color = Cream,
                fontSize = 17.sp,
                textAlign = TextAlign.Center
            )

            Spacer(Modifier.height(35.dp))

            Card(
                colors = CardDefaults.cardColors(
                    containerColor = Color(0xFF24352B)
                )
            ) {
                Column(
                    Modifier.padding(22.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(
                        "«این شهید، فقط یک قبر نیست. این، یک پیام است.»",
                        color = Gold,
                        fontSize = 19.sp,
                        textAlign = TextAlign.Center
                    )

                    Spacer(Modifier.height(20.dp))

                    Button(
                        onClick = onRead,
                        colors = ButtonDefaults.buttonColors(
                            containerColor = Gold
                        )
                    ) {
                        Text(
                            "شروع مطالعه",
                            color = Green,
                            fontWeight = FontWeight.Bold
                        )
                    }
                }
            }

            Spacer(Modifier.weight(1f))

            OutlinedButton(onClick = onDark) {
                Text(if (dark) "حالت روشن" else "حالت شب")
            }

            Spacer(Modifier.height(18.dp))

            Text(
                "نسخه اولیه • ۱۴۰۵",
                color = Color.Gray,
                fontSize = 12.sp
            )
        }
    }
}

@Composable
fun Toc(onBack: () -> Unit) {
    val chapters = listOf(
        "پیشگفتار: به قلمِ خودم",
        "فصل اول: مسافری در جاده‌ی عشق",
        "فصل دوم: کشف – آن روز که بیابان نفس کشید",
        "فصل سوم: از یک قبر تا یک جنبش",
        "فصل چهارم: آزمونِ بزرگ – سیلِ ۱۳۹۸",
        "فصل پنجم: حکایتِ پدرِ عباس کردانی",
        "موخره: گمنامی؛ یعنی همین!",
        "پیوست‌ها"
    )

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        "فهرست مطالب",
                        fontWeight = FontWeight.Bold
                    )
                },
                navigationIcon = {
                    TextButton(onClick = onBack) {
                        Text("بازگشت")
                    }
                }
            )
        }
    ) { pad ->
        LazyColumn(
            Modifier
                .padding(pad)
                .padding(16.dp)
        ) {
            items(chapters.size) { i ->
                Card(
                    Modifier
                        .fillMaxWidth()
                        .padding(vertical = 6.dp)
                        .clickable { },
                    colors = CardDefaults.cardColors(
                        containerColor = Cream
                    )
                ) {
                    Text(
                        chapters[i],
                        Modifier
                            .padding(20.dp)
                            .fillMaxWidth(),
                        fontSize = 17.sp,
                        textAlign = TextAlign.Right,
                        fontWeight = if (i == 0)
                            FontWeight.Bold
                        else
                            FontWeight.Normal
                    )
                }
            }
        }
    }
}
