package com.iessanalbertomagno.dam2.maquinadecambio.data

import androidx.compose.ui.unit.dp
import com.iessanalbertomagno.dam2.maquinadecambio.R


// declaracion de los billetes/monedas
val Billete100Euros : Dinero = Dinero(
    idImagen = R.drawable._100,
    descripcion = "Billete de 100 euros",
    tamanno = 65.dp,
    valor = 100.00,
    cantidad = 0
)
val Billete50Euros : Dinero = Dinero(
    idImagen = R.drawable._50,
    descripcion = "Billete de 50 euros",
    tamanno = 65.dp,
    valor = 50.00,
    cantidad = 0
)
val Billete20Euros : Dinero = Dinero(
    idImagen = R.drawable._20,
    descripcion = "Billete de 20 euros",
    tamanno = 65.dp,
    valor = 20.00,
    cantidad = 0
)
val Billete10Euros : Dinero = Dinero(
    idImagen = R.drawable._10,
    descripcion = "Billete de 10 euros",
    tamanno = 65.dp,
    valor = 10.00,
    cantidad = 0
)
val Billete5Euros : Dinero = Dinero(
    idImagen = R.drawable._5,
    descripcion = "Billete de 50 euros",
    tamanno = 65.dp,
    valor = 5.00,
    cantidad = 0
)
val Moneda2Euros : Dinero = Dinero(
    idImagen = R.drawable._2,
    descripcion = "Moneda de 2 euros",
    tamanno = 60.dp,
    valor = 2.00,
    cantidad = 0
)
val Moneda1Euro : Dinero = Dinero(
    idImagen = R.drawable._1,
    descripcion = "Moneda de 1 euro",
    tamanno = 60.dp,
    valor = 1.00,
    cantidad = 0
)
val Moneda50Centimos : Dinero = Dinero(
    idImagen = R.drawable.__50,
    descripcion = "Moneda de 50 centimos",
    tamanno = 60.dp,
    valor = 0.50,
    cantidad = 0
)
val Moneda20Centimos : Dinero = Dinero(
    idImagen = R.drawable.__20,
    descripcion = "Moneda de 20 centimos",
    tamanno = 60.dp,
    valor = 0.20,
    cantidad = 0
)
val Moneda10Centimos : Dinero = Dinero(
    idImagen = R.drawable.__10,
    descripcion = "Moneda de 10 centimos",
    tamanno = 60.dp,
    valor = 0.10,
    cantidad = 0
)
val Moneda5Centimos : Dinero = Dinero(
    idImagen = R.drawable.__5,
    descripcion = "Moneda de 2 centimos",
    tamanno = 60.dp,
    valor = 0.05,
    cantidad = 0
)
val Moneda2Centimos : Dinero = Dinero(
    idImagen = R.drawable.__2,
    descripcion = "Moneda de 2 centimos",
    tamanno = 60.dp,
    valor = 0.02,
    cantidad = 0
)
val Moneda1Centimo : Dinero = Dinero(
    idImagen = R.drawable.__1,
    descripcion = "Moneda de 1 centimo",
    tamanno = 60.dp,
    valor = 0.01,
    cantidad = 0
)

// creacion de las listas
var listaCompleta : List<Dinero> = listOf(
    Billete100Euros,
    Billete50Euros,
    Billete20Euros,
    Billete10Euros,
    Billete5Euros,
    Moneda2Euros,
    Moneda1Euro,
    Moneda50Centimos,
    Moneda20Centimos,
    Moneda10Centimos,
    Moneda5Centimos,
    Moneda2Centimos,
    Moneda1Centimo
)

val listaBilletes : List<Dinero> = listOf(
    Billete100Euros,
    Billete50Euros,
    Billete20Euros,
    Billete10Euros,
    Billete5Euros
)

val listaMonedas1 : List<Dinero> = listOf(
    Moneda2Euros,
    Moneda1Euro,
    Moneda50Centimos,
    Moneda20Centimos
)

val listaMonedas2 : List<Dinero> = listOf(
    Moneda10Centimos,
    Moneda5Centimos,
    Moneda2Centimos,
    Moneda1Centimo
)