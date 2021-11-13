package com.oyoyoy.basicscodelab

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.OutlinedButton
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.oyoyoy.basicscodelab.ui.theme.BasicsCodelabTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BasicsCodelabTheme {
                MyApp()
                // A surface container using the 'background' color from the theme
            }
        }
    }
}

@Composable
private fun MyApp(names : List<String> = listOf("Android","Compose")){
    Surface(
        //modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colors.background
    ){
        Column (modifier = Modifier.padding(4.dp)) {
            for (i in names) {
                Greeting(i)
            }
        }
    }
}


@Composable
fun Greeting(name: String) {
    val expanded = remember { mutableStateOf(false) }
    Surface(color = MaterialTheme.colors.primary,
    modifier = Modifier.padding(vertical = 4.dp, horizontal = 8.dp)) {

        Row (modifier = Modifier.fillMaxWidth().padding(24.dp)){
            Column(modifier = Modifier.weight(1f)) {
                Text(text = "Hello")
                Text(text =  name)
            }
            OutlinedButton(
                onClick = { expanded.value = !expanded.value  }
            ) {
                Text(if (expanded.value) "Show more" else "Show less")
            }
        }
    }
}

@Preview(showBackground = true, widthDp = 320)
@Composable
fun DefaultPreview() {
    BasicsCodelabTheme {
        MyApp()
    }
}