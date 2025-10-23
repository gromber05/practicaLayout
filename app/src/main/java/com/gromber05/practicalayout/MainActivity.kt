package com.gromber05.practicalayout

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import com.gromber05.practicalayout.ejercicios.Cajas
import com.gromber05.practicalayout.ejercicios.Constraints
import com.gromber05.practicalayout.ejercicios.Espaciadores
import com.gromber05.practicalayout.ejercicios.PantallaConfiguracion
import com.gromber05.practicalayout.ejercicios.PerfilUsuario
import com.gromber05.practicalayout.ejercicios.ProductosDestacados
import com.gromber05.practicalayout.ui.theme.PracticaLayoutTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PracticaLayoutTheme {
                AppPrincipal()
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AppPrincipal() {
    var pantallaActual by remember { mutableIntStateOf(0) }

    Scaffold(
        topBar = {
            TopAppBar(title = {
                Text("Practica Layout - Gonzalo Romero Bernal")
            })

        },
        bottomBar = {
            NavigationBar {
                NavigationBarItem(
                    selected = pantallaActual == 0,
                    onClick = { pantallaActual = 0 },
                    label = { Text("Ej1") },
                    icon = { Text("1") }
                )
                NavigationBarItem(
                    selected = pantallaActual == 1,
                    onClick = { pantallaActual = 1 },
                    label = { Text("Ej2") },
                    icon = { Text("2") }
                )
                NavigationBarItem(
                    selected = pantallaActual == 2,
                    onClick = { pantallaActual = 2 },
                    label = { Text("Ej3") },
                    icon = { Text("3") }
                )
                NavigationBarItem(
                    selected = pantallaActual == 3,
                    onClick = { pantallaActual = 3 },
                    label = { Text("Ej4") },
                    icon = { Text("4") }
                )
                NavigationBarItem(
                    selected = pantallaActual == 4,
                    onClick = { pantallaActual = 4 },
                    label = { Text("Ej5") },
                    icon = { Text("5") }
                )
                NavigationBarItem(
                    selected = pantallaActual == 5,
                    onClick = { pantallaActual = 5 },
                    label = { Text("Ej6") },
                    icon = { Text("6") }
                )
            }
        }
    ) { innerPadding ->
        Box(Modifier.padding(innerPadding)) {
            when (pantallaActual) {
                0 -> PerfilUsuario("Gonzalo Romero Bernal", "Estudiante de DAM", Modifier.fillMaxSize())
                1 -> PantallaConfiguracion(Modifier.fillMaxSize())
                2 -> ProductosDestacados(Modifier.fillMaxSize())
                3 -> Espaciadores(Modifier.fillMaxSize())
                4 -> Cajas(Modifier.fillMaxSize())
                5 -> Constraints(Modifier.fillMaxSize())
            }
        }
    }
}
