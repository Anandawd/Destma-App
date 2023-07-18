package com.project.destma.ui.section

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.project.destma.R
import com.project.destma.ui.component.BottomMenuContent
import com.project.destma.ui.component.BottomMenuItem
import com.project.destma.ui.theme.DarkGreen
import com.project.destma.ui.theme.DestMaTheme
import com.project.destma.ui.theme.GreenRegular
import com.project.destma.ui.theme.SoftGrey
import com.project.destma.ui.theme.White
import org.checkerframework.checker.units.qual.Current

@Composable
fun BottomMenu (
    navController: NavHostController,
    items: List<BottomMenuContent>,
    modifier: Modifier = Modifier,
    hoverColor: Color = DarkGreen,
    hoverTextColor: Color = White,
    normalTextColor: Color = SoftGrey,
    initialSelectedItemIndex: Int = 0,
) {
    var selectedItemIndex by remember { mutableStateOf(initialSelectedItemIndex) }

    Box(
        modifier = Modifier
            .fillMaxWidth()

    ){
        Row(
            horizontalArrangement = Arrangement.SpaceAround,
            verticalAlignment = Alignment.CenterVertically,
            modifier = modifier
                .clip(RoundedCornerShape(12.dp))
                .size(width = 360.dp, height = 80.dp)
                .background(DarkGreen)
                .align(Alignment.Center)
                .padding(6.dp)
        ) {
            items.forEachIndexed{index, item ->
                BottomMenuItem(
                    item = item,
                    isSelected = index == selectedItemIndex,
                    hoverColor = hoverColor,
                    hoverTextColor = hoverTextColor,
                    normalTextColor = normalTextColor,
                    onItemClick = {},
                )
            }

        }
    }

}

@Preview(showBackground = true)
@Composable
fun BottomMenuPreview() {
    DestMaTheme {
        BottomMenu(
            rememberNavController(),
            items = listOf(
            BottomMenuContent("Wishlist", R.drawable.icon_wishlist_active),
            BottomMenuContent("Home", R.drawable.icon_home_active),
            BottomMenuContent("Profile", R.drawable.icon_profile_active),
            )
        )
    }
}

