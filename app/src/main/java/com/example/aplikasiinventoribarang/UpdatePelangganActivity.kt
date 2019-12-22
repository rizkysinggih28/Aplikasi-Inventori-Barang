package com.example.aplikasiinventoribarang

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_update_pelanggan.*
import org.jetbrains.anko.db.update
import org.jetbrains.anko.toast

class UpdatePelangganActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_update_pelanggan)

        TV_Back_UpdatePelanggan.setOnClickListener {
            intent = Intent(this, PelangganActivity::class.java)
            startActivity(intent)
        }

        var oldnama_pelanggan= intent.getStringExtra("oldnama_pelanggan")
        var oldalamat_pelanggan= intent.getStringExtra("oldalamat_pelanggan")
        var oldno_telp_pelanggan = intent.getStringExtra("oldno_telp_pelanggan")

        Btn_Update_Pelanggan.setOnClickListener {
            database.use {
                update(Pelanggan.Pelanggan,
                    Pelanggan.nama_pelanggan to ET_NamaPelanggan.text.toString(), Pelanggan.alamat_pelanggan to ET_AlamatPelanggan.text.toString(), Pelanggan.no_telp_pelanggan to ET_NoTelpPelanggan.text.toString())
                    .whereArgs("${Pelanggan.nama_pelanggan} = {nama_pelanggan}",
                        "nama_pelanggan" to oldnama_pelanggan,
                        "alamat_pelanggan" to oldalamat_pelanggan,
                        "no_telp_pelanggan" to oldno_telp_pelanggan
                    ).exec()
            }
            intent = Intent(this, PelangganActivity::class.java)
            toast("Data Berhasil di Update")
            startActivity(intent)
        }
    }
}
