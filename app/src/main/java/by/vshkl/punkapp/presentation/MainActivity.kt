package by.vshkl.punkapp.presentation

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import by.vshkl.punkapp.presentation.ui.components.organism.BeerList
import by.vshkl.punkapp.presentation.ui.theme.PunkAppTheme

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PunkAppTheme {
                Surface(color = MaterialTheme.colors.background) {
                    BeerList(beers = emptyList()) {
                        Toast.makeText(this, it.id.toString(), Toast.LENGTH_SHORT).show()
                    }
                }
            }
        }
    }
}
