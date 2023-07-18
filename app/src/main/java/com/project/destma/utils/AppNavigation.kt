package com.project.destma.utils

import com.project.destma.utils.Const.ARG_DESTINATION_ID
import com.project.destma.utils.Const.DESTINATIONS_SCREEN
import com.project.destma.utils.Const.DETAIL_DESTINATION_SCREEN
import com.project.destma.utils.Const.HOME_SCREEN
import com.project.destma.utils.Const.PROFILE_SCREEN
import com.project.destma.utils.Const.WISHLIST_SCREEN

sealed class AppNavigation(
    val route: String,
    val argumentName: String = ""
) {

    object Home : AppNavigation(HOME_SCREEN)

    object Destinations : AppNavigation(DESTINATIONS_SCREEN)

    object DetailDestination : AppNavigation("$DESTINATIONS_SCREEN/{$ARG_DESTINATION_ID}") {
        fun routeForId(destinationId: Long) = "$DETAIL_DESTINATION_SCREEN/$destinationId"
    }

    object Profile : AppNavigation(PROFILE_SCREEN)

    object Wishlist : AppNavigation(WISHLIST_SCREEN)

}