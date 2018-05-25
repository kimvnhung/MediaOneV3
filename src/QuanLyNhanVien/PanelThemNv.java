/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package QuanLyNhanVien;

import Main.HomeFrame;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SpringLayout;
import DoiTuongChinh.Account;
import DoiTuongChinh.NhanVien;
import DoiTuongChinh.NhanVienBanHang;
import DoiTuongChinh.NhanVienThuNgan;

/**
 *
 * @author h
 */
public class PanelThemNv extends javax.swing.JPanel {

    /**
     * Creates new form ThemNv
     */
    public PanelThemNv() {
        initComponents();
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lbThemNvTitile = new javax.swing.JLabel();
        PanelLv2 = new javax.swing.JPanel();
        lbTenThemNv = new javax.swing.JLabel();
        lbTuoiThemNv = new javax.swing.JLabel();
        lbGioiTinhThemNv = new javax.swing.JLabel();
        lbDiaChiThemNv = new javax.swing.JLabel();
        lbSDTThemNv = new javax.swing.JLabel();
        lbLoaiNvThemNV = new javax.swing.JLabel();
        lbLuongThemNv = new javax.swing.JLabel();
        txtfTenThemNv = new javax.swing.JTextField();
        txtfLuongThemNv = new javax.swing.JTextField();
        txtfTuoiThemNv = new javax.swing.JTextField();
        cbNamThemNv = new javax.swing.JCheckBox();
        cbNuThemNv = new javax.swing.JCheckBox();
        txtfDiaChiThemNv = new javax.swing.JTextField();
        txtfSDTThemNv = new javax.swing.JTextField();
        lbDonviLuongThemNv = new javax.swing.JLabel();
        comBLoaiNhanVienThemNv = new javax.swing.JComboBox<>();
        paneParentUserPassThemNv = new javax.swing.JPanel();
        paneUserPassThemNv = new javax.swing.JPanel();
        lbUsernameThemNv = new javax.swing.JLabel();
        lbPasswordThemNv = new javax.swing.JLabel();
        txtfUsernameThemNv = new javax.swing.JTextField();
        txtfPasswordThemNv = new javax.swing.JTextField();
        btThem = new javax.swing.JButton();

        setPreferredSize(new java.awt.Dimension(800, 500));

        lbThemNvTitile.setText("Thêm Nhân Viên");
        add(lbThemNvTitile);

        lbTenThemNv.setText("Tên");

        lbTuoiThemNv.setText("Tuổi");

        lbGioiTinhThemNv.setText("Giới tính");

        lbDiaChiThemNv.setText("Địa chỉ");

        lbSDTThemNv.setText("SĐT");

        lbLoaiNvThemNV.setText("Loại nhân viên");

        lbLuongThemNv.setText("Lương");

        txtfTenThemNv.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtfTenThemNvFocusGained(evt);
            }
        });

        txtfLuongThemNv.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtfLuongThemNvFocusGained(evt);
            }
        });

        txtfTuoiThemNv.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtfTuoiThemNvFocusGained(evt);
            }
        });

        cbNamThemNv.setSelected(true);
        cbNamThemNv.setText("Nam");
        cbNamThemNv.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbNamThemNvItemStateChanged(evt);
            }
        });

        cbNuThemNv.setText("Nữ");
        cbNuThemNv.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbNuThemNvItemStateChanged(evt);
            }
        });

        txtfSDTThemNv.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtfSDTThemNvFocusGained(evt);
            }
        });

        lbDonviLuongThemNv.setText("VND/tháng");

        comBLoaiNhanVienThemNv.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Nhân Viên Thu Ngân", "Nhân Viên Bán Hàng" }));
        comBLoaiNhanVienThemNv.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comBLoaiNhanVienThemNvActionPerformed(evt);
            }
        });

        paneParentUserPassThemNv.setMinimumSize(new java.awt.Dimension(371, 362));

        lbUsernameThemNv.setText("Username");

        lbPasswordThemNv.setText("Password");

        txtfUsernameThemNv.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtfUsernameThemNvFocusGained(evt);
            }
        });

        javax.swing.GroupLayout paneUserPassThemNvLayout = new javax.swing.GroupLayout(paneUserPassThemNv);
        paneUserPassThemNv.setLayout(paneUserPassThemNvLayout);
        paneUserPassThemNvLayout.setHorizontalGroup(
            paneUserPassThemNvLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(paneUserPassThemNvLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(paneUserPassThemNvLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbUsernameThemNv)
                    .addComponent(lbPasswordThemNv))
                .addGap(52, 52, 52)
                .addGroup(paneUserPassThemNvLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtfUsernameThemNv, javax.swing.GroupLayout.DEFAULT_SIZE, 175, Short.MAX_VALUE)
                    .addComponent(txtfPasswordThemNv))
                .addContainerGap())
        );
        paneUserPassThemNvLayout.setVerticalGroup(
            paneUserPassThemNvLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(paneUserPassThemNvLayout.createSequentialGroup()
                .addGap(94, 94, 94)
                .addGroup(paneUserPassThemNvLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbUsernameThemNv)
                    .addComponent(txtfUsernameThemNv, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27)
                .addGroup(paneUserPassThemNvLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbPasswordThemNv)
                    .addComponent(txtfPasswordThemNv, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout paneParentUserPassThemNvLayout = new javax.swing.GroupLayout(paneParentUserPassThemNv);
        paneParentUserPassThemNv.setLayout(paneParentUserPassThemNvLayout);
        paneParentUserPassThemNvLayout.setHorizontalGroup(
            paneParentUserPassThemNvLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, paneParentUserPassThemNvLayout.createSequentialGroup()
                .addContainerGap(66, Short.MAX_VALUE)
                .addComponent(paneUserPassThemNv, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        paneParentUserPassThemNvLayout.setVerticalGroup(
            paneParentUserPassThemNvLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(paneParentUserPassThemNvLayout.createSequentialGroup()
                .addGap(69, 69, 69)
                .addComponent(paneUserPassThemNv, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        btThem.setText("Thêm");
        btThem.setPreferredSize(new java.awt.Dimension(85, 23));
        btThem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btThemActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout PanelLv2Layout = new javax.swing.GroupLayout(PanelLv2);
        PanelLv2.setLayout(PanelLv2Layout);
        PanelLv2Layout.setHorizontalGroup(
            PanelLv2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelLv2Layout.createSequentialGroup()
                .addGap(47, 47, 47)
                .addGroup(PanelLv2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbTenThemNv)
                    .addComponent(lbTuoiThemNv)
                    .addComponent(lbDiaChiThemNv)
                    .addComponent(lbSDTThemNv)
                    .addComponent(lbLoaiNvThemNV)
                    .addComponent(lbLuongThemNv)
                    .addComponent(lbGioiTinhThemNv))
                .addGap(48, 48, 48)
                .addGroup(PanelLv2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PanelLv2Layout.createSequentialGroup()
                        .addGroup(PanelLv2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(PanelLv2Layout.createSequentialGroup()
                                .addGroup(PanelLv2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(txtfSDTThemNv, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 191, Short.MAX_VALUE)
                                    .addComponent(txtfDiaChiThemNv)
                                    .addComponent(txtfTuoiThemNv, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtfTenThemNv, javax.swing.GroupLayout.Alignment.LEADING))
                                .addGap(44, 44, 44))
                            .addGroup(PanelLv2Layout.createSequentialGroup()
                                .addGroup(PanelLv2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(PanelLv2Layout.createSequentialGroup()
                                        .addComponent(txtfLuongThemNv)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(lbDonviLuongThemNv))
                                    .addComponent(comBLoaiNhanVienThemNv, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                        .addComponent(paneParentUserPassThemNv, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(PanelLv2Layout.createSequentialGroup()
                        .addComponent(cbNamThemNv)
                        .addGap(18, 18, 18)
                        .addComponent(cbNuThemNv)
                        .addContainerGap())))
            .addGroup(PanelLv2Layout.createSequentialGroup()
                .addGap(334, 334, 334)
                .addComponent(btThem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        PanelLv2Layout.setVerticalGroup(
            PanelLv2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelLv2Layout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addGroup(PanelLv2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbTenThemNv)
                    .addComponent(txtfTenThemNv, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(34, 34, 34)
                .addGroup(PanelLv2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbTuoiThemNv)
                    .addComponent(txtfTuoiThemNv, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(PanelLv2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PanelLv2Layout.createSequentialGroup()
                        .addGap(33, 33, 33)
                        .addGroup(PanelLv2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lbGioiTinhThemNv)
                            .addComponent(cbNamThemNv)
                            .addComponent(cbNuThemNv))
                        .addGap(32, 32, 32)
                        .addGroup(PanelLv2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lbDiaChiThemNv)
                            .addComponent(txtfDiaChiThemNv, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(34, 34, 34)
                        .addGroup(PanelLv2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lbSDTThemNv)
                            .addComponent(txtfSDTThemNv, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(34, 34, 34)
                        .addGroup(PanelLv2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lbLoaiNvThemNV)
                            .addComponent(comBLoaiNhanVienThemNv, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(34, 34, 34)
                        .addGroup(PanelLv2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lbLuongThemNv)
                            .addComponent(txtfLuongThemNv, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbDonviLuongThemNv)))
                    .addGroup(PanelLv2Layout.createSequentialGroup()
                        .addGap(5, 5, 5)
                        .addComponent(paneParentUserPassThemNv, javax.swing.GroupLayout.PREFERRED_SIZE, 292, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btThem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(158, Short.MAX_VALUE))
        );

        add(PanelLv2);
    }// </editor-fold>//GEN-END:initComponents

    private void comBLoaiNhanVienThemNvActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comBLoaiNhanVienThemNvActionPerformed
        // TODO add your handling code here:
        if(evt.getSource() == comBLoaiNhanVienThemNv){
            JComboBox cb = (JComboBox)evt.getSource();
            int pos = cb.getSelectedIndex();
            if(pos == 1){
                disablePaneUserPassThemNv();
                
            }else{
                enablePaneUserPassThemNv();
            }
        }
    }//GEN-LAST:event_comBLoaiNhanVienThemNvActionPerformed

    private void btThemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btThemActionPerformed
        // TODO add your handling code here:
        try{
            String ten = txtfTenThemNv.getText();
            int tuoi = Integer.parseInt(txtfTuoiThemNv.getText());
            boolean gioiTinh = cbNamThemNv.isSelected();
            String diaChi = txtfDiaChiThemNv.getText();
            String SDT = txtfSDTThemNv.getText();
            String loaiNhanVien = comBLoaiNhanVienThemNv.getSelectedItem().toString();
            int luong = Integer.parseInt(txtfLuongThemNv.getText());
            NhanVien nhanVienMoi;
            String username = "";
            if(comBLoaiNhanVienThemNv.getSelectedIndex() == 0){
                username = txtfUsernameThemNv.getText();
                String pass = txtfPasswordThemNv.getText();
                
                NhanVienThuNgan nhanVienThuNganMoi = new NhanVienThuNgan(ten,tuoi,gioiTinh,diaChi,SDT,loaiNhanVien,luong,username,pass);
                nhanVienMoi = nhanVienThuNganMoi;
            }else{
                nhanVienMoi = new NhanVienBanHang(ten,tuoi,gioiTinh,diaChi,SDT,loaiNhanVien,luong);
            }
            
            if(!isTxtfEmpty(ten,tuoi,SDT,luong) && 
                    (nhanVienMoi.getLoaiNhanVien().equals("Nhân Viên Bán Hàng") || !isTxtfEmpty(username))){
                
                HomeFrame.cuaHang.themNhanVien(nhanVienMoi);
                JOptionPane.showMessageDialog(this,"Thêm nhân viên thành công!");
                resetData();
            }
            
        }catch(NumberFormatException e){
            try{
                int tuoi = Integer.parseInt(txtfTuoiThemNv.getText());
            }catch(NumberFormatException e1){
                notifyError(txtfTuoiThemNv,"Tuổi phải là số tự nhiên!");
            }
            
            try{
                int luong = Integer.parseInt(txtfLuongThemNv.getText());
            }catch(NumberFormatException e1){
                notifyError(txtfLuongThemNv,"Lương phải là số tự nhiên!");
            }
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }
        
    }//GEN-LAST:event_btThemActionPerformed

    private void cbNamThemNvItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbNamThemNvItemStateChanged
        // TODO add your handling code here:
        if(cbNamThemNv.isSelected()){
            cbNuThemNv.setSelected(false);
        }else{
            cbNuThemNv.setSelected(true);
        }
    }//GEN-LAST:event_cbNamThemNvItemStateChanged

    private void cbNuThemNvItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbNuThemNvItemStateChanged
        // TODO add your handling code here:
        if(cbNuThemNv.isSelected()){
            cbNamThemNv.setSelected(false);
        }else{
            cbNamThemNv.setSelected(true);
        }
    }//GEN-LAST:event_cbNuThemNvItemStateChanged

    private void txtfTenThemNvFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtfTenThemNvFocusGained
        // TODO add your handling code here:
        handleWhenBeFocus(txtfTenThemNv);
    }//GEN-LAST:event_txtfTenThemNvFocusGained

    private void txtfTuoiThemNvFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtfTuoiThemNvFocusGained
        // TODO add your handling code here:
        handleWhenBeFocus(txtfTuoiThemNv);
    }//GEN-LAST:event_txtfTuoiThemNvFocusGained

    private void txtfSDTThemNvFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtfSDTThemNvFocusGained
        // TODO add your handling code here:
        handleWhenBeFocus(txtfSDTThemNv);
    }//GEN-LAST:event_txtfSDTThemNvFocusGained

    private void txtfLuongThemNvFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtfLuongThemNvFocusGained
        // TODO add your handling code here:
        handleWhenBeFocus(txtfLuongThemNv);
    }//GEN-LAST:event_txtfLuongThemNvFocusGained

    private void txtfUsernameThemNvFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtfUsernameThemNvFocusGained
        // TODO add your handling code here:
        handleWhenBeFocus(txtfUsernameThemNv);
    }//GEN-LAST:event_txtfUsernameThemNvFocusGained

    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel PanelLv2;
    private javax.swing.JButton btThem;
    private javax.swing.JCheckBox cbNamThemNv;
    private javax.swing.JCheckBox cbNuThemNv;
    private javax.swing.JComboBox<String> comBLoaiNhanVienThemNv;
    private javax.swing.JLabel lbDiaChiThemNv;
    private javax.swing.JLabel lbDonviLuongThemNv;
    private javax.swing.JLabel lbGioiTinhThemNv;
    private javax.swing.JLabel lbLoaiNvThemNV;
    private javax.swing.JLabel lbLuongThemNv;
    private javax.swing.JLabel lbPasswordThemNv;
    private javax.swing.JLabel lbSDTThemNv;
    private javax.swing.JLabel lbTenThemNv;
    private javax.swing.JLabel lbThemNvTitile;
    private javax.swing.JLabel lbTuoiThemNv;
    private javax.swing.JLabel lbUsernameThemNv;
    private javax.swing.JPanel paneParentUserPassThemNv;
    private javax.swing.JPanel paneUserPassThemNv;
    private javax.swing.JTextField txtfDiaChiThemNv;
    private javax.swing.JTextField txtfLuongThemNv;
    private javax.swing.JTextField txtfPasswordThemNv;
    private javax.swing.JTextField txtfSDTThemNv;
    private javax.swing.JTextField txtfTenThemNv;
    private javax.swing.JTextField txtfTuoiThemNv;
    private javax.swing.JTextField txtfUsernameThemNv;
    // End of variables declaration//GEN-END:variables

    private void disablePaneUserPassThemNv() {
        txtfUsernameThemNv.setEnabled(false);
        lbUsernameThemNv.setEnabled(false);
        
        txtfPasswordThemNv.setEnabled(false);
        lbPasswordThemNv.setEnabled(false);
    }

    private void enablePaneUserPassThemNv() {
        txtfUsernameThemNv.setEnabled(true);
        lbUsernameThemNv.setEnabled(true);
        
        txtfPasswordThemNv.setEnabled(true);
        lbPasswordThemNv.setEnabled(true);
    }

    private void resetData() {
        txtfTenThemNv.setText("");
        txtfTuoiThemNv.setText("");
        cbNamThemNv.setSelected(true);
        txtfDiaChiThemNv.setText("");
        txtfSDTThemNv.setText("");
        comBLoaiNhanVienThemNv.setSelectedIndex(0);
        txtfLuongThemNv.setText("");
        txtfUsernameThemNv.setText("");
        txtfPasswordThemNv.setText("");
    }

    private void notifyError(javax.swing.JTextField smt) {
        smt.setText("Không được để trống");
        smt.setForeground(java.awt.Color.RED);
    }
    
    private void notifyError(javax.swing.JTextField smt,String error) {
        smt.setText(error);
        smt.setForeground(java.awt.Color.RED);
    }
    
    private boolean isTxtfEmpty(String ten, int tuoi, String SDT, int luong ) {
        boolean result = false;
        if(ten.equals("")){
            notifyError(txtfTenThemNv);
            result = true;
        }
        if(tuoi == 0){
            notifyError(txtfTuoiThemNv);
            result = true;
        }
        if(luong == 0){
            notifyError(txtfLuongThemNv);
            result = true;
        }
        if(SDT.equals("")){
            notifyError(txtfSDTThemNv);
            result = true;
        }
        return result;
    }

    private boolean isTxtfEmpty(String username) {
        boolean result = false;
        if(username.equals("")){
            notifyError(txtfUsernameThemNv);
            result = true;
        }
        return result;
    }
    
    private void handleWhenBeFocus(javax.swing.JTextField smt){
        if(smt.getForeground() == Color.RED){
            smt.setText("");
            smt.setForeground(Color.black);
        }
    }
}
