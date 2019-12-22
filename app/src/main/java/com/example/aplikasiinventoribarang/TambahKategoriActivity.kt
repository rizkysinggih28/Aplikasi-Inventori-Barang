package com.example.aplikasiinventoribarang

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_tambah_kategori.*
import org.jetbrains.anko.db.insert
import org.jetbrains.anko.toast

class TambahKategoriActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tambah_kategori)

        TV_Back_TambahKategori.setOnClickListener {
            intent = Intent(this, KategoriActivity::class.java)
            startActivity(intent)
        }

        Btn_Simpan_Kategori.setOnClickListener {
            intent = Intent(this, KategoriActivity::class.java)
            addDataKategori()
            startActivity(intent)
        }
    }

    private fun addDataKategori() {
        database.use {
            insert(
                Kategori.Kategori,
                Kategori.nama_kategori to ET_NamaKategori.text.toString()
            )
            toast("Berhasil Disimpan")
        }
    }
}
