package com.gromber05.practicalayout.ejercicios

import android.widget.Toast
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun Espaciadores(modifier: Modifier = Modifier) {
    val ctx = LocalContext.current
    Column(
        modifier = modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
        ){
        Spacer(Modifier.padding(2.dp))
        Text(text = "Título principal", fontSize = 32.sp)
        Spacer(Modifier.padding(10.dp))
        Text(text = "Subtitulo", fontSize = 16.sp)
        Spacer(Modifier.weight(1f))
        Button(
            onClick = {
                Toast.makeText(ctx, "Hola buenos dias", Toast.LENGTH_SHORT).show()
            }
        ) { Text("Púlsame") }
    }
}


@Preview
@Composable
fun PreviewEspaciadores() {
    Espaciadores(Modifier.fillMaxSize())
}