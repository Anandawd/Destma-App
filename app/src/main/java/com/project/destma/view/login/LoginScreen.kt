package com.project.destma.view.login


import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.project.destma.R
import com.project.destma.utils.Screens
import com.project.destma.ui.theme.DarkGreen
import com.project.destma.ui.theme.DestMaTheme
import com.project.destma.ui.theme.White
import com.project.destma.ui.theme.openSans
import com.project.destma.viewmodel.AuthViewModel
import kotlinx.coroutines.launch

@Composable
fun LoginScreen(
    navController: NavHostController,
    authViewModel: AuthViewModel = hiltViewModel(),
) {
    var email by rememberSaveable { mutableStateOf("") }
    var password by rememberSaveable { mutableStateOf("") }
    val scope = rememberCoroutineScope()
    val context = LocalContext.current
    val state = authViewModel.signInState.collectAsState(initial = null)

    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                painter = painterResource(id = R.drawable.logo),
                contentDescription = "logo",
                modifier = Modifier.size(100.dp).padding(bottom = 10.dp)
            )

            Text(
                text = "Welcome Back",
                style = MaterialTheme.typography.titleLarge,
                color = DarkGreen,
            )

            Spacer(modifier = Modifier.padding(20.dp))

            OutlinedTextField(
                value = email,
                onValueChange = { email = it },
                label = { Text("Email") },
            )

            Spacer(modifier = Modifier.padding(6.dp))

            OutlinedTextField(
                value = password,
                onValueChange = { password = it },
                label = { Text("Password") },
                visualTransformation = PasswordVisualTransformation(),
                modifier = Modifier
            )

            Spacer(modifier = Modifier.padding(20.dp))

            Row(verticalAlignment = Alignment.CenterVertically) {
                Text(
                    fontFamily = openSans,
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Medium,
                    text = "Belum punya akun? ",
                )
                Text(
                    modifier = Modifier
                        .clickable {
                            navController.navigate(Screens.SignUpScreen.route)
                        },
                    fontFamily = openSans,
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Bold,
                    text = "Sign up",
                )
            }

            Spacer(modifier = Modifier.padding(60.dp))

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.Center
            ) {
                if (state.value?.isLoading == true){
                    CircularProgressIndicator()
                }
            }

            Button(
                onClick = {
                    scope.launch {
                        authViewModel.loginUser(email,password)
                    }
                },
                shape = RoundedCornerShape(10.dp),
                colors = ButtonDefaults.buttonColors(DarkGreen),
                modifier = Modifier
                    .padding(top = 160.dp, bottom = 10.dp)
                    .size(width = 300.dp, height = 50.dp)
            ) {
                Text(
                    "Login",
                    fontFamily = openSans,
                    fontSize = 18.sp,
                    fontWeight = FontWeight.SemiBold,
                )
            }

            OutlinedButton(
                onClick = {

                },
                shape = RoundedCornerShape(10.dp),
                colors = ButtonDefaults.outlinedButtonColors(White),
                modifier = Modifier
                    .padding(bottom = 20.dp)
                    .size(width = 300.dp, height = 50.dp)
            ) {
                Text(
                    "Login with Google",
                    fontFamily = openSans,
                    fontSize = 18.sp,
                    fontWeight = FontWeight.SemiBold,
                    color = DarkGreen
                )
            }

            LaunchedEffect(key1 = state.value?.isSuccess){
                scope.launch {
                    if (state.value?.isSuccess?.isNotEmpty() == true){
                        val success = state.value?.isSuccess
                        Toast.makeText(context, "$success", Toast.LENGTH_LONG).show()
                        navController.navigate(Screens.ProfileScreen.route)
                    }
                }
            }
            LaunchedEffect(key1 = state.value?.isError){
                scope.launch {
                    if (state.value?.isError?.isNotEmpty() == true){
                        val error = state.value?.isError
                        Toast.makeText(context, "$error", Toast.LENGTH_LONG).show()

                    }
                }
            }

        }
    }
}

@Preview(showBackground = true)
@Composable
fun LoginScreenPreview() {
    DestMaTheme {
        LoginScreen(rememberNavController())
    }
}
