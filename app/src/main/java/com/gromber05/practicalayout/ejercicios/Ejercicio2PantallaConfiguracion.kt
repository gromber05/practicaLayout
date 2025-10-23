package com.gromber05.practicalayout.ejercicios

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.material3.HorizontalDivider
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun PantallaConfiguracion(modifier: Modifier = Modifier) {
    var notificacionesActivas by remember { mutableStateOf(true) }
    var temaOscuro by remember { mutableStateOf(false) }
    var idioma by remember { mutableStateOf("Español") }

    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(2.dp)
    ) {
        Text(
            text = "Configuración",
            style = MaterialTheme.typography.headlineMedium,
            fontWeight = FontWeight.Bold
        )

        // Opción: Notificaciones
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text("Notificaciones")
            Switch(
                checked = notificacionesActivas,
                onCheckedChange = { notificacionesActivas = it }
            )
        }
        HorizontalDivider(
            Modifier.padding(2.dp),
            DividerDefaults.Thickness,
            DividerDefaults.color
        )

        // Opción: Tema oscuro
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text("Tema oscuro")
            Switch(
                checked = temaOscuro,
                onCheckedChange = { temaOscuro = it }
            )
        }
        HorizontalDivider(
            Modifier.padding(2.dp),
            DividerDefaults.Thickness,
            DividerDefaults.color
        )

        // Opción: Idioma
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text("Idioma")
            TextButton(
                onClick = {
                    idioma = if (idioma == "Español") "Inglés" else "Español"
                }
            ) {
                Text(idioma)
            }
        }
        HorizontalDivider(
            Modifier.padding(2.dp),
            DividerDefaults.Thickness,
            DividerDefaults.color
        )
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewPantallaConfiguracion() {
    MaterialTheme {
        PantallaConfiguracion()
    }
}
