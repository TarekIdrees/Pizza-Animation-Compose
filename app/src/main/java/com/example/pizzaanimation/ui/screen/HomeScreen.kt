package com.example.pizzaanimation.ui.screen

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.pager.PagerState
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.pizzaanimation.ui.screen.composables.HomeTopbar
import com.example.pizzaanimation.ui.screen.composables.Ingredients
import com.example.pizzaanimation.ui.screen.composables.Pizza
import com.example.pizzaanimation.ui.screen.composables.PizzaSizeChips
import com.example.pizzaanimation.composables.SpaceVertical16
import com.example.pizzaanimation.composables.SpacerHorizontal8

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun HomeScreen(
    viewModel: HomeViewModel = hiltViewModel()
) {
    val state by viewModel.state.collectAsState()
    val pagerState = rememberPagerState()
    HomeContent(
        state,
        pagerState,
        viewModel
    )
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun HomeContent(state: HomeUiState, pagerState: PagerState, listener: HomeInteractionListener) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        HomeTopbar()
        SpaceVertical16()
        Pizza(state, pagerState)
        SpaceVertical16()
        Text(
            "$${state.cost}",
            fontWeight = FontWeight.Bold,
            fontSize = 22.sp,
        )
        SpaceVertical16()
        PizzaSizeChips(
            state = state,
            onSelectionChanged = {
                listener.onClickSize(it)
            }
        )
        SpaceVertical16()
        Ingredients(state)
        Row(
            verticalAlignment = Alignment.Bottom
        ) {
            Button(
                modifier = Modifier.padding(top = 68.dp),
                onClick = { /*TODO*/ },
                colors = ButtonDefaults.buttonColors(Color.DarkGray),
                shape = RoundedCornerShape(8.dp),
            ) {
                Row {
                    Icon(
                        Icons.Default.ShoppingCart,
                        contentDescription = "cart button",
                        tint = Color.White,
                    )
                    SpacerHorizontal8()
                    Text(
                        text = "Add to cart",
                        color = Color.White
                    )
                }

            }
        }
    }
}
@OptIn(ExperimentalFoundationApi::class)
@Preview(showSystemUi = true)
@Composable
fun Preview() {
    HomeContent(
        state = HomeUiState(),
        pagerState = rememberPagerState(),
        object : HomeInteractionListener {
            override fun onClickSize(size: PizzaSize) {
                TODO("Not yet implemented")
            }

            override fun onClickIngredient(ingredient: Ingredient) {
                TODO("Not yet implemented")
            }

        })
}