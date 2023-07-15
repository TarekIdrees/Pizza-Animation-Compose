package com.example.pizzaanimation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.example.pizzaanimation.ui.screen.HomeScreen
import com.example.pizzaanimation.ui.theme.PizzaAnimationTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PizzaAnimationTheme {
                HomeScreen()
            }
        }
    }
}
