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
import javax.swing.table.TableModel;
import utils.DiaPhim;
import utils.Sach;

/**
 *
 * @author h
 */
public class DsCacLoaiSach extends DsSanPham{

    public DsCacLoaiSach() {
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
            Sach rowItem = new Sach(
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
            HomeFrame.cuaHang.loaiBoMatHang(HomeFrame.cuaHang.getListSach().get(position));
            HomeFrame.cuaHang.getListSach().remove(position);
            JOptionPane.showMessageDialog(this, "Xóa thành công!");
            setTableContent();
        } catch (ClassNotFoundException ex) {
            
        } catch (SQLException ex) {
            
        }
    }

    @Override
    public void setTableContent() {
        getModel().setNumRows(0);
        
        for(Sach x: HomeFrame.cuaHang.getListSach()){
            Object[] newRow = {getModel().getRowCount()+1,x.getTen(),
                x.getLoaiSanPham(),x.getTacGia(),x.getNxb(),
                x.getNgonNgu(),x.getTheLoai(),x.getSoLuong(),x.getGiaMua(),x.getGiaBan()
            };
            getModel().addRow(newRow);
        }
    }

    @Override
    public String[] getTableFields() {
        return new String[]{
            "STT","Tên MH","Loại MH","Tác giả","NXB","Ngôn ngữ","Thể loại","Số lượng","Giá mua","Giá bán"
        };
    }

    @Override
    public String getTitlePanel() {
        return "Danh Sách Các Loại Sách";
    }

    
    
}
