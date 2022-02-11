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


}