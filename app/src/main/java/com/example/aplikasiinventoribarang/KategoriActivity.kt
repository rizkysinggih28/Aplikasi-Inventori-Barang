package com.example.aplikasiinventoribarang

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_kategori.*

class KategoriActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_kategori)

        TV_Back_Kategori.setOnClickListener {
            intent = Intent(this, MasterActivity::class.java)
            startActivity(intent)
        }

        TambahKategori.setOnClickListener {
            intent = Intent(this, TambahKategoriActivity::class.java)
            startActivity(intent)
        }
    }
}
