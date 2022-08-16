package com.example.tourismproject.DataBase

import android.content.Context
import androidx.room.Database
import androidx.room.Entity
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.tourismproject.DAO.TourDao
import com.example.tourismproject.Model.TourModel

@Database(entities = [TourModel::class], version = 1, exportSchema = false)
public abstract class TourDataBase :RoomDatabase(){

    abstract fun tourDao() : TourDao


    companion object{
        public var instance : TourDataBase? = null

        @Synchronized
        fun getInstance(context: Context) : TourDataBase{
            if (instance == null){
                instance = Room.databaseBuilder(context,TourDataBase::class.java,"TourDb")
                    .fallbackToDestructiveMigration()
                    .allowMainThreadQueries()
                    .build()
            }

            return instance!!
        }
    }
}