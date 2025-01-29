package com.jetpack.letsgoscreenapp

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.jetpack.letsgoscreenapp.ui.theme.LetsGoScreenAppTheme

class MainActivity : ComponentActivity() {
    @SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            LetsGoScreenAppTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) {
                    LetsGoScreenComposable()
                }
            }
        }
    }
}

@Composable
fun LetsGoScreenComposable() {
    Box(
        // ToDo: Use a Box for full-screen centering
        modifier = Modifier.fillMaxSize()
    ) {
        Column(
            // ToDo: Align the entire Column to the bottom
            modifier = Modifier
                .fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            // Text : App Name
            Text(
                text = stringResource(id = R.string.app_name),
                fontSize = 30.sp,
                color = MaterialTheme.colorScheme.primary,
            )

            // Image : Jetpack Compose Image
            Image(
                painter = painterResource(id = R.drawable.ic_jetpack_compose),
                modifier = Modifier
                    .height(400.dp),
                contentScale = ContentScale.Crop,
                contentDescription = "App logo"
            )
        }
        Column(
            // ToDo: Position the bottom content at the bottom using Modifier.align(Alignment.Bottom)
            modifier = Modifier
                .fillMaxSize()
                .align(Alignment.BottomEnd),
            verticalArrangement = Arrangement.Bottom,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Row(
                // ToDo: Position the image and text content at the bottom within the specified row
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically
            ) {
                // Icon : Cart Icon
                Icon(
                    imageVector = Icons.Filled.ShoppingCart,
                    tint = MaterialTheme.colorScheme.error,
                    contentDescription = "Shopping cart icon",
                )

                // Text : Free shipping on all orders
                Text(
                    text = stringResource(id = R.string.text_free_shipping_orders),
                    color = MaterialTheme.colorScheme.error,
                    fontWeight = FontWeight.Normal,
                    modifier = Modifier.padding(10.dp),
                )
            }

            // Button : CLICK ME!
            val context = LocalContext.current
            Button(
                // ToDo: Shows the toast message while clicking on the "CLICK ME" button
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(15.dp),
                onClick = {
                    Toast.makeText(context, R.string.toast_message_click_me, Toast.LENGTH_LONG).show()
                }
            ) {
                // Button Text : CLICK ME!
                Text(
                    text = stringResource(R.string.action_click_me),
                    fontWeight = FontWeight.Bold,
                    fontSize = 25.sp,
                    style = MaterialTheme.typography.headlineMedium
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun LetsGoScreenComposablePreview() {
    LetsGoScreenAppTheme {
        LetsGoScreenComposable()
    }
}

