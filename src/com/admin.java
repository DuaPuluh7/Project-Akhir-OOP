/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com;

/**
 *
 * @author sendy
 */
public class admin {
    private String id;
    private String password;
    private String nama;

    public admin() {
    }

    public admin(String id, String password, String nama) {
        this.id = id;
        this.password = password;
        this.nama = nama;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    @Override
    public String toString() {
        return "admin{" + "id=" + id + ", password=" + password + ", nama=" + nama + '}';
    }
    
    
}
