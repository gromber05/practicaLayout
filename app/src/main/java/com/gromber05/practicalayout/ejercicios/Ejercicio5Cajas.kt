package com.gromber05.practicalayout.ejercicios

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun Cajas(modifier: Modifier = Modifier) {
    Box(
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Box(
            modifier = Modifier
                .size(80.dp)
                .background(Color.Red)
                .align(Alignment.Center)
        ) {
            Text(
                text = "Roja",
                color = Color.White,
                fontSize = 12.sp,
                modifier = Modifier.align(Alignment.Center)
            )
        }

        Box(
            modifier = Modifier
                .size(80.dp)
                .offset(y = -120.dp)
                .background(Color.Cyan)
                .align(Alignment.Center)
        ) {
            Text(
                text = "Cyan",
                color = Color.Black,
                fontSize = 12.sp,
                modifier = Modifier.align(Alignment.Center)
            )
        }

        Box(
            modifier = Modifier
                .size(80.dp)
                .offset(x = 120.dp)
                .background(Color.Green)
                .align(Alignment.Center)
        ) {
            Text(
                text = "Verde",
                color = Color.Black,
                fontSize = 12.sp,
                modifier = Modifier.align(Alignment.Center)
            )
        }
        Box(
            modifier = Modifier
                .size(80.dp)
                .offset(y = 120.dp)
                .background(Color.Blue)
                .align(Alignment.Center)
        ) {
            Text(
                text = "Azul",
                color = Color.White,
                fontSize = 12.sp,
                modifier = Modifier.align(Alignment.Center)
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewCajas() {
    Cajas()
}
