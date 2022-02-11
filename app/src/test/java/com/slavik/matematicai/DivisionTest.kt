package com.slavik.matematicai

import com.slavik.matematicai.modelo.EjercicioDivision
import org.junit.Assert.*
import org.junit.Test

class DivisionTest {

    @Test
    fun div_4537_12() {
        val ejercicio = EjercicioDivision(4537, 12)

        assertEquals(
            378,
            ejercicio.cociente
        )

        assertEquals(
            1,
            ejercicio.resto
        )

        assertEquals(
            mutableListOf(
                "4537",
                "3600",
                " 937",
                " 840",
                "  97",
                "  96",
                "   1"
            ),
            ejercicio.procedimiento
        )
    }

    @Test
    fun div_4537_123() {
        val ejercicio = EjercicioDivision(4537, 123)

        assertEquals(
            36,
            ejercicio.cociente
        )

        assertEquals(
            109,
            ejercicio.resto
        )

        assertEquals(
            mutableListOf(
                "4537",
                "3690",
                " 847",
                " 738",
                " 109"
            ),
            ejercicio.procedimiento
        )
    }

    @Test
    fun div_50_2() {
        val ejercicio = EjercicioDivision(50, 2)

        assertEquals(
            25,
            ejercicio.cociente
        )

        assertEquals(
            0,
            ejercicio.resto
        )

        assertEquals(
            mutableListOf(
                "50",
                "40",
                "10",
                "10",
                " 0"
            ),
            ejercicio.procedimiento
        )
    }

    @Test
    fun div_2_5() {
        val ejercicio = EjercicioDivision(2, 5)

        assertEquals(
            0,
            ejercicio.cociente
        )

        assertEquals(
            2,
            ejercicio.resto
        )

        assertEquals(
            mutableListOf(
                "2"
            ),
            ejercicio.procedimiento
        )
    }

    @Test
    fun div_9546_403() {
        val ejercicio = EjercicioDivision(9546, 403)

        assertEquals(
            23,
            ejercicio.cociente
        )

        assertEquals(
            277,
            ejercicio.resto
        )

        assertEquals(
            mutableListOf(
                "9546",
                "8060",
                "1486",
                "1209",
                " 277",

            ),
            ejercicio.procedimiento
        )
    }

    @Test
    fun div_1059_485() {
        val ejercicio = EjercicioDivision(1059, 485)

        assertEquals(
            2,
            ejercicio.cociente
        )

        assertEquals(
            89,
            ejercicio.resto
        )

        assertEquals(
            mutableListOf(
                "1059",
                " 970",
                "  89",
            ),
            ejercicio.procedimiento
        )
    }

    @Test
    fun div_710_426() {
        val ejercicio = EjercicioDivision(6580, 65)

        assertEquals(
            101,
            ejercicio.cociente
        )

        assertEquals(
            15,
            ejercicio.resto
        )

        assertEquals(
            mutableListOf(
                "1059",
                " 970",
                "  89",
            ),
            ejercicio.procedimiento
        )
    }


}