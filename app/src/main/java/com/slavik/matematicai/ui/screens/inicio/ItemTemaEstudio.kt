package com.slavik.matematicai.ui.screens.inicio

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.slavik.matematicai.ui.navegacion.Rutas

@Composable
fun ItemTemaEstudio(
    tema: TemaEstudio,
    navegar: (String) -> Unit
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(bottom = 25.dp)
            .clickable {
                navegar(tema.ruta)
            },
        elevation = 8.dp,
        shape = RoundedCornerShape(10.dp)
    ) {

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(
                    horizontal = 16.dp,
                    vertical = 40.dp
                )
        ) {
            Surface(
                color = tema.color,
                shape = CircleShape,
                modifier = Modifier.size(30.dp)
            ) {}

            Spacer(modifier = Modifier.width(24.dp))

            Text(
                text = tema.nombreTema,
                fontSize = 22.sp
            )
        }
    }
}

@Composable
@Preview(showBackground = true)
fun ItemTemaPreview() {
    ItemTemaEstudio(
        tema = TemaEstudio("Sumas", Rutas.SUMAS, Color(0xFF0BCA0B)),
        navegar = {}
    )
}