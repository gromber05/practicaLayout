# Práctica Layout - Gonzalo Romero Bernal

---

## Creación del proyecto
**Nombre del proyecto:** prácticaLayout  
**Tipo:** Empty Activity  
**Lenguaje:** Kotlin  
**Min SDK:** API 21 (Android 5.0)

---

## Ejercicio 1 — Perfil de usuario
**Explicación:** Lo que se ha pedido en este ejercicio es un Box,  lo que he hecho ha sido un box, introduciendole una foto, con otra caja en la que se incluyan los textos de la tarjeta de perfil.

**Código:**
```kotlin
@Composable
fun PerfilUsuario(nombre: String, subtitle: String, modifier: Modifier) {
    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Box(
            modifier = Modifier
                .width(250.dp)
                .height(250.dp)
        ) {
            Image(
                painter = painterResource(R.drawable.perfil),
                contentDescription = "Foto de perfil",
                contentScale = ContentScale.Crop,
                modifier = Modifier.fillMaxSize()
            )
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .align(Alignment.BottomCenter)
                    .padding(8.dp)
            ) {
                Column(horizontalAlignment = Alignment.CenterHorizontally) {
                    Text(
                        text = nombre,
                        fontSize = 18.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color.Black
                    )
                    Text(
                        text = subtitle,
                        fontSize = 14.sp,
                        color = Color.Black
                    )
                }
            }
        }
    }
}
````

---

## Ejercicio 2 — Pantalla de configuración

**Explicación:** En este ejercicio, lo que he hecho ha sido crear configuraciones, metiendole entre ellas un HorizontalDivider para crear la linea que divide entre cada elemento de la lista de configuraciones. He metido un row por cada elemento en la lista, para agregarle en el inicio de esta el texto, y luego en el final el botón/switch.

**Código:**

```kotlin
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
        HorizontalDivider(Modifier.padding(vertical = 2.dp))
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
        HorizontalDivider(Modifier.padding(vertical = 2.dp))

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
        HorizontalDivider(Modifier.padding(vertical = 2.dp))
    }
}
```

---

## Ejercicio 3 — Lista de productos

**Explicación:** Para crear la lista y mostrar los productos, lo que he hecho ha sido aplicarles un valor a las cadenas de texto que tengo en la lista, así, puedo usar el painterResource para pintar las imagenes guardadas en los valores de la lista.

**Código:**

```kotlin
@Composable
fun ProductosDestacados(modifier: Modifier = Modifier) {

    val listaProductos by rememberSaveable {
        mutableStateOf(
            mutableListOf(
                "Huevo" to R.drawable.huevo,
                "Tomate" to R.drawable.tomate,
                "Leche" to R.drawable.leche
            )
        )
    }

    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(8.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Productos destacados",
            fontSize = 16.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(bottom = 8.dp)
        )

        Row(
            modifier = Modifier
                .horizontalScroll(rememberScrollState())
                .padding(horizontal = 4.dp)
        ) {
            listaProductos.forEach { (nombre, imagen) ->
                Column(
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Image(
                        painter = painterResource(imagen),
                        contentDescription = "Producto destacado",
                        contentScale = ContentScale.Crop,
                        modifier = Modifier
                            .size(100.dp)
                            .padding(end = 8.dp)
                            .clip(RoundedCornerShape(12.dp))
                    )

                    Text(text = nombre)

                    val listaPrecios = mutableListOf(24.99, 25.99, 18.99, 9.99)
                    Text(text = listaPrecios.random().toString())
                }
            }
        }
    }
}
```

---

## Ejercicio 4 — Espaciadores

**Explicación:** En este código, lo que he usado han sido los espaciadores 'Spacer' que me permiten crear espacios dentro de mi contenido. Para pegar el botón al fondo, lo que he hecho ha sido aplicarle "peso" al espaciador.
**Código:**
````kotlin
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
````
---

## Ejercicio 5 — Cajas

**Explicación:** Para este ejercicio, se han pedido varias cajas de distintos colores y tamaños en distintas configuraciones, lo que he hecho para poder colocar las cajas en distintos sitios es usar el weight, una propiedad del modifier que me permite mover las cajas a mi antojo y luego las he coloreado jugando con el fondo.

**Código:**

```kotlin
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

@Composable
fun CajasEsquinas() {
    Box(Modifier.fillMaxSize().padding(16.dp).height(200.dp)) {
        BoxCyan(Modifier.align(Alignment.TopStart))
        BoxRed(Modifier.align(Alignment.TopEnd))
        BoxBlue(Modifier.align(Alignment.BottomStart))
        BoxGreen(Modifier.align(Alignment.BottomEnd))
    }
}

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
```

---

## Ejercicio 6 — Tarjeta con ConstraintLayout

**Explicación:** Para crear este código, se requiere el uso de un `ConstraintLayout`. Se ha pedido la creación de una tarjeta de perfil, para ello, se ha empleado una Card, en la que dentro se ha implementado el ConstraintLayout, luego dentro, se han establecido las referencias de posición de los distintos elementos.

**Código:**

```kotlin
@Composable
fun Constraints(modifier: Modifier = Modifier) {
   val ctx = LocalContext.current
   Box(
       modifier = modifier
           .fillMaxSize()
           .padding(16.dp)
   ) {
       Card(
           modifier = Modifier
               .fillMaxWidth()
               .wrapContentHeight(),
           shape = MaterialTheme.shapes.large,
           elevation = CardDefaults.cardElevation(defaultElevation = 8.dp),
           colors = CardDefaults.cardColors(
               containerColor = MaterialTheme.colorScheme.surface
           )
       ) {
           ConstraintLayout(
               modifier = Modifier
                   .fillMaxWidth()
                   .padding(16.dp)
           ) {
               val (avatarRef, nombreRef, biografiaRef, botonRef) = createRefs()

               Image(
                   painter = painterResource(id = R.drawable.perfil),
                   contentDescription = "Foto",
                   modifier = Modifier
                       .constrainAs(avatarRef) {
                           start.linkTo(parent.start)
                           top.linkTo(parent.top)
                       }
                       .size(96.dp)
                       .clip(CircleShape),
                   contentScale = ContentScale.Crop
               )

               Text(
                   text = "Gonzalo Romero Bernal",
                   style = MaterialTheme.typography.titleLarge.copy(fontWeight = FontWeight.Bold),
                   modifier = Modifier.constrainAs(nombreRef) {
                       start.linkTo(avatarRef.end, margin = 16.dp)
                       end.linkTo(parent.end)
                       top.linkTo(avatarRef.top)
                       width = Dimension.fillToConstraints
                   }
               )
               Text(
                   text = "Desarrollador Android. Apasionado por Jetpack Compose, el diseño limpio y el código bien hecho.",
                   style = MaterialTheme.typography.bodyMedium,
                   modifier = Modifier.constrainAs(biografiaRef) {
                       start.linkTo(nombreRef.start)
                       end.linkTo(parent.end)
                       top.linkTo(nombreRef.bottom, margin = 8.dp)
                       width = Dimension.fillToConstraints
                   }
               )
               Button(
                   onClick = {
                       Toast.makeText(
                           ctx,
                           "Contacta a gromber2911@g.educaand.es",
                           Toast.LENGTH_SHORT
                       ).show()
                   },
                   modifier = Modifier.constrainAs(botonRef) {
                       start.linkTo(parent.start)
                       end.linkTo(parent.end)
                       top.linkTo(biografiaRef.bottom, margin = 20.dp)
                       width = Dimension.fillToConstraints
                   }
               ) {
                   Icon(Icons.Default.Email, contentDescription = null)
                   Spacer(Modifier.width(8.dp))
                   Text("Contactar")
               }
           }
       }
   }
}
```