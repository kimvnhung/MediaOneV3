/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DoanhThu;

import Main.HomeFrame;
import java.awt.Color;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import utils.ChiPhiKhac;

/**
 *
 * @author h
 */
public class PanelChiPhiPhatSinh extends javax.swing.JPanel {
    private ArrayList<ChiPhiKhac> listChiPhi;
    private ArrayList<Integer> listRowBeChanged;

    public ArrayList<Integer> getListRowBeChanged() {
        return listRowBeChanged;
    }
    /**
     * Creates new form ChiPhiPhatSinh
     */
    public PanelChiPhiPhatSinh() {
        initComponents();
        
        
        
        listRowBeChanged = new ArrayList<>();
        
        listChiPhi = new ArrayList<>(HomeFrame.cuaHang.getListChiPhiKhac());
        setTableContent();
        
        this.tableChiPhiPhatSinh.getSelectionModel().addListSelectionListener(
                new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent lse) {
                if(tableChiPhiPhatSinh.isEditing()){
                    int check = getListRowBeChanged().indexOf(lse.getFirstIndex());
                    if(check == -1){
                        getListRowBeChanged().add(lse.getFirstIndex());
                        
                    }
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
        lbTenChiPhi = new javax.swing.JLabel();
        txtfTenChiPhi = new javax.swing.JTextField();
        lbSoTien = new javax.swing.JLabel();
        txtfSoTien = new javax.swing.JTextField();
        lbTrenDonVi = new javax.swing.JLabel();
        btThem = new javax.swing.JButton();
        comBTrenDonVi = new javax.swing.JComboBox<>();
        btXoa = new javax.swing.JButton();
        btLuu = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableChiPhiPhatSinh = new javax.swing.JTable();

        setPreferredSize(new java.awt.Dimension(800, 500));

        jLabel1.setText("Nhập Các Chi Phí Phát Sinh");

        lbTenChiPhi.setText("Tên Chi Phí");

        txtfTenChiPhi.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtfTenChiPhiFocusGained(evt);
            }
        });

        lbSoTien.setText("Số Tiền");

        txtfSoTien.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtfSoTienFocusGained(evt);
            }
        });

        lbTrenDonVi.setText("Trên đơn vị");

        btThem.setText("Thêm");
        btThem.setPreferredSize(new java.awt.Dimension(85, 23));
        btThem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btThemActionPerformed(evt);
            }
        });

        comBTrenDonVi.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "None", "Giờ", "Ngày", "Tháng" }));
        comBTrenDonVi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comBTrenDonViActionPerformed(evt);
            }
        });

        btXoa.setText("Xóa");
        btXoa.setPreferredSize(new java.awt.Dimension(85, 23));
        btXoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btXoaActionPerformed(evt);
            }
        });

        btLuu.setText("Lưu");
        btLuu.setEnabled(false);
        btLuu.setPreferredSize(new java.awt.Dimension(85, 23));
        btLuu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btLuuActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(76, 76, 76)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(txtfTenChiPhi)
                            .addComponent(txtfSoTien)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                .addComponent(comBTrenDonVi, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 43, Short.MAX_VALUE))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(btThem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btXoa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lbTrenDonVi)
                                    .addComponent(lbSoTien)
                                    .addComponent(lbTenChiPhi))
                                .addGap(0, 0, Short.MAX_VALUE)))))
                .addContainerGap())
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(80, 80, 80)
                .addComponent(btLuu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addComponent(lbTenChiPhi)
                .addGap(30, 30, 30)
                .addComponent(txtfTenChiPhi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(lbSoTien)
                .addGap(30, 30, 30)
                .addComponent(txtfSoTien, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(lbTrenDonVi)
                .addGap(30, 30, 30)
                .addComponent(comBTrenDonVi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(72, 72, 72)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btThem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btXoa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btLuu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        tableChiPhiPhatSinh.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "STT", "Tên Chi Phí", "Số Tiền", "Trên đơn vị"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, true, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tableChiPhiPhatSinh.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                tableChiPhiPhatSinhFocusGained(evt);
            }
        });
        jScrollPane1.setViewportView(tableChiPhiPhatSinh);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(336, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(335, 335, 335))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 458, Short.MAX_VALUE))
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void comBTrenDonViActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comBTrenDonViActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_comBTrenDonViActionPerformed

    private void txtfTenChiPhiFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtfTenChiPhiFocusGained
        // TODO add your handling code here:
        handleWhenBeFocus((JTextField)evt.getComponent());
    }//GEN-LAST:event_txtfTenChiPhiFocusGained

    private void txtfSoTienFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtfSoTienFocusGained
        // TODO add your handling code here:
        handleWhenBeFocus((JTextField)evt.getComponent());
    }//GEN-LAST:event_txtfSoTienFocusGained

    private void btThemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btThemActionPerformed
        // TODO add your handling code here:
        try{
            String ten = txtfTenChiPhi.getText();
            int soTien = Integer.parseInt(txtfSoTien.getText());
            
            String trenDonVi = (String) comBTrenDonVi.getSelectedItem();
            
            if(isAvailable(ten,soTien)){
                ChiPhiKhac newChiPhi = new ChiPhiKhac(ten,soTien,trenDonVi);
                listChiPhi.add(newChiPhi);
                HomeFrame.cuaHang.getListChiPhiKhac().add(newChiPhi);
                
                
                ArrayList<Integer> insertPos = new ArrayList<>();
                insertPos.add(HomeFrame.cuaHang.getListChiPhiKhac().size()-1);
                
                HomeFrame.cuaHang.capNhatChiPhi(insertPos, "insert");
                
                setTableContent();
                
                txtfTenChiPhi.setText("");
                txtfSoTien.setText("");
                comBTrenDonVi.setSelectedIndex(0);
                
            }
            
            
        }catch(NumberFormatException e){
            notifyError(txtfSoTien,"Số tiền phải là số nguyên!");
        }catch(Exception e){
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
    }//GEN-LAST:event_btThemActionPerformed

    private void btXoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btXoaActionPerformed
        // TODO add your handling code here:
        try {
            int[] deleteRow = this.tableChiPhiPhatSinh.getSelectedRows();
            ArrayList<Integer> listDelete = new ArrayList<>();

            for(int x: deleteRow){
                listDelete.add(x);
            }
        
        
            HomeFrame.cuaHang.capNhatChiPhi(listDelete, "delete");
            for(int x: deleteRow){
                listChiPhi.remove(x);
            }
            setTableContent();
            
        } catch (ClassNotFoundException ex) {
            
        } catch (SQLException ex) {
            
        }
        
        
    }//GEN-LAST:event_btXoaActionPerformed

    private void btLuuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btLuuActionPerformed
        // TODO add your handling code here:
        try{
            if(this.tableChiPhiPhatSinh.isEditing()){
                this.tableChiPhiPhatSinh.getCellEditor().stopCellEditing();
            }
            
            ArrayList<Integer> updateList = this.getListRowBeChanged();
            DefaultTableModel model = (DefaultTableModel) this.tableChiPhiPhatSinh.getModel();
            int rowRange = updateList.size();
            for(int i = 0; i <  rowRange; i++){
                String name = (String) model.getValueAt(i, 1);
                int soTien = (int) model.getValueAt(i, 2);
                String trenDonVi = (String) model.getValueAt(i, 3);
                ChiPhiKhac rowItem = new ChiPhiKhac(name,soTien,trenDonVi);
                
                int pos = updateList.get(i);
                
                HomeFrame.cuaHang.getListChiPhiKhac().remove(pos);
                HomeFrame.cuaHang.getListChiPhiKhac().add(pos, rowItem);
            }
            
            HomeFrame.cuaHang.capNhatChiPhi(updateList,"update");
            JOptionPane.showMessageDialog(this, "Chỉnh sửa thành công!");
            
            btLuu.setEnabled(false);
            
        }catch(Exception e){
            
        }
    }//GEN-LAST:event_btLuuActionPerformed

    private void tableChiPhiPhatSinhFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tableChiPhiPhatSinhFocusGained
        // TODO add your handling code here:
        btLuu.setEnabled(true);
    }//GEN-LAST:event_tableChiPhiPhatSinhFocusGained


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btLuu;
    private javax.swing.JButton btThem;
    private javax.swing.JButton btXoa;
    private javax.swing.JComboBox<String> comBTrenDonVi;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lbSoTien;
    private javax.swing.JLabel lbTenChiPhi;
    private javax.swing.JLabel lbTrenDonVi;
    private javax.swing.JTable tableChiPhiPhatSinh;
    private javax.swing.JTextField txtfSoTien;
    private javax.swing.JTextField txtfTenChiPhi;
    // End of variables declaration//GEN-END:variables

    private boolean isAvailable(String ten, int soTien) {
        boolean result = true;
        if(ten.equals("")){
            notifyError(txtfTenChiPhi);
            result = false;
        }
        if(soTien <= 0){
            notifyError(txtfSoTien,"Số tiền phải dương!");
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

    private void setTableContent() {
        DefaultTableModel model = (DefaultTableModel) this.tableChiPhiPhatSinh.getModel();
        model.setRowCount(0);
        
        for(int i = 0; i < listChiPhi.size(); i++){
            ChiPhiKhac cp = listChiPhi.get(i);
            Object[] newRow = {i+1,cp.getTenChiPhi(),cp.getSoTien(),cp.getTrenDonVi()};
            model.addRow(newRow);
        }
    }
    
}
