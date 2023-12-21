package com.iessanalbertomagno.dam2.maquinadecambio

import androidx.lifecycle.ViewModel
import com.iessanalbertomagno.dam2.maquinadecambio.data.Dinero
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class MainViewModel: ViewModel() {
    private val _uiState = MutableStateFlow(BilletesUi())
    val uiState: StateFlow<BilletesUi> = _uiState.asStateFlow()

    fun onChanged(importe: String, pagado: String) {
        _uiState.update {
            currentState -> currentState.copy(
            importe = (importe.toDouble() * 100),
            pagado = (pagado.toDouble()) * 100)
        }
    }

    fun onGiveChange(billetesUi: BilletesUi, listaDinero: List<Dinero>) {
        // Se da un valor a cambio (asegurandose de que el resultado solo tenga dos decicmales)
        var cambio = (billetesUi.pagado - billetesUi.importe).toInt().toDouble()
        cambio /= 100

        // Se cambia el cambio en State
        _uiState.update {
                currentState -> currentState.copy(cambio = cambio)
        }

        // Se modifica la cantidad de billetes necesarios para dar el cambio
        for (dinero in listaDinero) {
            // Se resetea la cantidad
            dinero.cantidad = 0
            var nuevaCantidad: Double = cambio / dinero.valor

            if (nuevaCantidad > 0 && cambio > 0) {
                dinero.cantidad = nuevaCantidad.toInt()
            }
            cambio -= dinero.cantidad * dinero.valor
        }
    }
}