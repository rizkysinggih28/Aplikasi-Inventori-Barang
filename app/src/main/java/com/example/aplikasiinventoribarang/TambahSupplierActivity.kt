package com.example.aplikasiinventoribarang

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_tambah_kategori.*
import kotlinx.android.synthetic.main.activity_tambah_supplier.*
import org.jetbrains.anko.db.insert
import org.jetbrains.anko.toast

class TambahSupplierActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tambah_supplier)

        TV_Back_TambahSupplier.setOnClickListener {
            intent = Intent(this, SupplierActivity::class.java)
            startActivity(intent)
        }

        Btn_Simpan_Supplier.setOnClickListener {
            intent = Intent(this, SupplierActivity::class.java)
            addDataSupplier()
            startActivity(intent)
        }
    }

    private fun addDataSupplier() {
        database.use {
            insert(
                Supplier.Supplier,
                Supplier.nama_supplier to ET_NamaSupplier.text.toString(),
                Supplier.alamat_supplier to ET_AlamatSupplier.text.toString(),
                Supplier.no_telp_supplier to ET_NoTelpSupplier.text.toString()
            )
            toast("Berhasil Disimpan")
        }
    }
}
