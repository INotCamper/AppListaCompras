package com.morschgartner.nac2semestre.adapter

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.LinearLayout
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import androidx.room.Room
import com.morschgartner.nac2semestre.R
import com.morschgartner.nac2semestre.database.AppDatabase
import com.morschgartner.nac2semestre.database.Item
import com.morschgartner.nac2semestre.model.ListItem

class ItemListAdapter(private val itens:List<Item>) : RecyclerView.Adapter<ItemListAdapter.ItemListViewHolder>() {

    class ItemListViewHolder(private val view: View) : RecyclerView.ViewHolder(view){
        private val tvName by lazy{
            view.findViewById<TextView>(R.id.tvName)
        }
        private val tvQuantity by lazy{
            view.findViewById<TextView>(R.id.tvQuantity)
        }
        private val  llItem by lazy{
            view.findViewById<LinearLayout>(R.id.llItem)
        }
        private  val tvNotes by lazy {
            view.findViewById<TextView>(R.id.tvNotes)
        }
        private val btDelete by lazy{
            view.findViewById<Button>(R.id.btDelete)
        }

        fun bind(itemLista: Item, darkerBG: Boolean){
            Log.v("ADAPTER", itemLista.name + itemLista.quantity)
            tvName.text = itemLista.name
            tvQuantity.text = (itemLista.quantity.toString() + " x")

            if (itemLista.notes.isNotBlank() || itemLista.notes.isNotEmpty()) {
                tvNotes.visibility = View.VISIBLE
                tvNotes.text = itemLista.notes
            }
            else {
                tvNotes.visibility = View.GONE
            }

            if (darkerBG)
                llItem.setBackgroundColor(ContextCompat.getColor(view.context, R.color.draculaBackGround))
            else{
                llItem.setBackgroundColor(ContextCompat.getColor(view.context, R.color.draculaPrimary))
            }
            btDelete.setOnClickListener {
                val db = Room.databaseBuilder(
                    view.context,
                    AppDatabase::class.java, "database-name"
                ).allowMainThreadQueries().build()

                db.itemDao().delete(itemLista)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemListViewHolder {
        Log.v("ADAPTER", "Inflater criado")
        val inflater = LayoutInflater.from(parent.context)
        val view = inflater.inflate(R.layout.item_list, parent, false)
        return ItemListViewHolder(view)
    }

    override fun onBindViewHolder(holder: ItemListViewHolder, position: Int) {
        Log.v("ADAPTER", "Item bindado")
        holder.bind(itens[position], position%2 == 0)
    }

    override fun getItemCount(): Int {
        Log.v("ADAPTER", "Itens a ser criados" + itens.size.toString())
        return itens.size
    }
}