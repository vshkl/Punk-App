package by.vshkl.punkapp.presentation.ui.components.organism

import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material.Divider
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.snapshotFlow
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import by.vshkl.punkapp.domain.model.Beer
import by.vshkl.punkapp.presentation.ui.components.molecule.BeerRow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.filter
import kotlinx.coroutines.flow.onEach

/**
 * [ScrollPosition] represents current scroll position. It holds current and last indexes.
 *
 * @param currentIndex  Current scroll index
 * @param lastIndex     Last possible scroll index
 */
data class ScrollPosition(
    val currentIndex: Int,
    val lastIndex: Int
) {

    val isNotEmpty: Boolean
        get() = currentIndex > 0 && lastIndex > 0
    val isReachedLast: Boolean
        get() = isNotEmpty && currentIndex == lastIndex
}

@Composable
fun BeerList(
    beers: List<Beer>,
    onLoadMore: () -> Unit = {},
    onClick: (beer: Beer) -> Unit = {}
) {
    val listState = rememberLazyListState()
    val farthestIndex = remember { mutableStateOf(0) }

    LazyColumn(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight(),
        state = listState,
    ) {
        items(
            items = beers,
            key = { it::id }
        ) { beer ->
            BeerRow(beer = beer, onClick = onClick)
            Divider(startIndent = 16.dp)
        }
    }

    LaunchedEffect(listState) {
        snapshotFlow {
            ScrollPosition(
                currentIndex = listState.layoutInfo.visibleItemsInfo.lastOrNull()?.index ?: 0,
                lastIndex = listState.layoutInfo.totalItemsCount - 1
            )
        }.filter {
            it.isNotEmpty && it.currentIndex > farthestIndex.value
        }.onEach {
            farthestIndex.value = it.currentIndex
        }.collect {
            if (it.isReachedLast) {
                onLoadMore()
            }
        }
    }
}

@Preview(showBackground = true, backgroundColor = 0xFFFFFF)
@Composable
fun BeerListPreview() {
    BeerList(
        beers = listOf(
            Beer(
                id = 1,
                name = "Beer 1",
                tagline = "Drink me!",
                description = "Eh?",
                abv = 5.0,
                ibu = 60.0,
                imageUrl = ""
            ),
            Beer(
                id = 2,
                name = "Beer 2",
                tagline = "Drink me!",
                description = "Eh?",
                abv = 5.0,
                ibu = 60.0,
                imageUrl = ""
            ),
            Beer(
                id = 3,
                name = "Beer 3",
                tagline = "Drink me!",
                description = "Eh?",
                abv = 5.0,
                ibu = 60.0,
                imageUrl = ""
            ),
        )
    )
}
