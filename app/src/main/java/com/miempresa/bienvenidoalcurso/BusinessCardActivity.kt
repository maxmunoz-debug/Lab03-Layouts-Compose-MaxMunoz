package com.miempresa.bienvenidoalcurso

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


val BackgroundGreen = Color(0xFFD2E8D4)
val AndroidNavy = Color(0xFF073042)
val TextDarkGreen = Color(0xFF006D3B)
val TextContactColor = Color(0xFF203226)

@Composable
fun BusinessCardApp() {
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = BackgroundGreen
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(24.dp),
            verticalArrangement = Arrangement.SpaceBetween,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            // Espaciador para balancear la parte superior
            Spacer(modifier = Modifier.height(40.dp))


            Column(
                horizontalAlignment = Alignment.CenterHorizontally
            ) {

                Box(
                    modifier = Modifier
                        .size(130.dp)
                        .background(AndroidNavy),
                    contentAlignment = Alignment.Center
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.android_logo),
                        contentDescription = "Android Logo",
                        modifier = Modifier
                            .size(115.dp)
                            .padding(8.dp)
                    )
                }

                Spacer(modifier = Modifier.height(18.dp))

                Text(
                    text = "Max Muñoz",
                    fontSize = 38.sp,
                    fontWeight = FontWeight.Light,
                    color = Color(0xFF1E2922)
                )

                Spacer(modifier = Modifier.height(8.dp))

                Text(
                    text = "Android Developer Extraordinaire",
                    fontSize = 15.sp,
                    fontWeight = FontWeight.Bold,
                    color = TextDarkGreen
                )
            }

            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 36.dp),
                verticalArrangement = Arrangement.spacedBy(16.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                ContactInfoRow(icon = "📞", infoText = "+51 925601235")
                ContactInfoRow(icon = "🔗", infoText = "@AndroidDev")
                ContactInfoRow(icon = "✉️", infoText = "max.munoz@android.com")
            }
        }
    }
}

@Composable
fun ContactInfoRow(icon: String, infoText: String) {
    Row(
        modifier = Modifier.fillMaxWidth(0.8f),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = icon,
            fontSize = 18.sp,
            color = TextDarkGreen,
            modifier = Modifier.width(36.dp)
        )
        Text(
            text = infoText,
            fontSize = 15.sp,
            color = TextContactColor,
            fontWeight = FontWeight.Normal
        )
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun PreviewBusinessCard() {
    BusinessCardApp()
}