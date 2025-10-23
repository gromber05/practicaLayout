package com.gromber05.practicalayout.ejercicios

import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.*
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.Dimension
import com.gromber05.practicalayout.R

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

@Preview(showBackground = true)
@Composable
fun PreviewConstraint() {
    MaterialTheme {
        Constraints(Modifier.fillMaxSize())
    }
}
