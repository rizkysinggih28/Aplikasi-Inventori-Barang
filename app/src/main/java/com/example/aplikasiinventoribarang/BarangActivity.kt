package com.example.aplikasiinventoribarang

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_barang.*

class BarangActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_barang)

        TV_Back_Barang.setOnClickListener {
            intent = Intent(this, MasterActivity::class.java)
            startActivity(intent)
        }

        TambahBarang.setOnClickListener {
            intent = Intent(this, TambahBarangActivity::class.java)
            startActivity(intent)
        }
    }
}
