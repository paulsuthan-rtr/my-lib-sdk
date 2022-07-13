package com.solidfi.mylibrary

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.solidfi.mylibrary.ui.theme.DemoApplicationTheme

class ComposeActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            DemoApplicationTheme {
                // A surface container using the 'background' color from the theme
                Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colors.background) {
                    Greeting(this@ComposeActivity)
                }
            }
        }
    }
}

@Composable
fun Greeting(activity: Activity) {
    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .align(Alignment.Center),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(text = "Received Auth Token \n" + activity.intent.getStringExtra("AUTH_TOKEN"))
            var label by remember { mutableStateOf("") }
            TextField(
                value = label,
                onValueChange = { label = it },
                label = { Text("Label") }
            )
            Button(
                onClick = {
                    activity.setResult(Activity.RESULT_OK, Intent().putExtra("RESULT", "Callback received successfully!!!\n Label: $label"))
                    activity.finish()
                }
            ) {
                Text(text = "Submit")
            }
        }
    }
}