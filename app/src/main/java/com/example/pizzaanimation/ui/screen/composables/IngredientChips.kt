package com.example.pizzaanimation.ui.screen.composables

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.pager.PagerState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.pizzaanimation.ui.screen.HomeUiState
import com.example.pizzaanimation.ui.screen.Ingredient

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun Ingredients(
    state: HomeUiState,
    pagerState: PagerState,
    onIngredientClicked: (Int) -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp),
        horizontalAlignment = Alignment.Start
    ) {
        Text(
            text = "CUSTOMIZE YOUR PIZZA",
            color = Color.LightGray,
            fontSize = 12.sp
        )
    }
    LazyRow(
        modifier = Modifier.fillMaxWidth(),
        contentPadding = PaddingValues(horizontal = 16.dp),
        horizontalArrangement = Arrangement.spacedBy(8.dp)
    ) {

        itemsIndexed(state.ingredients) { index: Int, item: Ingredient ->
            IngredientChip(
                ingredient = item,
                isSelected = state.pizzaBreads[pagerState.currentPage].pizzaIngredient[index].isSelected,
                onClickIngredient = {
                    onIngredientClicked(index)
                }
            )
        }
    }
}