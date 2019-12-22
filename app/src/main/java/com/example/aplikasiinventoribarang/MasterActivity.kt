package com.example.aplikasiinventoribarang

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_master.*

class MasterActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_master)

        TV_Back_Master.setOnClickListener {
            intent = Intent(this, HomeActivity::class.java)
            startActivity(intent)
        }

        Kategori.setOnClickListener {
            intent = Intent(this, KategoriActivity::class.java)
            startActivity(intent)
        }

        Barang.setOnClickListener {
            intent = Intent(this, BarangActivity::class.java)
            startActivity(intent)
        }

        Supplier.setOnClickListener {
            intent = Intent(this, SupplierActivity::class.java)
            startActivity(intent)
        }

        Pelanggan.setOnClickListener {
            intent = Intent(this, PelangganActivity::class.java)
            startActivity(intent)
        }
    }
}
