package com.example.aplikasiinventoribarang

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_barang.*
import org.jetbrains.anko.db.classParser
import org.jetbrains.anko.db.select

class BarangActivity : AppCompatActivity() {

    private lateinit var adapterBarang: RVAdapterBarang
    private var barang = arrayListOf<Barang>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_barang)

        adapterBarang =
            RVAdapterBarang(this, barang)
        RV_Barang.adapter = adapterBarang

        getData()
        RV_Barang.layoutManager = LinearLayoutManager(this)

        TV_Back_Barang.setOnClickListener {
            intent = Intent(this, MasterActivity::class.java)
            startActivity(intent)
        }

        TambahBarang.setOnClickListener {
            intent = Intent(this, TambahBarangActivity::class.java)
            startActivity(intent)
        }
    }

    private fun getData() {
        database.use {
            barang.clear()
            var result = select(Barang.Barang)
            var dataBarang= result.parseList(classParser<Barang>())
            barang.addAll(dataBarang)
            adapterBarang.notifyDataSetChanged()
        }
    }
}
