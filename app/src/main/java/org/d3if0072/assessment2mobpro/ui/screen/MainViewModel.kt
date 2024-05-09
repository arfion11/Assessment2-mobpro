package org.d3if0072.assessment2mobpro.ui.screen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.stateIn
import org.d3if0072.assessment2mobpro.database.LaptopDao
import org.d3if0072.assessment2mobpro.model.Laptop

class MainViewModel(dao: LaptopDao) : ViewModel() {

    val data: StateFlow<List<Laptop>> = dao.getLaptop().stateIn(
        scope = viewModelScope,
        started = SharingStarted.WhileSubscribed(5000L),
        initialValue = emptyList()
    )
}