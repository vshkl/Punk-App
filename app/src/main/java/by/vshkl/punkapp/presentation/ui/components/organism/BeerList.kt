package by.vshkl.punkapp.presentation.ui.components.organism

import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material.Divider
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.snapshotFlow
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import by.vshkl.punkapp.domain.model.Beer
import by.vshkl.punkapp.presentation.ui.components.molecule.BeerRow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.distinctUntilChanged

@Composable
fun BeerList(
    beers: List<Beer>,
    onLoadMore: () -> Unit = {},
    onClick: (beer: Beer) -> Unit = {}
) {
    val listState = rememberLazyListState()
    val loadMore = remember {
        derivedStateOf {
            val layoutInfo = listState.layoutInfo
            val totalItemsNumber = layoutInfo.totalItemsCount
            val lastVisibleItemIndex = (layoutInfo.visibleItemsInfo.lastOrNull()?.index ?: 0) + 1

            lastVisibleItemIndex > (totalItemsNumber - 2)
        }
    }

    LazyColumn(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight(),
        state = listState
    ) {
        items(
            items = beers,
            key = { it::id }
        ) { beer ->
            BeerRow(beer = beer, onClick = onClick)
            Divider(startIndent = 16.dp)
        }
    }

    LaunchedEffect(loadMore) {
        snapshotFlow { loadMore.value }
            .distinctUntilChanged()
            .collect { onLoadMore() }
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
