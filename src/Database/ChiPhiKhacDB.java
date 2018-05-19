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

import utils.ChiPhiKhac;

/**
 *
 * @author h
 */
public class ChiPhiKhacDB {
    private Connection connection;
    
    public static final String TABLE_CPPS = "chi_phi_phat_sinh";
    public static final String COLUMN_CPPS_1 = "ten_chi_phi";
    public static final String COLUMN_CPPS_2 = "so_tien";
    public static final String COLUMN_CPPS_3 = "tren_don_vi";

    public ChiPhiKhacDB() throws ClassNotFoundException, SQLException {
        this.connection = new DatabaseConnection().getMyConnection();
    }
    
    
    public void addChiPhi(ChiPhiKhac cp) throws SQLException{
        Statement st = connection.createStatement();
        String insert = "INSERT INTO "+TABLE_CPPS + " VALUES (\""
                + cp.getTenChiPhi()+"\" , "
                + cp.getSoTien()  +" , \""
                + cp.getTrenDonVi()+"\")";
        int result  = st.executeUpdate(insert);
        
    }
    
    public void deleteChiPhi(ChiPhiKhac cp) throws SQLException{
        Statement st = connection.createStatement();
        String delete = "DELETE FROM "+TABLE_CPPS +" WHERE "
                + COLUMN_CPPS_1 + " = \""+cp.getTenChiPhi()+"\"";
        int result = st.executeUpdate(delete);
    }
    
    public void updateChiPhi(ChiPhiKhac cp) throws SQLException{
        Statement st = connection.createStatement();
        String update = "UPDATE "+TABLE_CPPS +" SET "
                +COLUMN_CPPS_2 + " = "+cp.getSoTien()+" , "
                + COLUMN_CPPS_3 + " = \""+cp.getTrenDonVi()+"\" WHERE "
                + COLUMN_CPPS_1 + " = \""+cp.getTenChiPhi()+"\"";
        int result = st.executeUpdate(update);
    }
    
    public ArrayList<ChiPhiKhac> getListChiPhiKhac() throws SQLException{
        ArrayList<ChiPhiKhac> listChiPhiKhac = new ArrayList<>();
        Statement st = connection.createStatement();
        String select = "SELECT * FROM "+TABLE_CPPS;
        ResultSet rs = st.executeQuery(select);//kiểu dữ liệu bảng 
        while(rs.next()){
            listChiPhiKhac.add(new ChiPhiKhac(rs.getString(1),rs.getInt(2),rs.getString(3)));
        }
        
        return listChiPhiKhac;
    }
    
    
}
