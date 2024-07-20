package com.shppshcool.maslak.mycontacts.presentation.screens.profile

import androidx.compose.foundation.BorderStroke
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
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.shppshcool.maslak.mycontacts.R
import com.shppshcool.maslak.mycontacts.presentation.screens.profile.utils.socialNetworkImage
import com.shppshcool.maslak.mycontacts.ui.theme.MyContactsTheme

@Composable
fun UserProfileScreen(modifier: Modifier = Modifier) {

    Column(modifier = modifier.fillMaxSize()) {
        Box(
            modifier = Modifier
                .weight(1f)
                .background(MaterialTheme.colorScheme.primary)
        ) {

            val scrollState = rememberScrollState()
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(16.dp)
                    .verticalScroll(scrollState),
                horizontalAlignment = Alignment.CenterHorizontally

            ) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,

                    ) {

                    Text(
                        text = "Settings",
                        style = MaterialTheme.typography.headlineLarge,
                        color = MaterialTheme.colorScheme.onPrimary
                    )

                    OutlinedButton(
                        onClick = { /*TODO*/ },
                        shape = MaterialTheme.shapes.small
                    ) {
                        Text(
                            text = "Log out",
                            style = MaterialTheme.typography.labelLarge,
                            color = MaterialTheme.colorScheme.onSecondaryContainer
                        )
                    }
                }

                Spacer(modifier = Modifier.height(16.dp))
                Image(
                    modifier = Modifier
                        .size(113.dp)
                        .clip(CircleShape)
                        .background(MaterialTheme.colorScheme.background),
                    painter = painterResource(id = R.drawable.moc),
                    contentDescription = null,
                )
                Spacer(modifier = Modifier.height(24.dp))
                Text(
                    text = "Name",
                    style = MaterialTheme.typography.titleLarge,
                    color = MaterialTheme.colorScheme.onPrimary
                )
                Spacer(modifier = Modifier.height(16.dp))
                Text(
                    text = "Carer",
                    style = MaterialTheme.typography.bodyMedium,
                    color = MaterialTheme.colorScheme.onSecondaryContainer
                )
                Spacer(modifier = Modifier.height(24.dp))

                Text(
                    text = "Home address",
                    style = MaterialTheme.typography.bodyMedium,
                    color = MaterialTheme.colorScheme.onSecondaryContainer
                )

            }

        }

        Box(
            modifier = Modifier
                .weight(1f)
                .background(MaterialTheme.colorScheme.background)
        ) {

            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(16.dp)
            ) {
                LazyRow(
                    modifier = Modifier
                        .fillMaxWidth()
                        .weight(1f),
                    horizontalArrangement = Arrangement.SpaceEvenly,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    items(socialNetworkImage.size) {
                        Image(
                            modifier = Modifier.size(60.dp),
                            painter = painterResource(id = socialNetworkImage[it]),
                            contentDescription = null
                        )
                    }
                }

                Column {
                    OutlinedButton(
                        onClick = { /*TODO*/ },
                        modifier = Modifier.fillMaxWidth(),
                        shape = MaterialTheme.shapes.small,
                        colors = ButtonDefaults.outlinedButtonColors(
                            contentColor = MaterialTheme.colorScheme.onSurface
                        ),
                        border = BorderStroke(2.dp, MaterialTheme.colorScheme.primary)
                    ) {
                        Text(text = "Edit profile")

                    }

                    Spacer(modifier = Modifier.height(16.dp))
                    Button(
                        onClick = { /*TODO*/ },

                        modifier = Modifier
                            .fillMaxWidth(),
                        shape = MaterialTheme.shapes.small,
                        colors = ButtonDefaults.buttonColors(
                            containerColor = MaterialTheme.colorScheme.tertiary
                        )

                    ) {
                        Text(
                            modifier = Modifier.padding(vertical = 6.dp),
                            text = "view my profile".uppercase(),
                            style = MaterialTheme.typography.labelLarge

                        )

                    }
                }
            }
        }
    }
}

@Preview
@Composable
private fun Preview() {
    MyContactsTheme {
        UserProfileScreen()
    }

}