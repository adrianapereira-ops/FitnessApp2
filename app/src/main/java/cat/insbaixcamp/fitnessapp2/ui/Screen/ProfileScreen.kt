package cat.insbaixcamp.fitnessapp2.ui.Screen

import android.icu.util.Calendar
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import cat.insbaixcamp.fitnessapp2.R

@Composable
fun ProfileScreen(
    nom: String,
    email: String,
    dataNaixement: String,
    genere: String,
    alçada: Int,
    pes: Double,
    objectiu: String,
    nivellActivitat: String,
    guardar: () -> Unit
) {
    Column() {
        //Caixa Foto , Nom , Email
        Column(
            Modifier.fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                painter = painterResource(id = R.drawable.ic_launcher_foreground),
                contentDescription = null,
                modifier = Modifier.size(120.dp).clip(CircleShape).background(Color.Black)
            )
            Text(
                text = nom,
                fontSize = 20.sp

            )
            Text(
                text = email,
                fontSize = 16.sp,
                fontWeight = FontWeight.Bold
            )
            Text(
                text = email,
                color = Color.Gray,
                fontSize = (16.sp)
            )
        }
        Card(Modifier.fillMaxWidth().padding(16.dp),
            shape = RoundedCornerShape(16.dp)){
            Row(Modifier.fillMaxWidth().padding(8.dp)) {

                Column() {

                    Text("edat" ,
                        color = Color.Gray)

                    val edat = Calendar.getInstance().get(Calendar.YEAR) - dataNaixement.substring(6).toInt()
                    Text(edat.toString(), fontWeight = FontWeight.Bold)
                }
                Column() {
                    Text("genere", color = Color.Gray)
                    Text(genere)
                }
                Column() {
                    Text("alçada", color = Color.Gray)
                    Text("$alçada cm")
                }
                Column() {
                    Text("Pes:" , color = Color.Gray)
                    Text("$pes kg")
                }
            }
        }
        //caixa d'objectius
Text("objectius")
        Card() {
            Text(objectiu)
        }
        //caixa nivell d'activitat
        Text("Nivell d'activitat")
        Card(
            Modifier
                .fillMaxWidth()
                .padding(16.dp),
        ) {
            Text(nivellActivitat, Modifier.padding(8.dp))
        }



    }
}


