/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import DoiTuongChinh.Account;
import DoiTuongChinh.ChiPhiKhac;
import DoiTuongChinh.DiaNhac;
import DoiTuongChinh.DiaPhim;
import DoiTuongChinh.HoaDon;
import DoiTuongChinh.NhanVien;
import DoiTuongChinh.NhanVienThuNgan;
import DoiTuongChinh.Sach;
import DoiTuongChinh.SanPham;

/**
 *
 * @author h
 */
public class DatabaseConnection {
    private final String className = "com.mysql.jdbc.Driver";
    private final String url = "jdbc:mysql://localhost/mediaonev3?useSSL=no&useUnicode=true&characterEncoding=UTF-8";
    private final String username = "root";
    private final String password = "123456";
    private final boolean connectable;
    
    
    
    public DatabaseConnection() throws ClassNotFoundException, SQLException{
        connect();
        connectable = true;
    }
    
    private Connection myConnection;
    
    private void connect() throws ClassNotFoundException, SQLException {
        Class.forName(className);
        myConnection = DriverManager.getConnection(url, username, password);
    }
    
    
    public Connection getMyConnection() {
        return myConnection;
    }
    
     //thực thi 1 query bất kì
    public void executeQuery(String query) throws SQLException,Exception{
        Statement st;
        st = myConnection.createStatement();
        int result = st.executeUpdate(query);
    }  
    
    
}
