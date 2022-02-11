package com.slavik.matematicai.ui.screens.division

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.slavik.matematicai.modelo.EjercicioDivision
import com.slavik.matematicai.R
import com.slavik.matematicai.ui.theme.*

@Composable
fun DivisionScreen2(
    volver: () -> Unit,
    vm: DivisionVM = viewModel()
) {
    Contenido(
        volver = volver,
        estado = vm.estado,
        onEvento = vm::onEvento
    )
}

@Composable
@Preview(showBackground = true)
private fun DivisionScreenPreview() {
    Contenido(
        volver = { },
        estado = DivisionEstado(
            ejercicio = EjercicioDivision(234, 12),
            cociente = "19",
            resto = "6",
            mostrarResultado = true,
            mensajeResultado = Mensajes.Ejercicio.Correcto[0],
            mensajeProcedimiento = Mensajes.Procedimiento.Correcto[0],
            cocienteCorrecto = true,
            restoCorrecto = true,
            colorTop = Verde1
        ),
        onEvento = {}
    )

}

@Composable
private fun Contenido(
    volver: () -> Unit,
    estado: DivisionEstado,
    onEvento: (EventoDivision) -> Unit
) {

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Box(
            modifier = Modifier.fillMaxWidth(),
            contentAlignment = Alignment.Center
        ) {
            Box(
                modifier = Modifier.fillMaxWidth(),
                contentAlignment = Alignment.CenterStart
            ) {
                Image(
                    imageVector = ImageVector.vectorResource(id = R.drawable.ic_division),
                    contentDescription = "División",
                    colorFilter = ColorFilter.tint(estado.colorTop),
                    modifier = Modifier
                        .width(60.dp)
                        .height(60.dp)
                        .padding(start = 18.dp)
                )
            }

            Column(
                modifier = Modifier.fillMaxWidth(),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {

                if (!estado.mostrarResultado) {
                    Text(
                        text = "Resolver",
                        fontFamily = Poppins,
                        fontSize = 18.sp,
                        color = Violeta1,
                        fontWeight = FontWeight.SemiBold
                    )
                    Spacer(modifier = Modifier.height(8.dp))
                }

                Text(
                    text = if (estado.mostrarResultado) estado.mensajeResultado else "${estado.ejercicio.dividendo} ÷ ${estado.ejercicio.divisor}",
                    fontFamily = Poppins,
                    fontSize = 30.sp,
                    color = estado.colorTop,
                    fontWeight = FontWeight.Bold
                )
            }
        }

        Column(
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(rememberScrollState())
                .weight(1f),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            if (!estado.mostrarResultado) {

                Spacer(modifier = Modifier.height(16.dp))

                Text(
                    text = "Calculá la división y cargá el cociente y resto para ver el resultado.",
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 18.dp),
                    fontFamily = Poppins,
                    fontWeight = FontWeight.Light,
                    fontSize = 14.sp,
                    textAlign = TextAlign.Center
                )
            }

            Spacer(modifier = Modifier.height(32.dp))

            Text(
                text = if (estado.mostrarResultado) "Respondiste" else "Tu respuesta",
                modifier = Modifier
                    .fillMaxWidth(),
                fontFamily = Poppins,
                fontWeight = FontWeight.SemiBold,
                fontSize = 18.sp,
                textAlign = TextAlign.Center
            )

            Spacer(modifier = Modifier.height(24.dp))

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp)
            ) {
                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .weight(1f),
                    elevation = 8.dp,
                    shape = RoundedCornerShape(10.dp),
                    backgroundColor = when {
                        !estado.mostrarResultado -> Color.White
                        estado.restoCorrecto && estado.cocienteCorrecto -> Violeta1
                        estado.cocienteCorrecto -> Violeta1
                        estado.restoCorrecto -> Naranja1
                        else -> Rojo1
                    }
                ) {
                    Column(
                        modifier = Modifier.fillMaxWidth(),
                        verticalArrangement = Arrangement.Center,
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Text(
                            text = "Cociente",
                            fontFamily = Poppins,
                            fontWeight = FontWeight.Normal,
                            fontSize = 18.sp,
                            textAlign = TextAlign.Center,
                            modifier = Modifier.padding(top = 8.dp),
                            color = if (estado.mostrarResultado) Color.White else Color.Black
                        )

                        if (estado.mostrarResultado){
                            Text(
                                text = estado.cociente,
                                fontFamily = Poppins,
                                fontWeight = FontWeight.Normal,
                                fontSize = 40.sp,
                                textAlign = TextAlign.Center,
                                modifier = Modifier.padding(top = 8.dp),
                                color = if (estado.mostrarResultado) Color.White else Color.Black
                            )
                        }
                        else{
                            TextField(
                                value = estado.cociente,
                                onValueChange = { onEvento(EventoDivision.CambioCociente(it)) },
                                colors = TextFieldDefaults.textFieldColors(
                                    backgroundColor = Color.Transparent,
                                    focusedIndicatorColor = Color.Transparent,
                                    unfocusedIndicatorColor = Color.Transparent
                                ),
                                textStyle = TextStyle(
                                    fontSize = 60.sp,
                                    textAlign = TextAlign.Center,
                                    fontFamily = Poppins,
                                    fontWeight = FontWeight.Medium
                                ),
                                keyboardOptions = KeyboardOptions(
                                    keyboardType = KeyboardType.Number
                                ),
                                placeholder = {
                                    Text(
                                        text = "?",
                                        fontSize = 60.sp,
                                        modifier = Modifier.fillMaxWidth(),
                                        textAlign = TextAlign.Center,
                                        fontFamily = Poppins,
                                        fontWeight = FontWeight.Medium
                                    )
                                }
                            )
                        }
                    }
                }

                Spacer(modifier = Modifier.width(24.dp))

                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .weight(1f),
                    elevation = 8.dp,
                    shape = RoundedCornerShape(10.dp),
                    backgroundColor = when {
                        !estado.mostrarResultado -> Color.White
                        estado.restoCorrecto && estado.cocienteCorrecto -> Violeta1
                        estado.restoCorrecto -> Violeta1
                        estado.cocienteCorrecto -> Naranja1
                        else -> Rojo1
                    }
                ) {
                    Column(
                        modifier = Modifier.fillMaxWidth(),
                        verticalArrangement = Arrangement.Center,
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Text(
                            text = "Resto",
                            fontFamily = Poppins,
                            fontWeight = FontWeight.Normal,
                            fontSize = 18.sp,
                            textAlign = TextAlign.Center,
                            modifier = Modifier.padding(top = 8.dp),
                            color = if (estado.mostrarResultado) Color.White else Color.Black
                        )

                        if (estado.mostrarResultado){
                            Text(
                                text = estado.resto,
                                fontFamily = Poppins,
                                fontWeight = FontWeight.Normal,
                                fontSize = 40.sp,
                                textAlign = TextAlign.Center,
                                modifier = Modifier.padding(top = 8.dp),
                                color = if (estado.mostrarResultado) Color.White else Color.Black
                            )
                        }
                        else {
                            TextField(
                                value = estado.resto,
                                onValueChange = { onEvento(EventoDivision.CambioResto(it)) },
                                colors = TextFieldDefaults.textFieldColors(
                                    backgroundColor = Color.Transparent,
                                    focusedIndicatorColor = Color.Transparent,
                                    unfocusedIndicatorColor = Color.Transparent
                                ),
                                textStyle = TextStyle(
                                    fontSize = 60.sp,
                                    textAlign = TextAlign.Center,
                                    fontFamily = Poppins,
                                    fontWeight = FontWeight.Medium
                                ),
                                keyboardOptions = KeyboardOptions(
                                    keyboardType = KeyboardType.Number
                                ),
                                placeholder = {
                                    Text(
                                        text = "?",
                                        fontSize = 60.sp,
                                        modifier = Modifier.fillMaxWidth(),
                                        textAlign = TextAlign.Center,
                                        fontFamily = Poppins,
                                        fontWeight = FontWeight.Medium
                                    )
                                }
                            )
                        }
                    }
                }
            }
            if (estado.mostrarResultado) {
                Spacer(modifier = Modifier.height(30.dp))

                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 18.dp),
                    elevation = 8.dp,
                    shape = RoundedCornerShape(10.dp),
                ) {
                    Column(
                        modifier = Modifier.fillMaxWidth()
                    ) {


                        Text(
                            text = "Procedimiento",
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(vertical = 16.dp),
                            fontFamily = Poppins,
                            fontWeight = FontWeight.SemiBold,
                            fontSize = 18.sp,
                            textAlign = TextAlign.Center
                        )

                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(horizontal = 40.dp),
                            verticalAlignment = Alignment.Top,
                            horizontalArrangement = Arrangement.Center
                        ) {
                            Column(
                                modifier = Modifier
                                    .wrapContentWidth(),
                                verticalArrangement = Arrangement.Top,
                                horizontalAlignment = Alignment.End
                            ) {
                                for (i in estado.ejercicio.procedimiento.indices) {
                                    Text(
                                        text = estado.ejercicio.procedimiento[i],
                                        fontSize = 26.sp,
                                        textAlign = TextAlign.End,
                                        color = when {
                                            i < estado.ejercicio.procedimiento.size - 1 -> Color.Black
                                            estado.restoCorrecto -> Verde1
                                            else -> Rojo1
                                        }
                                    )

                                    if (i % 2 == 1) {
                                        Divider(modifier = Modifier.width(70.dp))
                                    }
                                }
                            }

                            Spacer(modifier = Modifier.width(24.dp))

                            Column(
                                verticalArrangement = Arrangement.Top,
                                horizontalAlignment = Alignment.CenterHorizontally
                            ) {
                                Box(
                                    modifier = Modifier
                                        .drawBehind {
                                            val y = size.height

                                            drawLine(
                                                color = Color.Black,
                                                start = Offset(0f, 0f),
                                                end = Offset(0f, y)
                                            )

                                            drawLine(
                                                color = Color.Black,
                                                start = Offset(0f, y),
                                                end = Offset(size.width, y)
                                            )
                                        },
                                    contentAlignment = Alignment.Center
                                ) {
                                    Text(
                                        text = estado.ejercicio.divisor.toString(),
                                        textAlign = TextAlign.Center,
                                        fontSize = 26.sp,
                                        modifier = Modifier.padding(
                                            horizontal = 40.dp,
                                            vertical = 8.dp
                                        )
                                    )
                                }

                                Text(
                                    modifier = Modifier
                                        .padding(
                                            start = 16.dp,
                                            top = 8.dp
                                        ),
                                    text = estado.ejercicio.cociente.toString(),
                                    fontSize = 26.sp,
                                    textAlign = TextAlign.Start,
                                    color = if (estado.cocienteCorrecto) Verde1 else Rojo1
                                )
                            }
                        }

                        Text(
                            text = estado.mensajeProcedimiento,
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(horizontal = 8.dp, vertical = 16.dp),
                            fontFamily = Poppins,
                            fontWeight = FontWeight.Light,
                            fontSize = 14.sp,
                            textAlign = TextAlign.Center
                        )
                    }
                }
            }
        }

        Spacer(modifier = Modifier.height(16.dp))

        if (estado.mostrarResultado){
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 18.dp),
                horizontalArrangement = Arrangement.SpaceAround,
                verticalAlignment = Alignment.CenterVertically
            ) {
                TextButton(
                    onClick = {
                        volver()
                    }
                ) {
                    Text(
                        text = "Salir",
                        color = Violeta1,
                        fontFamily = Poppins,
                        fontSize = 14.sp,
                        fontWeight = FontWeight.Medium
                    )
                }

                Button(
                    onClick = {
                        onEvento(EventoDivision.SiguienteEjercicio)
                    },
                    colors = ButtonDefaults.buttonColors(backgroundColor = Violeta1)
                ) {
                    Text(
                        text = "Nuevo ejercicio",
                        color = Color.White,
                        fontFamily = Poppins,
                        fontSize = 14.sp,
                        fontWeight = FontWeight.Medium
                    )
                }
            }
        }
        else {
            Button(
                onClick = {
                    onEvento(EventoDivision.ComprobarResultado)
                },
                enabled = estado.cociente.isNotBlank() && estado.resto.isNotBlank(),
                colors = ButtonDefaults.buttonColors(backgroundColor = Violeta1)
            ) {
                Text(
                    text = "Comprobar",
                    color = Color.White,
                    fontFamily = Poppins,
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Medium,
                    modifier = Modifier.padding(vertical = 6.dp)
                )
            }
        }
        Spacer(modifier = Modifier.height(16.dp))
    }
}