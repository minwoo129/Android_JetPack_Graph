package com.example.graph

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AddCircle
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.graph.screen.Graph1
import com.example.graph.screen.Graph2
import com.example.graph.screen.Graph3
import com.example.graph.ui.theme.GraphTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            GraphTheme {
                GraphAppMain()
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun GraphAppMain() {

    val navController = rememberNavController()

    val navItems = listOf(
        NavigationItem("그래프1", Icons.Default.AddCircle, "tab1"),
        NavigationItem("그래프2", Icons.Default.AddCircle, "tab2"),
        NavigationItem("그래프3", Icons.Default.AddCircle, "tab3"),
    )
    
    Scaffold(
        bottomBar = {
            BottomAppBar {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceAround
                ) {
                    navItems.forEach {nav ->
                        val currentRoute = navController.currentBackStackEntryAsState().value?.destination?.route;

                        Column(
                            verticalArrangement = Arrangement.Center,
                            horizontalAlignment = Alignment.CenterHorizontally,
                            modifier = Modifier.clickable {
                                navController.navigate(nav.route)
                            }
                        ) {
                            val isCurrentRoute = nav.route == currentRoute


                            Icon(
                                imageVector = nav.icon,
                                contentDescription = nav.name,
                                tint = if(isCurrentRoute) Color.Red else Color.Black
                            )
                            Text(
                                text = nav.name,
                                color = if(isCurrentRoute) Color.Red else Color.Black
                            )
                        }
                    }
                }
            }
        }
    ) { paddingValues ->
        NavHost(
            navController = navController,
            startDestination = navItems.first().route,
            modifier = Modifier.padding(paddingValues)
        ) {
            composable("tab1") {
                Graph1()
            }
            composable("tab2") {
                Graph2()
            }
            composable("tab3") {
                Graph3()
            }

        }
//        Box(
//            modifier = Modifier.padding(paddingValues)
//        ) {
//            Text(text = "임시 텍스트")
//        }
    }
}

data class NavigationItem(
    val name: String,
    val icon: ImageVector,
    val route: String
)

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    GraphTheme {
        GraphAppMain()
    }
}