package com.example.gonevishing.ui.theme

import android.os.Build
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext

private val DarkColorScheme = darkColorScheme(
    primary = DarkBlue,
    secondary = Blue,
    tertiary = DarkCyan,

    background = AppSurfaceDark,
    onBackground = AppOnSurfaceDark,
    surface = AppSurfaceDark,
    onSurface = AppOnSurfaceDark
)

private val LightColorScheme = lightColorScheme(
    primary = WhiteBlue, // keep primary neutral so you don't change many things
    secondary = LightBlue,
    tertiary = Turquoise,

    background = AppBackgroundLight,
    onBackground = AppOnBackgroundLight,
    surface = AppBackgroundLight,
    onSurface = AppOnBackgroundLight
)

@Composable
fun GoneVishingTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    dynamicColor: Boolean = true, // leave true while developing if you want Wallpaper colors on Android 12+
    content: @Composable () -> Unit
) {
    val colorScheme = when {
        dynamicColor && Build.VERSION.SDK_INT >= Build.VERSION_CODES.S -> {
            val context = LocalContext.current
            if (darkTheme) dynamicDarkColorScheme(context) else dynamicLightColorScheme(context)
        }
        darkTheme -> DarkColorScheme
        else -> LightColorScheme
    }

    MaterialTheme(
        colorScheme = colorScheme,
        typography = Typography,
        content = content
    )
}
