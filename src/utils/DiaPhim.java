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
public class DiaPhim extends SanPham{
    private String daoDien;
    private String dienVien;
    private String chatLuong;
    private String theLoai;

    public DiaPhim( String ten, String loaiSanPham, String daoDien, String dienVien, String chatLuong,String theLoai, int soLuong, int giaMua, int giaBan) {
        super(ten, loaiSanPham , soLuong, giaMua, giaBan);
        this.daoDien = daoDien;
        this.dienVien = dienVien;
        this.chatLuong = chatLuong;
        this.theLoai = theLoai;
    }

    public String getDaoDien() {
        return daoDien;
    }

    public void setDaoDien(String daoDien) {
        this.daoDien = daoDien;
    }

    public String getDienVien() {
        return dienVien;
    }

    public void setDienVien(String dienVien) {
        this.dienVien = dienVien;
    }

    public String getChatLuong() {
        return chatLuong;
    }

    public void setChatLuong(String chatLuong) {
        this.chatLuong = chatLuong;
    }

   
    public String getTheLoai() {
        return theLoai;
    }

    
    public void setTheLoai(String theLoai) {
        this.theLoai = theLoai;
    }
    
    
    
}
