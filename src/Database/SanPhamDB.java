package Database;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import utils.Account;
import utils.DiaNhac;
import utils.DiaPhim;
import utils.Sach;
import utils.SanPham;

public class SanPhamDB {
    private Connection connection;
    public static final String TABLE_DS_SP = "ds_san_pham";
    public static final String COLUMN_DS_SP_1 = "ten_sp";
    public static final String COLUMN_DS_SP_2 = "loai_sp";
    public static final String COLUMN_DS_SP_3 = "ton_kho";
    public static final String COLUMN_DS_SP_4 = "gia_mua";
    public static final String COLUMN_DS_SP_5 = "gia_ban";

    public static final String TABLE_CT_SP = "chi_tiet_sp";
    public static final String COLUMN_CT_SP_1 = "ten_sp";
    public static final String COLUMN_CT_SP_2 = "ref1";
    public static final String COLUMN_CT_SP_3 = "ref2";
    public static final String COLUMN_CT_SP_4 = "ref3";
    public static final String COLUMN_CT_SP_5 = "the_loai";

    public SanPhamDB() throws ClassNotFoundException, SQLException {
        this.connection = new DatabaseConnection().getMyConnection();
    }

    public void addSanPham(SanPham sp) throws SQLException{
        Statement st = connection.createStatement();
        String insert = "INSERT INTO "+TABLE_DS_SP + " VALUES (\""
                + sp.getTen()         +"\" , \""
                + sp.getLoaiSanPham()  +"\" , "
                + sp.getSoLuong()      +" , "
                + sp.getGiaMua()       +" , "
                + sp.getGiaBan()       +")";
        int result  = st.executeUpdate(insert);
        switch(sp.getLoaiSanPham()){
            case "Đĩa Nhạc":
                DiaNhac diaNhac = (DiaNhac)sp;
                insert = "INSERT INTO "+TABLE_CT_SP + " VALUES (\""
                + diaNhac.getTen()   +"\", \""
                + diaNhac.getNhacSi()  +"\" , \""
                + diaNhac.getCaSi()    +"\" , \""
                + diaNhac.getAlbumn()  +"\" , \""
                + diaNhac.getTheLoai() +"\")";
                
                result = st.executeUpdate(insert);
                break;
            case "Đĩa Phim":
                DiaPhim diaPhim = (DiaPhim)sp;
                insert = "INSERT INTO "+TABLE_CT_SP + " VALUES (\""
                + diaPhim.getTen()   +"\", \""
                + diaPhim.getDaoDien()  +"\" , \""
                + diaPhim.getDienVien()    +"\" , \""
                + diaPhim.getChatLuong()+"\" , \""
                + diaPhim.getTheLoai() +"\")";
         
                result = st.executeUpdate(insert);
                break;
            default:
                Sach sach = (Sach)sp;
                insert = "INSERT INTO "+TABLE_CT_SP + " VALUES (\""
                + sach.getTen()   +"\", \""
                + sach.getTacGia()  +"\" , \""
                + sach.getNxb()    +"\" , \""
                + sach.getNgonNgu()  +"\" , \""
                + sach.getTheLoai() +"\")";
                
                result = st.executeUpdate(insert);
                break;
        }
    }

    public void deleteSanPham(SanPham sp) throws SQLException{
        Statement st = connection.createStatement();
        String delete = "DELETE FROM "+TABLE_DS_SP +" WHERE "
                + COLUMN_DS_SP_1 + " = \""+sp.getTen()+"\"";
        int result = st.executeUpdate(delete);
        
        
        delete = "DELETE FROM "+TABLE_CT_SP +" WHERE "
                + COLUMN_CT_SP_1 + " = \""+sp.getTen()+"\"";
        result = st.executeUpdate(delete);
    }

    public void updateSanPham(SanPham sp) throws SQLException{
        Statement st = connection.createStatement();
        String update = "UPDATE "+TABLE_DS_SP +" SET "
                + COLUMN_DS_SP_2 + " = \""+sp.getLoaiSanPham()+"\", "
                + COLUMN_DS_SP_3 + " = "+sp.getSoLuong()+", "
                + COLUMN_DS_SP_4 + " = "+sp.getGiaMua()+", "
                + COLUMN_DS_SP_5 + " = "+sp.getGiaBan()+" WHERE "
                + COLUMN_DS_SP_1 + " = \""+sp.getTen()+"\"";
        int result = st.executeUpdate(update);
        
        switch(sp.getLoaiSanPham()){
            case "Đĩa Nhạc":
                update = "UPDATE "+TABLE_CT_SP + " SET "
                + COLUMN_CT_SP_2 + " = \""+((DiaNhac)sp).getNhacSi()+"\", "
                + COLUMN_CT_SP_3 + " = \""+((DiaNhac)sp).getCaSi()+"\", "
                + COLUMN_CT_SP_4 + " = \""+((DiaNhac)sp).getAlbumn()+"\" ,"
                + COLUMN_CT_SP_5 + " = \""+((DiaNhac)sp).getTheLoai()+"\" WHERE "
                + COLUMN_CT_SP_1 + " = \""+((DiaNhac)sp).getTen()+"\"";
                
                result = st.executeUpdate(update);
                break;
            case "Đĩa Phim":
                update = "UPDATE "+TABLE_CT_SP + " SET "
                + COLUMN_CT_SP_2 + " = \""+((DiaPhim)sp).getDaoDien()+"\", "
                + COLUMN_CT_SP_3 + " = \""+((DiaPhim)sp).getDienVien()+"\", "
                + COLUMN_CT_SP_4 + " = \""+((DiaPhim)sp).getChatLuong()+"\" ,"
                + COLUMN_CT_SP_5 + " = \""+((DiaPhim)sp).getTheLoai() +"\" WHERE "
                + COLUMN_CT_SP_1 + " = \""+((DiaPhim)sp).getTen()+"\"";
                
                result = st.executeUpdate(update);
                break;
            default:
                update = "UPDATE "+TABLE_CT_SP + " SET "
                + COLUMN_CT_SP_2 + " = \""+((Sach)sp).getTacGia()+"\", "
                + COLUMN_CT_SP_3 + " = \""+((Sach)sp).getNxb()+"\", "
                + COLUMN_CT_SP_4 + " = \""+((Sach)sp).getNgonNgu()+"\" ,"
                + COLUMN_CT_SP_5 + " = \""+((Sach)sp).getTheLoai() +"\" WHERE "
                + COLUMN_CT_SP_1 + " = \""+((Sach)sp).getTen()+"\"";
                
                result = st.executeUpdate(update);
                break;
        }
    }

    public ArrayList<SanPham> getListSanPham() throws SQLException{
        ArrayList<SanPham> listSanPham = new ArrayList<>();
        Statement st = connection.createStatement();
        String select = "SELECT * FROM "+TABLE_DS_SP;
        ResultSet rs = st.executeQuery(select);//kiểu dữ liệu bảng 
        while(rs.next()){
            listSanPham.add(new SanPham(rs.getString(1),rs.getString(2),rs.getInt(3),rs.getInt(4),rs.getInt(5)));
        }
        
        
        return listSanPham;
    }
    
    public ArrayList<DiaNhac> getListDiaNhac() throws SQLException{
        ArrayList<DiaNhac> listSanPham = new ArrayList<>();
        Statement st = connection.createStatement();
        String select = "SELECT * FROM "+TABLE_DS_SP + " INNER JOIN "+TABLE_CT_SP+" ON "
                + TABLE_DS_SP+"."+COLUMN_DS_SP_1+" = "+TABLE_CT_SP +"."+COLUMN_CT_SP_1+" WHERE "
                + COLUMN_DS_SP_2+" = \"Đĩa Nhạc\"";
        ResultSet rs = st.executeQuery(select);//kiểu dữ liệu bảng 
        while(rs.next()){
            listSanPham.add(new DiaNhac(rs.getString(1),rs.getString(2),rs.getString(7),rs.getString(8),
                    rs.getString(9),rs.getString(10),rs.getInt(3),rs.getInt(4),rs.getInt(5)));
        }
        
        
        return listSanPham;
    }
    
    public ArrayList<DiaPhim> getListDiaPhim() throws SQLException{
        ArrayList<DiaPhim> listSanPham = new ArrayList<>();
        Statement st = connection.createStatement();
        String select = "SELECT * FROM "+TABLE_DS_SP + " INNER JOIN "+TABLE_CT_SP+" ON "
                + TABLE_DS_SP+"."+COLUMN_DS_SP_1+" = "+TABLE_CT_SP +"."+COLUMN_CT_SP_1+" WHERE "
                + COLUMN_DS_SP_2+" = \"Đĩa Phim\"";
        ResultSet rs = st.executeQuery(select);//kiểu dữ liệu bảng 
        while(rs.next()){
            listSanPham.add(new DiaPhim(rs.getString(1),rs.getString(2),rs.getString(7),rs.getString(8),
                    rs.getString(9),rs.getString(10),rs.getInt(3),rs.getInt(4),rs.getInt(5)));
        }
        
        
        return listSanPham;
    }
    
    public ArrayList<Sach> getListSach() throws SQLException{
        ArrayList<Sach> listSanPham = new ArrayList<>();
        Statement st = connection.createStatement();
        String select = "SELECT * FROM "+TABLE_DS_SP + " INNER JOIN "+TABLE_CT_SP+" ON "
                + TABLE_DS_SP+"."+COLUMN_DS_SP_1+" = "+TABLE_CT_SP +"."+COLUMN_CT_SP_1+" WHERE "
                + COLUMN_DS_SP_2+" = \"Các Loại Sách\"";
        ResultSet rs = st.executeQuery(select);//kiểu dữ liệu bảng 
        while(rs.next()){
            listSanPham.add(new Sach(rs.getString(1),rs.getString(2),rs.getString(7),rs.getString(8),
                    rs.getString(9),rs.getString(10),rs.getInt(3),rs.getInt(4),rs.getInt(5)));
        }
        
        
        return listSanPham;
    }
    
    public SanPham getSanPhamByName(String name) throws SQLException{
        Statement st = connection.createStatement();
        String select = "SELECT * FROM "+TABLE_DS_SP+" WHERE "
                + COLUMN_DS_SP_1+" = \""+name+"\"";
        ResultSet rs = st.executeQuery(select);
        rs.first();
        
        return new SanPham(rs.getString(2),rs.getString(3),rs.getInt(4),rs.getInt(5),rs.getInt(6));
    }
}
