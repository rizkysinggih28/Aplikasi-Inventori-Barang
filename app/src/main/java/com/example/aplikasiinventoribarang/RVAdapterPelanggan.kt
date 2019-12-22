package com.example.aplikasiinventoribarang

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.item_list_pelanggan.view.*
import org.jetbrains.anko.db.delete
import org.jetbrains.anko.startActivity

class RVAdapterPelanggan(val context: Context, val items: ArrayList<Pelanggan>) : RecyclerView.Adapter<RVAdapterPelanggan.ViewHolder>() {

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        fun bindItem(items: Pelanggan) {
            itemView.TV_Nama_Pelanggan.text = items.nama_pelanggan
            itemView.TV_Alamat_Pelanggan.text = items.alamat_pelanggan
            itemView.TV_NoTelp_Pelanggan.text = items.no_telp_pelanggan

            itemView.Update_Pelanggan.setOnClickListener {
                itemView.context.startActivity<UpdatePelangganActivity>(
                    "oldnama_pelanggan" to items.nama_pelanggan,
                    "oldalamat_pelanggan" to items.alamat_pelanggan,
                    "oldno_telp_pelanggan" to items.no_telp_pelanggan
                )
            }

            itemView.Delete_Pelanggan.setOnClickListener {
                itemView.context.database.use {
                    delete(Pelanggan.Pelanggan, "(${Pelanggan.nama_pelanggan} = {nama_pelanggan})",
                        "nama_pelanggan" to items.nama_pelanggan.toString(),
                        "alamat_pelanggan" to items.alamat_pelanggan.toString(),
                        "no_telp_pelanggan" to items.no_telp_pelanggan.toString())
                    itemView.context.startActivity<PelangganActivity>()
                }
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            LayoutInflater.from(context).inflate(
                R.layout.item_list_pelanggan,
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