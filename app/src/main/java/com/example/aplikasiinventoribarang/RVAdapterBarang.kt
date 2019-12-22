package com.example.aplikasiinventoribarang

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.item_list_barang.view.*

class RVAdapterBarang(val context: Context, val items: ArrayList<Barang>) : RecyclerView.Adapter<RVAdapterBarang.ViewHolder>() {

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        fun bindItem(items: Barang) {
            itemView.TV_Kategori_Barang.text = items.kategori_barang
            itemView.TV_Nama_Barang.text = items.nama_barang
            itemView.TV_Stok_Barang.text = items.stok_barang.toString()
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            LayoutInflater.from(context).inflate(
                R.layout.item_list_barang,
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