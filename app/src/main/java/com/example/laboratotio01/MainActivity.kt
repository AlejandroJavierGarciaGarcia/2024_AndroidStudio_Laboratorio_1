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
import androidx.compose.material3.ButtonDefaults
import androidx.compose.foundation.background
import androidx.compose.ui.res.stringResource




@Composable
fun MyAlertDialog(shouldShowDialog: MutableState<Boolean>) {
    if (shouldShowDialog.value) {
        AlertDialog(
            onDismissRequest = {
                shouldShowDialog.value = false
            },
            title = {
                Text(text = stringResource(R.string.titleMoreInfo))
            },
            text = {
                Box(
                    modifier = Modifier
                        .padding(16.dp)
                ) {
                    Text(
                        text = stringResource(R.string.descriptionMoreInfo)
                    )
                }
            },
            confirmButton = {
                Button(
                    onClick = {
                        shouldShowDialog.value = false
                    },
                    colors = ButtonDefaults.buttonColors(containerColor = Color.Black)
                ) {
                    Text(
                        text = stringResource(R.string.closeMoreInfo),
                        color = Color.White
                    )
                }
            },
            containerColor = Color.White
        )
    }
}


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
            text = stringResource(R.string.title),
            fontSize = 30.sp,
            lineHeight = 50.sp,
            textAlign = TextAlign.Center,
            modifier = Modifier.fillMaxWidth(),
            fontStyle = FontStyle.Italic,
        )
        Text(
            text =  stringResource(R.string.description1),
            fontSize = 16.sp,
            textAlign = TextAlign.Center
        )
        Text(
            text =  stringResource(R.string.description2),
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
            colors = ButtonDefaults.buttonColors(containerColor = Color.Black),
            modifier = Modifier.wrapContentSize()
        ) {
            Text(text = stringResource(R.string.moreInfo))
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
