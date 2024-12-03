package com.assignment.rmgdevassignment.login

import android.content.Intent
import android.widget.Toast
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.MutableLiveData
import com.assignment.rmgdevassignment.R
import com.assignment.rmgdevassignment.common.UILoverText
import com.assignment.rmgdevassignment.home.HomeActivity
import com.assignment.rmgdevassignment.login.data.AppDatabase
import com.assignment.rmgdevassignment.ui.theme.RMGDevAssignmentTheme
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch

@Composable
fun LoginScreen(modifier: Modifier = Modifier) {
    val context = LocalContext.current

//    val userDao = AppDatabase.getDatabase(context).userDao()

    val loginEmail = remember {
        mutableStateOf("")
    }
    val loginPassword = remember {
        mutableStateOf("")
    }
    val scope = rememberCoroutineScope()

    Surface(modifier = modifier) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(rememberScrollState()),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                modifier = Modifier.fillMaxWidth(),
                painter = painterResource(id = R.drawable.top_2), contentDescription = "top_image",
                contentScale = ContentScale.FillWidth
            )
            Spacer(modifier = Modifier.height(18.dp))

            UILoverText(color = Color.Red.copy(0.67f, green = 0.18f), fontSize = 64)
            Text(text = "Start Your Activity with us")

            Spacer(modifier = Modifier.height(22.dp))
            Text(
                text = "Please Login",
                fontWeight = FontWeight(700),
                style = MaterialTheme.typography.headlineLarge
            )

            Spacer(modifier = Modifier.height(32.dp))
            Column(
                modifier = Modifier.padding(horizontal = 18.dp)
            ) {
                // login
                BorderedTextFieldWithHint(text = loginEmail, hint = "Enter Your Email")
                Spacer(modifier = Modifier.height(8.dp))
                // password
                BorderedTextFieldWithHint(text = loginPassword, hint = "Enter Your Password")
            }

            Spacer(modifier = Modifier.height(32.dp))

            Text(text = "Don't remember Password? Recover it")
            Spacer(modifier = Modifier.height(18.dp))
            Row(
                modifier = Modifier.padding(horizontal = 18.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Row(
                    modifier = Modifier
                        .height(1.dp)
                        .weight(1f)
                        .background(Color.Black)
                ) {}
                Text(
                    modifier = Modifier.padding(horizontal = 12.dp),
                    text = "Or Login with", fontSize = 20.sp
                )
                Row(
                    modifier = Modifier
                        .height(1.dp)
                        .weight(1f)
                        .background(Color.Black)
                ) {}
            }

            Spacer(modifier = Modifier.height(22.dp))

            // login button
            Button(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 18.dp),
                onClick = {
                    scope.launch {
                        if (loginEmail.value == "user1@example.com" && loginPassword.value == "password1")
                            context.startActivity(Intent(context, HomeActivity::class.java))
                        else
                            Toast.makeText(context, "Wrong Email or Password", Toast.LENGTH_SHORT).show()
                    }
                })
            {
                Text(text = "Login", fontSize = 22.sp)
            }
            Spacer(modifier = Modifier.height(32.dp))
            Text(text = "Don't have any account?")

            // signUp
            TextButton(onClick = { /*TODO*/ }) {
                Text(text = "SignUp", fontSize = 22.sp, fontWeight = FontWeight(700))
            }
        }
    }
}

@Preview
@Composable
private fun LoginScreenPreview() {
    RMGDevAssignmentTheme {
        LoginScreen()
    }
}

@Composable
fun BorderedTextFieldWithHint(
    text: MutableState<String>,
    hint: String
) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(48.dp)
            .border(BorderStroke(2.dp, Color.Gray), RoundedCornerShape(8.dp))
            .padding(8.dp),
        contentAlignment = Alignment.CenterStart
    ) {
        // Show the hint if the text field is empty
        if (text.value.isEmpty()) {
            Text(
                text = hint,
                color = Color.Gray,
                style = MaterialTheme.typography.bodyMedium
            )
        }

        BasicTextField(
            modifier = Modifier.fillMaxWidth(),
            value = text.value,
            onValueChange = { text.value = it },
            singleLine = true, // Optional, ensures a single line
            textStyle = MaterialTheme.typography.bodyLarge.copy(color = Color.Black)
        )
    }
}
