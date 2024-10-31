package com.example.tarea_5_android

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SegmentedButtonDefaults.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.tarea_5_android.ui.components.Screen1
import com.example.tarea_5_android.ui.components.Screen2
import com.example.tarea_5_android.ui.components.Screen3
import com.example.tarea_5_android.ui.theme.Tarea_5_AndroidTheme
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.outlined.AccountCircle
import androidx.compose.material.icons.twotone.AccountCircle
import androidx.compose.material3.Icon
import androidx.compose.ui.Alignment


class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Tarea_5_AndroidTheme {
                val navController = rememberNavController()
                Scaffold(
                    topBar = {
                        CenterAlignedTopAppBar(
                            colors = TopAppBarDefaults.topAppBarColors(
                                containerColor =  Color(0xFFCDE7B0)
                            ),
                            title = { Text("Asignaturas") },
                            navigationIcon = {
                                Box(
                                    Modifier.clip(shape = CircleShape)
                                        .height(35.dp)
                                        .width(35.dp)
                                ){ MyIconFlechaAtras(Modifier) }
                            },
                            actions = {
                                Box(
                                    Modifier.clip(shape = CircleShape)
                                        .height(35.dp)
                                        .width(35.dp)
                                ){ MyIconCuenta(Modifier) }
                            }
                        )
                    },
                    bottomBar = {
                        BottomAppBar (
                            containerColor = Color(0xFFCDE7B0)
                        ){
                            Row (Modifier.fillMaxWidth(),
                                horizontalArrangement = Arrangement.SpaceEvenly){
                                Box(
                                    Modifier.clip(shape = CircleShape)
                                        .height(35.dp)
                                        .width(35.dp)
                                        .clickable { navController.navigate("screen1") }
                                ){ MyIconHome(Modifier) }
                                Box(
                                    Modifier.clip(shape = CircleShape)
                                        .height(35.dp)
                                        .width(35.dp)
                                        .clickable { navController.navigate("screen2") }
                                ){ MyIconEdit(Modifier) }
                                Box(
                                    Modifier.clip(shape = CircleShape)
                                        .height(35.dp)
                                        .width(35.dp)
                                        .clickable { navController.navigate("screen3") }
                                ){ MyIconFav(Modifier) }
                            }
                        }
                    },
                    modifier = Modifier.fillMaxSize()) { innerPadding ->
                    MyLazyColumn(Modifier.padding(innerPadding))
                }
            }
        }
    }
}

@Composable
fun MyNavControllerCustom(navController: NavHostController, modifier: Modifier){

    NavHost(navController = navController, startDestination = "screen1",
        modifier = modifier){
        composable("screen1"){ Screen1() }
        composable("screen2"){ Screen2() }
        composable("screen3"){ Screen3() }
    }
}
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyIconCuenta(modifier:Modifier){
    Row(){
        Icon(
            painter = painterResource(R.drawable.cuenta),
            contentDescription = "favorite",
            modifier = modifier.size(48.dp)
        )
    }
}

@Composable
fun MyIconFlechaAtras(modifier:Modifier){
    Row(){
        Icon(
            painter = painterResource(R.drawable.flecha_atras),
            contentDescription = "favorite",
            modifier = modifier.size(48.dp)
        )
    }
}

@Composable
fun MyIconHome(modifier:Modifier){
    Row(){
        Icon(
            painter = painterResource(R.drawable.home),
            contentDescription = "favorite",
            modifier = modifier.size(48.dp)
        )
    }
}

@Composable
fun MyIconEdit(modifier:Modifier){
    Row(){
        Icon(
            painter = painterResource(R.drawable.pencil),
            contentDescription = "favorite",
            modifier = modifier.size(48.dp)
        )
    }
}
@Composable
fun MyIconFav(modifier:Modifier){
    Row(){
        Icon(
            painter = painterResource(R.drawable.favorite),
            contentDescription = "favorite",
            modifier = modifier.size(48.dp)
        )
    }
}

@Composable
fun MyLazyColumn(modifier: Modifier){
    val itemList = listOf(
        Asignatura("Historia", R.drawable.historia),
        Asignatura("Matematicas", R.drawable.matematicas),
    )
    LazyColumn (modifier = modifier.padding(horizontal = 15.dp).fillMaxWidth()) {
        items(itemList) { asign ->
            Column(Modifier.fillMaxWidth()){
                Text(asign.asignatura,
                    Modifier.align(Alignment.CenterHorizontally))
                Box(
                    Modifier
                        .fillMaxWidth()
                        .height(150.dp)
                        .clip(shape = RoundedCornerShape(20.dp))
                ){
                    Image(
                        painter = painterResource(asign.imageId),
                        contentDescription = "",
                        contentScale = ContentScale.Crop,
                    )
                }
            }
            Column(Modifier.fillMaxWidth()){
                Text(asign.asignatura,
                    Modifier.align(Alignment.CenterHorizontally))
                Box(
                    Modifier
                        .fillMaxWidth()
                        .height(150.dp)
                        .clip(shape = RoundedCornerShape(20.dp))
                ){
                    Image(
                        painter = painterResource(asign.imageId),
                        contentDescription = "",
                        contentScale = ContentScale.Crop,
                    )
                }
            }
            Spacer(Modifier.height(20.dp))
        }
    }
}

data class Asignatura(val asignatura: String, val imageId: Int)