package cat.insbaixcamp.fitnessapp2.ui.Screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import cat.insbaixcamp.fitnessapp2.R
import cat.insbaixcamp.fitnessapp2.ui.component.CalendariPicker
import cat.insbaixcamp.fitnessapp2.ui.component.MenuDesplegable
import androidx.compose.ui.tooling.preview.Preview
import cat.insbaixcamp.fitnessapp2.ui.theme.FitnessApp2Theme


@Composable
fun EditProfile(
    nom: String,
    email: String,
    dataNaixement: Long,
    genere: String,
    pes: Double,
    pesObjectiu: Double,
    alçada: Int,
    objectiu: String,
    nivellActivitat: String,
    guardar: (String, String, Long, String, Double, Double, Int) -> Unit
) {
    var nomNou by remember { mutableStateOf(nom) }
    var emailNou by remember { mutableStateOf(email) }
    var dataNaixementNou by remember { mutableStateOf(dataNaixement) }
    var genereNou by remember { mutableStateOf(genere) }
    var pesNou by remember { mutableStateOf(pes.toString()) }
    var pesObjectiuNou by remember { mutableStateOf(pesObjectiu.toString()) }
    var alçadaNou by remember { mutableStateOf(alçada.toString()) }

    val opcionsGenere = listOf("Masculí", "Femení", "Prefereixo no dir-ho")

    Column(Modifier.fillMaxWidth()) {
        Row(Modifier.fillMaxWidth().padding(16.dp)) {
            Image(
                painter = painterResource(R.drawable.ic_launcher_foreground),
                contentDescription = null,
                modifier = Modifier.size(100.dp).clip(CircleShape).background(Color.Black)
            )
            Column(Modifier.fillMaxWidth(), horizontalAlignment = Alignment.End) {
                Button(onClick = {}) { Text("Canviar foto") }
                Button(onClick = {}) { Text("Eliminar foto") }
            }
        }

        Text("Dades personals", modifier = Modifier.padding(8.dp))
        OutlinedTextField(
            value = nomNou,
            onValueChange = { nomNou = it },
            label = { Text("Nom complet") },
            modifier = Modifier.padding(8.dp).fillMaxWidth(),
        )
        OutlinedTextField(
            value = emailNou,
            onValueChange = { emailNou = it },
            label = { Text("Email") },
            modifier = Modifier.padding(8.dp).fillMaxWidth(),
        )

        CalendariPicker(
            label = "Data de naixement",
            selectedDateMillis = dataNaixementNou,
            onDateSelected = { dataNaixementNou = it },
            modifier = Modifier.padding(8.dp).fillMaxWidth()
        )

        MenuDesplegable(
            label = "Genere",
            opcions = opcionsGenere,
            valorSeleccionat = genereNou,
            onValorSeleccionat = { genereNou = it },
            modifier = Modifier.padding(8.dp).fillMaxWidth()
        )

        Text("Dades físiques", modifier = Modifier.padding(8.dp))
        Row(Modifier.padding(8.dp)) {
            OutlinedTextField(
                value = alçadaNou,
                onValueChange = { alçadaNou = it },
                label = { Text("Alçada") },
                modifier = Modifier.weight(1f),
            )
            OutlinedTextField(
                value = pesNou,
                onValueChange = { pesNou = it },
                label = { Text("Pes") },
                modifier = Modifier.weight(1f),
            )
            OutlinedTextField(
                value = pesObjectiuNou,
                onValueChange = { pesObjectiuNou = it },
                label = { Text("Pes objectiu") },
                modifier = Modifier.weight(1f),
            )
        }

        Button(
            onClick = {
                guardar(
                    nomNou,
                    emailNou,
                    dataNaixementNou,
                    genereNou,
                    pesNou.toDoubleOrNull() ?: pes,
                    pesObjectiuNou.toDoubleOrNull() ?: pesObjectiu,
                    alçadaNou.toIntOrNull() ?: alçada
                )
            },
            modifier = Modifier.padding(8.dp).fillMaxWidth()
        ) {
            Text("Guardar canvis")
        }
    }
}
@Preview(showBackground = true)
@Composable
fun EditProfilePreview() {
    FitnessApp2Theme {
        EditProfile(
            nom = "Nom",
            email = "correu@exemple.com",
            dataNaixement = 0L,
            genere = "Femení",
            pes = 60.0,
            pesObjectiu = 55.0,
            alçada = 165,
            objectiu = "",
            nivellActivitat = "",
            guardar = { _, _, _, _, _, _, _ -> }
        )
    },
    modifier = Modifier
        .padding(8.dp)
        .fillMaxWidth()
    )
    {
        Text("Guardar canvis")
    }
}
}