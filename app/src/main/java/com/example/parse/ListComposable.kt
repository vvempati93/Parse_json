package com.example.parse

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shadow
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun ListComposable(viewModel: ParseViewModel) {
    LaunchedEffect(Unit, block = {
        viewModel.getCountriesList()
    })
        // this remember should remember the scroll position of the list scroll even on rotation as long as the fragment is alive
        //because it's tied to the fragment's lifecycle
        val lazyListState = rememberLazyListState()
        LazyColumn(state = lazyListState, modifier = Modifier.fillMaxHeight()) {
            items(viewModel.countriesList) { country ->
                CountryRow(
                    countryName = country.name,
                    region = country.region,
                    code = country.code,
                    capital = country.capital
                )
            }
        }
    }


@Composable
fun CountryRow(countryName: String, region: String, code: String, capital: String) {
    Column() {
        Row(modifier = Modifier.padding(16.dp)) {
            Text(
                text = countryName, style = TextStyle(
                    fontSize = 24.sp,
                    shadow = Shadow(
                        color = Color.Blue,
                        offset = Offset(5.0f, 10.0f),
                        blurRadius = 3f
                    )
                )
            )
            Text(
                text = region, style = TextStyle(
                    fontSize = 24.sp,
                    shadow = Shadow(
                        color = Color.Blue,
                        offset = Offset(5.0f, 10.0f),
                        blurRadius = 3f
                    )
                )
            )
            Text(
                text = code, style = TextStyle(
                    fontSize = 24.sp,
                    shadow = Shadow(
                        color = Color.Blue,
                        offset = Offset(5.0f, 10.0f),
                        blurRadius = 3f
                    )
                )
            )
        }
        Text(
            text = capital, style = TextStyle(
                fontSize = 24.sp,
                shadow = Shadow(
                    color = Color.Blue,
                    offset = Offset(5.0f, 10.0f),
                    blurRadius = 3f
                )
            )
        )
    }
}