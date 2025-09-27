package com.example.smendozaloginapp.screens

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController

@Composable
fun RegisterScreen(
    navController: NavController
) {
    var firstName by remember { mutableStateOf("Vijay") }
    var lastName by remember { mutableStateOf("Bhuva") }
    var email by remember { mutableStateOf("vijaybhuva90@gmail.com") }
    var password by remember { mutableStateOf("••••••") }
    var confirmPassword by remember { mutableStateOf("••••••") }

    Scaffold(
        topBar = {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(200.dp)
                    .background(Color.Black)
            ) {
                IconButton(onClick = {navController.popBackStack() }) {
                    Icon(
                        imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                        contentDescription = "Go Back",
                        tint = Color.White
                    )
                }
                Text(
                    text = "Sign Up",
                    style = MaterialTheme.typography.headlineMedium,
                    fontWeight = FontWeight.Bold,
                    color = Color.White,
                    modifier = Modifier
                        .align(Alignment.Center)
                        .offset(y = (-30).dp)
                )
            }
        }
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
                .background(Color.White)
                .verticalScroll(rememberScrollState()),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Card(
                shape = RoundedCornerShape(topStart = 40.dp, topEnd = 40.dp),
                modifier = Modifier
                    .fillMaxWidth()
                    .offset(y = (-40).dp)
            ) {
                Column(
                    modifier = Modifier
                        .padding(horizontal = 32.dp, vertical = 40.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    // Campo de First name
                    TextField(
                        value = firstName,
                        onValueChange = { firstName = it },
                        label = { Text("First name") },
                        colors = TextFieldDefaults.colors(focusedContainerColor = Color.White, unfocusedContainerColor = Color.White),
                        modifier = Modifier.fillMaxWidth().padding(vertical = 8.dp)
                    )

                    // Campo de Last name
                    TextField(
                        value = lastName,
                        onValueChange = { lastName = it },
                        label = { Text("Last name") },
                        colors = TextFieldDefaults.colors(focusedContainerColor = Color.White, unfocusedContainerColor = Color.White),
                        modifier = Modifier.fillMaxWidth().padding(vertical = 8.dp)
                    )

                    // Campo de Email
                    TextField(
                        value = email,
                        onValueChange = { email = it },
                        label = { Text("Email") },
                        colors = TextFieldDefaults.colors(focusedContainerColor = Color.White, unfocusedContainerColor = Color.White),
                        modifier = Modifier.fillMaxWidth().padding(vertical = 8.dp)
                    )

                    // Campo de Contraseña (Oculta el texto)
                    TextField(
                        value = password,
                        onValueChange = { password = it },
                        label = { Text("Password") },
                        visualTransformation = PasswordVisualTransformation(),
                        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
                        colors = TextFieldDefaults.colors(focusedContainerColor = Color.White, unfocusedContainerColor = Color.White),
                        modifier = Modifier.fillMaxWidth().padding(vertical = 8.dp)
                    )

                    // Campo de Confirmar Contraseña (Oculta el texto)
                    TextField(
                        value = confirmPassword,
                        onValueChange = { confirmPassword = it },
                        label = { Text("Confirm password") },
                        visualTransformation = PasswordVisualTransformation(),
                        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
                        colors = TextFieldDefaults.colors(focusedContainerColor = Color.White, unfocusedContainerColor = Color.White),
                        modifier = Modifier.fillMaxWidth().padding(vertical = 8.dp)
                    )

                    Spacer(modifier = Modifier.height(32.dp))

                    Button(
                        onClick = {
                            val newEmail = email // El email que se acaba de registrar
                            val userData = UserData(email = newEmail)

                            navController.navigate(LoginScreenRoute(userData = userData)) {
                                popUpTo<LoginScreenRoute> { inclusive = true }
                            }
                        },
                        colors = ButtonDefaults.buttonColors(containerColor = Color.Black),
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(50.dp)                    ) {
                        Text(
                            text = "Sign up",
                            color = Color.White
                        )
                    }

                    Spacer(modifier = Modifier.height(60.dp))

                }
            }

            TextButton(
                onClick = {
                    navController.navigate(LoginScreenRoute()) {
                        popUpTo<LoginScreenRoute> { inclusive = true }
                    }
                },
                modifier = Modifier.offset(y= (-40).dp)
            ) {
                Text(
                    text = "Already have an account? Sign in",
                    color = Color.Black
                )
            }

        }

    }

}