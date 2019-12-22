package com.example.aplikasiinventoribarang

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_laporan_supplier.*
import org.jetbrains.anko.db.classParser
import org.jetbrains.anko.db.select

class LaporanSupplierActivity : AppCompatActivity() {

    private lateinit var adapterLaporanSupplier: RVAdapterLaporanSupplier
    private var laporansupplier = arrayListOf<Supplier>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_laporan_supplier)

        TV_Back_LaporanSupplier.setOnClickListener {
            intent = Intent(this, LaporanActivity::class.java)
            startActivity(intent)
        }

        adapterLaporanSupplier =
            RVAdapterLaporanSupplier(this, laporansupplier)
        RV_LaporanSupplier.adapter = adapterLaporanSupplier

        getData()
        RV_LaporanSupplier.layoutManager = LinearLayoutManager(this)
    }

    private fun getData() {
        database.use {
            laporansupplier.clear()
            var result = select(Supplier.Supplier)
            var dataLaporanSupplier = result.parseList(classParser<Supplier>())
            laporansupplier.addAll(dataLaporanSupplier)
            adapterLaporanSupplier.notifyDataSetChanged()
        }
    }
}
