package com.project.destma.ui.component

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.project.destma.R
import com.project.destma.ui.theme.DarkGreen
import com.project.destma.ui.theme.DestMaTheme
import com.project.destma.ui.theme.GreenRegular
import com.project.destma.ui.theme.RedFavorite
import com.project.destma.ui.theme.SoftGrey
import com.project.destma.ui.theme.White
import com.project.destma.ui.theme.YellowRating
import com.project.destma.ui.theme.openSans

@Composable
fun DestinationItem(
    //destination: Destination
    isFavorite: Boolean = false,
    onClickFavorite: () -> Unit
){
    Box(
        modifier = Modifier
            .padding(start = 35.dp, top = 10.dp, bottom = 20.dp, end = 4.dp)
            .clip(RoundedCornerShape(20.dp))
            .background(SoftGrey)
            .size(width = 320.dp, height = 370.dp)
    ) {
        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier
                .padding(14.dp)
                .clip(RoundedCornerShape(20.dp))
                .size(40.dp)
                .background(DarkGreen)
                .align(Alignment.TopEnd)
        ) {
            Icon(
                painter = painterResource(id = R.drawable.icon_favorite),
                tint = if(isFavorite) RedFavorite else White,
                contentDescription = "Favorite",
                modifier = Modifier
                    .size(width = 22.dp, height = 20.dp)
                    .clickable { onClickFavorite() }
            )
        }

        Box(modifier = Modifier
            .clip(RoundedCornerShape(20.dp))
            .background(DarkGreen)
            .size(width = 320.dp, height = 120.dp)
            .align(Alignment.BottomCenter)
        ){
            Column(
                verticalArrangement = Arrangement.Center,
                modifier = Modifier
                    .padding(start = 20.dp, top = 18.dp)
            ) {
                Text(
                    text = "Gunung Bromo",
                    color = White,
                    fontFamily = openSans,
                    fontSize = 16.sp,
                    fontWeight = FontWeight.SemiBold
                )
                Spacer(modifier = Modifier.padding(4.dp))
                Text(
                    text = "Bromo Tengger Semeru, Jawa Timur",
                    color = White,
                    fontFamily = openSans,
                    fontSize = 10.sp,
                    fontWeight = FontWeight.Normal,
                )
            }
            Column(
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier
                    .align(Alignment.TopEnd)
                    .padding(top = 20.dp, end = 20.dp)
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.icon_rating),
                    tint = YellowRating,
                    contentDescription = "Rating",
                    modifier = Modifier
                        .size(18.dp)
                )
                Text(
                    text = "4.8",
                    color = White,
                    fontFamily = openSans,
                    fontSize = 10.sp,
                    fontWeight = FontWeight.SemiBold
                )
            }
        }
        Button(
            onClick = { /*TODO*/ },
            colors = ButtonDefaults.buttonColors(GreenRegular),
            modifier = Modifier
                .padding(12.dp)
                .size(width = 300.dp, height = 32.dp)
                .align(Alignment.BottomCenter)
        ) {
            Text("Lihat selengkapnya", fontFamily = openSans, fontSize = 10.sp, fontWeight = FontWeight.SemiBold)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DestinationItemPreview() {
    var isFavorite by remember { mutableStateOf(false) }

    DestMaTheme {
        DestinationItem(
            isFavorite = isFavorite,
            onClickFavorite = { isFavorite = !isFavorite}
        )
    }
}