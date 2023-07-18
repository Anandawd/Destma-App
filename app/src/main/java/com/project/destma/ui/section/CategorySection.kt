package com.project.destma.ui.section

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.project.destma.ui.theme.DestMaTheme
import com.project.destma.ui.theme.GreenRegular
import com.project.destma.ui.theme.SoftGrey
import com.project.destma.ui.theme.White

@Composable
fun CategorySection(
    title: String = "Kategori",
    category: List<String>
){
    var selectedCategoryIndex by remember {
        mutableIntStateOf(0)
    }
    Column(
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = title,
            style = MaterialTheme.typography.titleSmall,
            modifier = Modifier
                .padding(start = 36.dp, top = 10.dp)
        )

        LazyRow {
            items(category.size) {
                Box(contentAlignment = Alignment.Center,
                    modifier = Modifier
                        .padding(start = if (it == 0) 36.dp else 10.dp, top = 10.dp, bottom = 20.dp)
                        .clickable {
                            selectedCategoryIndex = it
                        }
                        .clip(RoundedCornerShape(10.dp))
                        .background(
                            if (selectedCategoryIndex == it) GreenRegular
                            else SoftGrey
                        )
                        .padding(20.dp)
                ) {
                    Text(
                        text = category[it],
                        style = MaterialTheme.typography.bodyMedium,
                        color = White)
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun CategorySectionPreview() {
    DestMaTheme {
        CategorySection(category = listOf(
            "Wisata Alam",
            "Pantai",
            "Museum",
            "Tempat Umum",
            "Taman Wisata",
            "Wisata Kampung"
        ))
    }
}



