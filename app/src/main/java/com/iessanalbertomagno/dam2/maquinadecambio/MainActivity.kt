package com.iessanalbertomagno.dam2.maquinadecambio

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.iessanalbertomagno.dam2.maquinadecambio.data.Dinero
import com.iessanalbertomagno.dam2.maquinadecambio.data.listaBilletes
import com.iessanalbertomagno.dam2.maquinadecambio.data.listaMonedas1
import com.iessanalbertomagno.dam2.maquinadecambio.data.listaMonedas2
import com.iessanalbertomagno.dam2.maquinadecambio.ui.theme.MaquinaDeCambioTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MaquinaDeCambioTheme {
                val mainViewModel: MainViewModel = viewModel()
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    DarCambio(mainViewModel)
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DarCambio(mainViewModel: MainViewModel) {
    var importeStr by rememberSaveable { mutableStateOf("") }
    var pagadoStr by rememberSaveable { mutableStateOf("") }
    var mensaje by rememberSaveable { mutableStateOf("") }
    val billetesUi by mainViewModel.uiState.collectAsState()
    val context = LocalContext.current

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(20.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Row {
            OutlinedTextField(
                value = importeStr,
                onValueChange = { importeStr = it },
                label = { Text(text = "Importe") },
                modifier = Modifier.width(150.dp),
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
            )
            Spacer(modifier = Modifier.width(20.dp))

            OutlinedTextField(
                value = pagadoStr,
                onValueChange = { pagadoStr = it },
                label = { Text(text = "Pagado") },
                modifier = Modifier.width(150.dp),
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
            )
        }
        Spacer(modifier = Modifier.height(20.dp))

        Button(onClick = {
            try {
                mainViewModel.onChanged(importeStr, pagadoStr)
                mainViewModel.onGiveChange(billetesUi.pagado, billetesUi.importe)

                if (billetesUi.cambio >= 0) {
                    // TODO para ver por que hay que dar al botón 3 veces:
                    //  mensaje = "Cambio: ${billetesUi.pagado} - ${billetesUi.importe} = ${billetesUi.cambio}€"
                    //  (solucion fea: for(i = 0; i <= 3; i++)) {mensaje...}
                    //  igualmente la variable mensaje no se deberia de usar al final
                    mensaje = "${billetesUi.cambio}€"
                } else {
                    mensaje = "Cantidad pagada insuficiente"
                }
            } catch (e: NumberFormatException) {
                Toast.makeText(
                    context,
                    "Los valores introducidos no son validos",
                    Toast.LENGTH_SHORT
                ).show()
            }
        }) {
            Text(text = "Dar cambio")
        }
        Spacer(modifier = Modifier.height(20.dp))


        // euros
        CrearLineaImagenes(listaBilletes)
        Spacer(modifier = Modifier.height(20.dp))

        // centimos (1ª linea)
        CrearLineaImagenes(listaMonedas1)
        Spacer(modifier = Modifier.height(20.dp))

        // centimos (2ª linea)
        CrearLineaImagenes(listaMonedas2)
        Spacer(modifier = Modifier.height(20.dp))

        // Cambio TODO (esto no es necesario)
        Text(text = mensaje)
    }
}


@Composable
fun CrearLineaImagenes(listaDinero: List<Dinero>) {
    Row(
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier.fillMaxWidth()
    ) {
        for (dinero in listaDinero) {
            Spacer(modifier = Modifier.width(10.dp))
            Column (horizontalAlignment = Alignment.CenterHorizontally) {
                Image(
                    painter = painterResource(id = dinero.idImagen),
                    contentDescription = dinero.descripcion,
                    modifier = Modifier.size(dinero.tamanno)
                )
                Spacer(modifier = Modifier.height(5.dp))
                Text(text = dinero.cantidad.toString())
            }
        }
    }
}
