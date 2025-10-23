package com.gromber05.practicalayout.ejercicios

import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout

@Composable
fun PantallaPrincipalCajas(modifier: Modifier = Modifier) {
    Column(
        modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
            .padding(16.dp)
    ) {

        Text("Todas alineadas arriba")
        CajasArriba()

        Text("Centradas eje horizontal")
        CajasCentro()

        Text("Cada una en una esquina")
        CajasEsquinas()

        Text("Relaciones entre cajas")
        RelacionesEntreCajas()

        Text("Alineación múltiple")
        CajasMultiple()

        Text("Márgenes y tamaños")
        CajasMargenes()

        Text("Forma cruz")
        CajasCruz()

        Text("Forma L")
        CajasL()

        Text("Forma T")
        CajasT()

        Text("Extra")
        Cajas_Movido()
    }
}

@Composable
private fun BoxCyan(modifier: Modifier = Modifier) =
    Box(modifier.size(80.dp).background(Color.Cyan), contentAlignment = Alignment.Center) {
        Text("C")
    }

@Composable
private fun BoxRed(modifier: Modifier = Modifier) =
    Box(modifier.size(80.dp).background(Color.Red), contentAlignment = Alignment.Center) {
        Text("R")
    }

@Composable
private fun BoxBlue(modifier: Modifier = Modifier) =
    Box(modifier.size(80.dp).background(Color.Blue), contentAlignment = Alignment.Center) {
        Text("B")
    }

@Composable
private fun BoxGreen(modifier: Modifier = Modifier) =
    Box(modifier.size(80.dp).background(Color.Green), contentAlignment = Alignment.Center) {
        Text("G")
    }

@Composable
fun CajasArriba() {
    Row(
        Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalArrangement = Arrangement.spacedBy(16.dp),
        verticalAlignment = Alignment.Top
    ) {
        BoxCyan()
        BoxRed()
        BoxBlue()
        BoxGreen()
    }
}

@Preview(
    showBackground = true, 
    widthDp = 360, 
    heightDp = 640)
@Composable fun Preview_CajasArriba() { 
    CajasArriba() 
}


@Composable
fun CajasCentro() {
    Column(
        Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        BoxCyan()
        Spacer(Modifier.height(16.dp))
        BoxRed()
        Spacer(Modifier.height(16.dp))
        BoxBlue()
        Spacer(Modifier.height(16.dp))
        BoxGreen()
    }
}

@Preview(showBackground = true, widthDp = 360, heightDp = 640)
@Composable fun Preview_CajasCentro() { CajasCentro() }

@Composable
fun CajasEsquinas() {
    Box(Modifier.fillMaxSize().padding(16.dp).height(200.dp)) {
        BoxCyan(Modifier.align(Alignment.TopStart))
        BoxRed(Modifier.align(Alignment.TopEnd))
        BoxBlue(Modifier.align(Alignment.BottomStart))
        BoxGreen(Modifier.align(Alignment.BottomEnd))
    }
}

@Preview(showBackground = true, widthDp = 360, heightDp = 640)
@Composable fun Preview_CajasEsquinas() { CajasEsquinas() }

@Composable
fun RelacionesEntreCajas(margen: Dp = 16.dp) {
    ConstraintLayout(
        modifier = Modifier
            .fillMaxSize()
            .padding(margen)
    ) {
        val (boxR, boxB, boxG, boxC) = createRefs()

        BoxRed(
            Modifier.constrainAs(boxR) {
                centerTo(parent) 
                
            }
        )
        BoxBlue(
            Modifier.constrainAs(boxB) {
                top.linkTo(boxR.bottom, margin = margen)
                start.linkTo(boxR.start)
                end.linkTo(boxR.end)
            }
        )
        BoxGreen(
            Modifier.constrainAs(boxG) {
                start.linkTo(boxR.end, margin = margen)
                top.linkTo(boxR.top)
                bottom.linkTo(boxR.bottom)
            }
        )
        BoxCyan(
            Modifier.constrainAs(boxC) {
                bottom.linkTo(boxR.top, margin = margen)
                start.linkTo(boxR.start)
                end.linkTo(boxR.end)
            }
        )
    }
}

@Preview(showBackground = true, widthDp = 360, heightDp = 640)
@Composable fun Preview_RelacionesEntreCajas() { RelacionesEntreCajas() }


@Composable
fun CajasMultiple() {
    Box(Modifier.fillMaxSize().padding(16.dp)) {
        Row(
            Modifier
                .fillMaxWidth()
                .align(Alignment.Center),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            BoxCyan()                 
            BoxRed()                
            BoxBlue()                 
            BoxGreen()                
        }
        BoxCyan(
            Modifier
                .align(Alignment.Center)
                .offset(y = 40.dp)    
        )
    }
}

@Preview(showBackground = true, widthDp = 360, heightDp = 640)
@Composable fun Preview_CajasMultiple() { CajasMultiple() }

@Composable
fun CajasMargenes() {
    Row(
        Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalArrangement = Arrangement.spacedBy(16.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        BoxCyan(Modifier.size(100.dp))
        
        Box(
            Modifier
                .fillMaxHeight(0.25f)
                .fillMaxWidth(0.3f)
                .background(Color.Red),
            contentAlignment = Alignment.Center
        ) { Text("R 30%") }
        BoxBlue(Modifier.size(60.dp))
        Box(
            Modifier
                .fillMaxHeight(0.25f)
                .fillMaxWidth(0.25f)
                .background(Color.Green),
            contentAlignment = Alignment.Center
        ) { Text("G 25%") }
    }
}

@Preview(showBackground = true, widthDp = 360, heightDp = 640)
@Composable fun Preview_CajasMargenes() { CajasMargenes() }

@Composable
fun CajasCruz() {
    ConstraintLayout(
        Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        val (c, r, b, g) = createRefs()
        
        BoxCyan(Modifier.constrainAs(c) {
            bottom.linkTo(r.top, margin = 16.dp)
            centerHorizontallyTo(parent)
        })
        BoxBlue(Modifier.constrainAs(b) {
            top.linkTo(r.bottom, margin = 16.dp)
            centerHorizontallyTo(parent)
        })
        
        BoxRed(Modifier.constrainAs(r) {
            centerTo(parent)
        })
        
        BoxGreen(Modifier.constrainAs(g) {
            start.linkTo(r.end, margin = 16.dp)
            centerVerticallyTo(r)
        })
    }
}

@Preview(showBackground = true, widthDp = 360, heightDp = 640)
@Composable fun Preview_CajasCruz() { CajasCruz() }


@Composable
fun CajasL() {
    ConstraintLayout(
        Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        val (c, r, b, g) = createRefs()
        
        BoxCyan(Modifier.constrainAs(c) {
            top.linkTo(parent.top)
            start.linkTo(parent.start)
        })
        BoxRed(Modifier.constrainAs(r) {
            top.linkTo(c.bottom, margin = 16.dp)
            start.linkTo(parent.start)
        })
        
        BoxBlue(Modifier.constrainAs(b) {
            top.linkTo(r.bottom, margin = 16.dp)
            start.linkTo(parent.start)
        })
        BoxGreen(Modifier.constrainAs(g) {
            start.linkTo(b.end, margin = 16.dp)
            bottom.linkTo(b.bottom)
        })
    }
}

@Preview(showBackground = true, widthDp = 360, heightDp = 640)
@Composable fun Preview_CajasL() { CajasL() }

@Composable
fun CajasT() {
    ConstraintLayout(
        Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        val (c, r, b, g) = createRefs()
        
        BoxCyan(Modifier.constrainAs(c) {
            top.linkTo(parent.top)
            start.linkTo(parent.start)
        })
        BoxRed(Modifier.constrainAs(r) {
            top.linkTo(parent.top)
            start.linkTo(c.end, margin = 16.dp)
        })
        BoxGreen(Modifier.constrainAs(g) {
            top.linkTo(parent.top)
            start.linkTo(r.end, margin = 16.dp)
        })
        
        BoxBlue(Modifier.constrainAs(b) {
            top.linkTo(r.bottom, margin = 16.dp)
            start.linkTo(r.start)
            end.linkTo(r.end)
        })
    }
}

@Preview(showBackground = true, widthDp = 360, heightDp = 640)
@Composable fun Preview_CajasT() { CajasT() }

@Composable
fun Cajas_Movido() {
    Column(Modifier.fillMaxSize()) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f)
                .background(Color.Cyan),
            contentAlignment = Alignment.TopStart
        ) {
            Text("Soy un texto dentro de Box")
        }
        Spacer(Modifier.height(30.dp))
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Box(
                Modifier
                    .weight(1f)
                    .fillMaxSize()
                    .padding(end = 8.dp)
                    .background(Color.Red)
            )
            Box(
                Modifier
                    .weight(1f)
                    .fillMaxSize()
                    .padding(start = 8.dp)
                    .background(Color.Blue),
                contentAlignment = Alignment.Center
            ) {
                Text("Soy un texto dentro de Box")
            }
        }
        Spacer(Modifier.height(30.dp))
        Box(
            Modifier
                .fillMaxWidth()
                .weight(1f)
                .background(Color.Green)
        )
    }
}

@Preview(showBackground = true, widthDp = 360, heightDp = 640)
@Composable fun 
        Preview_Cajas_Movido() { 
            Cajas_Movido() 
        }
