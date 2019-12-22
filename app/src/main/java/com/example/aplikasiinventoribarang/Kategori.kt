package com.example.aplikasiinventoribarang

data  class Kategori(var id_kategori: Long?, var nama_kategori: String?) {
    companion object {
        const val Kategori: String = "Kategori"
        const val id_kategori: String = "id_kategori"
        const val nama_kategori: String = "nama_kategori"
    }
}