/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Database;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import utils.Account;

/**
 *
 * @author h
 */
public class AccountDB {
    private Connection connection;
    
    public static final String TABLE_ACC = "acc";
    public static final String COLUMN_ACC_1 = "ten_nv";
    public static final String COLUMN_ACC_2 = "username";
    public static final String COLUMN_ACC_3 = "pass";

    public static final String TABLE_ADMIN_ACC = "admin_acc";
    public static final String COLUMN_ADMIN_ACC_1 = "username";
    public static final String COLUMN_ADMIN_ACC_2 = "pass";
    
    public AccountDB() throws ClassNotFoundException, SQLException {
        this.connection = new DatabaseConnection().getMyConnection();
    }
    
    public void addAminAcount(Account acc)throws SQLException{
        Statement st = connection.createStatement();
        String insert = "INSERT INTO "+TABLE_ADMIN_ACC + " VALUES (\""
                + acc.getUsername()+"\" , \""
                + acc.getPassword()+"\")";
        int result  = st.executeUpdate(insert);
        
    }
    
    public void addAccount(Account acc,String tenNv) throws SQLException{
        Statement st = connection.createStatement();
        String insert = "INSERT INTO "+TABLE_ACC + " VALUES (\""
                + tenNv+"\" , \""
                + acc.getUsername()+"\" , \""
                + acc.getPassword()+"\")";
        int result  = st.executeUpdate(insert);
        
    }
    
    public void deleteAccount(String tenNv) throws SQLException{
        Statement st = connection.createStatement();
        String delete = "DELETE FROM "+TABLE_ACC +" WHERE "
                + COLUMN_ACC_1 + " = "+tenNv;
        int result = st.executeUpdate(delete);
    }
    
    public void updateAccount(Account acc,String tenNv) throws SQLException{
        Statement st = connection.createStatement();
        String update = "UPDATE "+TABLE_ACC +" SET "
                +COLUMN_ACC_2 + " = \""+acc.getUsername()+"\", \""
                + COLUMN_ACC_3 + " = \""+acc.getPassword()+"\" WHERE "
                + COLUMN_ACC_1 + " = "+tenNv;
        int result = st.executeUpdate(update);
    }
    
    public ArrayList<Account> getListAccount() throws SQLException{
        ArrayList<Account> listAccount = new ArrayList<>();
        Statement st = connection.createStatement();
        String select = "SELECT * FROM "+TABLE_ACC;
        ResultSet rs = st.executeQuery(select);//kiểu dữ liệu bảng 
        while(rs.next()){
            listAccount.add(new Account(rs.getString(2),rs.getString(3)));
        }
        
        return listAccount;
    }
    
    public ArrayList<Account> getListAdminAccount() throws SQLException{
        ArrayList<Account> listAccount = new ArrayList<>();
        Statement st = connection.createStatement();
        String select = "SELECT * FROM "+TABLE_ADMIN_ACC;
        ResultSet rs = st.executeQuery(select);//kiểu dữ liệu bảng 
        while(rs.next()){
            listAccount.add(new Account(rs.getString(1),rs.getString(2)));
        }
        
        return listAccount;
    }
    
    public int getCountOfAccTable() throws SQLException{
        Statement st = connection.createStatement();
        String select = "SELECT count(*) FROM " + TABLE_ACC;
        int count = 0;
        ResultSet result = st.executeQuery(select);
        result.first();
        count = result.getInt(1);
        result.close();
        
        return count;
    }
}
