package com.iessanalbertomagno.dam2.maquinadecambio

data class BilletesUi(
    val importe: Double = 0.0,
    val pagado: Double = 0.0,
    val cambio: Double = 0.0,
    val billetes: List<Int> = listOf(10_000, 5_000, 2_000, 1_000, 500, 200, 100, 50, 20, 10, 5, 2, 1)   // De 100€ a 0,01€ en centimos
)
