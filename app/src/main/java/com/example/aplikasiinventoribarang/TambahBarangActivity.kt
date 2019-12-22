package com.example.aplikasiinventoribarang

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.aplikasiinventoribarang.R
import kotlinx.android.synthetic.main.activity_tambah_barang.*
import org.jetbrains.anko.db.insert
import org.jetbrains.anko.toast

class TambahBarangActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tambah_barang)

        TV_Back_TambahBarang.setOnClickListener {
            intent = Intent(this, BarangActivity::class.java)
            startActivity(intent)
        }

        Btn_Simpan_Barang.setOnClickListener {
            intent = Intent(this, BarangActivity::class.java)
            addDataSupplier()
            startActivity(intent)
        }
    }

    private fun addDataSupplier() {
        database.use {
            insert(
                Barang.Barang,
                Barang.kategori_barang to arrayOf(SP_KategoriBarang),
                Barang.nama_barang to ET_NamaBarang.text.toString(),
                Barang.stok_barang to ET_StokBarang.text.toString()
            )
            toast("Berhasil Disimpan")
        }
    }
}
