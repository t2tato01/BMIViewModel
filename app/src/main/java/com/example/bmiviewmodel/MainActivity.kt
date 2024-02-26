package com.example.bmiviewmodel

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.bmiviewmodel.ui.theme.BMIViewModelTheme

import androidx.activity.compose.setContent
//import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.TextField
import androidx.compose.ui.Alignment
//import androidx.compose.material.MaterialTheme
//import androidx.compose.material.Surface
//import androidx.compose.material.Text
//import androidx.compose.runtime.Composable
//import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
//import com.example.myapp.view-model.BMIViewModel
//import androidx.lifecycle.view-model.compose.viewModel
import com.example.bmiviewmodel.BMIViewModel.BMIViewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BMIApp()
        }
    }
}

private val viewModel = BMIViewModel()

@Composable
fun BMIApp() {
    // UIを構築するCompose関数を呼び出す
    Surface(
        color = MaterialTheme.colorScheme.background,
        modifier = Modifier.fillMaxSize()
    ) {
        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text("Calculate BMI", fontSize = 24.sp, modifier = Modifier.padding(16.dp))

            // Text field for entering height
            TextField(
                value = viewModel.height.value,
                onValueChange = { viewModel.setHeight(it) },
                label = { Text("Height (meters)") },
                modifier = Modifier.padding(16.dp)
            )

            // Text field for entering weight
            TextField(
                value = viewModel.weight.value,
                onValueChange = { viewModel.setWeight(it) },
                label = { Text("Weight (kilograms)") },
                modifier = Modifier.padding(16.dp)
            )

            // Button to calculate BMI
            Button(
                onClick = { viewModel.calculateBMI() },
                modifier = Modifier.padding(16.dp)
            ) {
                Text("Calculate")
            }

            // Display BMI result
            viewModel.bmiResult.value?.let { bmi ->
                Text(
                    text = "Your BMI: %.2f".format(bmi),
                    fontSize = 20.sp,
                    modifier = Modifier.padding(16.dp)
                )
            }
        }
    }
}

    @Preview(showBackground = true)
    @Composable
    fun DefaultPreview() {
        BMIApp()
    }

/*
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BMIViewModelTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Greeting("Android")
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    BMIViewModelTheme {
        Greeting("Android")
    }
}
*/
