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
import utils.NhanVien;
import utils.NhanVienBanHang;
import utils.NhanVienThuNgan;

/**
 *
 * @author h
 */
public class NhanVienDB {
    private Connection connection;

    public static final String TABLE_NHAN_VIEN = "nhan_vien";
    public static final String COLUMN_NHAN_VIEN_1 = "ten_nv";
    public static final String COLUMN_NHAN_VIEN_2 = "tuoi";
    public static final String COLUMN_NHAN_VIEN_3 = "gioi_tinh";
    public static final String COLUMN_NHAN_VIEN_4 = "dia_chi";
    public static final String COLUMN_NHAN_VIEN_5 = "sdt";
    public static final String COLUMN_NHAN_VIEN_6 = "loai_nhan_vien";
    public static final String COLUMN_NHAN_VIEN_7 = "luong";
    
    public static final String TABLE_ACC = "acc";
    public static final String COLUMN_ACC_1 = "ten_nv";
    public static final String COLUMN_ACC_2 = "username";
    public static final String COLUMN_ACC_3 = "pass";
    
    public NhanVienDB() throws ClassNotFoundException, SQLException {
        this.connection = new DatabaseConnection().getMyConnection();
    }
    
    public void addNhanVien(NhanVien nv) throws SQLException, ClassNotFoundException{
        Statement st = connection.createStatement();
        String insert = "INSERT INTO "+TABLE_NHAN_VIEN + " VALUES (\""
                + nv.getTen()           +"\" , "
                + nv.getTuoi()          +" , "
                + nv.getGioiTinh()      +" , \""
                + nv.getDiaChi()        +"\" , \""
                + nv.getSDT()           +"\" , \""
                + nv.getLoaiNhanVien()  +"\", "
                + nv.getLuong()         +" )";
        int result  = st.executeUpdate(insert);
        if(nv instanceof NhanVienThuNgan){
            AccountDB tbAcc = new AccountDB();
            tbAcc.addAccount(((NhanVienThuNgan) nv).getAccount(),nv.getTen());
        }
    }

    
    public void deleteNhanVien(NhanVien nv) throws SQLException, ClassNotFoundException{
        Statement st = connection.createStatement();
        String delete = "DELETE FROM "+TABLE_NHAN_VIEN +" WHERE "
                + COLUMN_NHAN_VIEN_1 + " = "+nv.getTen();
        int result = st.executeUpdate(delete);
        
        
        if(nv instanceof NhanVienThuNgan){
            AccountDB tbAcc = new AccountDB();
            
            tbAcc.deleteAccount(((NhanVienThuNgan) nv).getTen());
        }
    }

    public void updateNhanVien(NhanVien nv) throws SQLException, ClassNotFoundException{
        Statement st = connection.createStatement();
        String update = "UPDATE "+TABLE_NHAN_VIEN +" SET "
                + COLUMN_NHAN_VIEN_2 + " = "+nv.getTuoi()+", "
                + COLUMN_NHAN_VIEN_3 + " = "+nv.getGioiTinh()+", "
                + COLUMN_NHAN_VIEN_4 + " = \""+nv.getDiaChi()+"\", "
                + COLUMN_NHAN_VIEN_5 + " = \""+nv.getSDT()+"\", "
                + COLUMN_NHAN_VIEN_6 + " = \""+nv.getLoaiNhanVien()+"\", "
                + COLUMN_NHAN_VIEN_7 + " = "+nv.getLuong()+" WHERE "
                + COLUMN_NHAN_VIEN_1 + " = "+nv.getTen();
        int result = st.executeUpdate(update);
        
        if(nv instanceof NhanVienThuNgan ){
            
            AccountDB tbAcc = new AccountDB();
            
            tbAcc.updateAccount(((NhanVienThuNgan) nv).getAccount(), nv.getTen());
        }
    }

    public ArrayList<NhanVien> getListNhanVien() throws SQLException{
        ArrayList<NhanVien> listNhanVien = new ArrayList<>();
        Statement st = connection.createStatement();
        String select = "SELECT * FROM "+TABLE_NHAN_VIEN;
        ResultSet rs = st.executeQuery(select);//kiểu dữ liệu bảng 
        while(rs.next()){
                listNhanVien.add(new NhanVien(rs.getString(1),rs.getInt(2),rs.getInt(3)==1,rs.getString(4),
                    rs.getString(5),rs.getString(6),rs.getInt(7)
            ));        
        }
        
        
        return listNhanVien;
    }
    
    //lấy danh sách nhân viên
    public ArrayList<NhanVienThuNgan> getListNhanVienThuNgan() throws SQLException{
        ArrayList<NhanVienThuNgan> listNhanVienThuNgan = new ArrayList<>();
        Statement st = connection.createStatement();
        String select = "SELECT * FROM "+TABLE_NHAN_VIEN +" INNER JOIN "
                + TABLE_ACC + " ON "+TABLE_NHAN_VIEN +"."+COLUMN_NHAN_VIEN_1+" = "
                + TABLE_ACC +"."+COLUMN_ACC_1;
        ResultSet rs = st.executeQuery(select);
        while(rs.next()){
            listNhanVienThuNgan.add(new NhanVienThuNgan(rs.getString(1),rs.getInt(2),rs.getInt(3)==1,rs.getString(4),rs.getString(5),
                    rs.getString(6),rs.getInt(7),rs.getString(9),rs.getString(10)
            ));
        }
        return listNhanVienThuNgan;
    }
    
    //lấy danh sách nhân viên
    public ArrayList<NhanVienBanHang> getListNhanVienBanHang() throws SQLException{
        ArrayList<NhanVienBanHang> listNhanVienBanHang = new ArrayList<>();
        Statement st = connection.createStatement();
        String select = "SELECT * FROM "+TABLE_NHAN_VIEN +" WHERE " +COLUMN_NHAN_VIEN_1 +" NOT IN ("
                + "SELECT "+COLUMN_ACC_1 +" FROM "+TABLE_ACC
                + ")";
        ResultSet rs = st.executeQuery(select);
        while(rs.next()){
            listNhanVienBanHang.add(new NhanVienBanHang(rs.getString(1),rs.getInt(2),rs.getInt(3)==1,rs.getString(4),rs.getString(5),
                    rs.getString(6),rs.getInt(7)
            ));
        }
        return listNhanVienBanHang;
    }
}