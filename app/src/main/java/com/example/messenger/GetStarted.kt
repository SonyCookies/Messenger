package com.example.messenger

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.messenger.ui.theme.Bluish
import com.example.messenger.ui.theme.White
import com.example.messenger.ui.theme.montserrat

@Composable
fun StartScreen(
    navController: NavController
) {


    Column(
        modifier = Modifier
            .background(Bluish)
            .fillMaxSize()
            .padding(32.dp),
        verticalArrangement = Arrangement.Bottom,
    ) {
        Text(
            fontWeight = FontWeight.ExtraBold,
            text = "Stay Connected With Us",
            fontSize = 48.sp,
            color = White,
            fontFamily = montserrat,
        )

        Text(
            fontWeight = FontWeight.SemiBold,
            text = "Let's talk about more things to the people closest to you",
            fontSize = 16.sp,
            color = White,
            fontFamily = montserrat,
        )
        Spacer(modifier = Modifier.height(32.dp))

        Button(
            shape = RoundedCornerShape(22.dp),
            onClick = {
                      navController.navigate(route = Screen.Login.route)
            },
            colors = ButtonDefaults.buttonColors(
                backgroundColor = White,
                contentColor = Bluish
            ),
            modifier = Modifier
                .requiredHeight(60.dp)
                .fillMaxWidth()

        ) {
            Text(
                text = "Get Started",
                fontFamily = montserrat,
                fontWeight = FontWeight.SemiBold,
                fontSize = 16.sp,
            )
        }
        Spacer(modifier = Modifier.height(10.dp))

        Text(
            fontWeight = FontWeight.Medium,
            text = "Create an Account",
            fontSize = 13.sp,
            color = White,
            fontFamily = montserrat,
            textDecoration = TextDecoration.Underline,
            modifier = Modifier
                .clickable {

                }
                .align(CenterHorizontally)

        )
    }
}


@Preview
@Composable
fun StartScreenPreview() {
    StartScreen(
        navController = rememberNavController()
    )
}