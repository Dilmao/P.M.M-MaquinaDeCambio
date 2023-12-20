package com.iessanalbertomagno.dam2.maquinadecambio

import androidx.lifecycle.ViewModel
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

    fun onGiveChange(pagado: Double, importe: Double) {
        var change: Double = ((pagado - importe) / 100)
        _uiState.update {
            currentState -> currentState.copy(cambio = change)
        }

    }
}