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
import DoiTuongChinh.HoaDon;
import DoiTuongChinh.SanPham;

/**
 *
 * @author h
 */
public class HoaDonDB {
    private Connection connection;

    public static final String TABLE_HOA_DON = "hoa_don";
    public static final String COLUMN_HOA_DON_1 = "ma_hd";
    public static final String COLUMN_HOA_DON_2 = "nguoi_ban";
    public static final String COLUMN_HOA_DON_3 = "ngay_ban";
    public static final String COLUMN_HOA_DON_4 = "ten_khach_hang";
    public static final String COLUMN_HOA_DON_5 = "sdt";
    
    public static final String TABLE_CT_HD = "chi_tiet_hd";
    public static final String COLUMN_CT_HD_1 = "ma_hd";
    public static final String COLUMN_CT_HD_2 = "ten_sp";
    public static final String COLUMN_CT_HD_3 = "so_luong";
    
    public static final String TABLE_DS_SP = "ds_san_pham";
    public static final String COLUMN_DS_SP_1 = "ten_sp";
    public static final String COLUMN_DS_SP_2 = "loai_sp";
    public static final String COLUMN_DS_SP_3 = "ton_kho";
    public static final String COLUMN_DS_SP_4 = "gia_mua";
    public static final String COLUMN_DS_SP_5 = "gia_ban";
    
    public HoaDonDB() throws ClassNotFoundException, SQLException {
        this.connection = new DatabaseConnection().getMyConnection();
    }
    
    public void addHoaDon(HoaDon hd) throws SQLException{
        Statement st = connection.createStatement();
        String insert = "INSERT INTO "+TABLE_HOA_DON + " VALUES ( DEFAULT, \""
                + hd.getTenNguoiBan()+"\" , \""
                + hd.getNgayBan()  +"\" , \""
                + hd.getKhachHang().getTenKhachHang()+"\", \""
                + hd.getKhachHang().getSDT() + "\")";
        int result  = st.executeUpdate(insert);
        
        
        for(SanPham x: hd.getListSanPham()){
            insert = "INSERT INTO "+TABLE_CT_HD + " VALUES ("
                    + hd.getMaHoaDon() + " , \""
                    + x.getTen() + "\" , "
                    + x.getSoLuong() + ")";
            result = st.executeUpdate(insert);
        }
        
    }
    
    //hasn't completed
    public void deleteHoaDon(HoaDon hd) throws SQLException{
        Statement st = connection.createStatement();
        String delete = "DELETE FROM "+TABLE_HOA_DON +" WHERE "
                + COLUMN_HOA_DON_1 + " = \""+hd.getMaHoaDon()+"\"";
        st.execute(delete);
    }
    
    public void updateHoaDon(HoaDon hd) throws SQLException{
        Statement st = connection.createStatement();
        String update = "UPDATE "+TABLE_HOA_DON +" SET "
                + COLUMN_HOA_DON_2 + " = \""+hd.getTenNguoiBan()+"\" , "
                + COLUMN_HOA_DON_3 + " = \""+hd.getNgayBan()+"\", "
                + COLUMN_HOA_DON_4 + " = \""+hd.getKhachHang().getTenKhachHang()+"\", "
                + COLUMN_HOA_DON_5 + " = \""+hd.getKhachHang().getSDT()+"\" WHERE "
                + COLUMN_HOA_DON_1 + " = "+hd.getMaHoaDon();
        int result = st.executeUpdate(update);
        for(SanPham x: hd.getListSanPham()){
            update = "UPDATE "+TABLE_CT_HD + " SET "
                    + COLUMN_CT_HD_3 + " = "+x.getSoLuong() +" WHERE "
                    + COLUMN_CT_HD_1 +" = "+hd.getMaHoaDon()+" AND "
                    + COLUMN_CT_HD_2 +" = \""+x.getTen()+"\"";
            result = st.executeUpdate(update);
        }
    }
    
    public ArrayList<HoaDon> getListHoaDon() throws SQLException{
        ArrayList<HoaDon> listHoaDon = new ArrayList<>();
        Statement st = connection.createStatement();
        String select = "SELECT * FROM "+TABLE_HOA_DON;
        ResultSet rs = st.executeQuery(select);//kiểu dữ liệu bảng 
        while(rs.next()){
            
            listHoaDon.add(new HoaDon(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),new ArrayList<>()));
        }
        for(HoaDon x : listHoaDon){
            select = "SELECT * FROM "+TABLE_CT_HD+" INNER JOIN "
                    + TABLE_DS_SP+" ON "
                    + TABLE_CT_HD +"."
                    + COLUMN_CT_HD_2+" = "
                    + TABLE_DS_SP+"."
                    + COLUMN_DS_SP_1 +" WHERE "+TABLE_CT_HD+"."
                    + COLUMN_CT_HD_1+" = "+x.getMaHoaDon();
            ResultSet rs2 = st.executeQuery(select);
            ArrayList<SanPham> listSanPham = new ArrayList<>();
            while(rs2.next()){
                listSanPham.add(new SanPham(rs2.getString(2),rs2.getString(5),rs2.getInt(3),rs2.getInt(7),rs2.getInt(8)));
            }
            x.setListSanPham(listSanPham);
        }
        return listHoaDon;
    }
    
}
