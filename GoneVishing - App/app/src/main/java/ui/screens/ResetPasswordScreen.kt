package com.example.gonevishing.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun ResetPasswordScreen(
    onBack: () -> Unit      //defined onBack in AppRouter, and Unit is basically like void
) {
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text("Reset Password")
        Spacer(Modifier.height(16.dp))
        Text("This feature is coming soon.")
        Spacer(Modifier.height(16.dp))
        Button(onClick = onBack) {
            Text("Back to login")
        }
    }
}
