package com.iessanalbertomagno.dam2.maquinadecambio.data

import androidx.compose.ui.unit.Dp

data class Dinero(
    var idImagen : Int,
    var descripcion: String,
    var tamanno: Dp,
    var valor: Int,
    var cantidad: Int
    )
