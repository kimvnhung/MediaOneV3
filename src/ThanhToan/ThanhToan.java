/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ThanhToan;

import Main.HomeFrame;
import java.awt.Color;
import Others.DateLabelFormatter;
import java.awt.Dimension;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.DefaultTableModel;
import utils.DiaNhac;
import utils.DiaPhim;
import utils.HoaDon;
import utils.Sach;
import utils.SanPham;

/**
 *
 * @author h
 */
public class ThanhToan extends javax.swing.JPanel {
    private ArrayList<SanPham> listSanPham;
    private ArrayList<String> listTenSp;
    /**
     * Creates new form ThanhToan
     */
    public ThanhToan() {
        initComponents();
        
        setMaHoaDon();
        
        
        comBNguoiBan.setModel(new DefaultComboBoxModel<String>(getListNVThuNgan()));
        comBNguoiBan.setSelectedItem(HomeFrame.getCurrentUser());
        
        setCombTenMH();
        
        
        txtfNgayBan.setText(new DateLabelFormatter().getTime());
        
        
        listSanPham = new ArrayList<>();
        
        DefaultTableModel model = (DefaultTableModel) this.tableThanhToan.getModel();
        model.addTableModelListener(
                new TableModelListener(){
                    @Override
                    public void tableChanged(TableModelEvent tme) {
                        if(tme.getType() == TableModelEvent.UPDATE){
                            int row = tme.getFirstRow();
                            listSanPham.get(row).setSoLuong(Integer.parseInt((String) model.getValueAt(row, 4)));
                            setInfoWhenListSpBeChanged();
                        }
                    }

                }
        );
        
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        lbMaHoaDon = new javax.swing.JLabel();
        lbNguoiBan = new javax.swing.JLabel();
        lbNgayBan = new javax.swing.JLabel();
        lbTenKhachHang = new javax.swing.JLabel();
        txtfMaHoaDon = new javax.swing.JTextField();
        comBNguoiBan = new javax.swing.JComboBox<>();
        btPreviousDay = new javax.swing.JButton();
        btNextDay = new javax.swing.JButton();
        txtfTenKhachHang = new javax.swing.JTextField();
        txtfNgayBan = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        btThem = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        lbSDT = new javax.swing.JLabel();
        lbTenMatHang = new javax.swing.JLabel();
        lbSoLuong = new javax.swing.JLabel();
        txtfSDT = new javax.swing.JTextField();
        txtfSoLuong = new javax.swing.JTextField();
        comBTenMatHang = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableThanhToan = new javax.swing.JTable();
        jPanel4 = new javax.swing.JPanel();
        lbTongSoLuong = new javax.swing.JLabel();
        lbShowTongSoLuong = new javax.swing.JLabel();
        lbTongSoTien = new javax.swing.JLabel();
        lbShowTongSoTien = new javax.swing.JLabel();
        lbVND = new javax.swing.JLabel();
        btReset = new javax.swing.JButton();
        btThanhToan = new javax.swing.JButton();
        btXoa = new javax.swing.JButton();

        setPreferredSize(new java.awt.Dimension(800, 500));

        jLabel1.setText("Thanh Toán");

        lbMaHoaDon.setText("Mã Hóa Đơn");

        lbNguoiBan.setText("Người Bán");

        lbNgayBan.setText("Ngày Bán");

        lbTenKhachHang.setText("Tên Khách Hàng");

        txtfMaHoaDon.setEditable(false);

        btPreviousDay.setText("<<");
        btPreviousDay.setBorder(null);
        btPreviousDay.setPreferredSize(new java.awt.Dimension(23, 23));
        btPreviousDay.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btPreviousDayActionPerformed(evt);
            }
        });

        btNextDay.setText(">>");
        btNextDay.setBorder(null);
        btNextDay.setPreferredSize(new java.awt.Dimension(23, 23));
        btNextDay.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btNextDayActionPerformed(evt);
            }
        });

        txtfTenKhachHang.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtfTenKhachHangFocusGained(evt);
            }
        });

        txtfNgayBan.setEditable(false);
        txtfNgayBan.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtfNgayBan.setText("12/04/2018");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbMaHoaDon)
                    .addComponent(lbNguoiBan)
                    .addComponent(lbNgayBan)
                    .addComponent(lbTenKhachHang))
                .addGap(29, 29, 29)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(btPreviousDay, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtfNgayBan))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(comBNguoiBan, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 16, Short.MAX_VALUE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btNextDay, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(txtfMaHoaDon)
                    .addComponent(txtfTenKhachHang))
                .addContainerGap(36, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbMaHoaDon)
                    .addComponent(txtfMaHoaDon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbNguoiBan)
                    .addComponent(comBNguoiBan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbNgayBan)
                    .addComponent(btPreviousDay, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btNextDay, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtfNgayBan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbTenKhachHang)
                    .addComponent(txtfTenKhachHang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        btThem.setText("Thêm");
        btThem.setPreferredSize(new java.awt.Dimension(85, 23));
        btThem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btThemActionPerformed(evt);
            }
        });

        lbSDT.setText("SĐT");

        lbTenMatHang.setText("Tên Mặt Hàng");

        lbSoLuong.setText("Số Lượng");

        txtfSDT.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtfSDTFocusGained(evt);
            }
        });

        txtfSoLuong.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtfSoLuongFocusGained(evt);
            }
        });

        comBTenMatHang.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbSDT)
                    .addComponent(lbTenMatHang)
                    .addComponent(lbSoLuong))
                .addGap(31, 31, 31)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtfSDT)
                    .addComponent(txtfSoLuong)
                    .addComponent(comBTenMatHang, 0, 207, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbSDT)
                    .addComponent(txtfSDT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbTenMatHang)
                    .addComponent(comBTenMatHang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbSoLuong)
                    .addComponent(txtfSoLuong, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btThem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btThem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addComponent(jPanel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        tableThanhToan.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null}
            },
            new String [] {
                "STT", "Tên Hàng Hóa", "Loại Mặt Hàng", "Giá Bán ", "Số Lượng", "Thành Tiền"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, true, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tableThanhToan);

        lbTongSoLuong.setText("Tổng số lượng:");

        lbShowTongSoLuong.setText("0");

        lbTongSoTien.setText("Tổng số tiền");

        lbShowTongSoTien.setText("0");

        lbVND.setText("VND");

        btReset.setText("Reset");
        btReset.setPreferredSize(new java.awt.Dimension(85, 23));
        btReset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btResetActionPerformed(evt);
            }
        });

        btThanhToan.setText("Thanh Toán");
        btThanhToan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btThanhToanActionPerformed(evt);
            }
        });

        btXoa.setText("Xóa");
        btXoa.setPreferredSize(new java.awt.Dimension(85, 23));
        btXoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btXoaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(459, 459, 459)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btReset, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(lbTongSoLuong)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lbShowTongSoLuong)))
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(31, 31, 31)
                        .addComponent(btXoa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btThanhToan)
                        .addGap(2, 26, Short.MAX_VALUE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(61, 61, 61)
                        .addComponent(lbTongSoTien)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lbShowTongSoTien)
                        .addGap(14, 14, 14)
                        .addComponent(lbVND)
                        .addContainerGap())))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbTongSoLuong)
                    .addComponent(lbShowTongSoLuong)
                    .addComponent(lbTongSoTien)
                    .addComponent(lbShowTongSoTien)
                    .addComponent(lbVND))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 18, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btReset, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btThanhToan)
                    .addComponent(btXoa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(371, 371, 371))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane1)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 221, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btNextDayActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btNextDayActionPerformed
        try {
            // TODO add your handling code here:
            DateLabelFormatter timeShowing = new DateLabelFormatter(txtfNgayBan.getText().toString());
            txtfNgayBan.setText(timeShowing.getNextDayTime());
        } catch (ParseException ex) {
            Logger.getLogger(ThanhToan.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btNextDayActionPerformed

    private void btPreviousDayActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btPreviousDayActionPerformed
        // TODO add your handling code here:
        try {
            // TODO add your handling code here:
            DateLabelFormatter timeShowing = new DateLabelFormatter(txtfNgayBan.getText().toString());
            txtfNgayBan.setText(timeShowing.getPreviousDayTime());
        } catch (ParseException ex) {
            Logger.getLogger(ThanhToan.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btPreviousDayActionPerformed

    private void btThemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btThemActionPerformed
        // TODO add your handling code here:
        try{
            SanPham info = getInfoFromTen();

            int soLuong = Integer.parseInt(txtfSoLuong.getText().toString());
            if(soLuong <= 0){
                notifyError(txtfSoLuong,"Số lượng phải dương!");
                throw new Exception("Nhập số âm!");
            }
            
            if(soLuong > info.getSoLuong()){
                notifyError(txtfSoLuong,"Số lượng tối đa là "+info.getSoLuong());
            }else{
                info.setSoLuong(soLuong);
                listSanPham.add(info);


                setInfoWhenListSpBeChanged();




                comBTenMatHang.setSelectedIndex(0);
                txtfSoLuong.setText("");
            }
        }catch(NumberFormatException e){
            notifyError(txtfSoLuong,"Số lượng phải là số nguyên!");
        }catch(Exception e){
            System.out.print(e.getMessage());
        }
        
        
    }//GEN-LAST:event_btThemActionPerformed

    private void txtfTenKhachHangFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtfTenKhachHangFocusGained
        // TODO add your handling code here:
        handleWhenBeFocus((JTextField)evt.getComponent());
    }//GEN-LAST:event_txtfTenKhachHangFocusGained

    private void txtfSDTFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtfSDTFocusGained
        // TODO add your handling code here:
        handleWhenBeFocus((JTextField)evt.getComponent());
    }//GEN-LAST:event_txtfSDTFocusGained

    private void txtfSoLuongFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtfSoLuongFocusGained
        // TODO add your handling code here:
        handleWhenBeFocus((JTextField)evt.getComponent());
    }//GEN-LAST:event_txtfSoLuongFocusGained

    private void btXoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btXoaActionPerformed
        // TODO add your handling code here:

        int position = this.tableThanhToan.getSelectedRow();
        listSanPham.remove(position);
        setInfoWhenListSpBeChanged();
    }//GEN-LAST:event_btXoaActionPerformed

    private void btThanhToanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btThanhToanActionPerformed
        // TODO add your handling code here:
        try{
            if(tableThanhToan.isEditing()){
                tableThanhToan.getCellEditor().stopCellEditing();
            }
            
            

            int maHd = getMaHoaDon(txtfMaHoaDon.getText());
            String tenNguoiBan = (String) comBNguoiBan.getSelectedItem();
            String ngayBan = txtfNgayBan.getText().toString();
            String tenKH = txtfTenKhachHang.getText().toString();
            String sdt = txtfSDT.getText().toString();

            if(isAvailable(tenKH,sdt)){
                HoaDon hdMoi = new HoaDon(maHd,tenNguoiBan,ngayBan,tenKH,sdt,listSanPham);
                
                hdMoi.getKhachHang().thanhToan(hdMoi);
                JOptionPane.showMessageDialog(this,
                "Tổng số tiền phải trả là "+lbShowTongSoTien.getText()+" VND\nCảm ơn quý khách đã sử dụng sản phẩm của chúng tôi",
                "MediaOne Notice!",JOptionPane.INFORMATION_MESSAGE);
                
                btReset.doClick();
                setMaHoaDon();
            }
        }catch(NumberFormatException e){

        } catch (ClassNotFoundException ex) {

        } catch (SQLException ex) {

        }

    }//GEN-LAST:event_btThanhToanActionPerformed

    private void btResetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btResetActionPerformed
        // TODO add your handling code here:
        txtfNgayBan.setText(new DateLabelFormatter().getTime());
        txtfTenKhachHang.setText("");
        txtfSDT.setText("");
        comBTenMatHang.setSelectedIndex(0);
        txtfSoLuong.setText("");

        listSanPham = new ArrayList<>();
        setInfoWhenListSpBeChanged();
    }//GEN-LAST:event_btResetActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btNextDay;
    private javax.swing.JButton btPreviousDay;
    private javax.swing.JButton btReset;
    private javax.swing.JButton btThanhToan;
    private javax.swing.JButton btThem;
    private javax.swing.JButton btXoa;
    private javax.swing.JComboBox<String> comBNguoiBan;
    private javax.swing.JComboBox<String> comBTenMatHang;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lbMaHoaDon;
    private javax.swing.JLabel lbNgayBan;
    private javax.swing.JLabel lbNguoiBan;
    private javax.swing.JLabel lbSDT;
    private javax.swing.JLabel lbShowTongSoLuong;
    private javax.swing.JLabel lbShowTongSoTien;
    private javax.swing.JLabel lbSoLuong;
    private javax.swing.JLabel lbTenKhachHang;
    private javax.swing.JLabel lbTenMatHang;
    private javax.swing.JLabel lbTongSoLuong;
    private javax.swing.JLabel lbTongSoTien;
    private javax.swing.JLabel lbVND;
    private javax.swing.JTable tableThanhToan;
    private javax.swing.JTextField txtfMaHoaDon;
    private javax.swing.JTextField txtfNgayBan;
    private javax.swing.JTextField txtfSDT;
    private javax.swing.JTextField txtfSoLuong;
    private javax.swing.JTextField txtfTenKhachHang;
    // End of variables declaration//GEN-END:variables

    private String[] getListNVThuNgan(){
        int size = HomeFrame.cuaHang.getListNhanVienThuNgan().size();
        if(size > 0){
            String[] listNVThuNgan = new String[size+1];
            for(int i = 0; i < size ; i++){
                listNVThuNgan[i] = HomeFrame.cuaHang.getListNhanVienThuNgan().get(i).getTen();
            }
            listNVThuNgan[size] = "admin";
            return listNVThuNgan;
        }else{
            return new String[]{"admin"};
        }      
    }

    private boolean isAvailable(String ten, String sdt) {
        boolean result = true;
        if(ten.equals("")){
            notifyError(txtfTenKhachHang);
            result = false;
        }
        if(sdt.equals("")){
            notifyError(txtfSDT);
            result = false;
        }        
        return result;
    }
    
    
    
    private void notifyError(javax.swing.JTextField smt) {
        smt.setText("Không được để trống");
        smt.setForeground(java.awt.Color.RED);
    }
    
    private void notifyError(javax.swing.JTextField smt,String error) {
        smt.setText(error);
        smt.setForeground(java.awt.Color.RED);
    }
    
    private void handleWhenBeFocus(javax.swing.JTextField smt){
        if(smt.getForeground() == Color.RED){
            smt.setText("");
            smt.setForeground(Color.black);
        }
    }

    private ArrayList<String> getListTenMH() {
        int sizeDiaNhac = HomeFrame.cuaHang.getListDiaNhac().size();
        int sizeDiaPhim = HomeFrame.cuaHang.getListDiaPhim().size();
        int sizeSach = HomeFrame.cuaHang.getListSach().size();
        int totalSize = sizeDiaNhac+sizeDiaPhim+sizeSach;
        if(totalSize == 0){
            return new ArrayList<String>();
        }else{
            ArrayList<String> listTenMH = new ArrayList<>();
            for(int i = 0; i < totalSize; i++){
                if(i < sizeDiaNhac){
                    listTenMH.add(HomeFrame.cuaHang.getListDiaNhac().get(i).getTen());
                }else if(i < ( sizeDiaNhac + sizeDiaPhim )){
                    listTenMH.add(HomeFrame.cuaHang.getListDiaPhim().get(i-sizeDiaNhac).getTen());
                }else{
                    listTenMH.add(HomeFrame.cuaHang.getListSach().get(i-sizeDiaNhac-sizeDiaPhim).getTen());
                }
                
            }
            return listTenMH;
        }
        
    }

    private void setMaHoaDon() {
        int size = HomeFrame.cuaHang.getListHoaDon().size();
        int id = 0;
        if(size >0){
            id = HomeFrame.cuaHang.getListHoaDon().get(size-1).getMaHoaDon();
        }
        
        txtfMaHoaDon.setText("HD"+(id+1));
    }
    
    private int getMaHoaDon(String ma){
        int length = ma.length();
        String id = "";
        for(int i = 2; i < length; i++){
            id += ""+ma.charAt(i);
        }
        
        return Integer.parseInt(id);
    }
    
    private SanPham getInfoFromTen() {
        SanPham info = new SanPham();
        String ten = "";
        try{
            ten = (String)comBTenMatHang.getSelectedItem();
        }catch (Exception e){
            
        }
        
        for(DiaNhac x: HomeFrame.cuaHang.getListDiaNhac()){
            if(ten == x.getTen()){
                info = x;
            }
        }
        
        for(DiaPhim x: HomeFrame.cuaHang.getListDiaPhim()){
            if(ten == x.getTen()){
                info = x;
            }
        }
        
        for(Sach x: HomeFrame.cuaHang.getListSach()){
            if(ten == x.getTen()){
                info = x;
            }
        }
        
        return info;
    }

    private void setTableContent() {
        DefaultTableModel model = (DefaultTableModel) tableThanhToan.getModel();
        model.setRowCount(0);
        
        for(SanPham x: listSanPham){
            int stt = model.getRowCount()+1;

            Object[] newRow = new String[]{stt+"",x.getTen(),x.getLoaiSanPham(),x.getGiaBan()+"",
                x.getSoLuong()+"",String.valueOf(x.getGiaBan()*x.getSoLuong())};
            model.addRow(newRow);
        }
    }

    private void setCombTenMH() {
        listTenSp = getListTenMH();
        DefaultTableModel model = (DefaultTableModel) this.tableThanhToan.getModel();
        int size = model.getRowCount();
        for(int i = 0; i < size; i++){
            int index = listTenSp.indexOf((String)model.getValueAt(i, 1));
            if(index != -1){
                listTenSp.remove(index);
            }
        }
        String[] stringModel = new String[listTenSp.size()];
        for(int i = 0; i < listTenSp.size();i++){
            stringModel[i] = listTenSp.get(i);
        }
        DefaultComboBoxModel newModel = new DefaultComboBoxModel(stringModel);
        comBTenMatHang.setModel(newModel);
    }

    private void setInfoWhenListSpBeChanged() {
        setTableContent();
        setCombTenMH();
        
        
        setLbShow();
        
        
    }

    private void setLbShow() {
        DefaultTableModel model = (DefaultTableModel) tableThanhToan.getModel();
        int numRow = model.getRowCount();
        int tongSoLuong = 0,tongSoTien = 0;
        for(int i = 0; i < numRow; i++){
            tongSoLuong += Integer.parseInt((String) model.getValueAt(i, 4));
            tongSoTien += Integer.parseInt((String) model.getValueAt(i, 5));
        }
        
        lbShowTongSoLuong.setText(""+tongSoLuong);
        lbShowTongSoTien.setText(""+tongSoTien);
    }
    
    
}
