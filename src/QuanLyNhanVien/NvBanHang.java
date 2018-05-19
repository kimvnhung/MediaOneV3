/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package QuanLyNhanVien;

import Main.HomeFrame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.DefaultTableModel;
import utils.NhanVien;

/**
 *
 * @author h
 */
public class NvBanHang extends NhanVienTable{
    
    public NvBanHang() {
        super();
        
        
        
    }
    
    @Override
    public void btLuuDsActionPerformed(ActionEvent ae){
        try {
            
            if(this.getTbDsNv().isEditing()){
                this.getTbDsNv().getCellEditor().stopCellEditing();
            }
            
            ArrayList<Integer> updateList = this.getListRowBeChanged();
            DefaultTableModel model = (DefaultTableModel) getTbDsNv().getModel();
            int rowRange = updateList.size();
            for(int i = 0; i <  rowRange; i++){
                int stt = updateList.get(i);
                
                String loaiNhanVien = HomeFrame.cuaHang.getListNhanVienBanHang().get(stt).getLoaiNhanVien();
                NhanVien rowItem = new NhanVien(
                        (String)model.getValueAt(stt, 1),(int)model.getValueAt(stt, 2), model.getValueAt(stt, 3).equals("Nam")?true:false,
                        (String)model.getValueAt(stt, 4),(String)model.getValueAt(stt, 5),loaiNhanVien,(int) model.getValueAt(stt, 6)
                );
                HomeFrame.cuaHang.capNhatttNv(rowItem,stt);
            }
            
            
            JOptionPane.showMessageDialog(this, "Chỉnh sửa thành công!");
            
            
        } catch (ClassNotFoundException ex) {
            
        } catch (SQLException ex) {
            
        } catch(Exception ex){
            System.out.print(ex.getMessage());
        }
    }
        
    @Override
    public void btXoaDsActionPerformed(ActionEvent ae){
        int position = getTbDsNv().getSelectedRow();
        try {
            HomeFrame.cuaHang.thoiViec(position, "Nhân Viên Bán Hàng");
            JOptionPane.showMessageDialog(this, "Xóa thành công!");
            setContentTable();
        } catch (ClassNotFoundException ex) {
            
        } catch (SQLException ex) {
            
        }
        
        
    }

    @Override
    public void setContentTable() {
        getModel().setNumRows(0);
        
        for(NhanVien x: HomeFrame.cuaHang.getListNhanVienBanHang()){
            Object[] newRow = {getModel().getRowCount()+1,x.getTen(),x.getTuoi(),
                x.getGioiTinh()==1?"Nam":"Nữ",x.getDiaChi(),x.getSDT(),x.getLuong()
            };
            getModel().addRow(newRow);
        }
    }
    
}

