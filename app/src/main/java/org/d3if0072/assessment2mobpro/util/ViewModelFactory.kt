package org.d3if0072.assessment2mobpro.util

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import org.d3if0072.assessment2mobpro.database.LaptopDao
import org.d3if0072.assessment2mobpro.ui.screen.DetailViewModel
import org.d3if0072.assessment2mobpro.ui.screen.MainViewModel

class ViewModelFactory (
    private val dao: LaptopDao
) : ViewModelProvider.Factory{
    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(MainViewModel::class.java)){
            return MainViewModel(dao) as T
        } else if (modelClass.isAssignableFrom(DetailViewModel::class.java)){
            return DetailViewModel(dao) as T
        }
        throw IllegalArgumentException("Unknown Viewmodel Class")
    }
}