package com.slavik.matematicai.ui.screens.inicio

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.LinearGradient
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.slavik.matematicai.ui.navegacion.Rutas

@Composable
fun InicioScreen(
    navegar: (String) -> Unit
) {
    Contenido(navegar)
}

@Composable
private fun Contenido(
    navegar: (String) -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(
                brush = Brush.linearGradient(
                    colors = listOf(Color(0xffEC8AEE), Color(0xff8A9AEE))
                )
            ),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 24.dp, vertical = 40.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            listOf(
                TemaEstudio("Sumas", Rutas.SUMAS, Color(0xff35CE32)),
                TemaEstudio("Restas", Rutas.RESTAS, Color(0xff3254CE)),
                TemaEstudio("Mutiplicaciones", Rutas.MULTI, Color(0xffCE32AC)),
                TemaEstudio("Divisiones", Rutas.DIVISION, Color(0xffFF9900)),
            ).forEach {
                ItemTemaEstudio(tema = it, navegar = navegar)
            }
        }
    }
}

@Composable
@Preview
fun InicioScreenPreview() {
    Contenido {}
}
