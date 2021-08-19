package by.vshkl.punkapp.presentation.feature.beers

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.platform.LocalContext
import by.vshkl.punkapp.presentation.ui.components.organism.BeerList
import by.vshkl.punkapp.presentation.ui.theme.PunkAppTheme
import org.koin.androidx.compose.getViewModel

class BeersActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            PunkAppTheme {
                Surface(color = MaterialTheme.colors.background) {
                    BeersScreen()
                }
            }
        }
    }
}

@Composable
fun BeersScreen() {
    val viewModel = getViewModel<BeersViewModel>()
    val beersState = viewModel.beers.observeAsState()
    val context = LocalContext.current

    BeerList(
        beers = beersState.value ?: emptyList(),
        onLoadMore = {
            Toast.makeText(context, "Load more", Toast.LENGTH_SHORT).show()
            viewModel.loadBeers()
        },
        onClick = {
            Toast.makeText(context, "${it.id} | ${it.name}", Toast.LENGTH_SHORT).show()
        }
    )
}
