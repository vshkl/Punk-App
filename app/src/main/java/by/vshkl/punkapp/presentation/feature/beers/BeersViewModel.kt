package by.vshkl.punkapp.presentation.feature.beers

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import by.vshkl.punkapp.data.repository.BeerRepository
import by.vshkl.punkapp.domain.model.Beer
import kotlinx.coroutines.launch

class BeersViewModel(
    private val beerRepository: BeerRepository
) : ViewModel() {

    val beers: LiveData<List<Beer>> = beerRepository.observeBeers().asLiveData()

    init {
        loadBeers()
    }

    fun loadBeers() {
        viewModelScope.launch {
            beerRepository.loadBeers()
        }
    }
}
