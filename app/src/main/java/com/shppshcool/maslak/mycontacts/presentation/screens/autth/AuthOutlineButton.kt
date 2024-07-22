package com.shppshcool.maslak.mycontacts.presentation.screens.autth

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.shppshcool.maslak.mycontacts.ui.theme.GrayText
import com.shppshcool.maslak.mycontacts.ui.theme.Orange
import com.shppshcool.maslak.mycontacts.ui.theme.White

@Composable
fun AuthOutlineButton(
    textResource:Int,
    enable: Boolean = true,
    onClick: () -> Unit = {}
) {


    OutlinedButton(
        onClick = onClick,
        modifier = Modifier.fillMaxWidth(),
        enabled = enable,
        shape = MaterialTheme.shapes.small,
        border = BorderStroke(width = 2.dp, color = if(enable) Orange else GrayText),
        contentPadding = PaddingValues(vertical = 16.dp)

    ) {

        Text(text = stringResource(id = textResource).uppercase(),
            color = if(enable) White else GrayText
        )

    }

}

