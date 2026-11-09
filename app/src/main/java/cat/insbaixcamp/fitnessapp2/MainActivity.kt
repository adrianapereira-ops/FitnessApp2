package cat.insbaixcamp.fitnessapp2

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import cat.insbaixcamp.fitnessapp2.ui.Screen.EditProfile
import cat.insbaixcamp.fitnessapp2.ui.Screen.ProfileScreen
import cat.insbaixcamp.fitnessapp2.ui.theme.FitnessApp2Theme
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale
import java.util.TimeZone

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            FitnessApp2Theme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Box(Modifier.padding(innerPadding)) {
                        FitnessApp()
                    }
                }
            }
        }
    }
}

@Composable
fun FitnessApp() {
    var nom: String by remember { mutableStateOf("Laia Soler") }
    var email: String by remember { mutableStateOf("laia.soler@exemple.com") }
    var dataNaixement: Long by remember { mutableStateOf(937440000000L) }
    var genere: String by remember { mutableStateOf("Femení") }
    var alçada: Int by remember { mutableStateOf(170) }
    var pes: Double by remember { mutableStateOf(60.0) }
    var pesObjectiu: Double by remember { mutableStateOf(65.0) }
    var objectiu: String by remember { mutableStateOf("Guanyar massa muscular") }
    var nivellActivitat: String by remember { mutableStateOf("Moderat") }
    var editant: Boolean by remember { mutableStateOf(false) }

    if (editant) {
        EditProfile(
            nom = nom,
            email = email,
            dataNaixement = dataNaixement,
            genere = genere,
            pes = pes,
            pesObjectiu = pesObjectiu,
            alçada = alçada,
            objectiu = objectiu,
            nivellActivitat = nivellActivitat,
            guardar = { n, e, d, g, p, po, a ->
                nom = n
                email = e
                dataNaixement = d
                genere = g
                pes = p
                pesObjectiu = po
                alçada = a
                editant = false
            }
        )
    } else {
        val dataText = SimpleDateFormat("dd/MM/yyyy", Locale.getDefault()).apply {
            timeZone = TimeZone.getTimeZone("UTC")
        }.format(Date(dataNaixement))

        ProfileScreen(
            nom, email, dataText, genere, alçada,
            pes, objectiu, nivellActivitat,
            { editant = true }
        )
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    FitnessApp2Theme {
        FitnessApp()
    }
}