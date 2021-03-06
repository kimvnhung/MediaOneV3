/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

import Khac.DateLabelFormatter;
import Database.AccountDB;
import Database.ChiPhiKhacDB;
import Database.HoaDonDB;
import Database.DatabaseConnection;
import Database.NhanVienDB;
import Database.SanPhamDB;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.concurrent.TimeUnit;

/**
 *
 * @author h
 */
public class CuaHang {
    private final String tenCuaHang = "MediaOne";
    
    private String chuCuaHang;
    private ArrayList<NhanVienBanHang> listNhanVienBanHang;
    private ArrayList<NhanVienThuNgan> listNhanVienThuNgan;
    private ArrayList<DiaNhac> listDiaNhac;
    private ArrayList<DiaPhim> listDiaPhim;
    private ArrayList<Sach> listSach;
    private ArrayList<HoaDon> listHoaDon;
    private ArrayList<ChiPhiKhac> listChiPhiKhac;
    

    public CuaHang() throws SQLException, ClassNotFoundException {
        
        updateData();
    }
    
    public void themNhanVien(NhanVien nhanVienMoi) throws SQLException, ClassNotFoundException{
        NhanVienDB db = new NhanVienDB();
        db.addNhanVien(nhanVienMoi);
        
        
        if(nhanVienMoi.getLoaiNhanVien().equals("Nhân Viên Thu Ngân")){
            getListNhanVienThuNgan().add((NhanVienThuNgan) nhanVienMoi);
        }else{
            getListNhanVienBanHang().add((NhanVienBanHang)nhanVienMoi);
        }
    }
    
    public void capNhatttNv(NhanVien nv,int position) throws ClassNotFoundException, SQLException{
        
        
        
        NhanVienDB nvdb = new NhanVienDB();
        
        switch(nv.getLoaiNhanVien()){
            case "Nhân Viên Thu Ngân":
                    this.listNhanVienThuNgan.remove(position);
                    this.listNhanVienThuNgan.add(position, (NhanVienThuNgan) nv);
                    
                    nvdb.updateNhanVien((NhanVienThuNgan)nv);
                break;
            default:
                this.listNhanVienBanHang.remove(position);
                this.listNhanVienBanHang.add(position, (NhanVienBanHang) nv);
                
                nvdb.updateNhanVien(nv);
                break;
        }
    }
    
    public void thoiViec(int position, String loaiNv) throws ClassNotFoundException, SQLException{
        NhanVienDB nvdb = new NhanVienDB();
        
        switch(loaiNv){
            case "Nhân Viên Thu Ngân":
                nvdb.deleteNhanVien(this.listNhanVienThuNgan.get(position));
                
                getListNhanVienThuNgan().remove(position);
                break;
            default:
                nvdb.deleteNhanVien(this.listNhanVienBanHang.get(position));
                
                getListNhanVienBanHang().remove(position);
                break;
        }
    }
    
    public void nhapKhoHang(String typeProduct) throws ClassNotFoundException, SQLException{
        SanPhamDB kho = new SanPhamDB();
        
        switch(typeProduct){
            case "Đĩa Nhạc":
                int size1 = this.listDiaNhac.size();
                kho.addSanPham(this.listDiaNhac.get(size1-1));
                break;
            case "Đĩa Phim":
                int size2 = this.listDiaPhim.size();
                kho.addSanPham(this.listDiaPhim.get(size2-1));
                break;
            default:
                int size3 = this.listSach.size();
                kho.addSanPham(this.listSach.get(size3-1));
                break;
        }
    }
    
    public void xuatKhoHang(SanPham sp,int position) throws ClassNotFoundException, SQLException{
        switch(sp.getLoaiSanPham()){
            case "Đĩa Nhạc":
                this.listDiaNhac.remove(position);
                this.listDiaNhac.add(position, (DiaNhac) sp);
                break;
            case "Đĩa Phim":
                this.listDiaPhim.remove(position);
                this.listDiaPhim.add(position, (DiaPhim) sp);
                break;
            default:
                this.listSach.remove(position);
                this.listSach.add(position, (Sach) sp);
                break;
        }
        
        SanPhamDB kho = new SanPhamDB();
        kho.updateSanPham(sp);
    }
    
    public void loaiBoMatHang(SanPham sp) throws  ClassNotFoundException, SQLException{
        SanPhamDB kho = new SanPhamDB();
        
        kho.deleteSanPham(sp);
        
    }
    
    public void capNhatChiPhi(ArrayList<Integer> pos,String keyWord) throws ClassNotFoundException, SQLException{
        ChiPhiKhacDB soSach = new ChiPhiKhacDB();
        switch(keyWord){
            case "insert":
                for(int x:pos){
                    soSach.addChiPhi(listChiPhiKhac.get(x));
                }
                
                break;
            case "update":
                for(int x:pos){
                    soSach.updateChiPhi(listChiPhiKhac.get(x));
                }
                break;
            default:
                for(int x:pos){
                    soSach.deleteChiPhi(listChiPhiKhac.get(x));
                }
                for(int x:pos){
                    listChiPhiKhac.remove(x);
                }
                break;
        }
    }
    
    public ArrayList<SanPham> getDanhSachSanPhamDaBan(long fromTime,long toTime) throws ParseException, CloneNotSupportedException, Exception{
        if(fromTime > toTime){
            throw new Exception("Thời gian không hợp lệ");
        }else{
            ArrayList<HoaDon> hdInTime = new ArrayList<>();
        
            for(HoaDon x:listHoaDon){
                hdInTime.add((HoaDon) x.clone());
            }

            for(int i = 0; i < hdInTime.size(); i++){
                String ngayBan = hdInTime.get(i).getNgayBan();
                long toComp = new DateLabelFormatter(ngayBan).getMiliSeconds();
                if(toComp < fromTime || toComp > toTime){
                    hdInTime.remove(i);
                    i--;
                }
            }

            ArrayList<SanPham> listSanPham = new ArrayList<>();
            for(DiaNhac x: listDiaNhac){
                listSanPham.add((DiaNhac) x.clone());
            }
            for(DiaPhim x: listDiaPhim){
                listSanPham.add((DiaPhim) x.clone());
            }
            for(Sach x:listSach){
                listSanPham.add((Sach) x.clone());
            }

            for(int i = 0; i < listSanPham.size(); i++){
                listSanPham.get(i).setSoLuong(0);
                for(int j = 0; j < hdInTime.size(); j++){
                    ArrayList<SanPham> para = new ArrayList<>(hdInTime.get(j).getListSanPham());
                    for(int k = 0; k < para.size(); k++){
                        SanPham sp = para.get(k);
                        if(sp.getTen().equals(listSanPham.get(i).getTen())){
                            listSanPham.get(i).setSoLuong(listSanPham.get(i).getSoLuong()+sp.getSoLuong());
                        }
                    }
                }
            }

            return listSanPham;
        }
    }
    
    public ArrayList<ChiPhiKhac> getDanhSachChiPhi(long fromTime,long toTime) throws CloneNotSupportedException, Exception{
        if(fromTime > toTime){
            throw new Exception("Thời gian không hợp lệ!");
        }else{
            ArrayList<ChiPhiKhac> listChiPhi = new ArrayList<>();
        
            for(ChiPhiKhac x: this.listChiPhiKhac){
                listChiPhi.add((ChiPhiKhac) x.clone());
            }


            Date from = new Date(fromTime);
            Date to = new Date(toTime);


            int hour = (int) TimeUnit.HOURS.convert(toTime - fromTime, TimeUnit.MILLISECONDS);
            int day = (int) TimeUnit.DAYS.convert(toTime - fromTime, TimeUnit.MILLISECONDS);
            int month = (to.getYear() - from.getYear())*12+(to.getMonth() - from.getMonth());
            int numYear = to.getYear() - from.getYear();

            ChiPhiKhac tienLuong = new ChiPhiKhac("Tiền Lương Nhân Viên",0,"Tháng");
            for(NhanVienBanHang x: listNhanVienBanHang){
                tienLuong.setSoTien(tienLuong.getSoTien()+x.getLuong());
            }
            for(NhanVienThuNgan y: listNhanVienThuNgan){
                tienLuong.setSoTien(tienLuong.getSoTien()+y.getLuong());
            }

            listChiPhi.add(tienLuong);

            int soTien = 0;
            for(ChiPhiKhac x:listChiPhi){

                switch(x.getTrenDonVi()){
                    case "None":
                        soTien = x.getSoTien();
                        break;
                    case "Giờ":
                        soTien = x.getSoTien()*hour;
                        break;
                    case "Ngày":
                        soTien = x.getSoTien()*day;
                        break;
                    default:
                        soTien = x.getSoTien()*month;
                        break;
                }

                x.setSoTien(soTien);

            }


            return listChiPhi;
        }
    }
    
    public int thongKeDoanhThu(long fromTime,long toTime) throws ParseException, CloneNotSupportedException, Exception{
        int result = 0;
        ArrayList<SanPham> sanPhamDaBan = getDanhSachSanPhamDaBan(fromTime,toTime);
        
        for(SanPham x: sanPhamDaBan){
            result += x.getSoLuong()*x.getGiaBan();
        }
        
        return result;
    }
    
    public int thongKeLoiNhuan(long fromTime,long toTime) throws ParseException, CloneNotSupportedException, Exception{
        int doanhThu = thongKeDoanhThu(fromTime,toTime);
        
        int tongChiPhi = 0;
        for(ChiPhiKhac x: getDanhSachChiPhi(fromTime,toTime)){
            tongChiPhi += x.getSoTien();
        }
        
        int loiNhuan = doanhThu - tongChiPhi;
        
        return loiNhuan;
        
    }
    
    public boolean isAdmin(String username){
        if(username.equals(chuCuaHang)){
            return true;
        }
        
        return false;
    }

    
    
    public void updateData() throws SQLException, ClassNotFoundException{
        this.setChuCuaHang(new AccountDB().getListAdminAccount().get(0).getUsername());
        this.setListNhanVienBanHang(new NhanVienDB().getListNhanVienBanHang());
        this.setListNhanVienThuNgan(new NhanVienDB().getListNhanVienThuNgan());
        this.setListDiaNhac(new SanPhamDB().getListDiaNhac());
        this.setListDiaPhim(new SanPhamDB().getListDiaPhim());
        this.setListSach(new SanPhamDB().getListSach());
        this.setListHoaDon(new HoaDonDB().getListHoaDon());
        this.setListChiPhiKhac(new ChiPhiKhacDB().getListChiPhiKhac());
        
        
    }
    
    
    //setter and getter
    
    public String getTenCuaHang() {
        return tenCuaHang;
    }

    public String getChuCuaHang() {
        return chuCuaHang;
    }

    public ArrayList<NhanVienBanHang> getListNhanVienBanHang() {
        return listNhanVienBanHang;
    }

    public ArrayList<DiaNhac> getListDiaNhac() {
        return listDiaNhac;
    }

    public ArrayList<DiaPhim> getListDiaPhim() {
        return listDiaPhim;
    }

    public ArrayList<Sach> getListSach() {
        return listSach;
    }

    public ArrayList<ChiPhiKhac> getListChiPhiKhac() {
        return listChiPhiKhac;
    }

    public ArrayList<NhanVienThuNgan> getListNhanVienThuNgan() {
        return listNhanVienThuNgan;
    }

    public void setListNhanVienThuNgan(ArrayList<NhanVienThuNgan> listNhanVienThuNgan) {
        this.listNhanVienThuNgan = listNhanVienThuNgan;
    }

    public void setChuCuaHang(String chuCuaHang) {
        this.chuCuaHang = chuCuaHang;
    }

    public void setListNhanVienBanHang(ArrayList<NhanVienBanHang> listNhanVienBanHang) {
        this.listNhanVienBanHang = listNhanVienBanHang;
    }

    public void setListDiaNhac(ArrayList<DiaNhac> listDiaNhac) {
        this.listDiaNhac = listDiaNhac;
    }

    public void setListDiaPhim(ArrayList<DiaPhim> listDiaPhim) {
        this.listDiaPhim = listDiaPhim;
    }

    public void setListSach(ArrayList<Sach> listSach) {
        this.listSach = listSach;
    }

    public void setListChiPhiKhac(ArrayList<ChiPhiKhac> listChiPhiKhac) {
        this.listChiPhiKhac = listChiPhiKhac;
    }

    public ArrayList<HoaDon> getListHoaDon() {
        return listHoaDon;
    }

    public void setListHoaDon(ArrayList<HoaDon> listHoaDon) {
        this.listHoaDon = listHoaDon;
    }
    
    
    
}
