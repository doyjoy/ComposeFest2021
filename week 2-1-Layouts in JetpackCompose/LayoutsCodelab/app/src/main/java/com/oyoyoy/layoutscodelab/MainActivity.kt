package com.oyoyoy.layoutscodelab

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.rememberImagePainter
import com.oyoyoy.layoutscodelab.ui.theme.LayoutsCodelabTheme


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LayoutsCodelabTheme {
                // A surface container using the 'background' color from the theme
                /*Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    PhotographerCard()
                }*/
                LayoutsCodelab()

            }
        }
    }
}

@Composable
fun Button(
    modifier: Modifier = Modifier,
    onClick : (() -> Unit)? = null,
    content : @Composable () -> Unit
){
    Row {

    }
}

@Composable
fun LayoutsCodelab(){
    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(text = "LayoutsCodelab")
                }
            )
        }
    ) {
        innerPadding ->
        BodyContent(modifier = Modifier
            .padding(innerPadding)
            .padding(8.dp))
    }
}

@Composable
fun BodyContent(modifier : Modifier = Modifier) {
    Column(modifier = modifier) {
        ImageList()
        Text(text = "Hi There!")
        Text(text = "Thanks for going through the Layouts codelab")
    }
}

@Composable
fun ImageList (){
    val scrollState = rememberLazyListState()
    LazyColumn(state = scrollState){
        items(100){
            imageListItem(index = it)
        }
    }

}

@Composable
fun imageListItem(index : Int){
    Row(verticalAlignment = Alignment.CenterVertically){
        Image(
            painter = rememberImagePainter(data = "https://developer.android.com/images/brand/Android_Robot.png"),
            contentDescription = "Android Logo",
            modifier = Modifier.size(50.dp)
        )
        Spacer(Modifier.width(10.dp))
        Text("Item #$index")

    }
}

@Composable
fun PhotographerCard(modifier: Modifier = Modifier) {
    Row (
        modifier
            .padding(16.dp)
            .clip(RoundedCornerShape(4.dp))
            .clickable(onClick = {})
            .background(MaterialTheme.colors.surface) ) {
        Surface (
            modifier = Modifier.size(50.dp),
            shape = CircleShape,
            color = MaterialTheme.colors.onSurface.copy(0.2f)
        ) {
        }
        Column(
            Modifier
                .padding(start = 8.dp)
                .align(Alignment.CenterVertically)) {
            Text("Alfred Sisley", fontWeight = FontWeight.Bold)
            CompositionLocalProvider(LocalContentAlpha provides ContentAlpha.medium) {
                Text ("3mins ago", style = MaterialTheme.typography.body2)
            }
        }
    }
}

@Preview
@Composable
fun LayoutsCodelabPreview() {
    LayoutsCodelabTheme {
        LayoutsCodelab()
    }
}