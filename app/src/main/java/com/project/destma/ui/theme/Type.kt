package com.project.destma.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.project.destma.R

val openSans = FontFamily(
    listOf(
        Font(R.font.opensans_light, FontWeight.Thin),
        Font(R.font.opensans_regular, FontWeight.Normal),
        Font(R.font.opensans_medium, FontWeight.Medium),
        Font(R.font.opensans_semibold, FontWeight.SemiBold),
        Font(R.font.opensans_bold, FontWeight.Bold),
        Font(R.font.opensans_extrabold, FontWeight.ExtraBold)
    )
)

// Set of Material typography styles to start with
val Typography = Typography(
    titleLarge = TextStyle(
        fontFamily = openSans,
        fontWeight = FontWeight.SemiBold,
        fontSize = 24.sp,
    ),
    titleSmall = TextStyle(
        fontFamily = openSans,
        fontWeight = FontWeight.SemiBold,
        fontSize = 14.sp,
    ),
    bodyLarge = TextStyle(
        fontFamily = openSans,
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp,
    ),
    bodyMedium = TextStyle(
        fontFamily = openSans,
        fontWeight = FontWeight.Normal,
        fontSize = 12.sp,
    ),
    bodySmall = TextStyle(
        fontFamily = openSans,
        fontWeight = FontWeight.Light,
        fontSize = 12.sp,
    ),
    labelLarge = TextStyle(
        fontFamily = openSans,
        fontWeight = FontWeight.SemiBold,
        fontSize = 16.sp,
    ),
    labelMedium = TextStyle(
        fontFamily = openSans,
        fontWeight = FontWeight.Normal,
        fontSize = 14.sp,
    ),
    labelSmall = TextStyle(
        fontFamily = openSans,
        fontSize = 10.sp,
    ),

)

