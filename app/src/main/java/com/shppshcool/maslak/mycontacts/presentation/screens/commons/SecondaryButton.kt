package com.shppshcool.maslak.mycontacts.presentation.screens.commons

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.shppshcool.maslak.mycontacts.ui.theme.OpenSans

@Composable
fun SecondaryButton(
    color: Color,
    text:String,
    onClick:()->Unit
) {
    OutlinedButton(
        onClick = onClick,
        modifier = Modifier.fillMaxWidth(),
        shape = MaterialTheme.shapes.small,
        colors = ButtonDefaults.outlinedButtonColors(
            contentColor = color
        ),
        border = BorderStroke(2.dp, color)
    ) {
        Text(text = text,
            fontFamily = OpenSans
        )

    }
}