/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import static java.lang.Double.sum;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import view.admission;
import view.payment;

/**
 *
 * @author hima1993
 */
public class payment_mod {
    
    public String pay_adm_id;
    public String pay_subtotal;
    public String pay_payment;
    public String pay_balance;
    public double show(JTable table_pay){
        payment pay = new payment();
        double sum = 0;
    try {
            // TODO add your handling code here:
            DefaultTableModel model = (DefaultTableModel) table_pay.getModel();
            
            int srvc_id = 0;
            double srvc_cost;
            int p_id = 0;
            int per_id = 0;
            String fname =null;
            String lname = null;
            String srvc_name = null;
            String srvc_type = null;
            String srvc_result = null;
            ResultSet d = query.thequery_search("select * from addmission where a_id='" + pay_adm_id + "'");
            if(d.next()){
            p_id = d.getInt("Patient_patient_id");
            }
            ResultSet e = query.thequery_search("select * from patient where patient_id='" + p_id + "'");
            if(e.next()){
            per_id = e.getInt("person_person_id");
            
            }
            ResultSet w = query.thequery_search("select * from person where person_id='" + per_id + "'");
            if(w.next()){
            fname = w.getString("person_fname");
            lname = w.getString("person_lname");
            
            }

            ResultSet h = query.thequery_search("select * from service_has_addmission where addmission_a_id='" + pay_adm_id + "'");
            while(h.next()){
                srvc_id = h.getInt("service_service_id");
                srvc_result = h.getString("service_result");
            ResultSet k = query.thequery_search("select * from service where service_id='" + srvc_id + "'");
            while(k.next()){
                srvc_cost = k.getDouble("service_cost");
                sum = sum+srvc_cost ;
                srvc_name = k.getString("service_name");
                srvc_type = k.getString("service_type");
                model.addRow(new Object[] {srvc_name,srvc_type,srvc_cost,srvc_result});
               
            }
            }
            pay.set(fname, lname);
           
            
            
          
            
        } catch (SQLException ex) {
            
        } catch (Exception ex) {
            
        }
    
   return sum;
    }
    
    public void print(JTable table_pay){
        admission mn = new admission();
    try {
            // TODO add your handling code here:
          
            int adm_id = 0;
            int pt_id = 0;
            int per_id = 0;
            
            
            ResultSet m = query.thequery_search("select a_id,Patient_patient_id as patient_id from addmission where a_id='"+pay_adm_id+"'");
            
            
            if(m.next()){
                adm_id = m.getInt("a_id");
                pt_id = m.getInt("patient_id");
               
            }  
            query.thequery("insert into payment(addmission_a_id,sub_total,payment,balance) values('"+adm_id+"','"+pay_subtotal+"','"+pay_payment+"','"+pay_balance+"')");
            
            
            
            mn.setVisible(true);
            
        }
    
    
    
    catch (Exception ex) {
        } 
    
    try {
            // TODO add your handling code here:
           DateFormat fmt = new SimpleDateFormat("yyyy-MM-dd");
            //DateFormat mt = new SimpleDateFormat("HH:mm:ss");
            //String date1= "0000-00-00";
            //String time = "00:00:00";

            //String date1 = "0000-00-00";
            int a_id = 0;
            int w_id = 0;
            int aper_id = 0;
            int ap_id = 0;
            String ad_time = null;
            String ad_date = null;
            String dish_time = null;
            String dish_date = null;
            String fname = null;
            String lname = null;
            int con_id = 0;
            int noncon_id = 0;
            int ext_id = 0;

            ResultSet j = query.thequery_search("select * from addmission where a_id='" + pay_adm_id+ "'");


            if (j.next()) {
                a_id = j.getInt("a_id");
                ap_id = j.getInt("Patient_patient_id");

                ad_date = fmt.format(j.getDate("admit_date"));
                ad_time = j.getString("admit_time");
                noncon_id = j.getInt("non_consultant_non_consultant_id");
                ext_id = j.getInt("external_physician_external_phy_id");
                dish_date = fmt.format(j.getDate("discharge_date"));
                dish_time = j.getString("discharge_time");

            }
            ResultSet m = query.thequery_search("select * from patient where patient_id='" + ap_id + "'");

            if (m.next()) {
                aper_id = m.getInt("person_person_id");
            }
            ResultSet k = query.thequery_search("select * from addmission_has_ward where addmission_a_id ='" + a_id + "' ");
            if (k.next()) {
                w_id = k.getInt("ward_ward_id");

            }

            ResultSet n = query.thequery_search("select * from person where person_id ='" + aper_id + "'");
            ResultSet l = query.thequery_search("select * from consultant_has_addmission where addmission_a_id ='" + pay_adm_id + "'");

            if (n.next()) {
                fname = n.getString("person_fname");
                lname = n.getString("person_lname");

            }
            if (l.next()) {
                con_id = l.getInt("consultant_consultant_id");

            }
             Date date = fmt.parse(ad_date);
            Date date2 = fmt.parse(dish_date);

          
            mn.set(Integer.parseInt(pay_adm_id),ap_id,fname,lname,w_id,date,date2,dish_time,ad_time,con_id,noncon_id,ext_id);

    
    }   catch (Exception ex) {
        }
    
    try {
            Document doc = new Document();
            PdfWriter.getInstance(doc, new FileOutputStream("table9.pdf"));
            doc.open();
            PdfPTable pdfTable = new PdfPTable(table_pay.getColumnCount());
            //adding table headers
            for (int i = 0; i < table_pay.getColumnCount(); i++) {
                pdfTable.addCell(table_pay.getColumnName(i));
            }
            //extracting data from the JTable and inserting it to PdfPTable
            for (int rows = 0; rows < table_pay.getRowCount() ; rows++) {
                for (int cols = 0; cols < table_pay.getColumnCount(); cols++) {
                    pdfTable.addCell(table_pay.getModel().getValueAt(rows, cols).toString());

                }
            }
            doc.add(pdfTable);
            doc.close();
            System.out.println("done");
        } catch (FileNotFoundException ex) {
        } catch (DocumentException ex) {
        } 
}}
