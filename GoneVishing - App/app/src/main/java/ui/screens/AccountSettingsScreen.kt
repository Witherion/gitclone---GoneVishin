package com.example.gonevishing.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.gonevishing.R
import com.example.gonevishing.ui.theme.Blue
import com.example.gonevishing.ui.theme.DarkBlue
import com.example.gonevishing.ui.theme.GVButton
import com.example.gonevishing.ui.theme.LightBlue
import com.example.gonevishing.ui.theme.WhiteBlue

@Composable
fun AccountSettingsScreen(
    onSave: (username: String, email: String, phone: String) -> Unit = { _, _, _ -> },
    onBack: () -> Unit = {},
    onEditProfilePicture: () -> Unit = {},
    onPasswordSettings: () -> Unit = {},
    initialUsername: String = "",
    initialEmail: String = "",
    initialPhone: String = ""
) {
    var username by remember { mutableStateOf(initialUsername) }
    var email by remember { mutableStateOf(initialEmail) }
    var phone by remember { mutableStateOf(initialPhone) }

    val fieldColors = OutlinedTextFieldDefaults.colors(
        focusedBorderColor = Color.White,
        unfocusedBorderColor = Color.White,
        focusedTextColor = Color.White,
        unfocusedTextColor = Color.White,
        cursorColor = Color.White,
        focusedContainerColor = Color.Transparent,
        unfocusedContainerColor = Color.Transparent
    )

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(WhiteBlue)
            .navigationBarsPadding()
            .padding(horizontal = 24.dp, vertical = 24.dp)
    ) {
        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Spacer(Modifier.height(24.dp))

            Row(verticalAlignment = Alignment.CenterVertically) {
                Image(
                    painter = painterResource(id = R.drawable.account_icon),
                    contentDescription = "Account Icon",
                    modifier = Modifier
                        .size(150.dp)
                        .clip(RoundedCornerShape(100.dp)),
                    contentScale = ContentScale.Crop
                )

                Spacer(Modifier.width(16.dp))

                GVButton(
                    onClick = onEditProfilePicture,
                ) {
                    Text("Edit Profile Picture")
                }
            }

            Spacer(Modifier.height(40.dp))

            LabeledOutlinedField(
                label = "Username:",
                value = username,
                onValueChange = { username = it },
                colors = fieldColors,
                labelBg = LightBlue,
                labelTextColor = Color.White
            )

            Spacer(Modifier.height(16.dp))

            LabeledOutlinedField(
                label = "Email:",
                value = email,
                onValueChange = { email = it },
                colors = fieldColors,
                labelBg = LightBlue,
                labelTextColor = Color.White
            )

            Spacer(Modifier.height(16.dp))

            LabeledOutlinedField(
                label = "Phone:",
                value = phone,
                onValueChange = { phone = it },
                colors = fieldColors,
                labelBg = LightBlue,
                labelTextColor = Color.White
            )

            Spacer(Modifier.height(32.dp))

            Surface(
                onClick = onPasswordSettings,
                shape = RoundedCornerShape(20.dp),
                color = Color(0xFFD5E8C8),
                modifier = Modifier
                    .fillMaxWidth()
                    .height(80.dp)
            ) {
                Box(contentAlignment = Alignment.Center) {
                    Text(
                        text = "Login Passwords/Passkeys",
                        style = MaterialTheme.typography.titleMedium,
                        fontWeight = FontWeight.Medium
                    )
                }
            }

            Spacer(Modifier.weight(1f))

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 12.dp),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Button(
                    onClick = { onSave(username, email, phone) },
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color(0xFF32a877)
                    ),
                    shape = RoundedCornerShape(20.dp)
                ) {
                    Text("Save")
                }

                Button(
                    onClick = onBack,
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color(0xFF8D6E63)
                    ),
                    shape = RoundedCornerShape(20.dp)
                ) {
                    Text("Back")
                }
            }
        }
    }
}

@Composable
private fun LabeledOutlinedField(
    label: String,
    value: String,
    onValueChange: (String) -> Unit,
    colors: TextFieldColors,
    labelBg: Color,
    labelTextColor: Color
) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Surface(
            shape = RoundedCornerShape(16.dp),
            color = labelBg,
            modifier = Modifier.padding(end = 12.dp)
        ) {
            Text(
                text = label,
                modifier = Modifier.padding(horizontal = 16.dp, vertical = 12.dp),
                color = labelTextColor
            )
        }

        OutlinedTextField(
            value = value,
            onValueChange = onValueChange,
            singleLine = true,
            label = null,
            modifier = Modifier
                .weight(1f)
                .height(56.dp),
            colors = colors,
            shape = RoundedCornerShape(16.dp)
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun AccountSettingsPreview() {
    AccountSettingsScreen(
        initialUsername = "jazzywazzy",
        initialEmail = "jasmine@example.com",
        initialPhone = "(818)-123-4567"
    )
}

