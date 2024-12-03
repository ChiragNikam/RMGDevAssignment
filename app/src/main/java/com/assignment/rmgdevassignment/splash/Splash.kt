package com.assignment.rmgdevassignment.splash

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.assignment.rmgdevassignment.R
import com.assignment.rmgdevassignment.common.UILoverText
import com.assignment.rmgdevassignment.ui.theme.RMGDevAssignmentTheme
import kotlinx.coroutines.delay

@Composable
fun SplashScreen(
    modifier: Modifier = Modifier,
    onSplashFinished: () -> Unit
) {
    // Trigger splash screen logic
    LaunchedEffect(Unit) {
        delay(3000) // 3 seconds delay
        onSplashFinished() // Navigate to next screen
    }
    Surface(
        modifier = modifier
            .fillMaxSize()
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.Red.copy(0.67f, green = 0.18f)),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                modifier = Modifier.fillMaxWidth(),
                painter = painterResource(id = R.drawable.top_1), contentDescription = "top_image",
                contentScale = ContentScale.FillWidth
            )

            UILoverText()

            Spacer(modifier = Modifier.height(18.dp))
            Text(text = "A version for the future with our channel", color = Color.White)

            Spacer(modifier = Modifier.weight(1f))
            Image(
                modifier = Modifier.fillMaxWidth(),
                painter = painterResource(id = R.drawable.bottom_1), contentDescription = "top_image",
                contentScale = ContentScale.FillWidth
            )
        }
    }
}

@Preview
@Composable
private fun SplashScreenPrev() {
    RMGDevAssignmentTheme {
        SplashScreen{}
    }
}