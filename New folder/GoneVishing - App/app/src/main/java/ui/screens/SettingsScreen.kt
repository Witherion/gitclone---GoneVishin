package com.example.gonevishing.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.gonevishing.ui.theme.DarkCyan
import com.example.gonevishing.ui.theme.GVOutlinedButton
import com.example.gonevishing.ui.theme.WhiteBlue

@Composable
fun SettingsScreen(
    onBack: () -> Unit
) {
    var scamOverlayEnabled by remember { mutableStateOf(true) }
    var notificationsEnabled by remember { mutableStateOf(true) }
    var vibrationEnabled by remember { mutableStateOf(false) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(WhiteBlue)
            .padding(24.dp),
        verticalArrangement = Arrangement.spacedBy(18.dp)
    ) {
        Text(
            text = "Settings",
            style = MaterialTheme.typography.headlineMedium
        )

        SettingSwitchRow(
            title = "Scam call overlay",
            description = "Show an overlay when a call is flagged.",
            checked = scamOverlayEnabled,
            onCheckedChange = { scamOverlayEnabled = it }
        )

        Divider()

        SettingSwitchRow(
            title = "Notifications",
            description = "Get alerts when scams are detected.",
            checked = notificationsEnabled,
            onCheckedChange = { notificationsEnabled = it }
        )

        SettingSwitchRow(
            title = "Vibration",
            description = "Vibrate when a call is flagged.",
            checked = vibrationEnabled,
            onCheckedChange = { vibrationEnabled = it }
        )

        Spacer(modifier = Modifier.weight(1f))

        GVOutlinedButton(
            onClick = onBack,
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Back")
        }
    }
}

@Composable
private fun SettingSwitchRow(
    title: String,
    description: String,
    checked: Boolean,
    onCheckedChange: (Boolean) -> Unit
) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Column(modifier = Modifier.weight(1f)) {
            Text(text = title, style = MaterialTheme.typography.titleMedium)
            Spacer(modifier = Modifier.height(2.dp))
            Text(text = description, style = MaterialTheme.typography.bodySmall)
        }

        Switch(
            checked = checked,
            onCheckedChange = onCheckedChange,
            colors = SwitchDefaults.colors(
                checkedThumbColor = DarkCyan,
                checkedTrackColor = DarkCyan.copy(alpha = 0.5f),
                uncheckedThumbColor = Color.Gray,
                uncheckedTrackColor = Color.LightGray
            )
        )
    }
}

