package com.example.aplikasiinventoribarang

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import org.jetbrains.anko.db.*

class DatabaseHelper (context: Context) : ManagedSQLiteOpenHelper(context,"dbInventoriBarang", null, 1) {

    companion object {
        private var instance: DatabaseHelper? = null
        @Synchronized

        fun getInstance(context: Context) : DatabaseHelper {
            if (instance == null) {
                instance =
                    DatabaseHelper(
                        context.applicationContext
                    )
            }
            return instance as DatabaseHelper
        }
    }

    override fun onCreate(db: SQLiteDatabase?) {
        db?.execSQL("create table User(nama varchar(30), email varchar(30) primary key, password varchar(30))")
        db?.createTable(
            Kategori.Kategori, true,
            Kategori.id_kategori to INTEGER + PRIMARY_KEY + AUTOINCREMENT,
            Kategori.nama_kategori to TEXT
        )
        db?.createTable(
            Supplier.Supplier, true,
            Supplier.id_supplier to INTEGER + PRIMARY_KEY + AUTOINCREMENT,
            Supplier.nama_supplier to TEXT,
            Supplier.alamat_supplier to TEXT,
            Supplier.no_telp_supplier to TEXT
        )
        db?.createTable(
            Pelanggan.Pelanggan, true,
            Pelanggan.id_pelanggan to INTEGER + PRIMARY_KEY + AUTOINCREMENT,
            Pelanggan.nama_pelanggan to TEXT,
            Pelanggan.alamat_pelanggan to TEXT,
            Pelanggan.no_telp_pelanggan to TEXT
        )
        db?.createTable(
            Barang.Barang, true,
            Barang.id_barang to INTEGER + PRIMARY_KEY + AUTOINCREMENT,
            Barang.kategori_barang to TEXT,
            Barang.nama_barang to TEXT,
            Barang.stok_barang to INTEGER
        )
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        db?.dropTable(Kategori.Kategori, true)
        db?.dropTable(Supplier.Supplier, true)
        db?.dropTable(Barang.Barang, true)
    }

    fun insertUser(nama: String, email: String, password: String) {
        val db: SQLiteDatabase = writableDatabase
        val values: ContentValues = ContentValues()
        values.put("nama", nama)
        values.put("email", email)
        values.put("password", password)

        db.insert("User", null, values)
        db.close()
    }

    fun insertKategori(nama_kategori: String) {
        val db: SQLiteDatabase = writableDatabase
        val values: ContentValues = ContentValues()
        values.put("nama_kategori", nama_kategori)

        db.insert("Kategori", null, values)
        db.close()
    }

    fun insertSupplier(nama_supplier: String, alamat_supplier: String, no_telp_supplier: String) {
        val db: SQLiteDatabase = writableDatabase
        val values: ContentValues = ContentValues()
        values.put("nama_supplier", nama_supplier)
        values.put("alamat_supplier", alamat_supplier)
        values.put("no_telp_supplier", no_telp_supplier)

        db.insert("Supplier", null, values)
        db.close()
    }

    fun insertPelanggan(nama_pelanggan: String, alamat_pelanggan: String, no_telp_pelanggan: String) {
        val db: SQLiteDatabase = writableDatabase
        val values: ContentValues = ContentValues()
        values.put("nama_pelanggan", nama_pelanggan)
        values.put("alamat_pelanggan", alamat_pelanggan)
        values.put("no_telp_pelanggan", no_telp_pelanggan)
    }

    fun insertBarang(kategori_barang: String, nama_barang: String, stok_barang: String) {
        val db: SQLiteDatabase = writableDatabase
        val values: ContentValues = ContentValues()
        values.put("kategori_barang", kategori_barang)
        values.put("nama_barang", nama_barang)
        values.put("stok_barang", stok_barang)
    }

    fun userPresent(email: String, password: String) : Boolean {
        val db = writableDatabase
        val query = "select * from User where email = '$email' and password = '$password'"
        val cursor = db.rawQuery(query, null)
        if (cursor.count <= 0) {
            cursor.close()
            return false
        }
        cursor.close()
        return true
    }
}

val Context.database : DatabaseHelper
get() = DatabaseHelper.getInstance(
    applicationContext
)
