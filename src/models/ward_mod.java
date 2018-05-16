/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import java.sql.ResultSet;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author hima1993
 */
public class ward_mod {
    public String ward_id;
    public String ward_name;
    public String number_of_patients;
    public String number_of_employee;
    public String ward_head;
    
    public void add(JTable table_ward){
    try {
            query.thequery("insert into ward (ward_name,number_of_patients,number_of_employee,ward_head) values('"+ward_name+"','"+number_of_patients+"','"+number_of_employee+"','"+ward_head+"')");
            DefaultTableModel model = (DefaultTableModel) table_ward.getModel();
            ResultSet l = query.thequery_search("select max(ward_id) as w_id from ward");
            int w_id = 0;
            if(l.next()){
            w_id = l.getInt("w_id");
            }
            model.addRow(new Object[]{w_id, ward_name, number_of_patients, number_of_employee,ward_head});
            JOptionPane.showMessageDialog(null, "Ward Submitted Sucessfully", "Ward submit", JOptionPane.INFORMATION_MESSAGE);

        } catch (Exception ex) {
            
        }
    
    
    }
    
    public void update(JTable table_ward){
    try {
            query.thequery("update ward set ward_name='" + ward_name + "',number_of_patients='" +  number_of_patients + "',number_of_employee='" + number_of_employee + "',ward_head='" + ward_head + "' where ward_id ='" + ward_id + "'");


            DefaultTableModel model = (DefaultTableModel) table_ward.getModel();
            int i = table_ward.getSelectedRow();

            if (i >= 0) {
                model.setValueAt(ward_id, i, 0);
                model.setValueAt(ward_name, i, 1);
                model.setValueAt(number_of_patients, i, 2);
                model.setValueAt(ward_head, i, 3);
                model.setValueAt(number_of_employee , i, 4);
            } else {
                System.out.println("Update Error");
            }
           
           JOptionPane.showMessageDialog(null, "Ward Updated Sucessfully", "Ward update", JOptionPane.INFORMATION_MESSAGE);

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Check whether you have Enter correct Ward ID !!! ", "Null value8", JOptionPane.ERROR_MESSAGE);

        }
    
    }
    
    public void delete(JTable table_ward){
    
    try {

            
                query.thequery("update addmission_has_ward set ward_ward_id=null where ward_ward_id='" + ward_id + "'");
                query.thequery("update employee set ward_ward_id=null where ward_ward_id='" + ward_id + "'");
                query.thequery("delete from ward where ward_id='" + ward_id + "'");
                DefaultTableModel model = (DefaultTableModel) table_ward.getModel();
                int i = table_ward.getSelectedRow();
                if (i >= 0) {
                    // remove a row from jtable
                    model.removeRow(i);
                } else {
                    System.out.println("Delete Error");
                }
               
             JOptionPane.showMessageDialog(null, "Ward Deleted Sucessfully", "Ward delete", JOptionPane.INFORMATION_MESSAGE);

        } catch (Exception ex) {
              JOptionPane.showMessageDialog(null, "Check whether you have Enter correct Ward ID !!! ", "Null value8", JOptionPane.ERROR_MESSAGE);

        } 
    
    }
    
    public void search(JTable table_ward){
    try {
            // TODO add your handling code here:
            int w_id = 0;
            String w_name = null;
            int number_of_patients = 0;
            int number_of_employee = 0;
            String ward_head = null;
            ResultSet l = query.thequery_search("select * from ward where ward_id = '"+ward_id+"' or ward_name = '"+ward_name+"'");
            if(l.next()){
              w_id = l.getInt("ward_id");  
              w_name = l.getString("ward_name");
              number_of_patients = l.getInt("number_of_patients");
              number_of_employee = l.getInt("number_of_employee");
              ward_head= l.getString("ward_head");
                
                
            }
            DefaultTableModel model = (DefaultTableModel) table_ward.getModel();
            model.addRow(new Object[]{w_id, w_name, number_of_patients, number_of_employee,ward_head});
            
            
        } catch (Exception ex) {
          JOptionPane.showMessageDialog(null, "Check whether you have Enter correct Ward ID !!! ", "Null value8", JOptionPane.ERROR_MESSAGE);

        } 
    
    }
    
    public void showall(JTable table_ward){
    try {
            // TODO add your handling code here:
            int wd_id;
            String wd_name;
            String wd_head;
            int num_pat;
            int num_emp;

            ResultSet d = query.thequery_search("select ward_id as w_id,ward_name as w_name,number_of_patients as num_patient,number_of_employee as num_employee,ward_head as w_head from ward");
            DefaultTableModel model = (DefaultTableModel) table_ward.getModel();
            while (d.next()) {
                wd_id = d.getInt("w_id");
                wd_name = d.getString("w_name");
                wd_head = d.getString("w_head");
                num_pat = d.getInt("num_patient");
                num_emp = d.getInt("num_employee");
                model.addRow(new Object[]{wd_id, wd_name, num_pat, num_emp, wd_head});
            }
        } catch (Exception ex) {
        } 
    }
}
