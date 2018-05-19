/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author h
 */
public class DatabaseCreation {
    private final String className = "com.mysql.jdbc.Driver";
    private final String url = "jdbc:mysql://localhost";
    private final String username = "root";
    private final String password = "123456";
    
    String sql = "create database if not exists mediaonev3";
    
    private Connection connToCreate;
    
    public void createDatabase() throws ClassNotFoundException, SQLException {
        Class.forName(className);
        connToCreate = DriverManager.getConnection(url, username, password);
        
        Statement s = connToCreate.createStatement();
        int result = s.executeUpdate(sql);
    }
    
    
        
    
}
