package com.morschgartner.nac2semestre

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.room.Room
import com.morschgartner.nac2semestre.database.AppDatabase
import com.morschgartner.nac2semestre.database.Item
import kotlinx.android.synthetic.main.activity_add_list_item.*

class AddListItem : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_list_item)

        btAdd.setOnClickListener {
            addItem()
        }
    }

    private fun addItem(){
        val name = etName.text.toString()
        val desc = etDesc.text.toString()
        val quant = etnQuant.text.toString().toInt()

        val item = Item(
            null,
            name,
            desc,
            quant
        )

        val db = Room.databaseBuilder(
            applicationContext,
            AppDatabase::class.java, "database-name"
        ).allowMainThreadQueries().build()

        db.itemDao().insert(item)

        finish()
    }
}