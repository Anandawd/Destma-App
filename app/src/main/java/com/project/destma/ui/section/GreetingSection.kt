package com.project.destma.ui.section

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.project.destma.R
import com.project.destma.ui.theme.DarkGreen
import com.project.destma.ui.theme.DestMaTheme

@Composable
fun GreetingSection(
    name: String = "Traveller"
) {
    Row(
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .padding(start = 36.dp, bottom = 10.dp)
            .fillMaxWidth()
    ) {
        Column(
            verticalArrangement = Arrangement.Center
        ) {
            Text(
                text = "Selamat datang, $name",
                style = MaterialTheme.typography.bodySmall,
                modifier = Modifier
                    .padding(top = 30.dp)
            )
            Text(
                text = "Temukan Wisata \nMenarik di Malang",
                style = MaterialTheme.typography.titleLarge,
                modifier = Modifier
                    .padding(top = 10.dp)
            )
        }
        Icon(
            painter = painterResource(id = R.drawable.icon_notification),
            contentDescription = "Search",
            tint = DarkGreen,
            modifier = Modifier
                .padding(end = 35.dp)
                .size(24.dp)
        )
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingSectionPreview() {
    DestMaTheme {
        GreetingSection("Ananda")
    }
}

