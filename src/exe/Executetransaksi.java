package exe;

import com.Transaksi;
import db.ConnectionManager;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.sql.PreparedStatement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JComboBox;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author sendy
 * 
 * 
 * 
 */


      

public class Executetransaksi {
        public List<Transaksi> getAlltransaksi(String email) {
        List<Transaksi> transaksiList = new ArrayList<>();

        try {
            ConnectionManager conMan = new ConnectionManager();
            Connection conn = conMan.logOn();

            String query = "SELECT * FROM transaksi WHERE email = ?";
            PreparedStatement pstmt = conn.prepareStatement(query);
            pstmt.setString(1, email);

            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                Transaksi transaksi = new Transaksi();
                transaksi.setNopemesanan(rs.getString("nopemesanan"));
                transaksi.setKodebarang(rs.getString("kodebarang"));
                transaksi.setNamabarang(rs.getString("namabarang"));
                transaksi.setSize(rs.getString("size"));
                transaksi.setTipebarang(rs.getString("tipebarang"));
                transaksi.setTanggal(rs.getString("tanggal"));
                transaksi.setHargabarang(rs.getInt("hargabarang"));
                transaksi.setJumlah(rs.getInt("jumlah"));
                transaksi.setTotalharga(rs.getInt("totalharga"));
                transaksiList.add(transaksi);
            }

            conMan.logOff();
        } catch (SQLException ex) {
            Logger.getLogger(ConnectionManager.class.getName()).log(Level.SEVERE, null, ex);
        }

        return transaksiList;
    }

    
    
    
    public int getKuantitasBarangFromDatabase(String kodeBarang) {
        int kuantitas = 0;

        // Mendapatkan koneksi ke database
        ConnectionManager conMan = new ConnectionManager();
        Connection conn = conMan.logOn();

        try {
            // Menyiapkan query untuk mendapatkan kuantitas barang berdasarkan kode barang
            String query = "SELECT kuantitas FROM barang WHERE kodebarang = ?";
            PreparedStatement pstmt = conn.prepareStatement(query);
            pstmt.setString(1, kodeBarang);

            // Menjalankan query dan mendapatkan hasil
            ResultSet rs = pstmt.executeQuery();

            // Mengambil nilai kuantitas dari hasil query
            if (rs.next()) {
                kuantitas = rs.getInt("kuantitas");
            }

            // Lakukan operasi atau tindakan lain dengan nilai kuantitas di sini
            // Contoh: cetak nilai kuantitas
            System.out.println("Kuantitas Barang: " + kuantitas);
        } catch (SQLException ex) {
            Logger.getLogger(ConnectionManager.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            // Menutup koneksi ke database
            conMan.logOff();
        }
        return kuantitas;
    }
    
    
    public void kurangiKuantitasBarang(String kodeBarang, int jumlahBeli) {
        ConnectionManager conMan = new ConnectionManager();
        Connection conn = conMan.logOn();
        try {
            String updateQuery = "UPDATE barang SET kuantitas = kuantitas - ? WHERE kodebarang = ?";
            PreparedStatement updateStmt = conn.prepareStatement(updateQuery);
            updateStmt.setString(1, kodeBarang);
            updateStmt.setInt(2, jumlahBeli);
            

            updateStmt.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ConnectionManager.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            conMan.logOff();
        }
    }
    
    public boolean lakukanPembelian(String kodeBarang, int jumlahBeli, int totalHarga, String namaBarang, String tipebarang, int hargaBarang, String dbEmail1, JComboBox t_Size) {
        ConnectionManager conMan = new ConnectionManager();
        Connection conn = conMan.logOn();
        boolean pembelianBerhasil = false;
        try {
            // Mengurangi kuantitas barang dalam tabel
            String updateQuery = "UPDATE barang SET kuantitas = kuantitas - ? WHERE kodebarang = ?";
            PreparedStatement updateStmt = conn.prepareStatement(updateQuery);
            updateStmt.setInt(1, jumlahBeli);
            updateStmt.setString(2, kodeBarang);
            int rowsAffected = updateStmt.executeUpdate();

            if (rowsAffected > 0) {
                // Jika jumlah baris yang terpengaruh lebih dari 0, artinya pembelian berhasil
                pembelianBerhasil = true;

                // Mendapatkan tanggal saat ini
                java.util.Date tanggalPembelian = new java.util.Date();
                String size = t_Size.getSelectedItem().toString();

                // Melakukan penyimpanan data pembelian ke tabel transaksi
                String insertQuery = "INSERT INTO transaksi (kodebarang, jumlah, totalharga, namabarang, tanggal, tipebarang, hargabarang, size, email) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
                PreparedStatement insertStmt = conn.prepareStatement(insertQuery);
                insertStmt.setString(1, kodeBarang);
                insertStmt.setInt(2, jumlahBeli);
                insertStmt.setInt(3, totalHarga);
                insertStmt.setString(4, namaBarang);
                insertStmt.setDate(5, new java.sql.Date(tanggalPembelian.getTime()));
                insertStmt.setString(6, tipebarang);
                insertStmt.setInt(7, hargaBarang);
                insertStmt.setString(8, size);
                insertStmt.setString(9, dbEmail1); // Menggunakan dbEmail1 sebagai nilai email
                insertStmt.executeUpdate();
            }
        } catch (SQLException ex) {
            Logger.getLogger(ConnectionManager.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            conMan.logOff();
        }
        return pembelianBerhasil;
    }
    
    
    
    

}

 
