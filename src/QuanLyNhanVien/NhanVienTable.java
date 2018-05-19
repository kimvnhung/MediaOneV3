/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package QuanLyNhanVien;

import Main.HomeFrame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.DefaultTableModel;
import utils.NhanVien;

/**
 *
 * @author h
 */
public abstract class NhanVienTable extends javax.swing.JPanel {
    private ArrayList<Integer> listRowBeChanged;
    private DefaultTableModel model;
    /**
     * Creates new form NvThuNgan
     */
    public NhanVienTable() {
        initComponents();
        model = (DefaultTableModel) getTbDsNv().getModel();
        setContentTable();
        setListRowBeChanged(new ArrayList<Integer>());
        
        
        getTbDsNv().getSelectionModel().addListSelectionListener(
                new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent lse) {
                if(getTbDsNv().isEditing()){
                    int check = getListRowBeChanged().indexOf(lse.getFirstIndex());
                    if(check == -1){
                        getListRowBeChanged().add(lse.getFirstIndex());
                    }
                }
            }
        }
        );
        
        getBtLuuNv().addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent ae) {
                        btLuuDsActionPerformed(ae);
                    }
        }
        );
        
        getBtXoaNv().addActionListener(
                new ActionListener(){
                    @Override
                    public void actionPerformed(ActionEvent ae) {
                        if(getListRowBeChanged().size() != 0){
                            btLuuDsActionPerformed(ae);
                        }
                        btXoaDsActionPerformed(ae);
                        
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

        ScrPDsNv = new javax.swing.JScrollPane();
        tbDsNv = new javax.swing.JTable();
        lbTitleDsNv = new javax.swing.JLabel();
        btLuuNv = new javax.swing.JButton();
        btXoaNv = new javax.swing.JButton();

        setPreferredSize(new java.awt.Dimension(800, 500));

        tbDsNv.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "STT", "Tên nhân viên", "Tuổi", "Giới tính", "Địa chỉ", "SĐT", "Lương(VND/Tháng)"
            }
        ));
        ScrPDsNv.setViewportView(tbDsNv);

        lbTitleDsNv.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        lbTitleDsNv.setText("Danh sách nhân viên bán hàng");

        btLuuNv.setText("Lưu");
        btLuuNv.setPreferredSize(new java.awt.Dimension(85, 23));

        btXoaNv.setText("Xóa");
        btXoaNv.setPreferredSize(new java.awt.Dimension(85, 23));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(ScrPDsNv))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(252, 252, 252)
                                .addComponent(btLuuNv, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(126, 126, 126)
                                .addComponent(btXoaNv, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(323, 323, 323)
                                .addComponent(lbTitleDsNv)))
                        .addGap(0, 242, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(9, 9, 9)
                .addComponent(lbTitleDsNv)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(ScrPDsNv, javax.swing.GroupLayout.PREFERRED_SIZE, 409, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btLuuNv, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btXoaNv, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(18, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents
    
    public JTable getTbDsNv() {
        return tbDsNv;
    }

    public JScrollPane getScrPDsNv() {
        return ScrPDsNv;
    }

    public JLabel getLbTitleDsNv() {
        return lbTitleDsNv;
    }

    public ArrayList<Integer> getListRowBeChanged() {
        return listRowBeChanged;
    }

    public JButton getBtLuuNv() {
        return btLuuNv;
    }

    public JButton getBtXoaNv() {
        return btXoaNv;
    }

    public void setListRowBeChanged(ArrayList<Integer> listRowBeChanged) {
        this.listRowBeChanged = listRowBeChanged;
    }

    public DefaultTableModel getModel() {
        return model;
    }
    
    public abstract void btLuuDsActionPerformed(ActionEvent evt);
    public abstract void btXoaDsActionPerformed(ActionEvent evt);
    public abstract void setContentTable();
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane ScrPDsNv;
    private javax.swing.JButton btLuuNv;
    private javax.swing.JButton btXoaNv;
    private javax.swing.JLabel lbTitleDsNv;
    private javax.swing.JTable tbDsNv;
    // End of variables declaration//GEN-END:variables
}
