package com.example.projekt

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.AnimatedContent
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.app.NotificationCompat

data class Hodnoty(val meno: String, val vaha: String, val vek: String)

class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalMaterial3Api::class, ExperimentalAnimationApi::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val hodnoty = remember { mutableStateOf<Hodnoty?>(null) } // zisti co toto robi
            AnimatedContent(targetState = hodnoty.value, label = "") { h ->
                // TODO pozri si 'arrow function' v kotline ako funguje a co to je
                if (h == null) {
                    Main { meno, vaha, vek -> hodnoty.value = Hodnoty(meno, vaha, vek) }
                }
            }

        }
    }

    var builder = NotificationCompat.Builder(this,)
        .setSmallIcon(R.drawable.flasa)
        .setContentTitle("Upozornenie!")
        .setContentText("TREBA SA NAPIŤ")
        .setPriority(NotificationCompat.PRIORITY_DEFAULT)

    @OptIn(ExperimentalMaterial3Api::class)
    @Composable
    fun Main(onButton: (String, String, String) -> Unit) {
        Column {

            val vek = remember { mutableStateOf("") }
            val meno = remember { mutableStateOf("") }
            val vaha = remember { mutableStateOf("") }


            Text(
                text = "Zadajte meno",
                fontSize = 30.sp,
                modifier = Modifier.padding(start = 120.dp)

            )

            OutlinedTextField(
                value = meno.value,
                onValueChange = { meno.value = it },
                modifier = Modifier.padding(start = 70.dp)
            )

            Text(
                text = "Zadajte váhu",
                fontSize = 30.sp,
                modifier = Modifier.padding(start = 120.dp)
            )

            OutlinedTextField(
                value = vaha.value,
                onValueChange = { vaha.value = it },
                modifier = Modifier.padding(start = 70.dp)
            )
            Text(
                text = "Zadajte vek",
                fontSize = 30.sp,
                modifier = Modifier.padding(start = 120.dp)

            )
            OutlinedTextField(
                value = vek.value,
                onValueChange = { vek.value = it },
                modifier = Modifier.padding(start = 70.dp)
            )
            Button(modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth()
                .size(50.dp),
                onClick = {
                    // tu musis vytvorit novu aktivitu ktora ti da toto okno do pozadia a otvori novu
                    onButton(meno.value, vaha.value, vek.value)
                }) {
                Text(text = "Pokračovať", fontSize = 25.sp)



            }
        }
    }
}
/*fun stpracujHodnoty(String: meno, Int: vaha) {
    // Toto bude kvazi tvoj bacend
    if (vaha > 100) {
        println('vypi viac ako 5L denne')
    }
}
*/