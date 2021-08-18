package by.vshkl.punkapp.presentation.ui.components.organism

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import by.vshkl.punkapp.domain.model.Beer
import by.vshkl.punkapp.presentation.ui.components.molecule.BeerRow

@Composable
fun BeerList(
    beers: List<Beer>,
    onClick: (beer: Beer) -> Unit = {}
) {
    LazyColumn {
        items(
            items = beers,
            key = { it::id }
        ) { beer ->
            BeerRow(beer = beer, onClick = onClick)
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
                ibu = 60,
                ebc = 10,
                ph = 2.0,
                imageUrl = ""
            ),
            Beer(
                id = 2,
                name = "Beer 2",
                tagline = "Drink me!",
                description = "Eh?",
                abv = 5.0,
                ibu = 60,
                ebc = 10,
                ph = 2.0,
                imageUrl = ""
            ),
            Beer(
                id = 3,
                name = "Beer 3",
                tagline = "Drink me!",
                description = "Eh?",
                abv = 5.0,
                ibu = 60,
                ebc = 10,
                ph = 2.0,
                imageUrl = ""
            ),
        )
    )
}
