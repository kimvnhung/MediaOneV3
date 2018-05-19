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
public class DiaNhac extends SanPham{
    
    private String nhacSi;
    private String caSi;
    private String albumn;
    private String theLoai;

    public DiaNhac( String ten, String loaiSanPham, String nhacSi, String caSi, String albumn, String theLoai, int soLuong, int giaMua, int giaBan) {
        super(ten, loaiSanPham , soLuong, giaMua, giaBan);
        this.nhacSi = nhacSi;
        this.caSi = caSi;
        this.albumn = albumn;
        this.theLoai = theLoai;
    }

    public void setNhacSi(String nhacSi) {
        this.nhacSi = nhacSi;
    }

    public void setCaSi(String caSi) {
        this.caSi = caSi;
    }

    public void setAlbumn(String albumn) {
        this.albumn = albumn;
    }

    
    
    public String getNhacSi() {
        return nhacSi;
    }

    public String getCaSi() {
        return caSi;
    }

    public String getAlbumn() {
        return albumn;
    }

    
    public String getTheLoai() {
        return theLoai;
    }

    
    public void setTheLoai(String theLoai) {
        this.theLoai = theLoai;
    }
    
    
    
    
    
    
    
    
    
    
}
