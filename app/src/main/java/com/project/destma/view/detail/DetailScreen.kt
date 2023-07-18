package com.project.destma.view.detail

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.project.destma.utils.Screens
import com.project.destma.viewmodel.MainViewModel

@Composable
fun DetailScreen(navController: NavController, place_id: Int, viewModel: MainViewModel = viewModel()) {
    val places = viewModel.resultState

    val place = places[place_id - 1]

    Column(
        modifier = Modifier.fillMaxSize()
            .padding(16.dp)
    ) {
        Icon(
            imageVector = Icons.Default.ArrowBack, contentDescription = "back icon",
            modifier = Modifier.clickable {
                navController.navigate(Screens.HomeScreen.route)
            }
        )

        AsyncImage(
            model = ImageRequest.Builder(LocalContext.current)
                .data(place.imageUrl)
                .crossfade(true)
                .build(),
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .clip(CircleShape)
                .width(150.dp)
                .height(150.dp),
            alignment = Alignment.Center
        )

        Text(text = place.name)
        Text(text = place.address)
        Text(text = place.description)
    }
}