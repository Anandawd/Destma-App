package com.project.destma.view.greeting

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.project.destma.R
import com.project.destma.utils.Screens
import com.project.destma.ui.theme.DarkGreen
import com.project.destma.ui.theme.DestMaTheme
import com.project.destma.ui.theme.White
import com.project.destma.ui.theme.openSans
import kotlinx.coroutines.launch

@Composable
fun GetStartedScreen(
    navController: NavHostController
){
    val scope = rememberCoroutineScope()

    Image(
        painter = painterResource(id = R.drawable.background_color),
        contentDescription = "Background Image",
        modifier = Modifier.fillMaxSize()
    )

    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ){

        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.fillMaxHeight()
        ) {
            Spacer(modifier = Modifier.height(143.dp))
            Text(
               fontFamily = openSans,
               fontSize = 36.sp,
               fontWeight = FontWeight.SemiBold,
               text = "Welcome Back",
               color = DarkGreen
            )
            Text(
                fontFamily = openSans,
                fontSize = 36.sp,
                fontWeight = FontWeight.SemiBold,
                text = "Traveler",
                color = DarkGreen
            )
            Spacer(modifier = Modifier.height(13.dp))
            Text(
                fontFamily = openSans,
                fontSize = 15.sp,
                fontWeight = FontWeight.Normal,
                text = "Jelajahi Malang mulai sekarang!",
                color = DarkGreen
            )
            Spacer(modifier = Modifier.height(382.dp))
            Button(
                onClick = {
                    scope.launch {
                        navController.navigate(Screens.SignUpScreen.route)
                    }
                },
                shape = RoundedCornerShape(10.dp),
                colors = ButtonDefaults.buttonColors(White),
                modifier = Modifier
                    .padding(bottom = 10.dp)
                    .size(width = 300.dp, height = 50.dp)
            ) {
                Text(
                    "Sign up",
                    fontFamily = openSans,
                    fontSize = 18.sp,
                    fontWeight = FontWeight.SemiBold,
                    color = DarkGreen
                )
            }

            OutlinedButton(
                onClick = {
                    navController.navigate(Screens.HomeScreen.route)
                },
                shape = RoundedCornerShape(10.dp),
                modifier = Modifier
                    .padding(bottom = 60.dp)
                    .size(width = 300.dp, height = 50.dp)
                    .background(Color.Transparent)
                    .border(width = 1.dp, color = White, shape = RoundedCornerShape(10.dp))
            ) {
                Text(
                    "Guest Login",
                    fontFamily = openSans,
                    fontSize = 18.sp,
                    fontWeight = FontWeight.SemiBold,
                    color = White
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GetStartedScreenPreview() {
    DestMaTheme {
        GetStartedScreen(rememberNavController())
    }
}