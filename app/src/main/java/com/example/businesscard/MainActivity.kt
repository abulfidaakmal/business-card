package com.example.businesscard

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Email
import androidx.compose.material.icons.rounded.Phone
import androidx.compose.material.icons.rounded.Share
import androidx.compose.material3.Icon
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.businesscard.ui.theme.BusinessCardTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            BusinessCardTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = Color(0xFFD2E8D4)
                ) {
                    BusinessCardApp()
                }
            }
        }
    }
}

@Composable
fun BusinessCardApp() {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.SpaceEvenly,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        BusinessCardInfo()
        BusinessCardContact()
    }
}

@Composable
fun BusinessCardInfo() {
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        Image(
            painter = painterResource(R.drawable.android_logo),
            contentDescription = null,
            modifier = Modifier
                .background(Color(0XFF073042))
                .width(150.dp)
                .height(150.dp)
        )
        Text(
            text = stringResource(R.string.card_fullname),
            fontSize = 32.sp,
            fontWeight = FontWeight.W400,
            modifier = Modifier.padding(
                top = 8.dp,
                bottom = 12.dp
            )
        )
        Text(
            text = stringResource(R.string.card_title),
            color = Color(0XFF006D3B),
            fontWeight = FontWeight.ExtraBold
        )
    }
}

@Composable
fun BusinessCardContact() {
    val icons = Icons.Rounded

    Column {
        ContactRow(icons.Phone, stringResource(R.string.contact_phone))
        ContactRow(icons.Share, stringResource(R.string.contact_website))
        ContactRow(icons.Email, stringResource(R.string.contact_email))
    }
}

@Composable
fun ContactRow(vector: ImageVector, contact: String) {
    Row(
        modifier = Modifier.padding(vertical = 6.dp)
    ) {
        Icon(
            imageVector = vector,
            contentDescription = null,
            modifier = Modifier.padding(end = 14.dp),
            tint = Color(0XFF006D3B)
        )
        Text(
            text = contact
        )
    }
}

@Preview(showBackground = true, showSystemUi = true, name = "Business Card")
@Composable
fun BusinessCardPreview() {
    BusinessCardTheme {
        BusinessCardApp()
    }
}