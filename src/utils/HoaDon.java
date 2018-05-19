/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

import java.util.ArrayList;

/**
 *
 * @author h
 */
public class HoaDon extends DoiTuong{
    private int maHoaDon;
    private String tenNguoiBan;
    private String ngayBan;
    private KhachHang khachHang;
    private ArrayList<SanPham> listSanPham;

    public HoaDon(int maHoaDon, String tenNguoiBan, String ngayBan, String tenKhachHang, String SDTKhachHang, ArrayList<SanPham> listSanPham) {
        this.maHoaDon = maHoaDon;
        this.tenNguoiBan = tenNguoiBan;
        this.ngayBan = ngayBan;
        this.khachHang = new KhachHang(tenKhachHang,SDTKhachHang);
        this.listSanPham = listSanPham;
    }

    

    

    public int getTongSoTien(){
        int tongSoTien = 0;
        for(SanPham x:listSanPham){
            tongSoTien += x.getGiaBan()*x.getSoLuong();
        }
        return tongSoTien;
    }
    
    public int getTongSoLuong(){
        int tongSoLuong = 0;
        for(SanPham x: listSanPham){
            tongSoLuong += x.getSoLuong();
        }
        return tongSoLuong;
    }
    
    //setter and getter
    public int getMaHoaDon() {
        return maHoaDon;
    }

    public void setMaHoaDon(int maHoaDon) {
        this.maHoaDon = maHoaDon;
    }

    public String getTenNguoiBan() {
        return tenNguoiBan;
    }

    public void setTenNguoiBan(String tenNguoiBan) {
        this.tenNguoiBan = tenNguoiBan;
    }

    public String getNgayBan() {
        return ngayBan;
    }

    public void setNgayBan(String ngayBan) {
        this.ngayBan = ngayBan;
    }


    public ArrayList<SanPham> getListSanPham() {
        return listSanPham;
    }

    public void setListSanPham(ArrayList<SanPham> listSanPham) {
        this.listSanPham = listSanPham;
    }

    public KhachHang getKhachHang() {
        return khachHang;
    }

    public void setKhachHang(KhachHang khachHang) {
        this.khachHang = khachHang;
    }

    
    
    
    
    
}
