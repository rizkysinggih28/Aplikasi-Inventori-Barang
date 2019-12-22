package com.example.aplikasiinventoribarang

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.item_laporan_pelanggan.view.*

class RVAdapterLaporanPelanggan(val context: Context, val items: ArrayList<Pelanggan>) : RecyclerView.Adapter<RVAdapterLaporanPelanggan.ViewHolder>() {

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        fun bindItem(items: Pelanggan) {
            itemView.TV_Nama_LaporanPelanggan.text = items.nama_pelanggan
            itemView.TV_Alamat_LaporanPelanggan.text = items.alamat_pelanggan
            itemView.TV_NoTelp_LaporanPelanggan.text = items.no_telp_pelanggan
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            LayoutInflater.from(context).inflate(
                R.layout.item_laporan_pelanggan,
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