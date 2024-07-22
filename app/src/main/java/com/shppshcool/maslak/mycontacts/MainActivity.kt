package com.shppshcool.maslak.mycontacts

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.shppshcool.maslak.mycontacts.presentation.navigation.destonation.SignUpDestination
import com.shppshcool.maslak.mycontacts.presentation.screens.profile.UserProfileScreen
import com.shppshcool.maslak.mycontacts.ui.theme.MyContactsTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MyContactsTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    SignUpDestination(
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

