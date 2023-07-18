package com.project.destma.ui.section

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.project.destma.ui.component.DestinationItem
import com.project.destma.ui.theme.DestMaTheme

@Composable
fun PopularDestinationSection(

){
    var isFavorite by remember { mutableStateOf(false) }

    Column(
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = "Paling Sering Dikunjungi",
            style = MaterialTheme.typography.titleSmall,
            modifier = Modifier
                .padding(start = 36.dp, top = 10.dp)
        )

        LazyRow {
            items(10) {
                DestinationItem(
                    isFavorite = isFavorite,
                    onClickFavorite = { isFavorite = !isFavorite}
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PopularDestinationSectionPreview() {
    DestMaTheme {
        PopularDestinationSection()
    }
}
