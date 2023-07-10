/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com;

/**
 *
 * @author sendy
 */
public class user {
    private String nama;
    private String email;
    private int umur;
    private String alamat;
    private String notelepon;
    private String password;

    public user() {
    }

    public user(String nama, String email, int umur, String alamat, String notelepon, String password) {
        this(nama, email, alamat, notelepon, umur, password);
    }

    public user(String nama, String email, String alamat, String notelepon, int umur, String password) {
        this.nama = nama;
        this.email = email;
        this.umur = umur;
        this.alamat = alamat;
        this.notelepon = notelepon;
        this.password = password;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getUmur() {
        return umur;
    }

    public void setUmur(int umur) {
        this.umur = umur;
    }

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    public String getNotelepon() {
        return notelepon;
    }

    public void setNotelepon(String notelepon) {
        this.notelepon = notelepon;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "user{" + "nama=" + nama + ", email=" + email + ", umur=" + umur + ", alamat=" + alamat + ", notelepon=" + notelepon + ", password=" + password + '}';
    }
    
    
}
