package com.project.destma.view.search

import android.annotation.SuppressLint
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.SearchBar
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.BlendMode.Companion.Screen
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.project.destma.domain.model.Destination
import com.project.destma.ui.section.CategorySection
import com.project.destma.ui.section.SearchDestinationBar
import com.project.destma.ui.theme.DestMaTheme
import com.project.destma.view.login.LoginScreen

@Composable
fun SearchDestinationScreen(

){
    Box(
        modifier = Modifier
            .fillMaxSize()
    ){
        Column(
            verticalArrangement = Arrangement.Center,
            modifier = Modifier.padding(top = 30.dp)
        ) {
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
        }

    }
}

@Preview(showBackground = true)
@Composable
fun SearchDestinationScreenPreview() {
    DestMaTheme {
        SearchDestinationScreen()
    }
}
