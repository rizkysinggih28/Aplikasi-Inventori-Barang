package com.example.aplikasiinventoribarang

data  class Supplier(var id_supplier: Long?, var nama_supplier: String?, var alamat_supplier: String?, var no_telp_supplier:String?) {
    companion object {
        const val Supplier: String = "Supplier"
        const val id_supplier: String = "id_supplier"
        const val nama_supplier: String = "nama_supplier"
        const val alamat_supplier: String = "alamat_supplier"
        const val no_telp_supplier: String = "no_telp_supplier"
    }
}