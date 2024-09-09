package com.example.navigation

import androidx.navigation.NamedNavArgument
import androidx.navigation.NavType
import androidx.navigation.navArgument

interface NavScreen {

    val route: String

    val navAgruments: List<NamedNavArgument>
        get() = listOf()

    val fullRoute get() = route

    data object Authorization: NavScreen {
        override val route: String
            get() = "authorization"

    }
    data object Registration: NavScreen {
        override val route: String
            get() = "registration"

        override val navAgruments: List<NamedNavArgument>
            get() = listOf(
                navArgument(PHONE) { type = NavType.StringType }
            )

        const val PHONE = "phone"

        override val fullRoute: String
            get() = "$route/{$PHONE}"

        fun createRoute(phone: String) = "$route/$phone"
    }

    data object Chats: NavScreen {
        override val route: String
            get() = "chats"

    }

    data object Chat : NavScreen {
        override val route: String
            get() = "chat"

        const val NAME = "name"

        override val fullRoute: String
            get() = "$route/{$NAME}"

        fun createRoute(name: String) = "$route/$name"

        override val navAgruments: List<NamedNavArgument>
            get() = listOf(navArgument(NAME) { type = NavType.StringType })

    }

    data object Profile: NavScreen{
        override val route: String
            get() = "profile"

    }


}