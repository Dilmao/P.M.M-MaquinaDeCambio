package com.iessanalbertomagno.dam2.maquinadecambio.data

import androidx.compose.ui.unit.dp
import com.iessanalbertomagno.dam2.maquinadecambio.R

val Billete100Euros : Dinero = Dinero(
    imagen = R.drawable._100,
    descripcion = "Billete de 100 euros",
    tamanno = 60.dp,
    cantidad = 0
)
val Billete50Euros : Dinero = Dinero(
    imagen = R.drawable._50,
    descripcion = "Billete de 50 euros",
    tamanno = 60.dp,
    cantidad = 0
)
val Billete20Euros : Dinero = Dinero(
    imagen = R.drawable._20,
    descripcion = "Billete de 20 euros",
    tamanno = 60.dp,
    cantidad = 0
)
val Billete10Euros : Dinero = Dinero(
    imagen = R.drawable._10,
    descripcion = "Billete de 10 euros",
    tamanno = 60.dp,
    cantidad = 0
)
val Billete5Euros : Dinero = Dinero(
    imagen = R.drawable._5,
    descripcion = "Billete de 50 euros",
    tamanno = 60.dp,
    cantidad = 0
)
val Moneda2Euros : Dinero = Dinero(
    imagen = R.drawable._2,
    descripcion = "Moneda de 2 euros",
    tamanno = 60.dp,
    cantidad = 0
)
val Moneda1Euro : Dinero = Dinero(
    imagen = R.drawable._1,
    descripcion = "Moneda de 1 euro",
    tamanno = 60.dp,
    cantidad = 0
)
val Moneda50Centimos : Dinero = Dinero(
    imagen = R.drawable.__50,
    descripcion = "Moneda de 50 centimos",
    tamanno = 60.dp,
    cantidad = 0
)
val Moneda20Centimos : Dinero = Dinero(
    imagen = R.drawable.__20,
    descripcion = "Moneda de 20 centimos",
    tamanno = 60.dp,
    cantidad = 0
)
val Moneda10Centimos : Dinero = Dinero(
    imagen = R.drawable.__10,
    descripcion = "Moneda de 10 centimos",
    tamanno = 60.dp,
    cantidad = 0
)
val Moneda5Centimos : Dinero = Dinero(
    imagen = R.drawable.__5,
    descripcion = "Moneda de 2 centimos",
    tamanno = 60.dp,
    cantidad = 0
)
val Moneda2Centimos : Dinero = Dinero(
    imagen = R.drawable.__2,
    descripcion = "Moneda de 2 centimos",
    tamanno = 60.dp,
    cantidad = 0
)
val Moneda1Centimo : Dinero = Dinero(
    imagen = R.drawable.__1,
    descripcion = "Moneda de 1 centimo",
    tamanno = 60.dp,
    cantidad = 0
)

val listaDinero : List<Dinero> = listOf(
    Billete100Euros,
    Billete50Euros,
    Billete20Euros,
    Billete10Euros,
    Billete5Euros,
    Moneda2Euros,
    Moneda2Euros,
    Moneda50Centimos,
    Moneda20Centimos,
    Moneda10Centimos,
    Moneda5Centimos,
    Moneda2Centimos,
    Moneda1Centimo
    )