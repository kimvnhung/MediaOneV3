/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package QuanLySanPham;

import Main.HomeFrame;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.DefaultTableModel;
import utils.DiaPhim;
import utils.SanPham;

/**
 *
 * @author h
 */
public class PanelDsDiaPhim extends PanelDsSanPham{

    public PanelDsDiaPhim() {
        
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
            DiaPhim rowItem = new DiaPhim(
                    ten,loaiMH,ref1,ref2,ref3,theLoai,soLuong,giaMua,giaBan
            );
            try {
                HomeFrame.cuaHang.xuatKhoHang(rowItem,stt);
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(this, ex.getMessage());
            } catch (ClassNotFoundException ex) {
                
            }
        }
        

        JOptionPane.showMessageDialog(this, "Chỉnh sửa thành công!");
    }

    @Override
    public void btXoaPerformed(ActionEvent evt) {
        int position = getTbDsSP().getSelectedRow();
        
        try {
            HomeFrame.cuaHang.loaiBoMatHang(HomeFrame.cuaHang.getListDiaPhim().get(position));
            HomeFrame.cuaHang.getListDiaPhim().remove(position);
            JOptionPane.showMessageDialog(this, "Xóa thành công!");
            setTableContent();
        } catch (ClassNotFoundException ex) {
            
        } catch (SQLException ex) {
            
        }
        
        
    }

    @Override
    public void setTableContent() {
         getModel().setNumRows(0);
        
        for(DiaPhim x: HomeFrame.cuaHang.getListDiaPhim()){
            Object[] newRow = {getModel().getRowCount()+1,x.getTen(),
                x.getLoaiSanPham(),x.getDaoDien(),x.getDienVien(),
                x.getChatLuong(),x.getTheLoai(),x.getSoLuong(),x.getGiaMua(),x.getGiaBan()
            };
            getModel().addRow(newRow);
        }
        
    }
    
    

    @Override
    public String[] getTableFields() {
        return new String[]{
                    "STT","Tên MH","Loại MH","Đạo diễn","Diễn viên","Chất lượng","Thể loại","Số lượng",
                    "Giá mua","Giá bán"
                };
    }

    @Override
    public String getTitlePanel() {
        return "Danh Sách Đĩa Phim";
    }

    
    
    
    
}
