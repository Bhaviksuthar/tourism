package com.example.tourismproject.Repository

import android.app.Application
import androidx.lifecycle.LiveData
import com.example.tourismproject.DAO.TourDao
import com.example.tourismproject.DataBase.TourDataBase
import com.example.tourismproject.Model.TourModel

class TourRepository(application: Application){

    public lateinit var tourDao : TourDao
    public lateinit var getAll : LiveData<List<TourModel>>

    init {
        val tourDataBase : TourDataBase = TourDataBase.getInstance(application)
        tourDao = tourDataBase.tourDao()
        getAll = tourDao.getAllData()
    }

    public fun add(tourModel: TourModel){
        tourDao.insert(tourModel)
    }

    public fun update(tourModel: TourModel){
        tourDao.update(tourModel)
    }

    public fun delete(id : Int){
        tourDao.delete(id)
    }
}