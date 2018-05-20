/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main;

import java.util.ArrayList;

import Database.DatabaseConnection;
import DoanhThu.PanelChiPhiPhatSinh;
import DoanhThu.PanelDoanhThuLoiNhuan;
import QuanLyNhanVien.PanelNhanVienTable;
import QuanLyNhanVien.PanelNvBanHang;
import QuanLyNhanVien.PanelNvThuNgan;
import QuanLyNhanVien.PanelThemNv;
import QuanLySanPham.PanelDsCacLoaiSach;
import QuanLySanPham.PanelDsDiaNhac;
import QuanLySanPham.PanelDsDiaPhim;
import QuanLySanPham.PanelNhapHang;
import ThanhToan.PanelThanhToan;
import com.sun.glass.events.WindowEvent;
import java.awt.Graphics;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import utils.Account;
import utils.ChiPhiKhac;
import utils.CuaHang;
import utils.DiaNhac;
import utils.DiaPhim;
import utils.NhanVien;
import utils.NhanVienThuNgan;
import utils.Sach;

/**
 *
 * @author h
 */
public class HomeFrame extends javax.swing.JFrame {

    public static CuaHang cuaHang;
    public DatabaseConnection myConnection;
    public static String username;
    /**
     * Creates new form HomeFrame
     */
    public HomeFrame(String username) throws ClassNotFoundException, SQLException {
        initComponents();
        
        
        ImageIcon backGround = new ImageIcon("Welcome.png");
        JPanel paneHome = new JPanel(){
            @Override
            protected void paintComponent(Graphics g){
                super.paintComponent(g);
                g.drawImage(backGround.getImage(),0,0,getWidth(),getHeight(),null);
            }
        };
        setContentPane(paneHome);
        
        
        myConnection = new DatabaseConnection();
        cuaHang = new CuaHang();
        this.username = username;
        if(cuaHang.isAdmin(username)){
            menuitThemNhanVien.setEnabled(true);
            menuitDsNvThuNgan.setEnabled(true);
            menuitDsNvBanHang.setEnabled(true);
        }else{
            menuitThemNhanVien.setEnabled(false);
            menuitDsNvThuNgan.setEnabled(false);
            menuitDsNvBanHang.setEnabled(false);
        }
    }
    
    
    
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        paneHome = new javax.swing.JPanel();
        menuBarHomeFrame = new javax.swing.JMenuBar();
        menuQuanLyNhanVien = new javax.swing.JMenu();
        menuitThemNhanVien = new javax.swing.JMenuItem();
        menuitDsNvThuNgan = new javax.swing.JMenuItem();
        menuitDsNvBanHang = new javax.swing.JMenuItem();
        menuItDangXuat = new javax.swing.JMenuItem();
        menuQuanLySp = new javax.swing.JMenu();
        menuitNhapKho = new javax.swing.JMenuItem();
        menuitDsDiaNhac = new javax.swing.JMenuItem();
        menuitDsDiaPhim = new javax.swing.JMenuItem();
        menuitDsCacLoaiSach = new javax.swing.JMenuItem();
        menuThanhToan = new javax.swing.JMenu();
        menuitMauDonThanhToan = new javax.swing.JMenuItem();
        menuDoanhThu = new javax.swing.JMenu();
        menuitChiPhiKhac = new javax.swing.JMenuItem();
        menuitDoanhThuLoiNhuan = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setLocation(new java.awt.Point(300, 50));
        setName("Trang Chủ"); // NOI18N
        setResizable(false);

        javax.swing.GroupLayout paneHomeLayout = new javax.swing.GroupLayout(paneHome);
        paneHome.setLayout(paneHomeLayout);
        paneHomeLayout.setHorizontalGroup(
            paneHomeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 800, Short.MAX_VALUE)
        );
        paneHomeLayout.setVerticalGroup(
            paneHomeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 479, Short.MAX_VALUE)
        );

        menuQuanLyNhanVien.setText("Quản Lý Nhân Viên");

        menuitThemNhanVien.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_1, java.awt.event.InputEvent.ALT_MASK));
        menuitThemNhanVien.setText("Thêm Nhân Viên");
        menuitThemNhanVien.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuitThemNhanVienActionPerformed(evt);
            }
        });
        menuQuanLyNhanVien.add(menuitThemNhanVien);

        menuitDsNvThuNgan.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_Q, java.awt.event.InputEvent.ALT_MASK));
        menuitDsNvThuNgan.setText("Nhân Viên Thu Ngân");
        menuitDsNvThuNgan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuitDsNvThuNganActionPerformed(evt);
            }
        });
        menuQuanLyNhanVien.add(menuitDsNvThuNgan);

        menuitDsNvBanHang.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_A, java.awt.event.InputEvent.ALT_MASK));
        menuitDsNvBanHang.setText("Nhân Viên Bán Hàng");
        menuitDsNvBanHang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuitDsNvBanHangActionPerformed(evt);
            }
        });
        menuQuanLyNhanVien.add(menuitDsNvBanHang);

        menuItDangXuat.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_X, java.awt.event.InputEvent.CTRL_MASK));
        menuItDangXuat.setText("Đăng Xuất");
        menuItDangXuat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItDangXuatActionPerformed(evt);
            }
        });
        menuQuanLyNhanVien.add(menuItDangXuat);

        menuBarHomeFrame.add(menuQuanLyNhanVien);

        menuQuanLySp.setText("Quản Lý Sản Phẩm");

        menuitNhapKho.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_2, java.awt.event.InputEvent.ALT_MASK));
        menuitNhapKho.setText("Nhập Kho");
        menuitNhapKho.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuitNhapKhoActionPerformed(evt);
            }
        });
        menuQuanLySp.add(menuitNhapKho);

        menuitDsDiaNhac.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_W, java.awt.event.InputEvent.ALT_MASK));
        menuitDsDiaNhac.setText("Đĩa Nhạc");
        menuitDsDiaNhac.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuitDsDiaNhacActionPerformed(evt);
            }
        });
        menuQuanLySp.add(menuitDsDiaNhac);

        menuitDsDiaPhim.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_S, java.awt.event.InputEvent.ALT_MASK));
        menuitDsDiaPhim.setText("Đĩa Phim");
        menuitDsDiaPhim.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuitDsDiaPhimActionPerformed(evt);
            }
        });
        menuQuanLySp.add(menuitDsDiaPhim);

        menuitDsCacLoaiSach.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_X, java.awt.event.InputEvent.ALT_MASK));
        menuitDsCacLoaiSach.setText("Các Loại Sách");
        menuitDsCacLoaiSach.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuitDsCacLoaiSachActionPerformed(evt);
            }
        });
        menuQuanLySp.add(menuitDsCacLoaiSach);

        menuBarHomeFrame.add(menuQuanLySp);

        menuThanhToan.setText("Thanh Toán");
        menuThanhToan.setVerifyInputWhenFocusTarget(false);

        menuitMauDonThanhToan.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_3, java.awt.event.InputEvent.ALT_MASK));
        menuitMauDonThanhToan.setText("Mẫu Đơn Thanh Toán ");
        menuitMauDonThanhToan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuitMauDonThanhToanActionPerformed(evt);
            }
        });
        menuThanhToan.add(menuitMauDonThanhToan);

        menuBarHomeFrame.add(menuThanhToan);

        menuDoanhThu.setText("Doanh Thu");

        menuitChiPhiKhac.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_4, java.awt.event.InputEvent.ALT_MASK));
        menuitChiPhiKhac.setText("Chi Phí Phát Sinh");
        menuitChiPhiKhac.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuitChiPhiKhacActionPerformed(evt);
            }
        });
        menuDoanhThu.add(menuitChiPhiKhac);

        menuitDoanhThuLoiNhuan.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_R, java.awt.event.InputEvent.ALT_MASK));
        menuitDoanhThuLoiNhuan.setText("Doanh Thu - Lợi Nhuận");
        menuitDoanhThuLoiNhuan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuitDoanhThuLoiNhuanActionPerformed(evt);
            }
        });
        menuDoanhThu.add(menuitDoanhThuLoiNhuan);

        menuBarHomeFrame.add(menuDoanhThu);

        setJMenuBar(menuBarHomeFrame);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(paneHome, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(paneHome, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void menuitDsNvThuNganActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuitDsNvThuNganActionPerformed
        // TODO add your handling code here:
        this.setContentPane(new PanelNvThuNgan());
        this.invalidate();
        this.validate();
        
    }//GEN-LAST:event_menuitDsNvThuNganActionPerformed

    private void menuitDsNvBanHangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuitDsNvBanHangActionPerformed
        // TODO add your handling code here:
        this.setContentPane(new PanelNvBanHang());
        this.invalidate();
        this.validate();
    }//GEN-LAST:event_menuitDsNvBanHangActionPerformed

    private void menuitThemNhanVienActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuitThemNhanVienActionPerformed
        // TODO add your handling code here:
        this.setContentPane(new PanelThemNv());
        this.invalidate();
        this.validate();
    }//GEN-LAST:event_menuitThemNhanVienActionPerformed

    private void menuitMauDonThanhToanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuitMauDonThanhToanActionPerformed
        // TODO add your handling code here:
        this.setContentPane(new PanelThanhToan());
        this.invalidate();
        this.validate();
    }//GEN-LAST:event_menuitMauDonThanhToanActionPerformed

    private void menuitNhapKhoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuitNhapKhoActionPerformed
        // TODO add your handling code here:
        this.setContentPane(new PanelNhapHang());
        this.invalidate();
        this.validate();
    }//GEN-LAST:event_menuitNhapKhoActionPerformed

    private void menuitDsDiaNhacActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuitDsDiaNhacActionPerformed
        // TODO add your handling code here:
        this.setContentPane(new PanelDsDiaNhac());
        this.invalidate();
        this.validate();
    }//GEN-LAST:event_menuitDsDiaNhacActionPerformed

    private void menuitChiPhiKhacActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuitChiPhiKhacActionPerformed
        // TODO add your handling code here:
        this.setContentPane(new PanelChiPhiPhatSinh());
        this.invalidate();
        this.validate();
    }//GEN-LAST:event_menuitChiPhiKhacActionPerformed

    private void menuitDoanhThuLoiNhuanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuitDoanhThuLoiNhuanActionPerformed
        try {
            // TODO add your handling code here:
            this.setContentPane(new PanelDoanhThuLoiNhuan());
            this.invalidate();
            this.validate();
        } catch (ParseException ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage());
        } catch (CloneNotSupportedException ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage());
        } catch (Exception ex) {
            
        }
        
    }//GEN-LAST:event_menuitDoanhThuLoiNhuanActionPerformed

    private void menuitDsCacLoaiSachActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuitDsCacLoaiSachActionPerformed
        // TODO add your handling code here:
        this.setContentPane(new PanelDsCacLoaiSach());
        this.invalidate();
        this.validate();
    }//GEN-LAST:event_menuitDsCacLoaiSachActionPerformed

    private void menuitDsDiaPhimActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuitDsDiaPhimActionPerformed
        // TODO add your handling code here:
        this.setContentPane(new PanelDsDiaPhim());
        this.invalidate();
        this.validate();
    }//GEN-LAST:event_menuitDsDiaPhimActionPerformed

    private void menuItDangXuatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItDangXuatActionPerformed
        // TODO add your handling code here:
        this.dispose();
        new LoginFrame().setVisible(true);
    }//GEN-LAST:event_menuItDangXuatActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuBar menuBarHomeFrame;
    private javax.swing.JMenu menuDoanhThu;
    private javax.swing.JMenuItem menuItDangXuat;
    private javax.swing.JMenu menuQuanLyNhanVien;
    private javax.swing.JMenu menuQuanLySp;
    private javax.swing.JMenu menuThanhToan;
    private javax.swing.JMenuItem menuitChiPhiKhac;
    private javax.swing.JMenuItem menuitDoanhThuLoiNhuan;
    private javax.swing.JMenuItem menuitDsCacLoaiSach;
    private javax.swing.JMenuItem menuitDsDiaNhac;
    private javax.swing.JMenuItem menuitDsDiaPhim;
    private javax.swing.JMenuItem menuitDsNvBanHang;
    private javax.swing.JMenuItem menuitDsNvThuNgan;
    private javax.swing.JMenuItem menuitMauDonThanhToan;
    private javax.swing.JMenuItem menuitNhapKho;
    private javax.swing.JMenuItem menuitThemNhanVien;
    private javax.swing.JPanel paneHome;
    // End of variables declaration//GEN-END:variables


    public static String getCurrentUser(){
        for(NhanVienThuNgan x: cuaHang.getListNhanVienThuNgan()){
            if(x.getAccount().getUsername().equals(username)){
                return x.getTen();
            }
        }
        return "admin";
    }

}
