package com.project.destma.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.project.destma.utils.Screens
import com.project.destma.view.greeting.GetStartedScreen
import com.project.destma.view.home.HomeScreen
import com.project.destma.view.login.LoginScreen
import com.project.destma.view.profile.ProfileScreen
import com.project.destma.view.register.RegisterScreen

@Composable
fun NavigationGraph(
    navController: NavHostController = rememberNavController()
){
    NavHost(
        navController = navController,
        startDestination = Screens.GetStartedScreen.route
    ){
        composable(route = Screens.GetStartedScreen.route){
            GetStartedScreen(navController)
        }
        composable(route = Screens.SignInScreen.route){
            LoginScreen(navController)
        }
        composable(route = Screens.SignUpScreen.route){
            RegisterScreen(navController)
        }
        composable(route = Screens.ProfileScreen.route){
            ProfileScreen(navController)
        }
        composable(route = Screens.HomeScreen.route){
            HomeScreen(navController)
        }
    }
}