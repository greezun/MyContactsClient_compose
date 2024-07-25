package com.shppshcool.maslak.mycontacts.presentation.screens.autth.add_profile_data

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.KeyboardCapitalization
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.shppshcool.maslak.mycontacts.R
import com.shppshcool.maslak.mycontacts.presentation.screens.autth.PagerTitle
import com.shppshcool.maslak.mycontacts.presentation.screens.commons.MainButton
import com.shppshcool.maslak.mycontacts.presentation.screens.commons.SecondaryButton
import com.shppshcool.maslak.mycontacts.ui.theme.GrayText2
import com.shppshcool.maslak.mycontacts.ui.theme.MyContactsTheme
import com.shppshcool.maslak.mycontacts.ui.theme.White

@Composable
fun AddProfileData(modifier: Modifier = Modifier) {

    Box(
        modifier = modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.tertiary)
    ) {

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(dimensionResource(id = R.dimen.standard_padding)),

            verticalArrangement = Arrangement.SpaceBetween
        ) {

            Column(modifier = Modifier.fillMaxWidth(),
                horizontalAlignment = Alignment.CenterHorizontally,) {

                Spacer(modifier = Modifier.size(60.dp))
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Image(
                        modifier = Modifier.size(dimensionResource(id = R.dimen.main_avatar_size)),
                        painter = painterResource(id = R.drawable.mocup1), contentDescription = null
                    )
                    Spacer(modifier = Modifier.size(dimensionResource(id = R.dimen.standard_padding)))
                    Image(
                        modifier = Modifier.size(dimensionResource(id = R.dimen.add_picture_size)),
                        painter = painterResource(id = R.drawable.add), contentDescription = null
                    )
                }
                Spacer(modifier = Modifier.height(24.dp))
                PagerTitle(
                    mainTitle = stringResource(id = R.string.add_profile_detail_title),
                    subTitle = stringResource(id = R.string.add_profile_detail_subtitle)
                )
                Spacer(modifier = Modifier.height(24.dp))
                Text(
                    text = stringResource(R.string.user_name),
                    modifier = Modifier.align(Alignment.Start),
                    style = MaterialTheme.typography.labelLarge,
                    color = GrayText2
                )

                var name by remember { mutableStateOf("") }

                TextField(
                    value = name,
                    onValueChange = { name = it },
                    modifier = Modifier.fillMaxWidth(),
                    singleLine = true,
                    colors = TextFieldDefaults.colors(
                        focusedIndicatorColor = GrayText2,
                        unfocusedIndicatorColor = GrayText2,

                        focusedContainerColor = Color.Transparent,
                        unfocusedContainerColor = Color.Transparent,
                        cursorColor = MaterialTheme.colorScheme.onPrimary,
                        focusedTextColor = MaterialTheme.colorScheme.onPrimary,
                        unfocusedTextColor = MaterialTheme.colorScheme.onPrimary,
                    ),
                    keyboardOptions = KeyboardOptions(capitalization = KeyboardCapitalization.Words)
                )

                Spacer(modifier = Modifier.height(24.dp))
                Text(
                    text = stringResource(R.string.phone),
                    modifier = Modifier.align(Alignment.Start),
                    style = MaterialTheme.typography.labelLarge,
                    color = GrayText2
                )

                var phone by remember { mutableStateOf("") }

                TextField(
                    value = phone,
                    onValueChange = { phone = it },
                    modifier = Modifier.fillMaxWidth(),
                    singleLine = true,
                    colors = TextFieldDefaults.colors(
                        focusedIndicatorColor = GrayText2,
                        unfocusedIndicatorColor = GrayText2,
                        focusedContainerColor = Color.Transparent,
                        unfocusedContainerColor = Color.Transparent,
                        cursorColor = MaterialTheme.colorScheme.onPrimary,
                        focusedTextColor = MaterialTheme.colorScheme.onPrimary,
                        unfocusedTextColor = MaterialTheme.colorScheme.onPrimary,
                    ),
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Phone)
                )
            }

            Column(modifier = Modifier.fillMaxWidth()) {
                SecondaryButton(color = White, text = stringResource(id = R.string.cansel)) {

                }
                Spacer(modifier = Modifier.height(16.dp))
                MainButton(
                    text = stringResource(id = R.string.forward)
                ) {

                }
            }
        }
    }

}

@Preview
@Composable
private fun Preview() {
    MyContactsTheme {
        AddProfileData()
    }
}