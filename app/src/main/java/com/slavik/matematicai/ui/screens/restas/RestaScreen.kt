package com.slavik.matematicai.ui.screens.restas

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.slavik.matematicai.ui.theme.Correcto
import com.slavik.matematicai.ui.theme.Incorrecto
import com.slavik.matematicai.ui.theme.Primario


@Composable
fun RestaScreen(
    volver: () -> Unit,
    vm: RestaVM = viewModel()
) {
    RestaScreenContenido(
        vm.numero1,
        vm.numero2,
        vm.resultado,
        vm.resultadoUsuario,
        vm.mostrarResultado,
        vm.resultadoCorrecto,
        volver = volver,
        vm::cambioResultadoUsuario,
        vm::siguienteEjercicio,
        vm::comprobar
    )
}

@Composable
@Preview(showBackground = true)
fun RestaScreenPreview(
) {
    RestaScreenContenido(
        "1321",
        "987",
        "1308",
        "",
        mostrarResultado = false,
        resultadoCorrecto = false,
        {},
        {},
        {},
        {}
    )
}

@Composable
private fun RestaScreenContenido(
    numero1: String,
    numero2: String,
    resultado: String,
    resultadoPorUsuario: String,
    mostrarResultado: Boolean,
    resultadoCorrecto: Boolean,
    volver: () -> Unit,
    cambioResultadoUsuario: (String) -> Unit,
    siguienteEjercicio : () -> Unit,
    comprobarResultado: () -> Unit
) {

    val scrollState = rememberScrollState()

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
                    text = "$numero1 - $numero2",
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

                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(start = 32.dp, top = 20.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {

                    Text(
                        text = "Dijiste",
                        fontSize = 22.sp
                    )

                    Spacer(modifier = Modifier.width(20.dp))

                    Text(
                        text = resultadoPorUsuario,
                        fontSize = 32.sp,
                        color = if (resultadoCorrecto) Correcto else Incorrecto,
                        textAlign = TextAlign.Center
                    )
                }

                Column(
                    modifier = Modifier.fillMaxSize(),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {

                    Column(
                        modifier = Modifier.wrapContentWidth(),
                        horizontalAlignment = Alignment.End
                    ) {
                        Text(
                            text = "-",
                            fontSize = 40.sp,
                            modifier = Modifier.offset((-100).dp, 80.dp)
                        )
                        Text(
                            text = numero1,
                            fontSize = 40.sp
                        )
                        Text(
                            text = numero2,
                            fontSize = 40.sp
                        )
                        Text(
                            text = resultado,
                            fontSize = 40.sp,
                            color = if (resultadoCorrecto) Correcto else Incorrecto
                        )
                    }

                    Divider(
                        color = Color.Black,
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(horizontal = 100.dp)
                            .offset(0.dp, (-55).dp)
                    )

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
                        onClick = { siguienteEjercicio() },
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
                        text = "Resultado",
                        fontSize = 22.sp
                    )

                    TextField(
                        value = resultadoPorUsuario,
                        onValueChange = { cambioResultadoUsuario(it) },
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
                        onClick = { comprobarResultado() },
                        colors = ButtonDefaults.buttonColors(backgroundColor = Primario),
                        shape = RoundedCornerShape(40.dp),
                        enabled = resultadoPorUsuario.isNotBlank()
                    ) {
                        Text(
                            text = "Comprobar",
                            color = if (resultadoPorUsuario.isNotBlank()) Color.White else Color(
                                0x99000000
                            ),
                            modifier = Modifier.padding(vertical = 8.dp)
                        )
                    }
                }
            }
        }
    }
}
