package br.applabbs.composecomponents.ui.theme.home

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import br.applabbs.composecomponents.ui.theme.ComposeComponentsTheme
import br.applabbs.composecomponents.ui.theme.blinkPolice.BlinkPoliceScreen
import br.applabbs.composecomponents.ui.theme.bottomMenu.BottomMenuScreen
import br.applabbs.composecomponents.ui.theme.bottomlayout.BottomLayoutScreen
import br.applabbs.composecomponents.ui.theme.buscaCep.ui.BuscaCepScreen
import br.applabbs.composecomponents.ui.theme.calcImc.CalculadoraImcScreen
import br.applabbs.composecomponents.ui.theme.dialog.DialogScreen
import br.applabbs.composecomponents.ui.theme.docscan.DocScanScreen
import br.applabbs.composecomponents.ui.theme.experiences.ExperienceScreen
import br.applabbs.composecomponents.ui.theme.finance.ui.FinanceScreen
import br.applabbs.composecomponents.ui.theme.gridImage.ZoomScreen
import br.applabbs.composecomponents.ui.theme.handlingLists.HandlingListScreen
import br.applabbs.composecomponents.ui.theme.instagramNews.InstagramNewsScreen
import br.applabbs.composecomponents.ui.theme.linegraph.LineGraphScreen
import br.applabbs.composecomponents.ui.theme.livedata.LiveDataScreen
import br.applabbs.composecomponents.ui.theme.notes.NotepadScreen
import br.applabbs.composecomponents.ui.theme.pulseanimation.PulseAnimationScreen
import br.applabbs.composecomponents.ui.theme.shimmerEffect.ShimmerScreen
import br.applabbs.composecomponents.ui.theme.spinloading.SpinLoadingScreen
import br.applabbs.composecomponents.ui.theme.swipeEffect.SwipeEffectCardScreen
import br.applabbs.composecomponents.ui.theme.voicetotext.VoiceToTextScreen

class MainActivity : ComponentActivity(), AnalyticsLogger by AnalyticsLoggerImpl() {

    private val viewModel : MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        installSplashScreen().apply {
            setKeepVisibleCondition {
                viewModel.isLoading.value
            }
        }
        setContent {
            ComposeComponentsTheme {
                Home()
            }
        }
        registerLifeCycleOwner(this)
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
        composable(Routes.DOCSCAN){
            DocScanScreen(navHostController = navController)
        }
        composable(Routes.SWIPE_EFECT){
            SwipeEffectCardScreen(navHostController = navController)
        }
        composable(Routes.SHIMMER_EFFECT){
            ShimmerScreen(navHostController = navController)
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
        composable(Routes.BUSCA_CEP){
            BuscaCepScreen(navHostController = navController)
        }
        composable(Routes.BLINK_POLICE){
            BlinkPoliceScreen(navHostController = navController)
        }
        composable(Routes.FINANCE_CONTROL){
            FinanceScreen(navHostController = navController)
        }
        composable(Routes.EXPERIENCIAS){
            ExperienceScreen(navHostController = navController)
        }
        composable(Routes.ZOOM_IMAGE){
            ZoomScreen(navHostController = navController)
        }
        composable(Routes.BOTTOM_LAYOUT){
            BottomLayoutScreen(navHostController = navController)
        }
        composable(Routes.LIVE_DATA){
            LiveDataScreen(navHostController = navController)
        }
        composable(Routes.VOICE_TEXT){
            VoiceToTextScreen(navHostController = navController)
        }
        composable(Routes.DIALOG){
            DialogScreen(navHostController = navController)
        }
        composable(Routes.HANDLING_LIST){
            HandlingListScreen(navHostController = navController)
        }
        composable(Routes.LINE_GRAPH){
            LineGraphScreen(navHostController = navController)
        }
        composable(Routes.SPIN_LOADING){
            SpinLoadingScreen(navHostController = navController)
        }
        composable(Routes.PULSE_ANIMATION){
            PulseAnimationScreen(navHostController = navController)
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