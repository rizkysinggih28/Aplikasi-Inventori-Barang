package com.example.aplikasiinventoribarang

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.aplikasiinventoribarang.R
import kotlinx.android.synthetic.main.activity_update_kategori.*
import org.jetbrains.anko.db.update
import org.jetbrains.anko.toast

class UpdateKategoriActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_update_kategori)

        TV_Back_UpdateKategori.setOnClickListener {
            intent = Intent(this, KategoriActivity::class.java)
            startActivity(intent)
        }

        var oldnama_kategori = intent.getStringExtra("oldnama_kategori")

        Btn_Update_Kategori.setOnClickListener {
            database.use {
                update(Kategori.Kategori,
                    Kategori.nama_kategori to ET_NamaKategori.text.toString())
                    .whereArgs("${Kategori.nama_kategori} = {nama_kategori}",
                        "nama_kategori" to oldnama_kategori
                    ).exec()
            }
            intent = Intent(this, KategoriActivity::class.java)
            toast("Data Berhasil di Update")
            startActivity(intent)
        }
    }
}
