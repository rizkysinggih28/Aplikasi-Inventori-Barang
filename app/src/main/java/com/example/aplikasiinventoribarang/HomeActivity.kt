package com.example.aplikasiinventoribarang

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_home.*

class HomeActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        TV_Back_Home.setOnClickListener {
            intent = Intent(this, LogInActivity::class.java)
            startActivity(intent)
        }

        Master.setOnClickListener {
            intent = Intent(this, MasterActivity::class.java)
            startActivity(intent)
        }

        Transaksi.setOnClickListener {
            intent = Intent(this, TransaksiActivity::class.java)
            startActivity(intent)
        }

        Laporan.setOnClickListener {
            intent = Intent(this, LaporanActivity::class.java)
            startActivity(intent)
        }

        About.setOnClickListener {
            intent = Intent(this, AboutActivity::class.java)
            startActivity(intent)
        }
    }
}
