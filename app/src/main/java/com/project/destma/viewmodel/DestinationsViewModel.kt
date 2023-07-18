package com.project.destma.viewmodel

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.project.destma.DestMaApplication
import com.project.destma.domain.model.Destination
import com.project.destma.domain.model.PartialDestination
import com.project.destma.domain.repository.DestinationRepository
import com.project.destma.network.database.AppDatabase
import com.project.destma.network.service.DestinationApiService
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class DestinationsViewModel(
    destinationRepository: DestinationRepository
) : ViewModel() {
    private var destInterface: DestinationApiService
    private var destinationDao = AppDatabase.getDestinationInstance(
        DestMaApplication.getAppContext()
    )

    val state = mutableStateOf(emptyArray<Destination>())

    private val errorHandle = CoroutineExceptionHandler{ _, exception ->
        exception.printStackTrace()
    }

    init {
        val retrofit: Retrofit = Retrofit
            .Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl("https://destmadb-default-rtdb.asia-southeast1.firebasedatabase.app/")
            .build()

        destInterface = retrofit.create(DestinationApiService::class.java)
        getDestinations()
    }

    fun toggleFavorite(id: Long, oldValue: Boolean){
        viewModelScope.launch(errorHandle) {
            val updatedDestinations = toggleFavoriteDestination(id, oldValue)
            //state.value = updatedDestinations
        }
    }

    private suspend fun toggleFavoriteDestination(
        id: Long,
        oldValue: Boolean
    ) = withContext(Dispatchers.IO){
        destinationDao.updateDestination(
            PartialDestination(id = id, isFavorite = !oldValue))
        destinationDao.getAllDestination()
    }

    private fun getDestinations(){
        viewModelScope.launch(errorHandle) {
            //state.value = getDestinations()
        }
    }
}