package com.music.tweetio

import android.R.attr.text
import android.R.color
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.contentColorFor
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.music.tweetio.api.TweetsAPI
import com.music.tweetio.screens.CategoryScreen
import com.music.tweetio.screens.DetailsScreen
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject


@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    @Inject
    lateinit var tweetsAPI: TweetsAPI

    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            setContent {
                Scaffold(

                    topBar = {
                        TopAppBar(
                            title = { Text(text = "Tweetsy") },
                            Modifier.background(Color.Black),
                        )
                    }
                ) {
                    Box(modifier = Modifier.padding(it)) {
                        App()
                    }
                }
            }


        }

    }


}



@Composable
fun App(){

    //controller
    val navController = rememberNavController()


    //navhost
    NavHost(navController = navController, startDestination = "category") {
        //graph builder
        composable(route = "category") {
            CategoryScreen {
                navController.navigate("detail/${it}")
            }
        }
        composable(route = "detail/{category}", arguments = listOf(navArgument("category") {
            type = NavType.StringType
        })) {
            DetailsScreen()
        }
    }

}


//
//@Composable
//fun App() {
//    //controller
//    val navController= rememberNavController()
//
//    //navhost
//    NavHost(navController = navController, startDestination = "registration"){
//        //graph
//        composable(route = "registration"){
//            RegistrationScreen{
//                navController.navigate("main/${it}")
//            }
//        }
//        composable(route = "login"){
//            LoginScreen()
//        }
//        composable(route = "main/{email}", arguments = listOf(
//            navArgument("email"){
//               type = NavType.StringType
//            }
//        )){
//            val email=it.arguments!!.getString("email")
//            MainScreen(email!!)
//        }
//    }
//}
//
//@Composable
//fun RegistrationScreen(onClick : (email:String) -> Unit) {   // excpecting email retuning unit
//    Text(
//        text = "Registration",
//        style = MaterialTheme.typography.headlineLarge,
//        modifier = Modifier.clickable {onClick("shsisish@gmail.com") }
//    )
//}
//
//@Composable
//fun LoginScreen() {
//    Text(text = "Login",style=MaterialTheme.typography.headlineLarge)
//}
//
//@Composable
//fun MainScreen(email:String) {
//    Text(text = "MainScreen  - $email",style=MaterialTheme.typography.headlineLarge)
//}