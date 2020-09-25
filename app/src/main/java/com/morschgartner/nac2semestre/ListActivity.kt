package com.morschgartner.nac2semestre

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.room.Room
import com.morschgartner.nac2semestre.adapter.ItemListAdapter
import com.morschgartner.nac2semestre.database.AppDatabase
import com.morschgartner.nac2semestre.database.Item
import com.morschgartner.nac2semestre.model.ListItem
import kotlinx.android.synthetic.main.activity_list.*

class ListActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list)



    }

    override fun onResume() {
        super.onResume()

        val db = Room.databaseBuilder(
            applicationContext,
            AppDatabase::class.java, "database-name"
        ).allowMainThreadQueries().build()
        val itens = db.itemDao().getAll()

        fillList(itens)

        btAddItem.setOnClickListener{
            val intent = Intent(this@ListActivity, AddListItem::class.java)
            startActivity(intent)
        }

        btSortQuant.setOnClickListener {
            sortByQuantity(itens)
        }

        btSortName.setOnClickListener {
            sortByName(itens)
        }
    }

    private fun fillList(itens:List<Item>){
        rvItems.adapter = ItemListAdapter(itens)
    }

    private fun sortByQuantity(itens:List<Item>){
        val sortedItens = itens.sortedBy { it.quantity }
        sortedItens.forEach { Log.v("LIST",it.toString()) }
        fillList(sortedItens)
    }
    private fun sortByName(itens:List<Item>){
        val sortedItens = itens.sortedBy { it.name }
        sortedItens.forEach { Log.v("LIST",it.toString()) }
        fillList(sortedItens)
    }
}