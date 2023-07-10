package com.example.pizzaanimation.screen

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.PagerState
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.selection.toggleable
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.IconButtonColors
import androidx.compose.material3.IconButtonDefaults
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import coil.compose.rememberAsyncImagePainter
import com.example.pizzaanimation.R
import com.example.pizzaanimation.composables.SpaceVertical16
import com.example.pizzaanimation.composables.SpaceVertical8
import com.example.pizzaanimation.composables.SpacerHorizontal8
import com.example.pizzaanimation.ui.theme.DarkGray
import com.example.pizzaanimation.ui.theme.GreenLight
import com.example.pizzaanimation.viewmodel.HomeUiState
import com.example.pizzaanimation.viewmodel.HomeViewModel
import com.example.pizzaanimation.viewmodel.Ingredient
import com.example.pizzaanimation.viewmodel.PizzaSize

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun HomeScreen(
    viewModel: HomeViewModel = hiltViewModel()
) {
    val state by viewModel.state.collectAsState()
    val pagerState = rememberPagerState()
    HomeContent(state, pagerState)
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun HomeContent(state: HomeUiState, pagerState: PagerState) {
    Column(
        modifier = Modifier.fillMaxSize().background(Color.White),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Header()
        SpaceVertical16()
        Pizza(state, pagerState)
        SpaceVertical16()
        Text(
            "$${state.cost}",
            fontWeight = FontWeight.Bold,
            fontSize = 22.sp,
        )
        SpaceVertical16()
        ChipGroup(
            pizzaSizes = state.pizzaSizes,
            onSelectionChanged = {

            }
        )
        SpaceVertical16()
        Ingredient(state)
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

@Composable
fun Ingredient(state: HomeUiState) {
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
    SpaceVertical8()
    LazyRow(
        modifier = Modifier.fillMaxWidth(),
        contentPadding = PaddingValues(horizontal = 16.dp),
        horizontalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        state.ingredients.forEach {
            item {
                IngredientChip(image = it.image)
            }
        }
    }
}

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
            modifier = Modifier
                .padding(8.dp)

        )
    }
}

@Composable
fun Chip(
    name: String,
    isSelected: Boolean,
    onSelectionChanged: (String) -> Unit
) {
    Surface(
        modifier = Modifier.padding(4.dp),
        shadowElevation = if (isSelected) 8.dp else 0.dp,
        shape = CircleShape,
        color = Color.Transparent
    ) {
        Row(
            modifier = Modifier.toggleable(
                value = isSelected,
                onValueChange = {
                    onSelectionChanged(name)
                })
        ) {
            Text(
                text = name,
                fontSize = 20.sp,
                color = Color.Black,
                modifier = Modifier.padding(8.dp)
            )
        }
    }
}

@Composable
fun ChipGroup(
    pizzaSizes: List<PizzaSize> = emptyList(),
    onSelectionChanged: (String) -> Unit = {}
) {
    Column() {
        LazyRow(
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            pizzaSizes.forEach {
                item {
                    Chip(
                        name = it.name,
                        isSelected = it.isSelected,
                        onSelectionChanged = onSelectionChanged
                    )
                }
            }
        }
    }
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun Pizza(state: HomeUiState, pagerState: PagerState) {
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
            beyondBoundsPageCount = state.pizzaBreads.size,
        ) { pageIndex ->
            Image(
                modifier = Modifier.size(width = 200.dp, height = 200.dp),
                painter = painterResource(id = state.pizzaBreads[pageIndex]),
                contentDescription = "pizza plate",
                contentScale = ContentScale.Crop
            )
        }
    }
}

@Composable
fun Header() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 8.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.Top
    ) {
        IconButton(onClick = { }) {
            Icon(
                Icons.Default.ArrowBack,
                contentDescription = "back button"
            )
        }
        Text(
            modifier = Modifier.padding(8.dp),
            text = "Pizza",
            textAlign = TextAlign.Center,
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold,
        )
        IconButton(onClick = { }) {
            Icon(
                Icons.Default.Favorite,
                contentDescription = "favorite button"
            )
        }

    }
}

@OptIn(ExperimentalFoundationApi::class)
@Preview(showSystemUi = true)
@Composable
fun Preview() {
    HomeContent(state = HomeUiState(), pagerState = rememberPagerState())
}