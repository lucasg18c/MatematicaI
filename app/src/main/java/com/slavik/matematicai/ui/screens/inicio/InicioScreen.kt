package com.slavik.matematicai.ui.screens.inicio

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.slavik.matematicai.R
import com.slavik.matematicai.ui.navegacion.Rutas
import com.slavik.matematicai.ui.theme.Poppins

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
            .verticalScroll(rememberScrollState())
    ) {
        Text(
            text = "Ejercicios",
            fontFamily = Poppins,
            fontWeight = FontWeight.SemiBold,
            modifier = Modifier
                .padding(horizontal = 24.dp)
                .padding(bottom = 8.dp, top = 24.dp),
            fontSize = 22.sp
        )

        Text(
            text = "Practicá el tema que quieras resolviendo ejercicios generados aleatoriamente.",
            fontFamily = Poppins,
            fontWeight = FontWeight.Light,
            modifier = Modifier
                .padding(horizontal = 24.dp)
                .padding(bottom = 32.dp),
            fontSize = 18.sp,
            textAlign = TextAlign.Center
        )

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 24.dp)
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(1f)
            ) {
                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .clickable {
                            navegar(Rutas.SUMAS)
                        },
                    elevation = 8.dp,
                    shape = RoundedCornerShape(12.dp),
                ) {
                    Image(
                        imageVector = ImageVector.vectorResource(
                            id = R.drawable.ic_suma
                        ),
                        contentDescription = "Suma",
                        contentScale = ContentScale.FillWidth,
                        modifier = Modifier.padding(32.dp),
                        colorFilter = ColorFilter.tint(Color(0xFF2196F3))
                    )
                }

                Spacer(modifier = Modifier.height(48.dp))

                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .clickable {
                            navegar(Rutas.MULTI)
                        }, elevation = 8.dp,
                    shape = RoundedCornerShape(12.dp)
                ) {
                    Image(
                        imageVector = ImageVector.vectorResource(
                            id = R.drawable.ic_multiplicacion
                        ),
                        contentDescription = "Multiplicación",
                        contentScale = ContentScale.FillWidth,
                        modifier = Modifier.padding(32.dp),
                        colorFilter = ColorFilter.tint(Color(0xFFFF9800))
                    )
                }

            }

            Spacer(modifier = Modifier.width(32.dp))

            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(1f)
            ) {
                Spacer(modifier = Modifier.height(70.dp))

                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .clickable {
                            navegar(Rutas.RESTAS)
                        }, elevation = 8.dp,
                    shape = RoundedCornerShape(12.dp)
                ) {
                    Image(
                        imageVector = ImageVector.vectorResource(
                            id = R.drawable.ic_resta
                        ),
                        contentDescription = "Resta",
                        contentScale = ContentScale.FillWidth,
                        modifier = Modifier.padding(32.dp),
                        colorFilter = ColorFilter.tint(Color(0xFF4CAF50))
                    )
                }

                Spacer(modifier = Modifier.height(48.dp))

                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .clickable {
                            navegar(Rutas.DIVISION)
                        }, elevation = 8.dp,
                    shape = RoundedCornerShape(12.dp)
                ) {
                    Image(
                        imageVector = ImageVector.vectorResource(
                            id = R.drawable.ic_division
                        ),
                        contentDescription = "División",
                        contentScale = ContentScale.FillWidth,
                        modifier = Modifier.padding(32.dp),
                        colorFilter = ColorFilter.tint(Color(0xFF9C27B0))
                    )
                }
            }
        }
    }
}

@Composable
@Preview(showBackground = true)
fun InicioScreenPreview() {
    Contenido {}
}
