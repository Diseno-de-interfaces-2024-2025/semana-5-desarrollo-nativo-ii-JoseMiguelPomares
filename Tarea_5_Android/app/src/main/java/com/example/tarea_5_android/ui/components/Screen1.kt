package com.example.tarea_5_android.ui.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier

@Composable
fun Screen1(){
    Box(
        Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center) {
        Text("Pantalla 1")
    }

}