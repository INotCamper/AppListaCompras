package com.morschgartner.nac2semestre.database

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.morschgartner.nac2semestre.model.ListItem

@Dao
interface ItemDao {

    @Query("SELECT * FROM item")
    fun getAll():List<Item>

    @Insert
    fun insert(vararg itens: Item)

    @Delete
    fun delete(item: Item)

}