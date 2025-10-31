package com.example.firstjcomposeproject.ui.screens

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Menu
import androidx.compose.material.icons.rounded.MoreVert
import androidx.compose.material3.DrawerState
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationDrawerItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.firstjcomposeproject.PostCardViewModel
import com.example.firstjcomposeproject.navigation.AppNavGraph
import com.example.firstjcomposeproject.navigation.NavigationState
import com.example.firstjcomposeproject.navigation.rememberNavigationState
import com.example.firstjcomposeproject.ui.views.NavigationItem
import kotlinx.coroutines.launch


@Composable
fun MainScreen() {

    val snackbarHostState = remember { SnackbarHostState() }

    val navState = rememberNavigationState()

    Scaffold(
        snackbarHost = {
            SnackbarHost(snackbarHostState)
        },
        bottomBar = {
            BottomBar(
                navState
            )
        },
//            floatingActionButtonPosition = FabPosition.Center,
//            floatingActionButton = {
//                AnimatedVisibility(
//                    visible = fabVisibility.value,
//                ) {
//                    FloatingActionButton(
//                        modifier = Modifier
//                            .fillMaxWidth()
//                            .padding(horizontal = 16.dp),
//                        elevation = FloatingActionButtonDefaults.loweredElevation(),
//                        onClick = {
//                            scope.launch {
//                                val result =
//                                    snackbarHostState.showSnackbar("My first snackbar in compose kotlin")
//                                if (result == SnackbarResult.Dismissed) {
//                                    fabVisibility.value = false
//                                }
//                            }
//                        }
//                    ) {
//                        Icon(
//                            Icons.Default.Add,
//                            contentDescription = null,
//                        )
//                    }
//                }
//            }
    ) {
        AppNavGraph(
            modifier = Modifier.padding(it),
            navController = navState.navHostController
        )
    }

}


@Composable
private fun BottomBar(navState: NavigationState) {
    val items = listOf(NavigationItem.Home, NavigationItem.Favorite, NavigationItem.Profile)
    val navStackEntry by navState.navHostController.currentBackStackEntryAsState()

    NavigationBar {
        items.mapIndexed { index, navigationItem ->
            val selected = navStackEntry?.destination?.hierarchy?.any {
                it.route == navigationItem.screen.route
            } ?: false
            NavigationBarItem(
                selected = selected,
                onClick = {
                    navState.navigateTo(navigationItem.screen.route)
                },
                label = {
                    Text(
                        navigationItem.title,
                    )
                },

                icon = {
                    Icon(
                        imageVector = if (selected) navigationItem.iconSelected else navigationItem.icon,
                        contentDescription = null,
                    )


                }

            )

        }

    }
}


//@Preview
//@Composable
//private fun ScaffoldViewPreview() {
//    ScaffoldView()
//}
