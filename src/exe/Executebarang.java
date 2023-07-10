/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package exe;

import com.barang;
import com.user;
import db.ConnectionManager;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author sendy
 */
public class Executebarang {
    
   public List<barang> getAllbarang() {
        String query = "SELECT * FROM barang";
        ConnectionManager conMan = new ConnectionManager();
        List<barang> lsBarang = new ArrayList<barang>();
        Connection conn = conMan.logOn();
        try {
            Statement stm = conn.createStatement();
            ResultSet rs = stm.executeQuery(query);
            while (rs.next()) {
                String kodebarang = rs.getString("kodebarang");
                String tipebarang = rs.getString("tipebarang");
                String namaBarang = rs.getString("namabarang");
                int harga = rs.getInt("hargabarang");
                int kuantitas = rs.getInt("kuantitas");
                String size = rs.getString("size");
                barang brg = new barang(kodebarang, namaBarang, harga, tipebarang, kuantitas, size);
                lsBarang.add(brg);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ConnectionManager.class.getName()).log(Level.SEVERE, null, ex);
        }
        conMan.logOff();
        return lsBarang;
    }
   
   
   
    public int editBarang(barang brg) {
        int rowsAffected = 0;
        ConnectionManager conMan = new ConnectionManager();
        Connection conn = conMan.logOn();
        try {
            String query = "UPDATE barang SET namabarang = '" + brg.getNamaBarang() + "', kuantitas = " + brg.getKuantitas() + ", tipebarang = '" + brg.getTipebarang() + "', hargabarang = " + brg.getHarga() + ", size = '" + brg.getSize() + "' WHERE kodebarang = '" + brg.getKodebarang() + "'";
            Statement stmt = conn.createStatement();
            rowsAffected = stmt.executeUpdate(query);
        } catch (SQLException ex) {
            Logger.getLogger(ConnectionManager.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            conMan.logOff();
        }
        return rowsAffected;
    }

    public int deleteBarang(String kodebarang) {
        int rowsAffected = 0;
        ConnectionManager conMan = new ConnectionManager();
        Connection conn = conMan.logOn();
        try {
            String query = "DELETE FROM barang WHERE kodebarang = '" + kodebarang + "'";
            Statement stmt = conn.createStatement();
            rowsAffected = stmt.executeUpdate(query);
        } catch (SQLException ex) {
            Logger.getLogger(ConnectionManager.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            conMan.logOff();
        }
        return rowsAffected;
    }

    public int insertBarang(barang brg) {
        int rowsAffected = 0;
        ConnectionManager conMan = new ConnectionManager();
        Connection conn = conMan.logOn();
        try {
            String query = "INSERT INTO barang (kodebarang, namabarang, kuantitas, tipebarang, hargabarang, size) VALUES "
                    + "('" + brg.getKodebarang() + "', '" + brg.getNamaBarang() + "', " + brg.getKuantitas() + ", '" + brg.getTipebarang() + "', " + brg.getHarga() + ", '" + brg.getSize() + "')";
            Statement stmt = conn.createStatement();
            rowsAffected = stmt.executeUpdate(query);
        } catch (SQLException ex) {
            Logger.getLogger(ConnectionManager.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            conMan.logOff();
        }
        return rowsAffected;
    }



   
   
    }

