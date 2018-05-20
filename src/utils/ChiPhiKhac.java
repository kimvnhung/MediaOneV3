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
public class ChiPhiKhac extends DoiTuong{
    private String tenChiPhi;
    private int soTien;
    private String trenDonVi;

    public ChiPhiKhac(String tenChiPhi, int soTien, String trenDonVi) {
        this.tenChiPhi = tenChiPhi;
        this.soTien = soTien;
        this.trenDonVi = trenDonVi;
    }

    public String getTenChiPhi() {
        return tenChiPhi;
    }

    public void setTenChiPhi(String tenChiPhi) {
        this.tenChiPhi = tenChiPhi;
    }

    public int getSoTien() {
        return soTien;
    }

    public void setSoTien(int soTien) {
        this.soTien = soTien;
    }

    public String getTrenDonVi() {
        return trenDonVi;
    }

    public void setTrenDonVi(String trenDonVi) {
        this.trenDonVi = trenDonVi;
    }
    
    
}
