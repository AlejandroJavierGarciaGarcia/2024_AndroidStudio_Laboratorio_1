package com.example.laboratotio01
// Copyright
// Alejandro Javier García García - 231136
// Universidad del Valle de Guatemala
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.laboratotio01.ui.theme.Laboratotio01Theme
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Box
import androidx.compose.ui.unit.sp
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.res.painterResource
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.ui.graphics.Color
import androidx.compose.material3.TextField
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.ui.Alignment
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxHeight


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Laboratotio01Theme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    GreetingImage(
                        message = "Android",
                        from = "Alex"
                    )
                }
            }
        }
    }
}


@Composable
fun Greeting(modifier: Modifier = Modifier) {
    Column(modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center) {
        Text(
            text = "\nLaboratorio #1 - Plataformas móviles",
            fontSize = 30.sp,
            lineHeight = 50.sp,
            textAlign = TextAlign.Center,
            modifier = Modifier.fillMaxWidth(),
            fontStyle = FontStyle.Italic,
        )
        Text(
            text = "\nMi nombre es Alejandro García, actual estudiante de la Universidad del Valle" +
                    " de Guatemala, de Ingeniería en Ciencia de la Computación y " +
                    "Tecnologías de la Información, con altas expectativas " +
                    "por innovar el campo tecnológico y computacional. " +
                    "Además, tengo el objetivo contribuir positivamente " +
                    "en el desarrollo sostenible del país; desempeñando " +
                    "con excelencia, disciplina, responsabilidad y " +
                    "constancia, actividades y proyectos afines a " +
                    "la programación, los sistemas de bases de datos, l" +
                    "a tecnología de vanguardia y el desarrollo web, entre " +
                    "otros.",
            fontSize = 16.sp,
            textAlign = TextAlign.Center
        )
        // Cóodigo de implementación de botón obtenido de:
        //https://medium.com/@esthcarelle/alert-dialog-with-jetpack-compose-a-step-by-step-guide-04dc3e9dfc1d
        val shouldShowDialog = remember { mutableStateOf(false) } // 1

        if (shouldShowDialog.value) {
            MyAlertDialog(shouldShowDialog = shouldShowDialog)
        }
        Button(
            onClick = { shouldShowDialog.value = true },
            modifier = Modifier.wrapContentSize()
        ) {
            Text(text = "Mostrar diálogo")
        }
    }

}

@Composable
fun GreetingImage(message: String, from: String, modifier: Modifier = Modifier) {
    val image = painterResource(R.drawable.background2)
    Box(modifier = Modifier
        .fillMaxSize()
        .padding(top = 16.dp),
        contentAlignment = Alignment.Center) {
        Image(
            painter = image,
            contentDescription = null,
            modifier = Modifier.fillMaxSize()
        )
        Greeting(
            modifier = Modifier
                .padding(25.dp)
        )
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun GreetingPreview() {
    Laboratotio01Theme {
        Column {
            GreetingImage(
                message = "ejemplo",
                from = "Alex"
            )
        }
    }
}

@Composable
fun MyAlertDialog(shouldShowDialog: MutableState<Boolean>) {
    if (shouldShowDialog.value) { // 2
        AlertDialog( // 3
            onDismissRequest = { // 4
                shouldShowDialog.value = false
            },
            // 5
            title = { Text(text = "Cuadro de diálogo de alerta") },
            text = { Text(text = "Cuadro de diálogo de alerta de Jetpack Compose") },
            confirmButton = { // 6
                Button(
                    onClick = {
                        shouldShowDialog.value = false
                    }
                ) {
                    Text(
                        text = "Confirmar",
                        color = Color.White
                    )
                }
            }
        )
    }
}