package com.assignment.rmgdevassignment.common

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.DpSize
import androidx.compose.ui.unit.sp

@Composable
fun UILoverText(
    modifier: Modifier = Modifier,
    color: Color = Color.White,
    fontSize: Int = 54
) {
    Text(
        modifier = modifier,
        text = "UiLover",
        fontSize = fontSize.sp,
        fontWeight = FontWeight(700),
        color = color
    )
}