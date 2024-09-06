package com.example.navigation

interface NavScreen {

    val route: String

    data object Authorization: NavScreen {
        override val route: String
            get() = "authorization"

    }
    data object Registration: NavScreen {
        override val route: String
            get() = "registration"

    }


}