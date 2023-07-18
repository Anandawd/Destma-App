package com.project.destma.ui.component

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
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
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.project.destma.R
import com.project.destma.ui.theme.DarkGreen
import com.project.destma.ui.theme.DestMaTheme
import com.project.destma.ui.theme.SoftGrey
import com.project.destma.ui.theme.White
import com.project.destma.ui.theme.openSans

@Composable
fun BottomMenuItem(
    item: BottomMenuContent,
    isSelected: Boolean = false,
    hoverColor: Color = DarkGreen,
    hoverTextColor: Color = White,
    normalTextColor: Color = SoftGrey,
    onItemClick: () -> Unit,
){
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier
            .clickable {
                onItemClick()
            }
            .padding(10.dp)
    ) {
        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier
                .clip(RoundedCornerShape(2.dp))
                .background(if (isSelected) hoverColor else Color.Transparent)
                .padding(6.dp)
        ) {
            Icon(
                painter = painterResource(id = item.iconId),
                contentDescription = item.title,
                tint = if(isSelected) hoverTextColor else normalTextColor,
                modifier = Modifier.size(18.dp)
            )
        }
        Text(
            text = item.title,
            fontFamily = openSans,
            fontWeight = FontWeight.SemiBold,
            fontSize = 12.sp,
            color = if(isSelected) hoverTextColor else normalTextColor,
        )
    }
}

@Preview(showBackground = true)
@Composable
fun ButtonMenuItemPreview() {
    DestMaTheme {
        BottomMenuItem(
            item = BottomMenuContent("Wishlist", R.drawable.icon_wishlist_active),
            isSelected = true,
            hoverColor = DarkGreen,
            hoverTextColor = White,
            normalTextColor = SoftGrey,
            onItemClick = {},
        )
    }
}