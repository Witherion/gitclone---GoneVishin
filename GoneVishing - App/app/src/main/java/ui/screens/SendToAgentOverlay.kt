package com.example.gonevishing.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.gonevishing.R
import com.example.gonevishing.ui.theme.DarkCyan

@Composable
fun SendToAgentOverlay(
    callerName: String,
    callerNumber: String,
    onDismiss: () -> Unit,
    onSendToAgent: () -> Unit,
    onBlockNumber: () -> Unit
) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.scrim.copy(alpha = 0.6f)),
        contentAlignment = Alignment.Center
    ) {
        Card(
            shape = RoundedCornerShape(16.dp),
            modifier = Modifier
                .padding(24.dp)
                .fillMaxWidth()
        ) {
            Column(
                modifier = Modifier.padding(24.dp),
                verticalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.spacedBy(8.dp)
                ) {

                    Image(
                        painter = painterResource(id = R.drawable.fishing_bobber),
                        contentDescription = "Fishing bobber icon",
                        modifier = Modifier.size(32.dp)
                    )

                    Text(
                        text = "Potential Scam Call!",
                        style = MaterialTheme.typography.headlineSmall
                    )
                }

                Column {
                    Text(
                        text = callerName,
                        style = MaterialTheme.typography.titleMedium
                    )
                    Text(
                        text = callerNumber,
                        style = MaterialTheme.typography.bodyMedium
                    )
                }

                Text(
                    text = "Gone Vishing has flagged this call as possible scam. Would you like to send it to your AI agent?",
                    style = MaterialTheme.typography.bodyMedium
                )

                Row(
                    horizontalArrangement = Arrangement.spacedBy(8.dp),
                    modifier = Modifier.fillMaxWidth()
                ) {

                    OutlinedButton(
                        onClick = onDismiss,
                        modifier = Modifier.weight(1f),
                        colors = ButtonDefaults.outlinedButtonColors(
                            contentColor = DarkCyan
                        )
                    ) {
                        Text("Dismiss")
                    }

                    Button(
                        onClick = onSendToAgent,
                        modifier = Modifier.weight(1f),
                        colors = ButtonDefaults.buttonColors(
                            containerColor = DarkCyan
                        )
                    ) {
                        Text("Send to Agent")
                    }
                }
            }
        }
    }
}



