package com.project.destma.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.project.destma.DestMaApplication
import com.project.destma.domain.model.Destination
import com.project.destma.network.dao.DestinationDao
import kotlinx.coroutines.launch


//
class MainViewModel(
    private val destinationDao: DestinationDao
): ViewModel() {
    var resultState by mutableStateOf<List<Destination>>(emptyList())
        private set

    init {
        viewModelScope.launch {
            destinationDao.getAllDestination().collect { value ->
                resultState = value
            }
        }
    }
}

//class MainViewModelFactory: ViewModelProvider.Factory {
//    override fun <T : ViewModel> create(modelClass: Class<T>): T = MainViewModel(DestMaApplication) as T
//}

