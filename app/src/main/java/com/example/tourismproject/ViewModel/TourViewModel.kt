package com.example.tourismproject.ViewModel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import com.example.tourismproject.Model.TourModel
import com.example.tourismproject.Repository.TourRepository

public class TourViewModel(application : Application) : AndroidViewModel(application) {

    lateinit var repository : TourRepository
    lateinit var getAllData : LiveData<List<TourModel>>

    init {
        repository = TourRepository(application)
        getAllData = repository.getAll
    }

    public fun Add(tourModel: TourModel){
        repository.add(tourModel)
    }

    public fun delete(id : Int){
        repository.delete(id)
    }

    public fun update(tourModel: TourModel){
        repository.update(tourModel)
    }

}