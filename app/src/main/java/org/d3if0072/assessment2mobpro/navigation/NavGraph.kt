package org.d3if0072.assessment2mobpro.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import org.d3if0072.assessment2mobpro.ui.screen.DetailScreen
import org.d3if0072.assessment2mobpro.ui.screen.KEY_ID_LAPTOP
import org.d3if0072.assessment2mobpro.ui.screen.MainScreen

@Composable
fun SetupNavGraph(navController: NavHostController = rememberNavController()) {
    NavHost(
        navController = navController,
        startDestination = Screen.Home.route
    ){
        composable(route = Screen.Home.route) {
            MainScreen(navController)
           }
        composable(route = Screen.FormBaru.route){
            DetailScreen(navController)
            }
        composable(
            route = Screen.FormUbah.route,
            arguments = listOf(
                navArgument(KEY_ID_LAPTOP) {type = NavType.LongType}
            )
        ) {navBackStackEntry ->
            val id = navBackStackEntry.arguments?.getLong(KEY_ID_LAPTOP)
            DetailScreen(navController, id)
          }
        }
    }