package com.example.aplikasiinventoribarang

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_transaksi.*

class TransaksiActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_transaksi)

        TV_Back_Transaksi.setOnClickListener {
            intent = Intent(this, HomeActivity::class.java)
            startActivity(intent)
        }
    }
}
