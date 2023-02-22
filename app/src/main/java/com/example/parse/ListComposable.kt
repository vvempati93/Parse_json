package com.example.parse

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shadow
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun ListComposable(countries: List<String>) {
    LazyColumn {

    }

}

@Composable
fun CountryRow(country: String) {
    Row(modifier = Modifier.padding(16.dp)) {
        Text(
            text = country, style = TextStyle(
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