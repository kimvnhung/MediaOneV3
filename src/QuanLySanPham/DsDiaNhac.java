/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package QuanLySanPham;

import Main.HomeFrame;
import java.awt.event.ActionEvent;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import utils.DiaNhac;
import utils.DiaPhim;

/**
 *
 * @author h
 */
public class DsDiaNhac extends DsSanPham{

    public DsDiaNhac() {
        super();
        
        
    }

    @Override
    public void btLuuPerformed(ActionEvent evt) {
        if(this.getTbDsSP().isEditing()){
            this.getTbDsSP().getCellEditor().stopCellEditing();
        }
        
        ArrayList<Integer> updateList = this.getListRowBeChanged();
        int rowRange = updateList.size();
        for(int i = 0; i <  rowRange; i++){
            int stt = updateList.get(i);
            
            String ten = (String)getModel().getValueAt(i, 2);
            String loaiMH = (String)getModel().getValueAt(i, 3);
            String ref1 = (String)getModel().getValueAt(i, 4);
            String ref2 = (String)getModel().getValueAt(i, 5);
            String ref3 = (String)getModel().getValueAt(i, 6);
            String theLoai = (String)getModel().getValueAt(i, 7);
            int soLuong = (int)getModel().getValueAt(i, 8);
            int giaMua = (int)getModel().getValueAt(i, 9);
            int giaBan = (int)getModel().getValueAt(i, 10);
            DiaNhac rowItem = new DiaNhac(
                    ten,loaiMH,ref1,ref2,ref3,theLoai,soLuong,giaMua,giaBan
            );
            try {
                HomeFrame.cuaHang.xuatKhoHang(rowItem,stt);
            } catch (ClassNotFoundException ex) {
                
            } catch (SQLException ex) {
                
            }
        }
        

        JOptionPane.showMessageDialog(this, "Chỉnh sửa thành công!");
    }

    @Override
    public void btXoaPerformed(ActionEvent evt) {
        int position = getTbDsSP().getSelectedRow();
        
        try {
            HomeFrame.cuaHang.loaiBoMatHang(HomeFrame.cuaHang.getListDiaNhac().get(position));
            HomeFrame.cuaHang.getListDiaNhac().remove(position);
            JOptionPane.showMessageDialog(this, "Xóa thành công!");
            setTableContent();
        } catch (ClassNotFoundException ex) {
            
        } catch (SQLException ex) {
            
        }
    }

    @Override
    public void setTableContent() {
        getModel().setNumRows(0);
        
        for(DiaNhac x: HomeFrame.cuaHang.getListDiaNhac()){
            Object[] newRow = {getModel().getRowCount()+1,x.getTen(),
                x.getLoaiSanPham(),x.getNhacSi(),x.getCaSi(),
                x.getAlbumn(),x.getTheLoai(),x.getSoLuong(),x.getGiaMua(),x.getGiaBan()
            };
            getModel().addRow(newRow);
        }
    }

    @Override
    public String[] getTableFields() {
        return new String[]{
            "STT","Tên MH","Loại MH","Nhạc sĩ","Ca sĩ","Album","Thể loại","Số lượng","Giá mua","Giá bán"
        };
    }

    @Override
    public String getTitlePanel() {
        return "Danh Sách Đĩa Nhạc";
    }

    
    
}
