package com.example.aplikasiinventoribarang

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_tambah_pelanggan.*
import org.jetbrains.anko.db.insert
import org.jetbrains.anko.toast

class TambahPelangganActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tambah_pelanggan)

        TV_Back_TambahPelanggan.setOnClickListener {
            intent = Intent(this, PelangganActivity::class.java)
            startActivity(intent)
        }

        Btn_Simpan_Pelanggan.setOnClickListener {
            intent = Intent(this, PelangganActivity::class.java)
            addDataPelanggan()
            startActivity(intent)
        }
    }

    private fun addDataPelanggan() {
        database.use {
            insert(
                Pelanggan.Pelanggan,
                Pelanggan.nama_pelanggan to ET_NamaPelanggan.text.toString(),
                Pelanggan.alamat_pelanggan to ET_AlamatPelanggan.text.toString(),
                Pelanggan.no_telp_pelanggan to ET_NoTelpPelanggan.text.toString()
            )
            toast("Berhasil Disimpan")
        }
    }
}
