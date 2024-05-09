package org.d3if0072.assessment2mobpro.ui.screen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import org.d3if0072.assessment2mobpro.database.LaptopDao
import org.d3if0072.assessment2mobpro.model.Laptop

class DetailViewModel(private val dao: LaptopDao) : ViewModel() {

    fun insert(nama: String, processor: String, gpu: String, stok:String){
        val laptop = Laptop(
            nama = nama,
            processor = processor,
            gpu = gpu,
            stok =stok
        )

        viewModelScope.launch (Dispatchers.IO){
            dao.insert(laptop)
        }
    }

    suspend fun getLaptop(id: Long): Laptop? {
        return dao.getLaptopById(id)
    }

    fun update(id: Long, nama: String, processor: String, gpu: String, stok:String){
        val laptop = Laptop(
            id = id,
            nama = nama,
            processor = processor,
            gpu = gpu,
            stok =stok
        )

        viewModelScope.launch (Dispatchers.IO){
            dao.update(laptop)
        }
    }

    fun delete(id: Long){
        viewModelScope.launch (Dispatchers.IO){
            dao.deletById(id)
        }
    }
}