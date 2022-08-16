package com.example.tourismproject.Model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "tourTable")
data class TourModel(

    @PrimaryKey(autoGenerate = true)
    var id : Int,

    @ColumnInfo(name = "placeName")
    var placeName : String,

    @ColumnInfo(name = "total People")
    var people : Int,

    @ColumnInfo(name = "TotalMoney")
    var money : Int,

    @ColumnInfo(name = "Person name")
    var name : String,

    @ColumnInfo(name = "address")
    var address : String,

    @ColumnInfo(name = "days")
    var days : String


)
