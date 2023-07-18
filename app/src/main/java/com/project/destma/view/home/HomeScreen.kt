package com.project.destma.view.home

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.project.destma.R
import com.project.destma.ui.component.BottomMenuContent
import com.project.destma.ui.section.BottomMenu
import com.project.destma.ui.section.CategorySection
import com.project.destma.ui.section.GreetingSection
import com.project.destma.ui.section.PopularDestinationSection
import com.project.destma.ui.section.SearchDestinationBar
import com.project.destma.ui.theme.DestMaTheme
import com.project.destma.ui.theme.White
import com.project.destma.viewmodel.DestinationsViewModel

@Composable
fun HomeScreen(
    navController: NavHostController,
    destinationViewModel: DestinationsViewModel = hiltViewModel(),
){
    Box(modifier = Modifier
        .background(White)
        .fillMaxSize()
    ) {
        Column {
            GreetingSection()
            SearchDestinationBar()
            CategorySection(
                category = listOf(
                    "Wisata Alam",
                    "Pantai",
                    "Museum",
                    "Tempat Umum",
                    "Taman Wisata",
                    "Wisata Kampung"
                )
            )
            PopularDestinationSection()
            BottomMenu(
                navController = rememberNavController(),
                items = listOf(
                    BottomMenuContent("Wishlist", R.drawable.icon_wishlist_active),
                    BottomMenuContent("Home", R.drawable.icon_home_active),
                    BottomMenuContent("Profile", R.drawable.icon_profile_active),
                )
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun HomeScreenPreview() {
    DestMaTheme {
        HomeScreen(rememberNavController())
    }
}


