/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package QuanLySanPham;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author h
 */
public abstract class DsSanPham extends javax.swing.JPanel {
    
    private ArrayList<Integer> listRowBeChanged;
    private DefaultTableModel model;
    
    /** Creates new form DsDiaPhim */
    public DsSanPham() {
        initComponents();
        
        DefaultTableModel tm = new javax.swing.table.DefaultTableModel(
            new Object [][] {},
            getTableFields()
        ) {
            boolean[] canEdit = getPermitionTableEditable();

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }

            
        };
        getTbDsSP().setModel(tm);
        getScrPaneTable().setViewportView(getTbDsSP());
        getLbDanhSachCacSanPham().setText(getTitlePanel());
        
        model = (DefaultTableModel) getTbDsSP().getModel();
        
        setTableContent();
        setListRowBeChanged(new ArrayList<Integer>());
        
        getTbDsSP().getSelectionModel().addListSelectionListener(
                new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent lse) {
                if(getTbDsSP().isEditing()){
                    int check = getListRowBeChanged().indexOf(lse.getFirstIndex());
                    if(check == -1){
                        getListRowBeChanged().add(lse.getFirstIndex());
                    }
                }
            }

            
        }
        );
        
        
        
        getBtLuuDsCacSp().addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent ae) {
                        btLuuPerformed(ae);
                    }
        }
        );
        
        getBtXoaDsCacSp().addActionListener(
                new ActionListener(){
                    @Override
                    public void actionPerformed(ActionEvent ae) {
                        if(getListRowBeChanged().size() != 0){
                            btLuuPerformed(ae);
                        }
                        
                        btXoaPerformed(ae);
                    }
                    
                }
        );
        
    }

    
    
    public ArrayList<Integer> getListRowBeChanged() {
        return listRowBeChanged;
    }

    public void setListRowBeChanged(ArrayList<Integer> listRowBeChanged) {
        this.listRowBeChanged = listRowBeChanged;
    }

    public DefaultTableModel getModel() {
        return model;
    }

    public JButton getBtLuuDsCacSp() {
        return btLuuDsCacSp;
    }

    public JButton getBtXoaDsCacSp() {
        return btXoaDsCacSp;
    }

    public JScrollPane getScrPaneTable() {
        return ScrPaneTable;
    }

    public JLabel getLbDanhSachCacSanPham() {
        return lbDanhSachCacSanPham;
    }

    

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lbDanhSachCacSanPham = new javax.swing.JLabel();
        ScrPaneTable = new javax.swing.JScrollPane();
        tableDsSanPham = new javax.swing.JTable();
        btLuuDsCacSp = new javax.swing.JButton();
        btXoaDsCacSp = new javax.swing.JButton();

        setPreferredSize(new java.awt.Dimension(800, 500));

        lbDanhSachCacSanPham.setText("Danh Sách Các Sản Phẩm");

        tableDsSanPham.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "STT", "Tên MH", "Loại MH", "Thể Loại", "Số lượng", "Giá mua", "Giá bán"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                true, false, true, true, true, true, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tableDsSanPham.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableDsSanPhamMouseClicked(evt);
            }
        });
        ScrPaneTable.setViewportView(tableDsSanPham);

        btLuuDsCacSp.setText("Lưu");
        btLuuDsCacSp.setPreferredSize(new java.awt.Dimension(85, 23));

        btXoaDsCacSp.setText("Xóa");
        btXoaDsCacSp.setPreferredSize(new java.awt.Dimension(85, 23));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lbDanhSachCacSanPham)
                .addGap(363, 363, 363))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(ScrPaneTable)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(243, 243, 243)
                .addComponent(btLuuDsCacSp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(119, 119, 119)
                .addComponent(btXoaDsCacSp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(268, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lbDanhSachCacSanPham)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 39, Short.MAX_VALUE)
                .addComponent(ScrPaneTable, javax.swing.GroupLayout.PREFERRED_SIZE, 384, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btLuuDsCacSp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btXoaDsCacSp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void tableDsSanPhamMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableDsSanPhamMouseClicked
        // TODO add your handling code here:
        
    }//GEN-LAST:event_tableDsSanPhamMouseClicked


    public JTable getTbDsSP() {
        return tableDsSanPham;
    }
    
    public abstract void btLuuPerformed(ActionEvent evt);
    
    public abstract void btXoaPerformed(ActionEvent evt);
    
    public abstract void setTableContent();
    
    //public abstract boolean[] getPermitionTableEditable();
    
    public abstract String[] getTableFields();
    
    public abstract String getTitlePanel();
    
    private void notifyError() {
        JOptionPane.showMessageDialog(this, "Không được phép sửa tên!");
    }
    
    public boolean[] getPermitionTableEditable() {
        return new boolean[]{false,false,false,true,true,true,true,true,true,true};
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane ScrPaneTable;
    private javax.swing.JButton btLuuDsCacSp;
    private javax.swing.JButton btXoaDsCacSp;
    private javax.swing.JLabel lbDanhSachCacSanPham;
    private javax.swing.JTable tableDsSanPham;
    // End of variables declaration//GEN-END:variables

    

    

}