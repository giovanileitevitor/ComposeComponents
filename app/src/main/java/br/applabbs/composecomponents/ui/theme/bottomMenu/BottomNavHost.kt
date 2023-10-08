package br.applabbs.composecomponents.ui.theme.bottomMenu

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable

@Composable
fun NavHostImpl(navController: NavHostController){
    NavHost(
        navController = navController,
        startDestination = BottomBarRoutes.HOME
    ){
        composable(BottomBarRoutes.HOME){
            //HomeApp(navHostController = navController)
        }
        composable(BottomBarRoutes.MINHA_REDE){
            //SwipeEffectCardScreen(navHostController = navController)
        }
        composable(BottomBarRoutes.PUBLICAR){
            //CalculadoraImcScreen(navHostController = navController)
        }
        composable(BottomBarRoutes.NOTIFICACAO){
            //NotepadScreen(navHostController = navController)
        }
        composable(BottomBarRoutes.VAGAS){
            //InstagramNewsScreen(navHostController = navController)
        }
    }
}