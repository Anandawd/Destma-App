package com.project.destma.view.register

import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
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
import androidx.compose.ui.draw.clip
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
fun RegisterScreen(
    navController: NavHostController,
    authViewModel: AuthViewModel = hiltViewModel(),
) {
    var name by rememberSaveable { mutableStateOf("") }
    var email by rememberSaveable { mutableStateOf("") }
    var password by rememberSaveable { mutableStateOf("") }
    val scope = rememberCoroutineScope()
    val context = LocalContext.current
    val state = authViewModel.signUpState.collectAsState(initial = null)

    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {

        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            Box(
                contentAlignment = Alignment.Center,
                modifier = Modifier
                    .padding(end = 293.dp)
                    .clip(RoundedCornerShape(40.dp))
                    .size(40.dp)
                    .background(DarkGreen)
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.icon_back),
                    tint = White,
                    contentDescription = "Back",
                    modifier = Modifier
                        .size(24.dp)
                        .clickable {
                            navController.navigate(Screens.GetStartedScreen.route)
                        }
                )
            }

            Spacer(modifier = Modifier.height(40.dp))

            Text(
                text = "Create New Account",
                style = MaterialTheme.typography.titleLarge,
                color = DarkGreen,
                modifier = Modifier.padding(10.dp)
            )

            Text(
                text = "Please fill the form to continue!",
                style = MaterialTheme.typography.labelMedium,
                color = DarkGreen,
            )

            Spacer(modifier = Modifier.height(40.dp))

            OutlinedTextField(
                value = name,
                onValueChange = { name = it },
                label = { Text("Nama Lengkap") },
                modifier = Modifier.padding(6.dp)
            )

            OutlinedTextField(
                value = email,
                onValueChange = { email = it },
                label = { Text("Email") },
                modifier = Modifier.padding(6.dp)
            )

            OutlinedTextField(
                value = password,
                onValueChange = { password = it },
                label = { Text("Password") },
                visualTransformation = PasswordVisualTransformation(),
                modifier = Modifier.padding(6.dp)
            )

            Spacer(modifier = Modifier.height(220.dp))

            Row(
                horizontalArrangement = Arrangement.Center
            ) {
                if (state.value?.isLoading == true){
                    CircularProgressIndicator()
                }
            }

            Spacer(modifier = Modifier.height(5.dp))

            Button(
                onClick = {
                          scope.launch {
                              authViewModel.registerUser(name, email,password)
                          }
                },
                shape = RoundedCornerShape(10.dp),
                colors = ButtonDefaults.buttonColors(DarkGreen),
                modifier = Modifier
                    .size(width = 300.dp, height = 50.dp)
            ) {
                Text("Sign up", fontFamily = openSans, fontSize = 18.sp, fontWeight = FontWeight.SemiBold)
            }

            Spacer(modifier = Modifier.height(20.dp))

            Row(verticalAlignment = Alignment.CenterVertically) {
                Text(
                    fontFamily = openSans,
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Medium,
                    text = "Sudah punya akun? ",
                )
                Text(
                    modifier = Modifier
                        .clickable {
                            navController.navigate(Screens.SignInScreen.route)
                        },
                    fontFamily = openSans,
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Bold,
                    text = "Login",
                )
            }

            LaunchedEffect(key1 = state.value?.isSuccess){
                scope.launch {
                    if (state.value?.isSuccess?.isNotEmpty() == true){
                        val success = state.value?.isSuccess
                        Toast.makeText(context, "${success}", Toast.LENGTH_LONG).show()
                    }
                }
            }
            LaunchedEffect(key1 = state.value?.isError){
                scope.launch {
                    if (state.value?.isError?.isNotEmpty() == true){
                        val error = state.value?.isError
                        Toast.makeText(context, "${error}", Toast.LENGTH_LONG).show()
                    }
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun RegisterScreenPreview() {
    DestMaTheme {
        val navController: NavHostController = rememberNavController()
        RegisterScreen(navController)
    }
}
