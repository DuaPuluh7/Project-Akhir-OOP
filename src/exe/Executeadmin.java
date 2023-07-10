/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package exe;

import com.admin;
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
public class Executeadmin {
    
    public List<admin> getAllAdmin() {
        String query = "SELECT * FROM admin";
        ConnectionManager conMan = new ConnectionManager();
        List<admin> lsAdmin = new ArrayList<admin>();
        Connection conn = conMan.logOn();
        try {
            Statement stm = conn.createStatement();
            ResultSet rs = stm.executeQuery(query);
            while (rs.next()) {
                String nama = rs.getString("nama");
                String id = rs.getString("id");
                String password = rs.getString("password");
                admin adm = new admin(id, password, nama);
                lsAdmin.add(adm);
            }

        } catch (SQLException ex) {
            Logger.getLogger(ConnectionManager.class.getName()).log(Level.SEVERE, null, ex);
        }
        conMan.logOff();
        return lsAdmin;
    }
    
    
      
    public int hitungJumlahUser() {
        ConnectionManager conMan = new ConnectionManager();
        Connection conn = conMan.logOn();
        int jumlahUser = 0;
        try {
            String query = "SELECT COUNT(*) as total FROM user";
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            if (rs.next()) {
                jumlahUser = rs.getInt("total");
            }
        } catch (SQLException ex) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, null, ex);
        } finally {
            conMan.logOff();
        }
        return jumlahUser;
    }

    
    public int hitungBanyakTransaksi() {
        int jumlahTransaksi = 0;
        ConnectionManager conMan = new ConnectionManager();
        Connection conn = conMan.logOn();
        try {
            String query = "SELECT COUNT(*) AS jumlah FROM transaksi";
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            if (rs.next()) {
                jumlahTransaksi = rs.getInt("jumlah");
            }
        } catch (SQLException ex) {
            Logger.getLogger(ConnectionManager.class.getName()).log(Level.SEVERE, null, ex);
        }
        conMan.logOff();
        return jumlahTransaksi;
    }
    
    public int hitungJumlahBarang() {
        int jumlahBarang = 0;
        ConnectionManager conMan = new ConnectionManager();
        Connection conn = conMan.logOn();
        try {
            String query = "SELECT SUM(kuantitas) AS jumlah FROM barang";
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            if (rs.next()) {
                jumlahBarang = rs.getInt("jumlah");
            }
        } catch (SQLException ex) {
            Logger.getLogger(ConnectionManager.class.getName()).log(Level.SEVERE, null, ex);
        }
        conMan.logOff();
        return jumlahBarang;
    }
    
    
    }

    
