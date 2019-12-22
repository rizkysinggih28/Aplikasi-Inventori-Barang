package com.example.aplikasiinventoribarang

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_supplier.*
import org.jetbrains.anko.db.classParser
import org.jetbrains.anko.db.select

class SupplierActivity : AppCompatActivity() {

    private lateinit var adapterSupplier: RVAdapterSupplier
    private var supplier = arrayListOf<Supplier>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_supplier)

        adapterSupplier =
            RVAdapterSupplier(this, supplier)
        RV_Supplier.adapter = adapterSupplier

        getData()
        RV_Supplier.layoutManager = LinearLayoutManager(this)

        TV_Back_Supplier.setOnClickListener {
            intent = Intent(this, MasterActivity::class.java)
            startActivity(intent)
        }

        TambahSupplier.setOnClickListener {
            intent = Intent(this, TambahSupplierActivity::class.java)
            startActivity(intent)
        }
    }

    private fun getData() {
        database.use {
            supplier.clear()
            var result = select(Supplier.Supplier)
            var dataSupplier = result.parseList(classParser<Supplier>())
            supplier.addAll(dataSupplier)
            adapterSupplier.notifyDataSetChanged()
        }
    }
}
