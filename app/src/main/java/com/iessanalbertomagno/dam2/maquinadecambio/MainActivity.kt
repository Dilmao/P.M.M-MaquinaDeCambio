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
import androidx.compose.foundation.lazy.LazyColumn
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
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
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

    Column( // TODO convertir a LazyColumn
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
                label = { Text(text = "Importe") }, modifier = Modifier.width(150.dp)
            )
            Spacer(modifier = Modifier.width(20.dp))

            OutlinedTextField(
                value = pagadoStr,
                onValueChange = { pagadoStr = it },
                label = { Text(text = "Pagado") }, modifier = Modifier.width(150.dp)
            )
        }
        Spacer(modifier = Modifier.height(20.dp))

        Button(onClick = {
            try {
                mainViewModel.onChanged(importeStr, pagadoStr)
                mainViewModel.onGiveChange(billetesUi.pagado, billetesUi.importe)

                if (billetesUi.cambio >= 0) {
                    // TODO comentar el if  para ver por que hay que dar 3 veces al boton
                    //  Codigo a utilizar: mensaje = "Cambio: ${billetesUi.pagado} - ${billetesUi.importe} = ${billetesUi.cambio}€"
                    //  (solucion fea: for(i = 0; i <= 3; i++))
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


        // EUROS
        CrearLineaImagenes(R.drawable._10000, "Billete de 100 euros", 100.dp)

        CrearLineaImagenes(R.drawable._5000, "Billete de 50 euros", 100.dp)
        CrearLineaImagenes(R.drawable._2000, "Billete de 20 euros", 100.dp)
        CrearLineaImagenes(R.drawable._1000, "Billete de 10 euros", 100.dp)

        CrearLineaImagenes(R.drawable._500, "Billete de 5 euros", 100.dp)
        CrearLineaImagenes(R.drawable._200, "Moneda de 2 euros", 100.dp)
        CrearLineaImagenes(R.drawable._100, "Moneda de 1 euro", 70.dp)
        // TODO buscar otra moneda de 1€ (puto asco esta)

        // CENTIMOS
        CrearLineaImagenes(R.drawable.__50, "Moneda de 50 cents", 40.dp)
        CrearLineaImagenes(R.drawable.__20, "Moneda de 20 cents", 40.dp)
        CrearLineaImagenes(R.drawable.__10, "Moneda de 10 cents", 40.dp)

        CrearLineaImagenes(R.drawable.__5, "Moneda de 5 cents", 40.dp)
        CrearLineaImagenes(R.drawable.__2, "Moneda de 2 cents", 40.dp)
        CrearLineaImagenes(R.drawable.__1, "Moneda de 1 cent", 40.dp)

        // Cambio TODO (esto no es necesario)
        Text(text = mensaje)
    }
}


@Composable
fun CrearLineaImagenes(resourceId: Int, descripcion: String, tamanno: Dp) {
    Row(
        horizontalArrangement = Arrangement.Start,
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier.fillMaxWidth()
    ) {
        // Se separa la imagen del borde y se imprime
        Spacer(modifier = Modifier.width(10.dp))
        Image(
            painter = painterResource(id = resourceId),
            contentDescription = descripcion,
            modifier = Modifier.size(tamanno)
        )

        // Se separa del borde y se imrpime la cantidad de billetes a devolver
        Spacer(modifier = Modifier.width(20.dp))
        Text(text = "Hola wenas :D")
    }
    
    Spacer(modifier = Modifier.height(20.dp))
}
