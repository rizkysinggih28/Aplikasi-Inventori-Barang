package com.example.aplikasiinventoribarang

data class Barang(var id_barang:Long?, var kategori_barang:String?, var nama_barang:String?, var stok_barang:Long?) {
    companion object{
        const val Barang: String = "Barang"
        const val id_barang: String = "id_barang"
        const val kategori_barang: String = "kategori_barang"
        const val nama_barang: String = "nama_barang"
        const val stok_barang: String = "stok_barang"
    }
}