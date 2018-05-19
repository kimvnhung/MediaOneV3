/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

/**
 *
 * @author h
 */
public class SanPham extends DoiTuong{ 
    private String ten;
    private String loaiMatHang;
    
    private int soLuong;
    private int giaMua;
    private int giaBan;

    public SanPham(String ten, String loaiMatHang, int soLuong, int giaMua, int giaBan) {
        this.ten = ten;
        this.loaiMatHang = loaiMatHang;
        this.soLuong = soLuong;
        this.giaMua = giaMua;
        this.giaBan = giaBan;
    }

    public SanPham() {
        
    }

    public String getLoaiSanPham() {
        return loaiMatHang;
    }

    public void setLoaiMatHang(String loaiMatHang) {
        this.loaiMatHang = loaiMatHang;
    }

    
    
    
    public void setTen(String ten) {
        this.ten = ten;
    }

    

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    public void setGiaBan(int giaBan) {
        this.giaBan = giaBan;
    }

    
    
    public String getTen() {
        return ten;
    }

    

    public int getSoLuong() {
        return soLuong;
    }

    public int getGiaMua() {
        return giaMua;
    }

    public int getGiaBan() {
        return giaBan;
    }
}
