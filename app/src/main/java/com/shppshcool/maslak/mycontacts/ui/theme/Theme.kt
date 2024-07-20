package com.shppshcool.maslak.mycontacts.ui.theme

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable


private val LightColorScheme = lightColorScheme(
    primary = Blue,
    secondary = White,
    tertiary = Orange,
    background = White,
    surface = White,
    onPrimary = White,
    onSecondary = GrayText,
    onTertiary = White,
    onBackground = GrayText,
    onSurface = GrayText,
    secondaryContainer = GrayText2,
    onSecondaryContainer = GrayText2,
)

@Composable
fun MyContactsTheme(
    content: @Composable () -> Unit
) {
    MaterialTheme(
        colorScheme = LightColorScheme,
        typography = Typography,
        content = content
    )
}