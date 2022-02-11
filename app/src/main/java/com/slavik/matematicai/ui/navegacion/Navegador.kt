package com.slavik.matematicai.ui.navegacion

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.slavik.matematicai.ui.screens.division.DivisionScreen
import com.slavik.matematicai.ui.screens.inicio.InicioScreen
import com.slavik.matematicai.ui.screens.mutli.MultiplicacionScreen
import com.slavik.matematicai.ui.screens.restas.RestaScreen
import com.slavik.matematicai.ui.screens.sumas.SumaScreen

@Composable
fun Navegador(
    nav: NavHostController
) {
    NavHost(
        navController = nav,
        startDestination = Rutas.INICIO
    ) {
        composable(
            Rutas.INICIO
        ) {
            InicioScreen(navegar = { nav.navigate(it) })
        }

        composable(Rutas.SUMAS) {
            SumaScreen(
                volver = {
                    nav.popBackStack()
                }
            )
        }

        composable(Rutas.RESTAS) {
            RestaScreen(
            volver = {nav.popBackStack()}
            )
        }

        composable(Rutas.MULTI) {
            MultiplicacionScreen {
                nav.popBackStack()
            }
        }

        composable(Rutas.DIVISION) {
            DivisionScreen {
                nav.popBackStack()
            }
        }
    }
}