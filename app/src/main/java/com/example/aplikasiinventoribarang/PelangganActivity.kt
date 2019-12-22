package com.example.aplikasiinventoribarang

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_pelanggan.*
import org.jetbrains.anko.db.classParser
import org.jetbrains.anko.db.select

class PelangganActivity : AppCompatActivity() {

    private lateinit var adapterPelanggan: RVAdapterPelanggan
    private var pelanggan = arrayListOf<Pelanggan>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pelanggan)

        adapterPelanggan =
            RVAdapterPelanggan(this, pelanggan)
        RV_Pelanggan.adapter = adapterPelanggan

        getData()
        RV_Pelanggan.layoutManager = LinearLayoutManager(this)

        TV_Back_Pelanggan.setOnClickListener {
            intent = Intent(this, MasterActivity::class.java)
            startActivity(intent)
        }

        TambahPelanggan.setOnClickListener {
            intent = Intent(this, TambahPelangganActivity::class.java)
            startActivity(intent)
        }
    }

    private fun getData() {
        database.use {
            pelanggan.clear()
            var result = select(Pelanggan.Pelanggan)
            var dataPelanggan= result.parseList(classParser<Pelanggan>())
            pelanggan.addAll(dataPelanggan)
            adapterPelanggan.notifyDataSetChanged()
        }
    }
}
