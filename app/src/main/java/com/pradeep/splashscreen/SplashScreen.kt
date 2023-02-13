package com.pradeep.splashscreen

import android.content.res.Configuration.UI_MODE_NIGHT_YES
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material.Icon
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import kotlinx.coroutines.delay

@Composable
fun AnimatedSplashScreen(navController: NavHostController) {
    var startAnimation by remember {
        mutableStateOf(false)
    }
    val alphaAnim= animateFloatAsState(
        targetValue =if (startAnimation)1f else 0f,
        animationSpec = tween(durationMillis = 1000)
    )
    LaunchedEffect(key1 = true){
        startAnimation=true
        delay(2500)
        navController.popBackStack()
        navController.navigate(
            Screen.Home.route
        )
    }
    Splash(alpha = alphaAnim.value)
}

@Composable
fun Splash(alpha:Float) {
    Box(
        modifier = Modifier
            .background(
                if (isSystemInDarkTheme()) Color.LightGray.copy(alpha = 0.8f) else Color.White
            )
            .fillMaxSize(),
        contentAlignment = Alignment.Center
    ){
        Icon(
            modifier= Modifier
                .size(120.dp)
                .alpha(alpha),
            painter = painterResource(id = R.drawable.amazon),
            contentDescription ="Logo",
            tint = Color.Unspecified
        )

    }
}

@Preview
@Composable
fun LightPreview() {
    Splash(1f)
}

@Preview(uiMode = UI_MODE_NIGHT_YES)
@Composable
fun DarkPreview() {
    Splash(1f)
}



