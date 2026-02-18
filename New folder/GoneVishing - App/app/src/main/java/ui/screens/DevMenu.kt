package com.example.gonevishing.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.gonevishing.ui.theme.GVButton

@Composable
fun DevMenuScreen(
    onOpenLogin: () -> Unit,
    onOpenHome: () -> Unit,
    onOpenAccountSettings: () -> Unit,
    onOpenSendToAgentOverlay: () -> Unit,
    onOpenSettingsScreen: () -> Unit,
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        Text(
            text = "DEV MENU",
            style = MaterialTheme.typography.headlineMedium
        )

        GVButton(
            onClick = onOpenLogin,
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Login Screen")
        }

        GVButton(
            onClick = onOpenHome,
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Home Screen")
        }

        GVButton(
            onClick = onOpenAccountSettings,
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Account Settings")
        }

        GVButton(
            onClick = onOpenSendToAgentOverlay,
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Send to Agent Overlay")
        }

        GVButton(
            onClick = onOpenSettingsScreen,
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Settings Screen")
        }
    }
}
