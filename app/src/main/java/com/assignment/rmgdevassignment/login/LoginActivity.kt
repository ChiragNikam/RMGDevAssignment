package com.assignment.rmgdevassignment.login

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.assignment.rmgdevassignment.login.data.AppDatabase
import com.assignment.rmgdevassignment.login.data.User
import com.assignment.rmgdevassignment.ui.theme.RMGDevAssignmentTheme
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class LoginActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // database operation
//        val db = AppDatabase.getDatabase(this)
//        val userDao = db.userDao()
//
//        CoroutineScope(Dispatchers.IO).launch {
//            userDao.insertUser(User(email = "user1@example.com", password = "password1"))
//            userDao.insertUser(User(email = "user2@example.com", password = "password2"))
//        }

        enableEdgeToEdge()
        setContent {
            RMGDevAssignmentTheme {
                    LoginScreen()
            }
        }
    }
}