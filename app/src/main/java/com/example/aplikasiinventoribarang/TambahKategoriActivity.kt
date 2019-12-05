package com.example.aplikasiinventoribarang

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_tambah_kategori.*

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
            startActivity(intent)
        }
    }
}
