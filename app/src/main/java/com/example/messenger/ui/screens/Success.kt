package com.example.messenger.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.messenger.navigation.Screen
import com.example.messenger.ui.theme.*

@Composable
fun SuccessScreen(
    navController: NavController
) {

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Bluish)
            .padding(32.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            fontWeight = FontWeight.ExtraBold,
            text = "Account Created Successfully!!",
            fontSize = 36.sp,
            color = White,
            fontFamily = montserrat,
        )

        Spacer(modifier = Modifier.height(40.dp))

        IconButton(
            onClick = {
                navController.navigate(route = Screen.Login.route)
            }
        ) {
            Icon(
                Icons.Default.ArrowForward,
                "",
                modifier = Modifier
                    .size(32.dp),
                tint = White
            )

        }

    }
}

@Preview
@Composable
fun SuccessScreenPreview() {
    SuccessScreen(
        navController = rememberNavController()
    )
}



