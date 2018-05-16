/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.plaf.TableUI;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author hima1993
 */
public class service_mod {
    public String srv_patient_id; 
    public String sr_id;
     public String srvc_name;
     public Double srvc_cost;
     public String srvc_result;
    public String srvc_type ;
    JTable table = new JTable();
    

     public void add_srv(int index){
           
        if (index==0) {
                try {
                    query.thequery("insert into service (service_cost,service_name,service_type) values('" + srvc_cost + "','" + srvc_name + "','" + srvc_type + "')");
                    int srvc_id = 0;
                    
                    ResultSet l = query.thequery_search("select max(service_id) as service_id from service");
                    
                    if (l.next()) {
                        srvc_id = l.getInt("service_id");
                        
                    }
                    try {
                        query.thequery("insert into test(service_service_id) values('" + srvc_id + "')");
                    } catch (Exception ex) {
                        Logger.getLogger(service_mod.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    
                } catch (SQLException ex) {
                } catch (Exception ex) {
         }
                
            }
            if (index==1) {
            try {
                query.thequery("insert into service (service_cost,service_name,service_type) values('" + srvc_cost + "','" + srvc_name + "','" + srvc_type + "')");
                int srvc_id = 0;

                ResultSet l = query.thequery_search("select max(service_id) as service_id from service");
                if (l.next()) {
                    srvc_id = l.getInt("service_id");

                }
                query.thequery("insert into treatment(service_service_id) values('" + srvc_id + "')");
                
            } catch (Exception ex) {
            }
               
            }

     }
     
     public void search_srv(JTable srv_table){
         try {
            int s_id;
            String s_name;
            double s_cost;
            String s_type;
            

             ResultSet d = query.thequery_search("select service_id as s_id,service_cost as s_cost,service_name as s_name,service_type as s_type from service");
             DefaultTableModel model = (DefaultTableModel) srv_table.getModel();
             while (d.next()) {
                 
                 s_id = d.getInt("s_id");
                 s_name = d.getString("s_name");
                 s_cost = d.getDouble("s_cost");
                 s_type = d.getString("s_type");
                 
                 model.addRow(new Object[]{"", s_id, s_cost, s_name, s_type});
             }
         } catch (Exception ex) {
         }
     
     
     
     }
     
     public void update_srv(int index,JTable srv_table){
         if (index == 0) {
             try {
                 query.thequery("update service set service_cost = '" + srvc_cost + "',service_name = '" + srvc_name + "',service_type='" + srvc_type + "' where service_id = '" + sr_id + "' ");
                 
                 DefaultTableModel model = (DefaultTableModel) srv_table.getModel();
                 
                 int i = srv_table.getSelectedRow();
                 
                 if (i >= 0) {
                     
                     model.setValueAt(sr_id, i, 1);
                     model.setValueAt(srvc_type, i, 4);
                     model.setValueAt(srvc_name, i, 3);
                     model.setValueAt(srvc_cost, i, 2);
                     
                 } else {
                     System.out.println("Update Error");
                 }
             } catch (Exception ex) {
           JOptionPane.showMessageDialog(null, "Check Whether you enter Correct Service ID !!! ", "Error", JOptionPane.ERROR_MESSAGE);
             }

            }
            if (index == 1) {
             try {
                 query.thequery("update service set service_cost = '" + srvc_cost + "',service_name = '" + srvc_name + "',service_type='" +srvc_type + "' where service_id = '" + sr_id + "'");
                 DefaultTableModel model = (DefaultTableModel) srv_table.getModel();
                 
                 int i = srv_table.getSelectedRow();
                 
                 if (i >= 0) {
                     model.setValueAt(sr_id, i, 1);
                     model.setValueAt(srvc_type, i, 4);
                     model.setValueAt(srvc_name, i, 3);
                     model.setValueAt(srvc_cost, i, 2);
                     
                 } else {
                     System.out.println("Update Error");
                 }
             } catch (Exception ex) {
             }
            }
     
     }
     
     public void search_srv_in_admission(JTable srv_table){
     
         try {
            // TODO add your handling code here:
            DefaultTableModel model = (DefaultTableModel) srv_table.getModel();

            int srvc_id = 0;
            double srvc_cost;
            int s_id = 0;
            String srvc_name = null;
            String srvc_type = null;
            String srvc_result = null;

            ResultSet h = query.thequery_search("select * from service_has_addmission where addmission_a_id='" + srv_patient_id + "'");
            while (h.next()) {
                srvc_id = h.getInt("service_service_id");
                srvc_result = h.getString("service_result");
                s_id = h.getInt("srcadd");
                ResultSet k = query.thequery_search("select * from service where service_id='" + srvc_id + "'");
                while (k.next()) {
                    srvc_cost = k.getDouble("service_cost");
                    srvc_name = k.getString("service_name");
                    srvc_type = k.getString("service_type");

                    model.addRow(new Object[]{s_id, srvc_id, srvc_cost, srvc_name, srvc_type, srvc_result});

                }
            }

        } catch (Exception ex) {
        } 
     
     }
     
     public void update_srv_in_addmission(JTable srv_table){
     try {
            // TODO add your handling code  
            DefaultTableModel model = (DefaultTableModel) srv_table.getModel();
            int i = srv_table.getSelectedRow();
            
            if (i >= 0) {

                query.thequery("update service_has_addmission set service_result='" + srvc_result + "' where srcadd ='" + Integer.parseInt(model.getValueAt(i, 0).toString()) + "'");
            }
           JOptionPane.showMessageDialog(null, "Service Updated In addmission Sucessfully.", "service submit", JOptionPane.INFORMATION_MESSAGE);


        } catch (Exception ex) {
           JOptionPane.showMessageDialog(null, "Check Whether you enter Correct Addmission ID !!! ", "Error", JOptionPane.ERROR_MESSAGE);

        }
     
     }
     public void add_Srv_in_addmission(){
      try {
            // TODO add your handling code here:

            int srvc_id = 0;
            int adm_id = 0;
            int pt_id = 0;

            ResultSet l = query.thequery_search("select service_id from service where service_id='" + sr_id + "'");
            ResultSet m = query.thequery_search("select * from addmission where a_id='" + srv_patient_id + "'");

            if (l.next()) {
                srvc_id = l.getInt("service_id");

            }
            if (m.next()) {
                adm_id = m.getInt("a_id");
                pt_id = m.getInt("Patient_patient_id");

            }

            query.thequery("insert into service_has_addmission(service_service_id,addmission_a_id,service_result) values('" + srvc_id + "','" + adm_id + "','" + srvc_result + "')");
        JOptionPane.showMessageDialog(null, "Service Submitted in Admission Sucessfully.", "service submit", JOptionPane.INFORMATION_MESSAGE);

        } catch (Exception ex) {
           JOptionPane.showMessageDialog(null, "Check Whether you enter Correct Addmission ID !!! ", "Error", JOptionPane.ERROR_MESSAGE);
        }
     
     }
     
     public void delete_Srv_in_addmission(JTable srv_table){
      try {
            // TODO add your handling code  
            DefaultTableModel model = (DefaultTableModel) srv_table.getModel();
            int i = srv_table.getSelectedRow();

            if (i >= 0) {

                query.thequery("delete from service_has_addmission  where srcadd ='" + Integer.parseInt(model.getValueAt(i, 0).toString()) + "'");
            }

        } catch (Exception ex) {
           JOptionPane.showMessageDialog(null, "Check Whether you enter Correct Addmission ID !!! ", "Error", JOptionPane.ERROR_MESSAGE);
        }
     
     }
    
}
