package exe;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.user;
import db.ConnectionManager;



/**
 *
 * author sendy
 */

public class Executeuser {
   
    
    
    public List<user> getAlluser() {
        String query = "SELECT * FROM user";
        ConnectionManager conMan = new ConnectionManager();
        List<user> lsUser = new ArrayList<user>();
        Connection conn = conMan.logOn();
        try {
            Statement stm = conn.createStatement();
            ResultSet rs = stm.executeQuery(query);
            while (rs.next()) {
                String nama = rs.getString("nama");
                String email = rs.getString("email");
                String alamat = rs.getString("alamat");
                int umur = rs.getInt("umur");
                String notelepon = rs.getString("notelepon");
                String password = rs.getString("Password");
                user usr = new user(nama, email, umur, alamat, notelepon, password);
                lsUser.add(usr);
            }

        } catch (SQLException ex) {
            Logger.getLogger(ConnectionManager.class.getName()).log(Level.SEVERE, null, ex);
        }
        conMan.logOff();
        return lsUser;
    }
    
    

    public int insertData(user usr) {
         int hasil = 0;
            String query = "INSERT INTO user (nama, email, alamat, notelepon, umur, password) VALUES "
                    + "('" + usr.getNama() + "','" + usr.getEmail() + "','" + usr.getAlamat() + "','" + usr.getNotelepon() + "'," + usr.getUmur() + ",'" + usr.getPassword() + "')";
            ConnectionManager conMan = new ConnectionManager();
            Connection conn = conMan.logOn();
            try {
                Statement stm = conn.createStatement();
                hasil = stm.executeUpdate(query);
            } catch (SQLException ex) {
                Logger.getLogger(ConnectionManager.class.getName()).log(Level.SEVERE, null, ex);
            }
            conMan.logOff();
            return hasil;
    }


    public int deleteData(String delEmail) {
        String query = "DELETE FROM user WHERE email='" + delEmail + "'";
        int hasil = 0;
        ConnectionManager conMan = new ConnectionManager();
        Connection conn = conMan.logOn();
        try {
            Statement stm = conn.createStatement();
            hasil = stm.executeUpdate(query);
        } catch (SQLException ex) {
            Logger.getLogger(ConnectionManager.class.getName()).log(Level.SEVERE, null, ex);
        }
        conMan.logOff();
        return hasil;
    }

    public int editData(user usr) {
        int hasil = 0;
        ConnectionManager conMan = new ConnectionManager();
        Connection conn = conMan.logOn();
        String query = "UPDATE user SET nama='" + usr.getNama() + "', alamat='" + usr.getAlamat() + "', umur=" + usr.getUmur()
                + ", notelepon='" + usr.getNotelepon() + "', password='" + usr.getPassword() + "' WHERE email='" + usr.getEmail() + "'";
        try {
            Statement stm = conn.createStatement();
            hasil = stm.executeUpdate(query);
        } catch (SQLException ex) {
            Logger.getLogger(ConnectionManager.class.getName()).log(Level.SEVERE, null, ex);
        }
        conMan.logOff();
        return hasil;
    
    } 
    
    
  


    
    
}