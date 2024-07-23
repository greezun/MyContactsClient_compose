package com.shppshcool.maslak.mycontacts.presentation.screens.autth.sign_up.compose

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
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
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.selection.toggleable
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Done
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.shppshcool.maslak.mycontacts.R
import com.shppshcool.maslak.mycontacts.presentation.screens.autth.AuthOutlineButton
import com.shppshcool.maslak.mycontacts.presentation.screens.autth.SpannedClickableText
import com.shppshcool.maslak.mycontacts.presentation.screens.autth.sign_up.SignUpContract
import com.shppshcool.maslak.mycontacts.presentation.screens.base.SIDE_EFFECTS_KEY
import com.shppshcool.maslak.mycontacts.presentation.screens.utils.spanList
import com.shppshcool.maslak.mycontacts.ui.theme.GrayText2
import com.shppshcool.maslak.mycontacts.ui.theme.MyContactsTheme
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.flow.collect

@Composable
fun SignUpScreen(
    modifier: Modifier = Modifier,
    state: SignUpContract.State,
    effectFlow: Flow<SignUpContract.Effect>?,
    onEventSent: (event: SignUpContract.Event) -> Unit,
    onNavigationRequested: (SignUpContract.Effect.Navigation) -> Unit

) {

    LaunchedEffect(SIDE_EFFECTS_KEY) {
        effectFlow?.onEach { effect ->
            when (effect) {
                is SignUpContract.Effect.Navigation.ToProfileDetail -> onNavigationRequested(effect)
            }
        }?.collect()
    }



    Box(
        modifier = modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.tertiary)
    )

    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Column(
            modifier = Modifier.weight(0.6f),
            verticalArrangement = Arrangement.Bottom
        ) {
            Text(
                text = stringResource(R.string.get_acquainted),
                style = MaterialTheme.typography.headlineLarge,
                color = MaterialTheme.colorScheme.onPrimary
            )

            Text(
                text = stringResource(R.string.fill_out_the_profile),
                style = MaterialTheme.typography.bodySmall,
                color = MaterialTheme.colorScheme.onPrimary
            )
        }


        Column(
            modifier = Modifier.weight(1f),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            Spacer(modifier = Modifier.height(24.dp))
            Text(
                text = stringResource(R.string.e_mail),
                modifier = Modifier.align(Alignment.Start),
                style = MaterialTheme.typography.labelLarge,
                color = GrayText2
            )

            TextField(
                value = state.email,
                onValueChange = { onEventSent(SignUpContract.Event.Email(it.trim())) },
                modifier = Modifier.fillMaxWidth(),
                isError = state.isEmailError,
                singleLine = true,
                supportingText = {
                    val text =
                        if (state.isEmailError) stringResource(R.string.email_error_message) else ""
                    Text(text)
                },
                colors = TextFieldDefaults.colors(
                    errorContainerColor = Color.Transparent,
                    errorTextColor = MaterialTheme.colorScheme.error,
                    focusedContainerColor = Color.Transparent,
                    unfocusedContainerColor = Color.Transparent,
                    cursorColor = MaterialTheme.colorScheme.onPrimary,
                    focusedTextColor = MaterialTheme.colorScheme.onPrimary,
                    unfocusedTextColor = MaterialTheme.colorScheme.onPrimary,
                )
            )

            var passwordVisible by remember { mutableStateOf(false) }
            Spacer(modifier = Modifier.height(24.dp))
            Text(
                text = stringResource(R.string.password),
                modifier = Modifier.align(Alignment.Start),
                style = MaterialTheme.typography.labelLarge,
                color = GrayText2
            )

            TextField(
                value = state.password,
                onValueChange = { onEventSent(SignUpContract.Event.Password(it)) },
                modifier = Modifier.fillMaxWidth(),
                isError = state.isPasswordError,
                singleLine = true,
                supportingText = {
                    val text =
                        if (state.isPasswordError) stringResource(R.string.password_error_message) else ""
                    Text(text)
                },
                visualTransformation = if (passwordVisible) VisualTransformation.None else PasswordVisualTransformation(),
                colors = TextFieldDefaults.colors(
                    errorContainerColor = Color.Transparent,
                    errorTextColor = MaterialTheme.colorScheme.error,
                    focusedContainerColor = Color.Transparent,
                    unfocusedContainerColor = Color.Transparent,
                    cursorColor = MaterialTheme.colorScheme.onPrimary,
                    focusedTextColor = MaterialTheme.colorScheme.onPrimary,
                    unfocusedTextColor = MaterialTheme.colorScheme.onPrimary,
                ),

                trailingIcon = {
                    val image = if (passwordVisible) {
                        R.drawable.baseline_visibility_24
                    } else {
                        R.drawable.baseline_visibility_off_24
                    }
                    IconButton(onClick = { passwordVisible = !passwordVisible }) {
                        Icon(
                            painter = painterResource(id = image),
                            contentDescription = null
                        )
                    }
                }
            )

            Row(
                Modifier
                    .fillMaxWidth()
                    .height(56.dp)
                    .toggleable(
                        value = state.checkboxChecked,
                        onValueChange = { onEventSent(SignUpContract.Event.Checkbox) },
                        role = Role.Checkbox
                    ),
                verticalAlignment = Alignment.CenterVertically
            ) {

                Box(
                    modifier = Modifier
                        .size(24.dp)
                        .border(1.dp, MaterialTheme.colorScheme.onPrimary, RoundedCornerShape(4.dp))
                )
                {
                    if (state.checkboxChecked) {
                        Icon(
                            imageVector = Icons.Default.Done, contentDescription = null,
                            tint = MaterialTheme.colorScheme.onPrimary
                        )
                    }

                }
                Text(
                    text = stringResource(R.string.remember_me),
                    style = MaterialTheme.typography.labelLarge,
                    color = GrayText2,
                    modifier = Modifier.padding(start = 16.dp)
                )
            }
        }
        Column(
            modifier = Modifier.weight(1f),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Bottom
        ) {

            Spacer(modifier = Modifier.height(24.dp))
            AuthOutlineButton(
                textResource = R.string.register,
                enable = state.registerButtonEnabled
            ) {
                onEventSent(SignUpContract.Event.Register)

            }


            Spacer(modifier = Modifier.height(24.dp))
            SpannedClickableText(
                modifier = Modifier.padding(horizontal = 40.dp),
                fullText = stringResource(R.string.by_clicking_register),
                spans = spanList
            )
            Spacer(modifier = Modifier.height(24.dp))
            SpannedClickableText(
                modifier = Modifier.fillMaxWidth(),
                fullText = stringResource(R.string.already_have_an_account),
                spans = spanList,
                style = MaterialTheme.typography.labelLarge
            )

        }

    }

}

@Preview
@Composable
private fun Preview() {
    MyContactsTheme {
        SignUpScreen(
            state = SignUpContract.State(
                email = "",
                isEmailError = true,
                password = "",
                isPasswordError = true,
                checkboxChecked = false

            ),
            effectFlow = null,
            onEventSent = {},
            onNavigationRequested = {}
        )

    }

}