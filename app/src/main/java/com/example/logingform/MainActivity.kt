package com.example.logingform

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import com.example.logingform.ui.theme.LogingformTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            LogingformTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    LoginForm(
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun LoginForm(modifier: Modifier = Modifier) {

    var username by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }

    Column (
        modifier = modifier
    ) {
        Text("Login")

        OutlinedTextField(
            value = username,
            onValueChange = {username=it},
            label = { Text("Username") },

            modifier = Modifier.fillMaxWidth(),

            trailingIcon = {
                Icon(
                    imageVector = Icons.Filled.Email,
                    contentDescription ="Email Icon"
                )
            }
        )

        OutlinedTextField(
            value = password,
            onValueChange = {password=it},
            label = { Text("Password") },

            modifier = Modifier.fillMaxWidth(),

            trailingIcon = {
                Icon(
                    imageVector = Icons.Filled.Lock,
                    contentDescription ="Password lock Icon"
                )
            },

            visualTransformation = PasswordVisualTransformation()
        )

        Button(onClick = {}) {
            Text("Submit")
        }
    }

}



@Preview(showBackground = true)
@Composable
fun LoginFormPreview() {
    LogingformTheme {
        LoginForm()
    }
}