package by.vshkl.punkapp.presentation.ui.components.molecule

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import by.vshkl.punkapp.domain.model.Beer

@Composable
fun BeerRow(
    beer: Beer,
    onClick: (beer: Beer) -> Unit = {}
) {
    Column(
        modifier = Modifier
            .clickable { onClick(beer) }
            .padding(16.dp, 8.dp)
            .fillMaxWidth()
    ) {
        Text(text = beer.name)
        Text(text = beer.tagline)
    }
}

@Preview(showBackground = true, backgroundColor = 0xFFFFFF)
@Composable
fun BeerRowPreview() {
    BeerRow(
        beer = Beer(
            id = 1,
            name = "Beer",
            tagline = "Drink me!",
            description = "Eh?",
            abv = 5.0,
            ibu = 60,
            ebc = 10,
            ph = 2.0,
            imageUrl = ""
        )
    )
}
