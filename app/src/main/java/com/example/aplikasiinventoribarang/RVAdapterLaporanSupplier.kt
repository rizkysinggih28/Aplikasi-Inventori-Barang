package com.example.aplikasiinventoribarang

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.item_laporan_supplier.view.*

class RVAdapterLaporanSupplier(val context: Context, val items: ArrayList<Supplier>) : RecyclerView.Adapter<RVAdapterLaporanSupplier.ViewHolder>() {

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        fun bindItem(items: Supplier) {
            itemView.TV_Nama_LaporanSupplier.text = items.nama_supplier
            itemView.TV_Alamat_LaporanSupplier.text = items.alamat_supplier
            itemView.TV_NoTelp_LaporanSupplier.text = items.no_telp_supplier
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            LayoutInflater.from(context).inflate(
                R.layout.item_laporan_supplier,
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