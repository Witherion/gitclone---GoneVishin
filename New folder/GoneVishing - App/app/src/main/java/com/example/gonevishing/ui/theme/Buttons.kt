package com.example.gonevishing.ui.theme

import androidx.compose.foundation.layout.RowScope
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.OutlinedButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color

/**
 * GVButton - primary button used across the app.
 * containerColor and contentColor use DarkCyan / WhiteBlue as requested.
 */
@Composable
fun GVButton(
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    containerColor: Color = DarkCyan,
    contentColor: Color = WhiteBlue,
    content: @Composable RowScope.() -> Unit
) {
    Button(
        onClick = onClick,
        modifier = modifier,
        colors = ButtonDefaults.buttonColors(
            containerColor = containerColor,
            contentColor = contentColor
        ),
        content = content
    )
}

/**
 * GVOutlinedButton - outlined variant that uses DarkCyan for content/border by default.
 */
@Composable
fun GVOutlinedButton(
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    content: @Composable RowScope.() -> Unit
) {
    OutlinedButton(
        onClick = onClick,
        modifier = modifier,
        colors = ButtonDefaults.outlinedButtonColors(
            contentColor = DarkCyan
        ),
    ) {
        content()
    }
}
