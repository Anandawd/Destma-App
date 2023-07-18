package com.project.destma.view.profile

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.project.destma.R
import com.project.destma.utils.Screens
import com.project.destma.ui.component.BottomMenuContent
import com.project.destma.ui.section.BottomMenu
import com.project.destma.ui.theme.DestMaTheme
import com.project.destma.ui.theme.SoftGrey
import com.project.destma.ui.theme.White
import com.project.destma.ui.theme.openSans
import com.project.destma.viewmodel.ProfileViewModel

@Composable
fun ProfileScreen(
    navController: NavHostController,
    profileViewModel: ProfileViewModel = hiltViewModel(),
){
    profileViewModel?.currentUser?.let {
        UserInfo(
            navController = navController,
            viewModel = profileViewModel,
            name = it.displayName.toString(),
            email = it.email.toString())
    }
}

@Composable
fun UserInfo(
    navController: NavHostController,
    viewModel: ProfileViewModel = hiltViewModel(),
    name: String,
    email: String
){
    Box(
        modifier = Modifier.fillMaxSize()
    ){
        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Spacer(modifier = Modifier.height(30.dp))
            Text(
                text = "Profile",
                fontFamily = openSans,
                fontSize = 16.sp,
                fontWeight = FontWeight.Bold,
            )
            Box(
                modifier = Modifier
                    .padding(top = 30.dp, bottom = 10.dp)
                    .size(200.dp)
                    .clip(RoundedCornerShape(100.dp))
                    .background(SoftGrey)
            ) {
                Box(modifier = Modifier
                    .size(160.dp)
                    .border(width = 1.dp, color = Color.White, shape = RoundedCornerShape(100.dp))
                    .align(Alignment.Center)
                )
                Icon(painter = painterResource(
                    id = R.drawable.icon_user),
                    contentDescription = "photo",
                    tint = White,
                    modifier = Modifier
                        .size(140.dp)
                        .clip(RoundedCornerShape(100.dp))
                        .align(Alignment.Center)
                )
            }
            Spacer(modifier = Modifier.height(10.dp))

            Text(
                text = name,
                fontFamily = openSans,
                fontSize = 16.sp,
                fontWeight = FontWeight.SemiBold,
            )
            Text(
                text = email,
                fontFamily = openSans,
                fontSize = 12.sp,
                fontWeight = FontWeight.Normal,
            )

            Box(
                contentAlignment = Alignment.Center,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(50.dp)
            ){
                Column(
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.Start,
                    modifier = Modifier
                ) {
                    Row(
                        horizontalArrangement = Arrangement.Center,
                        verticalAlignment = Alignment.Bottom
                    ) {
                        Icon(
                            painter = painterResource(id = R.drawable.icon_security),
                            contentDescription = "security",
                            modifier = Modifier.size(16.dp)
                        )
                        Text(
                            text = "Keamanan & Akun",
                            fontFamily = openSans,
                            fontSize = 16.sp,
                            fontWeight = FontWeight.SemiBold,
                            modifier = Modifier
                                .padding(start = 20.dp))
                    }
                    Spacer(modifier = Modifier.padding(10.dp))
                    Row(
                        horizontalArrangement = Arrangement.Center,
                        verticalAlignment = Alignment.Bottom
                    ) {
                        Icon(
                            painter = painterResource(id = R.drawable.icon_contact),
                            contentDescription = "contact",
                            modifier = Modifier.size(16.dp)
                        )
                        Text(
                            text = "Kontak Kami",
                            fontFamily = openSans,
                            fontSize = 16.sp,
                            fontWeight = FontWeight.SemiBold,
                            modifier = Modifier
                                .padding(start = 20.dp))
                    }
                    Spacer(modifier = Modifier.padding(10.dp))
                    Row(
                        horizontalArrangement = Arrangement.Center,
                        verticalAlignment = Alignment.Bottom
                    ) {
                        Icon(
                            painter = painterResource(id = R.drawable.icon_term_n_condition),
                            contentDescription = "contact",
                            modifier = Modifier.size(16.dp)
                        )
                        Text(
                            text = "Ketentuan & Privasi",
                            fontFamily = openSans,
                            fontSize = 16.sp,
                            fontWeight = FontWeight.SemiBold,
                            modifier = Modifier
                                .padding(start = 20.dp))
                    }
                    Spacer(modifier = Modifier.padding(10.dp))
                    Row(
                        horizontalArrangement = Arrangement.Center,
                        verticalAlignment = Alignment.Bottom
                    ) {
                        Icon(
                            painter = painterResource(id = R.drawable.icon_logout),
                            contentDescription = "contact",
                            modifier = Modifier.size(16.dp)
                        )
                        Text(
                            text = "Logout",
                            fontFamily = openSans,
                            fontSize = 16.sp,
                            fontWeight = FontWeight.SemiBold,
                            modifier = Modifier
                                .padding(start = 20.dp)
                                .clickable {
                                    viewModel?.logout()
                                    navController.navigate(Screens.GetStartedScreen.route)
                                }
                        )
                    }
                }

            }
            Spacer(modifier = Modifier.height(140.dp))
            BottomMenu(
                navController = rememberNavController(),
                modifier = Modifier,
                items = listOf(
                    BottomMenuContent("Wishlist", R.drawable.icon_wishlist_active),
                    BottomMenuContent("Home", R.drawable.icon_home_active),
                    BottomMenuContent("Profile", R.drawable.icon_profile_active),
                ),
            )
        }
    }

}

@Preview(showBackground = true)
@Composable
fun ProfileScreenPreview() {
    DestMaTheme {
        ProfileScreen(rememberNavController())
    }
}
