package com.justin.myapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyItemScope
import androidx.compose.foundation.lazy.items
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import com.justin.myapplication.ui.theme.MyApplicationTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyApplicationTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    Greeting("Android")
                }
            }
        }
    }
}

data class GreetingItem(val itemText: String)
@Composable
fun LazyItemScope.addHeader(){
    Text(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color.Magenta),
        textAlign = TextAlign.Center,
        text = "Header"
    )
}

@Composable
fun ColumnScope.addLazyList(){
    LazyColumn(
        modifier = Modifier
            .background(Color.Gray)
    ) {
       item { this.addHeader() }
        items(listOf(
            GreetingItem("Greetings 1"),
            GreetingItem("Greetings 2"),
            GreetingItem("Greetings 3"),
        )
        ){
            Text(text = it.itemText)
        }
    }
}

@Composable
fun createList() {
    Column(modifier = Modifier
        .background(Color.Red)){
        this.addLazyList()
    }
}

@Composable
fun Greeting(name: String) {
    createList()
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    MyApplicationTheme {
        Greeting("Android")
    }
}