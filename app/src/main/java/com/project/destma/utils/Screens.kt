package com.project.destma.utils

sealed class Screens(val route: String){
    object GetStartedScreen : Screens(route = "GetStarted_Screen")
    object SignInScreen : Screens(route = "SignIn_Screen")
    object SignUpScreen : Screens(route = "SignUp_Screen")
    object ProfileScreen : Screens(route = "Profile_Screen")
    object HomeScreen : Screens(route = "Home_Screen")
    object WishlistScreen : Screens(route = "Wishlist_Screen")
    object SearchDestinationScreen : Screens(route = "Search_Destination_Screen")
    object DetailDestinationScreen : Screens(route = "Detail_Destination_Screen")
}
