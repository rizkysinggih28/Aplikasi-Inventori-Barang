package com.example.aplikasiinventoribarang

data class Pelanggan(var id_pelanggan: Long?, var nama_pelanggan: String?, var alamat_pelanggan: String?, var no_telp_pelanggan:String?) {
    companion object {
        const val Pelanggan: String = "Pelanggan"
        const val id_pelanggan: String = "id_pelanggan"
        const val nama_pelanggan: String = "nama_pelanggan"
        const val alamat_pelanggan: String = "alamat_pelanggan"
        const val no_telp_pelanggan: String = "no_telp_pelanggan"
    }
}