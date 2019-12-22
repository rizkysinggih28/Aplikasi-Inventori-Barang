package com.example.aplikasiinventoribarang

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_laporan.*
import kotlinx.android.synthetic.main.activity_laporan_supplier.*

class LaporanActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_laporan)

        TV_Back_Laporan.setOnClickListener {
            intent = Intent(this, HomeActivity::class.java)
            startActivity(intent)
        }

        Btn_LaporanSupplier.setOnClickListener {
            intent = Intent(this, LaporanSupplierActivity::class.java)
            startActivity(intent)
        }

        Btn_LaporanPelanggan.setOnClickListener {
            intent = Intent(this, LaporanPelangganActivity::class.java)
            startActivity(intent)
        }
    }
}
