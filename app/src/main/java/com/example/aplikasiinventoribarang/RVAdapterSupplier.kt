package com.example.aplikasiinventoribarang

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.item_list_supplier.view.*
import org.jetbrains.anko.db.delete
import org.jetbrains.anko.startActivity

class RVAdapterSupplier(val context: Context, val items: ArrayList<Supplier>) : RecyclerView.Adapter<RVAdapterSupplier.ViewHolder>() {

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        fun bindItem(items: Supplier) {
            itemView.TV_Nama_Supplier.text = items.nama_supplier
            itemView.TV_Alamat_Supplier.text = items.alamat_supplier
            itemView.TV_NoTelp_Supplier.text = items.no_telp_supplier

            itemView.Update_Supplier.setOnClickListener {
                itemView.context.startActivity<UpdateSupplierActivity>(
                    "oldnama_supplier" to items.nama_supplier,
                    "oldalamat_supplier" to items.alamat_supplier,
                    "oldno_telp_supplier" to items.no_telp_supplier
                )
            }

            itemView.Delete_Supplier.setOnClickListener {
                itemView.context.database.use {
                    delete(Supplier.Supplier, "(${Supplier.nama_supplier} = {nama_supplier})",
                        "nama_supplier" to items.nama_supplier.toString(),
                        "alamat_supplier" to items.alamat_supplier.toString(),
                        "no_telp_supplier" to items.no_telp_supplier.toString())
                    itemView.context.startActivity<SupplierActivity>()
                }
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            LayoutInflater.from(context).inflate(
                R.layout.item_list_supplier,
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