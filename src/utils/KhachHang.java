/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

import Database.HoaDonDB;
import Database.SanPhamDB;
import Main.HomeFrame;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author h
 */
public class KhachHang {
    private String tenKhachHang;
    private String SDT;

    public KhachHang(String tenKhachHang, String SDT) {
        this.tenKhachHang = tenKhachHang;
        this.SDT = SDT;
    }
    
    public void thanhToan(HoaDon hd) throws ClassNotFoundException, SQLException{
        HomeFrame.cuaHang.getListHoaDon().add(hd);
        
        HoaDonDB soSach = new HoaDonDB();
        soSach.addHoaDon(hd);
        
        ArrayList<SanPham> listSanPham = hd.getListSanPham();
        SanPhamDB kho = new SanPhamDB();
        for(SanPham x: listSanPham){
            SanPham update = kho.getSanPhamByName(x.getTen());
            x.setSoLuong(update.getSoLuong()-x.getSoLuong());
            switch(x.getLoaiSanPham()){
                    case "Đĩa Nhạc":
                        kho.updateSanPham((DiaNhac)x);
                        break;
                    case "Đĩa Phim":
                        kho.updateSanPham((DiaPhim)x);
                        break;
                    default:
                        kho.updateSanPham((Sach)x);
                        break;
                }
            
        }
    }

    public String getTenKhachHang() {
        return tenKhachHang;
    }

    public void setTenKhachHang(String tenKhachHang) {
        this.tenKhachHang = tenKhachHang;
    }

    public String getSDT() {
        return SDT;
    }

    public void setSDT(String SDT) {
        this.SDT = SDT;
    }
    
    
}
