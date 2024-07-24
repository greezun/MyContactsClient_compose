package com.shppshcool.maslak.mycontacts.presentation.screens.commons

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun MainButton(
    text:String,
    onClick:()->Unit
) {

    Button(
        onClick = onClick,

        modifier = Modifier
            .fillMaxWidth(),
        shape = MaterialTheme.shapes.small,

    ) {
        Text(
            modifier = Modifier.padding(vertical = 6.dp),
            text = text.uppercase(),
            style = MaterialTheme.typography.labelLarge
        )

    }

}