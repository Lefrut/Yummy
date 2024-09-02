package com.example.navigation

interface Route {

    val route: String

    data object Authorization: Route {
        override val route: String
            get() = "authorization"

    }

}