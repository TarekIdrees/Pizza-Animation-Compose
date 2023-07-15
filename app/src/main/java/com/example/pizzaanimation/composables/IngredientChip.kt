package com.example.pizzaanimation.composables

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.pizzaanimation.ui.theme.GreenLight

@Composable
fun IngredientChip(image: Int) {
    Surface(
        modifier = Modifier.size(65.dp, 65.dp),
        shape = CircleShape,
        color = GreenLight,
    ) {
        Image(
            painter = painterResource(id = image),
            contentScale = ContentScale.Fit,
            contentDescription = "character image",
            modifier = Modifier.padding(8.dp)
        )
    }
}