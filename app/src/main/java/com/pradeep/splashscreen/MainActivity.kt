package com.pradeep.splashscreen

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.rememberNavController
import com.pradeep.splashscreen.ui.theme.SplashScreenTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SplashScreenTheme {
                val navController= rememberNavController()
                NavGraph(navController = navController)
            }
        }
    }
}



@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    SplashScreenTheme {

    }
}