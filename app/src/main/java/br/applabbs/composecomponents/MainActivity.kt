package br.applabbs.composecomponents

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import br.applabbs.composecomponents.ui.theme.ComposeComponentsTheme
import br.applabbs.composecomponents.ui.theme.bottomMenu.BottomMenuScreen
import br.applabbs.composecomponents.ui.theme.calcImc.CalculadoraImcScreen
import br.applabbs.composecomponents.ui.theme.home.HomeApp
import br.applabbs.composecomponents.ui.theme.home.Routes
import br.applabbs.composecomponents.ui.theme.instagramNews.InstagramNewsScreen
import br.applabbs.composecomponents.ui.theme.notes.NotepadScreen
import br.applabbs.composecomponents.ui.theme.swipeEffect.SwipeEffectCardScreen


class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeComponentsTheme {
                Home()
            }
        }
    }
}

@Composable
fun Home() {
    NavHostImpl(navController = rememberNavController())
}

@Composable
fun NavHostImpl(navController: NavHostController){
    NavHost(
        navController = navController,
        startDestination = Routes.HOME
    ){
        composable(Routes.HOME){
            HomeApp(navHostController = navController)
        }
        composable(Routes.SWIPE_EFECT){
            SwipeEffectCardScreen(navHostController = navController)
        }
        composable(Routes.CALC_IMC){
            CalculadoraImcScreen(navHostController = navController)
        }
        composable(Routes.NOTES){
            NotepadScreen(navHostController = navController)
        }
        composable(Routes.INSTAGRAM_NEWS){
            InstagramNewsScreen(navHostController = navController)
        }
        composable(Routes.BOTTOM_MENU){
            BottomMenuScreen(navHostController = navController)
        }

        //implement other composable itens
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun HomePreview() {
    ComposeComponentsTheme {
        Home()
    }
}