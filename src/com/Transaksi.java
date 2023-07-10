/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com;

import javax.swing.JOptionPane;

/**
 *
 * @author sendy
 */
public class Transaksi {
    private String kodebarang;
    private String namabarang;
    private int totalharga;
    private int jumlah;
    private String nopemesanan;
    private String tanggal;
    private String tipebarang;
    private int hargabarang;
    private String size;

    public Transaksi() {
    }

    public Transaksi(String kodebarang, String namabarang, int totalharga, int jumlah, String nopemesanan, String tanggal, String tipebarang, int hargabarang, String size) {
        this.kodebarang = kodebarang;
        this.namabarang = namabarang;
        this.totalharga = totalharga;
        this.jumlah = jumlah;
        this.nopemesanan = nopemesanan;
        this.tanggal = tanggal;
        this.tipebarang = tipebarang;
        this.hargabarang = hargabarang;
        this.size = size;
    }

    public String getKodebarang() {
        return kodebarang;
    }

    public void setKodebarang(String kodebarang) {
        this.kodebarang = kodebarang;
    }

    public String getNamabarang() {
        return namabarang;
    }

    public void setNamabarang(String namabarang) {
        this.namabarang = namabarang;
    }

    public int getTotalharga() {
        return totalharga;
    }

    public void setTotalharga(int totalharga) {
        this.totalharga = totalharga;
    }

    public int getJumlah() {
        return jumlah;
    }

    public void setJumlah(int jumlah) {
        this.jumlah = jumlah;
    }

    public String getNopemesanan() {
        return nopemesanan;
    }

    public void setNopemesanan(String nopemesanan) {
        this.nopemesanan = nopemesanan;
    }

    public String getTanggal() {
        return tanggal;
    }

    public void setTanggal(String tanggal) {
        this.tanggal = tanggal;
    }

    public String getTipebarang() {
        return tipebarang;
    }

    public void setTipebarang(String tipebarang) {
        this.tipebarang = tipebarang;
    }

    public int getHargabarang() {
        return hargabarang;
    }

    public void setHargabarang(int hargabarang) {
        this.hargabarang = hargabarang;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }
    
    public int hitungTotalHarga(int hargaBarang, int jumlahBeli) {
        return hargaBarang * jumlahBeli;
    }
    
    public int hitungTotalHarga(String kodeVoucher, int totalHarga) {
        int hargaSetelahDiskon = totalHarga;

        if (kodeVoucher.equalsIgnoreCase("Farhan")) {
            hargaSetelahDiskon = (int) (totalHarga * 0.1); // Diskon 90%
        } else if (kodeVoucher.equalsIgnoreCase("OOP")) {
            hargaSetelahDiskon = (int) (totalHarga * 0.2); // Diskon 80%
        }

        return hargaSetelahDiskon;
    }

    @Override
    public String toString() {
        return "Transaksi{" + "kodebarang=" + kodebarang + ", namabarang=" + namabarang + ", totalharga=" + totalharga + ", jumlah=" + jumlah + ", nopemesanan=" + nopemesanan + ", tanggal=" + tanggal + ", tipebarang=" + tipebarang + ", hargabarang=" + hargabarang + ", size=" + size + '}';
    }
    
    
    
    
}