package com.slavik.matematicai.ui.screens.division

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
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.slavik.matematicai.modelo.EjercicioDivision
import com.slavik.matematicai.ui.theme.Correcto
import com.slavik.matematicai.ui.theme.Incorrecto
import com.slavik.matematicai.ui.theme.Primario
import com.slavik.matematicai.util.Pruebas

@Composable
fun DivisionScreen(
    volver: () -> Unit,
    vm: DivisionVM = viewModel()
) {
    DivisionScreenContenido(
        ejercicio = vm.ejercicio,
        cociente = vm.cociente,
        resto = vm.resto,
        mostrarResultado = vm.mostrarResultado,
        volver = { volver() },
        onEvento = vm::onEvento
    )
}

@Composable
@Preview(showBackground = true)
private fun DivisionScreenPreview() {
    DivisionScreenContenido(
        ejercicio = Pruebas.division,
        cociente = "378",
        resto = "1",
        mostrarResultado = true,
        volver = {},
        onEvento = {}
    )
}


@Composable
private fun DivisionScreenContenido(
    ejercicio: EjercicioDivision,
    cociente: String,
    resto: String,
    mostrarResultado: Boolean,
    volver: () -> Unit,
    onEvento: (EventoDivision) -> Unit
) {

    val scrollState = rememberScrollState()
    val cocienteCorrecto = cociente == ejercicio.cociente.toString()
    val restoCorrecto = resto == ejercicio.resto.toString()
    val resultadoCorrecto = cocienteCorrecto && restoCorrecto

    Column(
        modifier = Modifier.fillMaxSize()
    ) {

        Card(
            modifier = Modifier.fillMaxWidth(),
            backgroundColor = Primario,
            elevation = 8.dp
        ) {
            Column(
                modifier = Modifier.fillMaxWidth(),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = "Resolver",
                    color = Color.White,
                    fontSize = 25.sp,
                    modifier = Modifier.padding(vertical = 8.dp)
                )

                Text(
                    text = "${ejercicio.dividendo} ÷ ${ejercicio.divisor}",
                    color = Color.White,
                    fontSize = 40.sp,
                    modifier = Modifier.padding(vertical = 32.dp)
                )
            }
        }

        Column(
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(scrollState),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {


            if (mostrarResultado) {

                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 16.dp),
                    horizontalAlignment = Alignment.Start
                ) {

                    Text(
                        text = "Dijiste",
                        fontSize = 22.sp
                    )

                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(top = 8.dp),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.SpaceAround
                    ) {

                        Row(
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Text(
                                text = "Cociente: ",
                                fontSize = 22.sp
                            )

                            Text(
                                text = cociente,
                                fontSize = 32.sp,
                                color = if (cocienteCorrecto) Correcto else Incorrecto,
                                textAlign = TextAlign.Center
                            )
                        }

                        Row(
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Text(
                                text = "Resto: ",
                                fontSize = 22.sp
                            )

                            Text(
                                text = resto,
                                fontSize = 32.sp,
                                color = if (restoCorrecto) Correcto else Incorrecto,
                                textAlign = TextAlign.Center
                            )
                        }
                    }
                }

                Spacer(modifier = Modifier.height(24.dp))

                Column(
                    modifier = Modifier.fillMaxSize(),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {

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
                            for (i in ejercicio.procedimiento.indices) {
                                Text(
                                    text = ejercicio.procedimiento[i],
                                    fontSize = 26.sp,
                                    textAlign = TextAlign.End,
                                    color = when {
                                        i < ejercicio.procedimiento.size - 1 -> Color.Black
                                        restoCorrecto -> Correcto
                                        else -> Incorrecto
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
                                    text = ejercicio.divisor.toString(),
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
                                text = ejercicio.cociente.toString(),
                                fontSize = 26.sp,
                                textAlign = TextAlign.Start,
                                color = if (cocienteCorrecto) Correcto else Incorrecto
                            )
                        }
                    }

                    Spacer(modifier = Modifier.height(40.dp))

                    Card(
                        shape = RoundedCornerShape(40.dp),
                        backgroundColor = if (resultadoCorrecto) Correcto else Incorrecto,
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(horizontal = 100.dp)
                    ) {
                        Text(
                            text = if (resultadoCorrecto) "Correcto!" else "Seguí practicando",
                            color = Color.White,
                            textAlign = TextAlign.Center,
                            modifier = Modifier.padding(vertical = 16.dp, horizontal = 8.dp),
                            fontSize = 22.sp
                        )
                    }

                    Spacer(modifier = Modifier.height(40.dp))

                    Button(
                        onClick = { onEvento(EventoDivision.SiguienteEjercicio) },
                        colors = ButtonDefaults.buttonColors(backgroundColor = Primario),
                        shape = RoundedCornerShape(40.dp)
                    ) {
                        Text(
                            text = "Siguiente ejercicio",
                            color = Color.White,
                            modifier = Modifier.padding(vertical = 8.dp),
                            fontSize = 18.sp
                        )
                    }

                    TextButton(
                        onClick = { volver() }
                    ) {
                        Text(
                            text = "Salir",
                            color = Color(0x88000000),
                            modifier = Modifier.padding(vertical = 8.dp)
                        )
                    }

                    Spacer(modifier = Modifier.height(16.dp))
                }

            } else {
                Column(
                    modifier = Modifier
                        .fillMaxSize(),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {

                    Text(
                        text = "Cociente",
                        fontSize = 22.sp
                    )

                    TextField(
                        value = cociente,
                        onValueChange = { onEvento(EventoDivision.CambioCociente(it)) },
                        colors = TextFieldDefaults.textFieldColors(
                            backgroundColor = Color.Transparent,
                            focusedIndicatorColor = Color.Transparent,
                            unfocusedIndicatorColor = Color.Transparent
                        ),
                        textStyle = TextStyle(
                            fontSize = 80.sp,
                            textAlign = TextAlign.Center
                        ),
                        keyboardOptions = KeyboardOptions(
                            keyboardType = KeyboardType.Number
                        ),
                        placeholder = {
                            Text(
                                text = "??",
                                fontSize = 80.sp,
                                modifier = Modifier.fillMaxWidth(),
                                textAlign = TextAlign.Center
                            )
                        }
                    )

                    Spacer(modifier = Modifier.height(32.dp))

                    Text(
                        text = "Resto",
                        fontSize = 22.sp
                    )

                    TextField(
                        value = resto,
                        onValueChange = { onEvento(EventoDivision.CambioResto(it)) },
                        colors = TextFieldDefaults.textFieldColors(
                            backgroundColor = Color.Transparent,
                            focusedIndicatorColor = Color.Transparent,
                            unfocusedIndicatorColor = Color.Transparent
                        ),
                        textStyle = TextStyle(
                            fontSize = 80.sp,
                            textAlign = TextAlign.Center
                        ),
                        keyboardOptions = KeyboardOptions(
                            keyboardType = KeyboardType.Number
                        ),
                        placeholder = {
                            Text(
                                text = "??",
                                fontSize = 80.sp,
                                modifier = Modifier.fillMaxWidth(),
                                textAlign = TextAlign.Center
                            )
                        }
                    )

                    Button(
                        onClick = { onEvento(EventoDivision.ComprobarResultado) },
                        colors = ButtonDefaults.buttonColors(backgroundColor = Primario),
                        shape = RoundedCornerShape(40.dp),
                        enabled = cociente.isNotBlank() && resto.isNotBlank()
                    ) {
                        Text(
                            text = "Comprobar",
                            color = if (cociente.isNotBlank() && resto.isNotBlank())
                                Color.White else Color(0x99000000),
                            modifier = Modifier.padding(vertical = 8.dp)
                        )
                    }
                }
            }
        }
    }
}
