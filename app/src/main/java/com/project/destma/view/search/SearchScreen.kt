package com.project.destma.view.search

import android.annotation.SuppressLint
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
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
import androidx.compose.ui.graphics.BlendMode
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.project.destma.domain.model.Destination

@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun Search(navController: NavController, _places: List<Destination>) {
    var text by remember { mutableStateOf("") }
    var active by remember { mutableStateOf(false) }
    var destination by remember { mutableStateOf<List<Destination>>(emptyList()) }

    Column {
        SearchBar(
            modifier = Modifier.fillMaxWidth(),
            query = text,
            onQueryChange = {
                text = it
                if (text.isNotEmpty())
                    destination = _places.filter {
                        it.name.contains(text, ignoreCase = true)
                    } else {
                    destination = emptyList()
                }
            },
            onSearch = {
                active = false
            },
            active = active,
            onActiveChange = {
                active = it
                destination = emptyList()
            },
            placeholder = {
                Text(text = "Cari tempat")
            },
            leadingIcon = {
                Icon(imageVector = Icons.Default.Search, contentDescription = "search icon")
            },
            trailingIcon = {
                if (active) {
                    Icon(
                        imageVector = Icons.Default.Close, contentDescription = "",
                        modifier = Modifier.clickable {
                            if (text.isEmpty()) {
                                active = false
                            } else {
                                text = ""
                            }
                        }
                    )
                }
            }
        )
        {
//            Spacer(modifier = Modifier.height(16.dp))
//            LazyColumn(modifier = Modifier
//                .fillMaxWidth()
//                .padding(16.dp)) {
//                item(destination) {
//                    Text(
//                        text = it.name,
//                        modifier = Modifier.clickable {
//                            navController.navigate(BlendMode.Screen.DetailScreen.withArgs(it.id.toString()))
//                        }
//                    )
//                }
//
//            }
        }
    }
}