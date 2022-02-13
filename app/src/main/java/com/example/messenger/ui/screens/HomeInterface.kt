package com.example.messenger

import android.util.Log
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.messenger.ui.theme.Blackish
import com.example.messenger.ui.theme.GrayishWhite
import com.example.messenger.ui.theme.White
import com.example.messenger.ui.theme.montserrat
import com.example.messenger.ui.viewmodels.MainViewModel
import com.example.messenger.util.SearchWidgetState

@Composable
fun HomeScreen(
    mainViewModel: MainViewModel = MainViewModel(),
    navController: NavController
) {

    val searchWidgetState by mainViewModel.searchWidgetState
    val searchTextState by mainViewModel.searchTextState

    Scaffold(
        topBar = {
            MainAppBar(
                searchWidgetState = searchWidgetState,
                searchTextState = searchTextState,
                onTextChange = {
                    mainViewModel.updateSearchTextState(newValue = it)
                },
                onCloseClicked = {
                    mainViewModel.updateSearchWidgetState(newValue = SearchWidgetState.CLOSED)
                    mainViewModel.updateSearchTextState(newValue = "")
                },
                onSearchClicked = {
                     Log.d("Searched Text", it)
                },
                onSearchTriggered = {
                    mainViewModel.updateSearchWidgetState(newValue = SearchWidgetState.OPENED)
                }
            )
        },
        backgroundColor = GrayishWhite

    ) {

    }
}


@Composable
fun MainAppBar(
    searchWidgetState: SearchWidgetState,
    searchTextState: String,
    onTextChange: (String) -> Unit,
    onCloseClicked: () -> Unit,
    onSearchClicked: (String) -> Unit,
    onSearchTriggered: () -> Unit
) {
    when (searchWidgetState) {
        SearchWidgetState.CLOSED -> {
            DefaultAppBar(
                onSearchClicked = onSearchTriggered
            )
        }
        SearchWidgetState.OPENED -> {
            SearchAppBar(
                text = searchTextState,
                onTextChange = onTextChange,
                onCloseClicked = onCloseClicked,
                onSearchClicked = onSearchClicked
            )
        }
    }
}


@Composable
fun DefaultAppBar(
    onSearchClicked: () -> Unit
) {
    TopAppBar(
        backgroundColor = White
    ) {
        IconButton(
            onClick = {

            }
        ) {
            Icon(Icons.Default.Menu, "Menu", tint = Color.Black)
        }

        Text(
            text = "Messages",
            color = Blackish,
            fontFamily = montserrat,
            fontWeight = FontWeight.SemiBold,
            fontSize = 24.sp,
            textAlign = TextAlign.Center,
            modifier = Modifier
                .weight(2.0f)

        )

        IconButton(
            onClick = {
                onSearchClicked()
            }
        ) {
            Icon(Icons.Default.Search, "Search", tint = Color.Black)
        }


    }
}

@Composable
fun SearchAppBar(
    text: String,
    onTextChange: (String) -> Unit,
    onCloseClicked: () -> Unit,
    onSearchClicked: (String) -> Unit
) {
    Surface(
        modifier = Modifier
            .fillMaxWidth()
            .height(56.dp),
        elevation = AppBarDefaults.TopAppBarElevation,
        color = GrayishWhite
    ) {
        TextField(
            modifier = Modifier
                .fillMaxWidth(),
            value = text,
            onValueChange = {
                onTextChange(it)
            },
            placeholder = {
                Text(
                    modifier = Modifier
                        .alpha(ContentAlpha.medium),
                    text = "Search here...",
                    color = Color.Black
                )
            },
            textStyle = TextStyle(
                fontSize = 16.sp,
                fontFamily = montserrat,
                fontWeight = FontWeight.Medium
            ),
            singleLine = true,
            leadingIcon = {
                IconButton(
                    onClick = {

                    },
                    modifier = Modifier
                        .alpha(ContentAlpha.medium)
                ) {
                    Icon(
                        Icons.Default.Search,
                        "Search",
                        tint = Color.Black
                    )
                }
            },
            trailingIcon = {
                IconButton(
                    onClick = {
                        if (text.isNotEmpty()) {
                            onTextChange("")
                        } else {
                            onCloseClicked()
                        }
                    },
                    modifier = Modifier
                        .alpha(ContentAlpha.medium)
                ) {
                    Icon(
                        Icons.Default.Close,
                        "Close",
                        tint = Color.Black
                    )
                }
            },
            keyboardOptions = KeyboardOptions(
                imeAction = ImeAction.Search
            ),
            keyboardActions = KeyboardActions(
                onSearch = {
                    onSearchClicked(text)
                }
            ),
            colors = TextFieldDefaults.textFieldColors(
                backgroundColor = Color.Transparent,
                cursorColor = Color.Black.copy(alpha = ContentAlpha.medium)
            )
        )
    }

}

@Preview
@Composable
fun SearchAppBarPreview() {
    SearchAppBar(
        text = "Some random text",
        onTextChange = {},
        onCloseClicked = {},
        onSearchClicked = {}
    )
}