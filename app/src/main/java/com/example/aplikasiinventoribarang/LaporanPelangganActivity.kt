package com.example.aplikasiinventoribarang

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_laporan_pelanggan.*
import org.jetbrains.anko.db.classParser
import org.jetbrains.anko.db.select

class LaporanPelangganActivity : AppCompatActivity() {

    private lateinit var adapterLaporanPelanggan: RVAdapterLaporanPelanggan
    private var laporanpelanggan = arrayListOf<Pelanggan>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_laporan_pelanggan)

        TV_Back_LaporanPelanggan.setOnClickListener {
            intent = Intent(this, LaporanActivity::class.java)
            startActivity(intent)
        }

        adapterLaporanPelanggan =
            RVAdapterLaporanPelanggan(this, laporanpelanggan)
        RV_LaporanPelanggan.adapter = adapterLaporanPelanggan

        getData()
        RV_LaporanPelanggan.layoutManager = LinearLayoutManager(this)
    }

    private fun getData() {
        database.use {
            laporanpelanggan.clear()
            var result = select(Pelanggan.Pelanggan)
            var dataLaporanPelanggan = result.parseList(classParser<Pelanggan>())
            laporanpelanggan.addAll(dataLaporanPelanggan)
            adapterLaporanPelanggan.notifyDataSetChanged()
        }
    }
}
