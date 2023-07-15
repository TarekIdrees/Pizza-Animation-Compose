package com.example.pizzaanimation.composables

import androidx.compose.animation.core.animateDpAsState
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.PagerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.pizzaanimation.R
import com.example.pizzaanimation.viewmodel.HomeUiState

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun Pizza(state: HomeUiState, pagerState: PagerState) {
    val size = remember { mutableStateOf(0.dp) }
    val pizzaSize by animateDpAsState(size.value)
    Box(
        modifier = Modifier.fillMaxWidth(),
        contentAlignment = Alignment.Center
    ) {
        Image(
            modifier = Modifier.size(width = 250.dp, height = 250.dp),
            painter = painterResource(id = R.drawable.plate),
            contentDescription = "pizza plate",
            contentScale = ContentScale.Crop
        )
        HorizontalPager(
            pageCount = state.pizzaBreads.size,
            state = pagerState,
            beyondBoundsPageCount = 2
        ) { pageIndex ->

            Image(
                modifier = Modifier.size(pizzaSize, pizzaSize),
                painter = painterResource(id = state.pizzaBreads[pageIndex].image),
                contentDescription = "pizza bread",
                contentScale = ContentScale.Crop
            )
            LaunchedEffect(key1 = state.pizzaSize) {
                size.value = state.pizzaSize.size
            }
        }

    }

}