package com.example.projekt

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.AnimatedContent
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.semantics.Role.Companion.Button
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.projekt.ui.theme.ProjektTheme

data class Hodnoty(val meno:String, val vaha:String)

class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalMaterial3Api::class, ExperimentalAnimationApi::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val hodnoty = remember { mutableStateOf<Hodnoty?>(null) }
            AnimatedContent(targetState = hodnoty.value){ h ->
                if (h == null){
                    Main { meno, vaha-> hodnoty.value = Hodnoty(meno,vaha) }
                }
                }

                }
            }


        }

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Main(onButton : (String, String) -> Unit) {
    Column {


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
        Button(modifier = Modifier
            .padding(16.dp)
            .fillMaxWidth()
            .size(50.dp),
            onClick = {
                onButton(meno.value, vaha.value)
            }) {
            Text(text = "Pokracovať", fontSize = 25.sp)
            


            }
            }
        }

