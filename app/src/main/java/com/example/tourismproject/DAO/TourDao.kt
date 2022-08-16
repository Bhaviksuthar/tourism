package com.example.tourismproject.DAO

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.example.tourismproject.Model.TourModel

@Dao
public interface TourDao {

    @Insert
    fun insert(tourModel: TourModel)

    @Update
    fun update(tourModel: TourModel)

    @Query("DELETE FROM tourTable WHERE id = :id")
    fun delete(id : Int)

    @Query("SELECT * FROM tourTable")
    fun getAllData() : LiveData<List<TourModel>>
}