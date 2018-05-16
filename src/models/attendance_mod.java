/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import java.util.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author hima1993
 */
public class attendance_mod {
    
    public String attd_emp_id;
    public Date attd_from;

    public Date attd_to;
    public Date attd_date;
    public int show (JTable attd_table ){
    int a =0 ;
      try {
            
            DefaultTableModel model = (DefaultTableModel) attd_table.getModel();
            model.setRowCount(0);
            DateFormat fmt = new SimpleDateFormat("yyyy-MM-dd");
            int attendances_id = 0;
            int e_id = 0;
            String attendance_date = null;

            ResultSet k = query.thequery_search("select * from employee_has_attendance where employee_emp_id='" + attd_emp_id+ "'");

            while (k.next()) {
                attendances_id = k.getInt("attendance_attendance_id");
                e_id = k.getInt("employee_emp_id");
                System.out.println("came");

                System.out.println(attendances_id);
                ResultSet h = query.thequery_search("select * from attendance where attendance_id='" + attendances_id + "' and date between '" + fmt.format(this.attd_from) + "' and '" + fmt.format(this.attd_to) + "'");

                while (h.next()) {
                    e_id = k.getInt("employee_emp_id");
                    attendance_date = fmt.format(h.getDate("date"));
                    Date date = (Date) fmt.parse(attendance_date);
                    model.addRow(new Object[]{e_id, attendance_date});

                }
                
            }
            a = attd_table.getRowCount(); 

            
        } catch (Exception ex) {
        }
      
      return a;
    }
    
    public void submit(JTable attd_table){
     try {

            DateFormat fmt = new SimpleDateFormat("yyyy-MM-dd");
            String date = fmt.format(this.attd_date);

            query.thequery("insert into attendance (date) values('" + date + "')");
            int attd = 0;
            ResultSet l = query.thequery_search("select max(attendance_id)as attd_id from attendance");
            if (l.next()) {
                attd = l.getInt("attd_id");
            }

            int pr_emp = 0;
            ResultSet m = query.thequery_search("select person_person_id from employee where emp_id='" + attd_emp_id + "'");
            if (m.next()) {
                pr_emp = m.getInt("person_person_id");
            }
            query.thequery("insert into employee_has_attendance (attendance_attendance_id,employee_emp_id) values('" + attd + "','" + attd_emp_id + "')");

            DefaultTableModel model = (DefaultTableModel) attd_table.getModel();

            model.addRow(new Object[]{attd_emp_id, date});
        

           
        } catch (Exception ex) {
           
        }
    
    }
    
    public void delete(JTable attd_table){
    
    
    try {
            // TODO add your handling code here:
            DateFormat fmt = new SimpleDateFormat("yyyy-MM-dd");
            String date = fmt.format(this.attd_date);
              int attd = 0;
              int emp =0;
              int aa_id = 0;
            ResultSet l = query.thequery_search("select attendance_id as attd_id from attendance where date ='" + date + "' ");
            System.out.println(date);
        while (l.next()) {
                attd = l.getInt("attd_id");
                System.out.println(attd);
           
            ResultSet m = query.thequery_search("select empadd as emp_id from employee_has_attendance where attendance_attendance_id ='" + attd + "' and employee_emp_id='"+attd_emp_id+"'");
        if(m.next()){
        emp = m.getInt("emp_id");
        System.out.println(emp);
        
        }
        ResultSet v = query.thequery_search("select * from employee_has_attendance where empadd='"+emp+"' ");
        if(v.next()){
        aa_id = v.getInt("attendance_attendance_id");
        }
        System.out.println("came");
        query.thequery("delete from employee_has_attendance where empadd='"+emp+"' ");
        query.thequery("delete from attendance where attendance_id='"+aa_id+"' ");
        
        }
            DefaultTableModel model = (DefaultTableModel) attd_table.getModel();
            int i = attd_table.getSelectedRow();
            if (i >= 0) {

                model.removeRow(i);
            } else {
                System.out.println("Delete Error");
            }

        

        } catch (SQLException ex) {
        } catch (Exception ex) {
        } 
    }
    
}
