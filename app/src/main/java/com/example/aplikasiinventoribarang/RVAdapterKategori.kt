package com.example.aplikasiinventoribarang

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.item_list_kategori.view.*
import org.jetbrains.anko.db.delete
import org.jetbrains.anko.startActivity

class RVAdapterKategori(val context: Context, val items: ArrayList<Kategori>) : RecyclerView.Adapter<RVAdapterKategori.ViewHolder>() {

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        fun bindItem(items: Kategori) {
            itemView.TV_Nama_Kategori.text = items.nama_kategori

            itemView.Update_Kategori.setOnClickListener {
                itemView.context.startActivity<UpdateKategoriActivity>(
                    "oldnama_kategori" to items.nama_kategori
                )
            }

            itemView.Delete_Kategori.setOnClickListener {
                itemView.context.database.use {
                    delete(Kategori.Kategori, "(${Kategori.nama_kategori} = {nama_kategori})",
                        "nama_kategori" to items.nama_kategori.toString())
                    itemView.context.startActivity<KategoriActivity>()
                }
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            LayoutInflater.from(context).inflate(
                R.layout.item_list_kategori,
                parent,
                false
            )
        )
    }

    override fun getItemCount(): Int = items.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindItem(items[position])
    }
}