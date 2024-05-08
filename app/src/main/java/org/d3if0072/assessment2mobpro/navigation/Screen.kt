package org.d3if0072.assessment2mobpro.navigation

import org.d3if0072.assessment2mobpro.ui.screen.KEY_ID_LAPTOP


sealed class Screen (val route: String){
    data object Home: Screen("mainScreen")
    data object FormBaru: Screen("detailScreen")

    data object FormUbah: Screen("detailScreen/{$KEY_ID_LAPTOP}") {
        fun withId(id: Long) = "detailScreen/$id"
    }
}