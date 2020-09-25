package com.morschgartner.nac2semestre.database

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Item (
    @PrimaryKey(autoGenerate = true) val id:Int?,
    @ColumnInfo(name="name") val name:String,
    @ColumnInfo(name="notes") val notes:String,
    @ColumnInfo(name="quantity") val quantity:Int
)