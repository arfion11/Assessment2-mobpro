package org.d3if0072.assessment2mobpro.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "laptop")
data class Laptop(
    @PrimaryKey(autoGenerate = true)
    val id: Long = 0L,
    val nama: String,
    val processor: String,
    val gpu: String,
    val stok: String,
)