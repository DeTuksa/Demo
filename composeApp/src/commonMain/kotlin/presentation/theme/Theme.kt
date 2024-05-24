package presentation.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable

private val darkColorPalette = darkColorScheme(
    primary = primaryColor,
    primaryContainer = primaryVariantColor,
    secondary = AccentColor
)

private val lightColorPalette = lightColorScheme(
    primary = primaryColor,
    primaryContainer = primaryVariantColor,
    secondary = AccentColor,
    background = background,
    surfaceVariant = background,
    surface = lightSurface
)

@Composable
fun AppTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    val colors = if (darkTheme) {
        darkColorPalette
    } else {
        lightColorPalette
    }

    MaterialTheme(
        colorScheme = colors,
        typography = InterTypography(),
        shapes = Shapes,
        content = content
    )
}