package com.example.aplikasiinventoribarang

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_kategori.*
import org.jetbrains.anko.db.classParser
import org.jetbrains.anko.db.select

class KategoriActivity : AppCompatActivity() {

    private lateinit var adapterKategori: RVAdapterKategori
    private var kategori = arrayListOf<Kategori>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_kategori)

        adapterKategori =
            RVAdapterKategori(this, kategori)
        RV_Kategori.adapter = adapterKategori

        getData()
        RV_Kategori.layoutManager = LinearLayoutManager(this)

        TV_Back_Kategori.setOnClickListener {
            intent = Intent(this, MasterActivity::class.java)
            startActivity(intent)
        }

        TambahKategori.setOnClickListener {
            intent = Intent(this, TambahKategoriActivity::class.java)
            startActivity(intent)
        }
    }

    private fun getData() {
        database.use {
            kategori.clear()
            var result = select(Kategori.Kategori)
            var dataKategori = result.parseList(classParser<Kategori>())
            kategori.addAll(dataKategori)
            adapterKategori.notifyDataSetChanged()
        }
    }
}
