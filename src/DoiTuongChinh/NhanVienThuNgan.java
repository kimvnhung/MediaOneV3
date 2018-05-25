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
public class NhanVienThuNgan extends NhanVien{
    private Account account;

    public NhanVienThuNgan(String ten, int tuoi, boolean gioiTinh, String diaChi, String SDT,String loaiNhanVien, int luong, String username,String password) {
        super(ten,tuoi,gioiTinh,diaChi,SDT,loaiNhanVien,luong);
        this.account = new Account(username,password);
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }
    
    
}
