package com.example.bmiviewmodel.BMIViewModel


import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel

class BMIViewModel : ViewModel() {
    // Member variables for height, weight, and BMI result
    val height: MutableState<String> = mutableStateOf("")
    val weight: MutableState<String> = mutableStateOf("")
    val bmiResult: MutableState<Float?> = mutableStateOf(null)

    // Method for updating height
    fun setHeight(value: String) {
        height.value = value
    }

    // Method for updating weight
    fun setWeight(value: String) {
        weight.value = value
    }

    // Method for calculating BMI
    fun calculateBMI() {
        val heightValue = height.value.toFloatOrNull()
        val weightValue = weight.value.toFloatOrNull()

        if (heightValue != null && weightValue != null && heightValue > 0 && weightValue > 0) {
            val bmi = weightValue / (heightValue * heightValue)
            bmiResult.value = bmi
        } else {
            // If height or weight is not valid, set BMI result to null
            bmiResult.value = null
        }
    }
}

