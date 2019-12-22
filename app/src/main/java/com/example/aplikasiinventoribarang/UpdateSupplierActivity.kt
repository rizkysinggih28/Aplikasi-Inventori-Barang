package com.example.aplikasiinventoribarang

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_update_supplier.*
import org.jetbrains.anko.db.update
import org.jetbrains.anko.toast

class UpdateSupplierActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_update_supplier)

        TV_Back_UpdateSupplier.setOnClickListener {
            intent = Intent(this, SupplierActivity::class.java)
            startActivity(intent)
        }

        var oldnama_supplier= intent.getStringExtra("oldnama_supplier")
        var oldalamat_supplier = intent.getStringExtra("oldalamat_supplier")
        var oldno_telp_supplier = intent.getStringExtra("oldno_telp_supplier")

        Btn_Update_Supplier.setOnClickListener {
            database.use {
                update(Supplier.Supplier,
                    Supplier.nama_supplier to ET_NamaSupplier.text.toString(), Supplier.alamat_supplier to ET_AlamatSupplier.text.toString(), Supplier.no_telp_supplier to ET_NoTelpSupplier.text.toString())
                    .whereArgs("${Supplier.nama_supplier} = {nama_supplier}",
                        "nama_supplier" to oldnama_supplier,
                        "alamat_supplier" to oldalamat_supplier,
                        "no_telp_supplier" to oldno_telp_supplier
                    ).exec()
            }
            intent = Intent(this, SupplierActivity::class.java)
            toast("Data Berhasil di Update")
            startActivity(intent)
        }
    }
}
