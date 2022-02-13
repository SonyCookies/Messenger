package com.example.messenger

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.messenger.navigation.Screen
import com.example.messenger.ui.theme.*

@Composable
fun LoginScreen(
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
            text = "Login",
            fontSize = 36.sp,
            color = White,
            fontFamily = montserrat,
        )
        Spacer(
            Modifier.height(16.dp)
        )

        var username by remember { mutableStateOf("") }

        TextField(
            value = username,
            onValueChange = {
                username = it
            },
            colors = TextFieldDefaults.textFieldColors(
                focusedIndicatorColor = White,
                unfocusedIndicatorColor = White,
                backgroundColor = Color.Transparent,
                cursorColor = Color.Black,
                disabledIndicatorColor = Color.Transparent
            ),
            modifier = Modifier
                .fillMaxWidth(),
            maxLines = 1,
            textStyle = TextStyle(
                fontFamily = montserrat,
                fontWeight = FontWeight.Medium,
                fontSize = 16.sp,
                color = Color.Black
            ),
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Text
            ),
            label = {
                Text(
                    text = "Username",
                )
            }
        )

        Spacer(modifier = Modifier.height(8.dp))

        var password by rememberSaveable { mutableStateOf("") }
        var passwordVisibility by remember { mutableStateOf(false) }

        TextField(
            value = password,
            onValueChange = {
                password = it
            },
            colors = TextFieldDefaults.textFieldColors(
                focusedIndicatorColor = White,
                unfocusedIndicatorColor = White,
                backgroundColor = Color.Transparent,
                cursorColor = Color.Black,
                disabledIndicatorColor = Color.Transparent
            ),
            modifier = Modifier
                .fillMaxWidth(),
            maxLines = 1,
            textStyle = TextStyle(
                fontFamily = montserrat,
                fontWeight = FontWeight.Medium,
                fontSize = 16.sp,
                color = Color.Black
            ),
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Password
            ),
            visualTransformation = if (passwordVisibility) VisualTransformation.None else PasswordVisualTransformation(),
            label = {
                Text(
                    text = "Password",
                )
            },
            trailingIcon = {
                val image = if (passwordVisibility)
                    Icons.Filled.Visibility
                else Icons.Filled.VisibilityOff

                IconButton(onClick = {
                    passwordVisibility = !passwordVisibility
                }) {
                    Icon(imageVector = image, contentDescription = "")
                }
            }

        )
        Spacer(modifier = Modifier.height(20.dp))

        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier.fillMaxWidth()
        ) {
            val checkedState = remember { mutableStateOf(false) }

            Row(
            ) {
                Checkbox(
                    checked = checkedState.value,
                    modifier = Modifier
                        .padding(start = 16.dp, end = 5.dp),
                    onCheckedChange = { checkedState.value = it },
                    colors = CheckboxDefaults.colors(
                        checkedColor = White,
                        disabledColor = White,
                        uncheckedColor = White,
                        checkmarkColor = Bluish
                    )
                )
                Text(
                    color = White,
                    text = "Remember Me",
                    fontFamily = montserrat,
                    fontWeight = FontWeight.Medium,
                    fontSize = 12.sp,
                    modifier = Modifier
                        .padding(top = 4.dp)
                )
            }

            Text(
                color = White,
                text = "Forgot password?",
                fontFamily = montserrat,
                fontWeight = FontWeight.Medium,
                textDecoration = TextDecoration.Underline,
                fontSize = 12.sp,
                modifier = Modifier
                    .padding(top = 4.dp)
                    .clickable {

                    }
            )
        }

        Spacer(modifier = Modifier.height(40.dp))

        Button(
            shape = RoundedCornerShape(22.dp),
            onClick = {
                navController.navigate(route = Screen.Home.route)
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
                text = "Login",
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
                    navController.navigate(route = Screen.Signup.route) {
                        popUpTo(route = Screen.Signup.route) {
                            inclusive = true
                        }
                    }
                }
                .align(Alignment.CenterHorizontally)

        )

    }
}

@Preview
@Composable
fun LoginScreenPreview() {
    LoginScreen(
        navController = rememberNavController()
    )
}