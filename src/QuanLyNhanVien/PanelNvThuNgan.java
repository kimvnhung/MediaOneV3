/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package QuanLyNhanVien;

import Main.HomeFrame;
import java.awt.event.ActionEvent;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.DefaultTableModel;
import DoiTuongChinh.NhanVien;
import DoiTuongChinh.NhanVienThuNgan;

/**
 *
 * @author h
 */
public class PanelNvThuNgan extends PanelNhanVienTable {
    public PanelNvThuNgan(){
        super();
        DefaultTableModel tm = new DefaultTableModel(
                new Object[][]{},new String[]{
                    "STT","Tên nhân viên","Tuổi","Giới tính","Địa chỉ","SĐT","Lương (VND/Tháng)","Username","Password"
                }
        );
        getTbDsNv().setModel(tm);
        getScrPDsNv().setViewportView(this.getTbDsNv());
        getLbTitleDsNv().setText("Danh sách nhân viên thu ngân");
        
        tm = (DefaultTableModel) getTbDsNv().getModel();
        
        for(NhanVienThuNgan x: HomeFrame.cuaHang.getListNhanVienThuNgan()){
            Object[] newRow = {HomeFrame.cuaHang.getListNhanVienThuNgan().indexOf(x)+1,
                x.getTen(),x.getTuoi(),
                x.getGioiTinh()==1?"Nam":"Nữ",x.getDiaChi(),x.getSDT(),
                x.getLuong(),x.getAccount().getUsername(),x.getAccount().getPassword()
            };
            tm.addRow(newRow);
        }
        
        
    }

    @Override
    public void btLuuDsActionPerformed(ActionEvent evt) {
        try {
            
            if(this.getTbDsNv().isEditing()){
                this.getTbDsNv().getCellEditor().stopCellEditing();
            }
            
            ArrayList<Integer> updateList = this.getListRowBeChanged();
            DefaultTableModel model = (DefaultTableModel) getTbDsNv().getModel();
            int rowRange = updateList.size();
            for(int i = 0; i <  rowRange; i++){
                int stt = updateList.get(i);
                
                String loaiNhanVien = HomeFrame.cuaHang.getListNhanVienThuNgan().get(stt).getLoaiNhanVien();
                NhanVienThuNgan rowItem = new NhanVienThuNgan(
                        (String)model.getValueAt(stt, 1),(int)model.getValueAt(stt, 2), model.getValueAt(stt, 3).equals("Nam"),
                        (String)model.getValueAt(stt, 4),(String)model.getValueAt(stt, 5),loaiNhanVien,(int)model.getValueAt(stt, 6),
                        (String)model.getValueAt(stt, 7),(String)model.getValueAt(stt, 8)
                );
                HomeFrame.cuaHang.capNhatttNv(rowItem,stt);
            }
            
            
            JOptionPane.showMessageDialog(this, "Chỉnh sửa thành công!");
            
            
        } catch (ClassNotFoundException ex) {
            
        } catch (SQLException ex) {
            
        }
    }

    @Override
    public void btXoaDsActionPerformed(ActionEvent evt) {
        int position = getTbDsNv().getSelectedRow();
        try {
            HomeFrame.cuaHang.thoiViec(position, "Nhân Viên Thu Ngân");
            JOptionPane.showMessageDialog(this, "Xóa thành công!");
            setContentTable();
        } catch (ClassNotFoundException ex) {
            
        } catch (SQLException ex) {
            
        }
    }

    @Override
    public void setContentTable() {
        getModel().setNumRows(0);
        
        for(NhanVienThuNgan x: HomeFrame.cuaHang.getListNhanVienThuNgan()){
            Object[] newRow = {getModel().getRowCount()+1,x.getTen(),x.getTuoi(),x.getGioiTinh()==1?"Nam":"Nữ",
                x.getDiaChi(),x.getSDT(),x.getLuong(),x.getAccount().getUsername(),x.getAccount().getPassword()
            };
            getModel().addRow(newRow);
        }
    }
    
    
    
}
