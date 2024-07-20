package com.shppshcool.maslak.mycontacts.presentation.screens.profile.autth

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
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.shppshcool.maslak.mycontacts.R
import com.shppshcool.maslak.mycontacts.presentation.screens.profile.utils.spanList
import com.shppshcool.maslak.mycontacts.ui.theme.GrayText2
import com.shppshcool.maslak.mycontacts.ui.theme.MyContactsTheme

@Composable
fun SignUpScreen(modifier: Modifier = Modifier) {
    Box(
        modifier = modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.primary)
    )

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Column(
            modifier = Modifier.weight(0.7f),
            verticalArrangement = Arrangement.Bottom
        ) {
            Text(
                text = "Let's get acquainted",
                style = MaterialTheme.typography.headlineLarge,
                color = MaterialTheme.colorScheme.onPrimary
            )

            Text(
                text = "Fill out the profile and go to the application!",
                style = MaterialTheme.typography.bodySmall,
                color = MaterialTheme.colorScheme.onPrimary
            )
        }


        Column(modifier = Modifier.weight(1f),
            horizontalAlignment = Alignment.CenterHorizontally

        ) {
            var email by remember {
                mutableStateOf("")
            }



            Spacer(modifier = Modifier.height(24.dp))
            Text(
                text = "E-mail",
                modifier = Modifier.align(Alignment.Start),
                style = MaterialTheme.typography.labelLarge,
                color = GrayText2
            )

            TextField(
                value = email,
                onValueChange = { email = it },
                modifier = Modifier.fillMaxWidth(),
                colors = TextFieldDefaults.colors(
                    focusedContainerColor = Color.Transparent,
                    unfocusedContainerColor = Color.Transparent,
                    cursorColor = MaterialTheme.colorScheme.onPrimary,
                    focusedTextColor = MaterialTheme.colorScheme.onPrimary,
                    unfocusedTextColor = MaterialTheme.colorScheme.onPrimary,
                )
            )

            var password by remember {
                mutableStateOf("")

            }
            var passwordVisible by remember { mutableStateOf(false) }
            Spacer(modifier = Modifier.height(24.dp))
            Text(
                text = "Password",
                modifier = Modifier.align(Alignment.Start),
                style = MaterialTheme.typography.labelLarge,
                color = GrayText2
            )

            TextField(
                value = password,
                onValueChange = { password = it },
                modifier = Modifier.fillMaxWidth(),
                visualTransformation = if (passwordVisible) VisualTransformation.None else PasswordVisualTransformation(),
                colors = TextFieldDefaults.colors(
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
                            contentDescription = if (passwordVisible) "Hide password" else "Show password"
                        )
                    }
                }
            )

            val (checkedState, onStateChange) = remember { mutableStateOf(false) }
            Row(
                Modifier
                    .fillMaxWidth()
                    .height(56.dp)
                    .toggleable(
                        value = checkedState,
                        onValueChange = { onStateChange(!checkedState) },
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
                    if (checkedState) {
                        Icon(
                            imageVector = Icons.Default.Done, contentDescription = null,
                            tint = MaterialTheme.colorScheme.onPrimary
                        )
                    }

                }
                Text(
                    text = "Remember me",
                    style = MaterialTheme.typography.labelLarge,
                    color = GrayText2,
                    modifier = Modifier.padding(start = 16.dp)
                )
            }
        }
        Column(modifier = Modifier.weight(1f),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {


            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(60.dp)
                    .background(
                        color = MaterialTheme.colorScheme.background,
                        shape = MaterialTheme.shapes.small
                    ),
                contentAlignment = Alignment.Center

            ) {

                Row {
                    Image(
                        modifier = Modifier.size(20.dp),
                        painter = painterResource(id = R.drawable.g),
                        contentDescription = null
                    )
                    Spacer(modifier = Modifier.width(8.dp))
                    Text(text = "google".uppercase())
                }

            }
            Spacer(modifier = Modifier.height(24.dp))
            Text(text = "or",
                style = MaterialTheme.typography.titleLarge,
                color = MaterialTheme.colorScheme.onPrimary
            )
            Spacer(modifier = Modifier.height(24.dp))




            Spacer(modifier = Modifier.height(24.dp))
            SpannedClickableText(
                modifier = Modifier.padding(horizontal = 40.dp),
                fullText = "By clicking Register you agree to our Terms and Conditions",
                spans = spanList
            )
            Spacer(modifier = Modifier.height(24.dp))
            SpannedClickableText(
                modifier = Modifier.fillMaxWidth(),
                fullText = "Already have an account? Sign in",
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
        SignUpScreen()

    }
}