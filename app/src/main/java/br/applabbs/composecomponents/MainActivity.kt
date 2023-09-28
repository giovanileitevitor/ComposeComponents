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
import br.applabbs.composecomponents.ui.theme.home.HomeApp
import br.applabbs.composecomponents.ui.theme.swipeEffect.SwipeEffectCard


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
        startDestination = "Home"
    ){
        composable("home"){
            HomeApp(navHostController = navController)
        }
        composable("swipe_effect_card"){
            SwipeEffectCard(navHostController = navController)
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