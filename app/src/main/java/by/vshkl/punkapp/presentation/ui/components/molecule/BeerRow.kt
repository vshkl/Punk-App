package by.vshkl.punkapp.presentation.ui.components.molecule

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
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
        Text(
            text = beer.name,
            fontSize = 22.sp,
            fontWeight = FontWeight.SemiBold,
            maxLines = 1,
            overflow = TextOverflow.Ellipsis,
        )
        Text(
            text = beer.tagline,
            fontSize = 14.sp,
            fontWeight = FontWeight.Light,
            maxLines = 1,
            overflow = TextOverflow.Ellipsis,
        )
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
            ibu = 60.0,
            imageUrl = ""
        )
    )
}
