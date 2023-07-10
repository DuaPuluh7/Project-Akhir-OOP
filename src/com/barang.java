/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com;

/**
 *
 * @author sendy
 */
public class barang {
    private String kodebarang;
    private String namaBarang;
    private int harga;
    private String tipebarang;
    private int kuantitas;
    private String size;

    public barang() {
    }

    public barang(String kodebarang, String namaBarang, int harga, String tipebarang, int kuantitas, String size) {
        this.kodebarang = kodebarang;
        this.namaBarang = namaBarang;
        this.harga = harga;
        this.tipebarang = tipebarang;
        this.kuantitas = kuantitas;
        this.size = size;
    }

    public String getKodebarang() {
        return kodebarang;
    }

    public void setKodebarang(String kodebarang) {
        this.kodebarang = kodebarang;
    }

    public String getNamaBarang() {
        return namaBarang;
    }

    public void setNamaBarang(String namaBarang) {
        this.namaBarang = namaBarang;
    }

    public int getHarga() {
        return harga;
    }

    public void setHarga(int harga) {
        this.harga = harga;
    }

    public String getTipebarang() {
        return tipebarang;
    }

    public void setTipebarang(String tipebarang) {
        this.tipebarang = tipebarang;
    }

    public int getKuantitas() {
        return kuantitas;
    }

    public void setKuantitas(int kuantitas) {
        this.kuantitas = kuantitas;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    @Override
    public String toString() {
        return "barang{" + "kodebarang=" + kodebarang + ", namaBarang=" + namaBarang + ", harga=" + harga + ", tipebarang=" + tipebarang + ", kuantitas=" + kuantitas + ", size=" + size + '}';
    }

    
   
   
    

    

   
    
    

    
    
    
   
    
}
