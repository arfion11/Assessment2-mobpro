package org.d3if0072.assessment2mobpro.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import org.d3if0072.assessment2mobpro.model.Laptop

@Database(entities = [Laptop::class], version = 1, exportSchema = false)
abstract class LaptopDB : RoomDatabase(){

    abstract val dao: LaptopDao

    companion object{
        @Volatile
        private var INSTANCE: LaptopDB? = null

        fun getInstance(context: Context): LaptopDB{
            synchronized(this) {
                var instance = INSTANCE
                if (instance == null) {
                    instance = Room.databaseBuilder(
                        context.applicationContext,
                        LaptopDB::class.java,
                        "catatan.db"
                    ).build()
                    INSTANCE = instance
                }
                return instance
            }
        }
    }
}