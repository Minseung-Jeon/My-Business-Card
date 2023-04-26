package com.example.mybusinesscard

import android.graphics.drawable.Drawable
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Divider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.Black
import androidx.compose.ui.graphics.Color.Companion.Green
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.font.FontWeight.Companion.Bold
import androidx.compose.ui.text.font.FontWeight.Companion.Medium
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.mybusinesscard.ui.theme.MyBusinessCardTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyBusinessCardTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    BusinessCard()
                }
            }
        }
    }
}

//main function that calls all functions
@Composable
fun BusinessCard(modifier: Modifier = Modifier){
    Surface(color = Color.Gray) {

        Column(modifier = Modifier.fillMaxSize()){
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Bottom,
                modifier = Modifier
                    .weight(1f)
                    .fillMaxSize()
            ){
                FirstBlock()
            }

            Column(
                horizontalAlignment = Alignment.Start,
                verticalArrangement = Arrangement.Bottom,
                modifier = Modifier
                    .weight(1f)
                    .fillMaxSize()
            ){
                SecondBlock()
            }
        }


    }

}

//First half of column (screen) for android logo, name and introduction
@Composable
fun FirstBlock(modifier: Modifier=Modifier){
    val android = painterResource(R.drawable.android_logo)
    Image(
        painter = android,
        contentDescription = null,
        modifier = Modifier
            .size(100.dp)
    )

// code for my selfie picture instead of android_logo
// just import drawable source file called my_selfie on your computer
/*
    val selfie = painterResource(R.drawable.my_selfie)

    Image(
        painter = selfie,
        contentDescription = null,
        modifier = Modifier
            .size(200.dp)
            .clip(CircleShape)
    )
*/


    Text(
        stringResource(R.string.english_name),
        fontSize = 40.sp,
        textAlign = TextAlign.Center,
        modifier = Modifier.padding(bottom = 6.dp),
        fontWeight = FontWeight.Light
    )


    Text(
        stringResource(R.string.introduction),
        fontSize = 16.sp,
        color = Color(0xFF3ddc84),
        textAlign = TextAlign.Center,
        modifier = Modifier.padding(6.dp),
        fontWeight = FontWeight.Bold

    )

}

//second half of column (screen) for contact logo and details
//calls function "DetailLine" for each row
@Composable
fun SecondBlock(modifier: Modifier = Modifier){
    DetailLine(icon = painterResource(R.drawable.baseline_call_24), description = stringResource(R.string.phone_num))
    DetailLine(icon = painterResource(R.drawable.baseline_travel_explore_24), description = stringResource(R.string.website))
    DetailLine(icon = painterResource(R.drawable.baseline_email_24), description = stringResource(R.string.email))
    Spacer(modifier = Modifier.height(60.dp))
}

//creates each row with icon and detailed information
@Composable
fun DetailLine(icon: Painter, description: String, modifier: Modifier = Modifier){

    Divider(color = Color.White, modifier = Modifier.height(1.dp))

    Row (modifier = Modifier.padding(10.dp)){
        Image(
            modifier = Modifier.padding(start = 50.dp, end = 40.dp),
            painter = icon,
            contentDescription = description,
            colorFilter = ColorFilter.tint(Color(0xFF3ddc84))
        )
        Text(

            text = description
        )
    }


}


@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    MyBusinessCardTheme {
        BusinessCard()
    }
}