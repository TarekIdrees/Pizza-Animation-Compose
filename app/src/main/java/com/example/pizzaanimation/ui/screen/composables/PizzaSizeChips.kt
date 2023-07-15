package com.example.pizzaanimation.ui.screen.composables

import androidx.compose.animation.core.animateDpAsState
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.pizzaanimation.ui.screen.HomeUiState
import com.example.pizzaanimation.ui.screen.PizzaSize
import com.example.pizzaanimation.ui.screen.Sizes

@Composable
fun PizzaSizeChips(
    state: HomeUiState,
    onSelectionChanged: (PizzaSize) -> Unit = {}
) {
    val size = remember { mutableStateOf(0.dp) }
    val offset: Dp by animateDpAsState(targetValue = size.value)
    Box(
        modifier = Modifier.fillMaxWidth(),
        contentAlignment = Alignment.Center
    ) {
        Column(
            modifier = Modifier
                .offset(x = offset,y = (-15).dp)
                .size(45.dp)
                .graphicsLayer(
                    shadowElevation = 20f,
                    shape = CircleShape,
                    translationY = 50f,
                )
                .background(color = Color.White, shape = CircleShape)
                .clip(CircleShape)
        ) {}
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(64.dp, Alignment.CenterHorizontally)
        ) {
            val interactionSource = remember { MutableInteractionSource() }
            for (i in 0 until state.pizzaSizes.size) {
                Text(
                    modifier = Modifier.clickable(
                        interactionSource = interactionSource,
                        indication = null
                    ) { onSelectionChanged(state.pizzaSizes[i]) },
                    text = state.pizzaSizes[i].name,
                    fontSize = 20.sp,
                    color = Color.Black,
                )
            }
            LaunchedEffect(key1 = state.pizzaSize) {
                when (state.pizzaSize.type) {
                    Sizes.Small -> size.value = (-78).dp
                    Sizes.Medium -> size.value = (0).dp
                    Sizes.Large -> size.value = (78).dp
                }
            }
        }
    }

}