/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DoiTuongChinh;

/**
 *
 * @author h
 */
public class NhanVien {
    private String ten;
    private int tuoi;
    private boolean gioiTinh; // true là nam, false là nữ
    private String diaChi;
    private String SDT;
    private String loaiNhanVien;
    private int luong;

    public NhanVien(String ten, int tuoi, boolean gioiTinh, 
            String diaChi, String SDT, String loaiNhanVien, int luong) {
        
        this.ten = ten;
        this.tuoi = tuoi;
        this.gioiTinh = gioiTinh;
        this.diaChi = diaChi;
        this.SDT = SDT;
        this.loaiNhanVien = loaiNhanVien;
        this.luong = luong;
    }

    
 
    
    
    
    
    //setter and getter 
    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public int getTuoi() {
        return tuoi;
    }

    public void setTuoi(int tuoi) {
        this.tuoi = tuoi;
    }

    public boolean isGioiTinh() {
        return gioiTinh;
    }

    public int getGioiTinh(){
        if(isGioiTinh()){
            return 1;
        }
        return 0;
    }
    
    public void setGioiTinh(boolean gioiTinh) {
        this.gioiTinh = gioiTinh;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public String getSDT() {
        return SDT;
    }

    public void setSDT(String SDT) {
        this.SDT = SDT;
    }

    public int getLuong() {
        return luong;
    }

    public void setLuong(int luong) {
        this.luong = luong;
    }

    public String getLoaiNhanVien() {
        return loaiNhanVien;
    }

    public void setLoaiNhanVien(String loaiNhanVien) {
        this.loaiNhanVien = loaiNhanVien;
    }
    
}
