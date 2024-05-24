
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import org.jetbrains.compose.resources.ExperimentalResourceApi
import org.koin.compose.KoinApplication
import org.koin.compose.koinInject
import common.Context
import di.appModule
import presentation.SharedViewModel
import presentation.theme.AppTheme
import presentation.navigation.AppNavigation
import presentation.ui.splash.SplashNav

@OptIn(ExperimentalResourceApi::class)
@Composable
fun App(context: Context) {
    KoinApplication(application = {
       modules(appModule(context))
    }) {
        AppTheme {
            val navigator = rememberNavController()
            val viewModel: SharedViewModel = koinInject()

            LaunchedEffect(key1 = viewModel.tokenManager.state.value.isTokenAvailable) {
                if (!viewModel.tokenManager.state.value.isTokenAvailable) {
                    navigator.popBackStack()
//                    navigator.navigate(AppNavigation.Splash.route)
                }
            }

            Box(modifier = Modifier.fillMaxSize()) {
                NavHost(
                    navController = navigator,
                    startDestination = AppNavigation.Splash.route,
                    modifier = Modifier.fillMaxSize()
                ) {
                    composable(route = AppNavigation.Splash.route) {
                        SplashNav(navigateToMain = {
                            navigator.popBackStack()
                            navigator.navigate(AppNavigation.Main.route)
                        })
                    }
                    /*composable(route = AppNavigation.Main.route) {
                        MainNav {
                            navigator.popBackStack()
                            navigator.navigate(AppNavigation.Splash.route)
                        }
                    }*/
                }
            }
        }
    }
}