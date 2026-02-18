package com.example.gonevishing.ui.screens

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import ui.screens.HomeScreen

private enum class Screen {
    DevMenu,
    Login,
    Home,
    ResetPassword,
    AccountSettingsScreen,
    SettingsScreen
}

@Composable
fun AppRouter() {

    //DevMenu
    var screen by remember { mutableStateOf(Screen.DevMenu) }

    var showSendToAgentOverlay by remember { mutableStateOf(false) }

    Box(modifier = Modifier.fillMaxSize()) {

        when (screen) {

            Screen.DevMenu ->
                DevMenuScreen(
                    onOpenLogin = { screen = Screen.Login },
                    onOpenHome = { screen = Screen.Home },
                    onOpenAccountSettings = { screen = Screen.AccountSettingsScreen },
                    onOpenSendToAgentOverlay = { showSendToAgentOverlay = true },
                    onOpenSettingsScreen = { screen = Screen.SettingsScreen }
                )

            Screen.Login ->
                LoginScreen(
                    onLoginSuccess = { screen = Screen.Home },
                    onForgotPassword = { screen = Screen.ResetPassword }
                )

            Screen.Home ->
                HomeScreen(
                    onAccountClick = { screen = Screen.AccountSettingsScreen },
                    onSettingsClick = { screen = Screen.SettingsScreen }
                )

            Screen.ResetPassword ->
                ResetPasswordScreen(
                    onBack = { screen = Screen.Login }
                )

            Screen.AccountSettingsScreen ->
                AccountSettingsScreen(
                    onSave = { _, _, _ -> screen = Screen.Home },
                    onBack = { screen = Screen.Home }
                )

            Screen.SettingsScreen ->
                SettingsScreen(
                    onBack  = { screen = Screen.Home }
                )
        }

        // Overlay sits above everything
        if (showSendToAgentOverlay) {
            SendToAgentOverlay(
                callerName = "Scam Caller",
                callerNumber = "+1 (818) 123-4567",
                onDismiss = { showSendToAgentOverlay = false },
                onSendToAgent = { showSendToAgentOverlay = false },
                onBlockNumber = { showSendToAgentOverlay = false }
            )
        }
    }
}


