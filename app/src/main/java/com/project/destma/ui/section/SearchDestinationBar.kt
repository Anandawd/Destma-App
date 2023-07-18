package com.project.destma.ui.section

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.project.destma.R
import com.project.destma.ui.theme.DestMaTheme
import com.project.destma.ui.theme.SoftGrey

@Composable
fun SearchDestinationBar(
    input: String = "",
){
    Box(modifier = Modifier
        .padding(start = 35.dp, top = 10.dp, bottom = 10.dp, end = 35.dp)
        .size(width = 320.dp, height = 48.dp)
        .clip(RoundedCornerShape(10.dp))
        .background(SoftGrey)
    ) {
        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .fillMaxWidth()
        ) {
            Text(
                text = "Pencarian",
                style = MaterialTheme.typography.bodySmall,
                modifier = Modifier
                    .padding(start = 13.dp, top = 15.dp, bottom = 14.dp)
            )
            Icon(
                painter = painterResource(id = R.drawable.icon_search),
                contentDescription = "Search",
                tint = Color.DarkGray,
                modifier = Modifier
                    .padding(end = 13.dp)
                    .size(16.67.dp)

            )
        }

    }
}

@Preview(showBackground = true)
@Composable
fun SearchDestinationBarPreview() {
    DestMaTheme {
        SearchDestinationBar("Ananda")
    }
}

