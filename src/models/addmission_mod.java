/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import java.sql.ResultSet;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import view.admission;

/**
 *
 * @author hima1993
 */
public class addmission_mod {

    public String ad_id;
    public Date admit_date;
    public Date discharge_date;
    public String discharge_time;
    public String admit_time;
    public String adm_patient_id;
    public String adm_nonconsultant_id;
    public String adm_ext_id;
    public String adm_ward_id;
    public String adm_consultant_id3;

    public void submit() {

        try {
            DateFormat fmt = new SimpleDateFormat("yyyy-MM-dd");
            String date = fmt.format(this.admit_date);
            String date1 = fmt.format(this.discharge_date);

            int pt_id = 0;
            int per_id = 0;
            int ext_id = 0;
            int ext_per_id = 0;
            int non_con_id = 0;
            int doc_id = 0;
            int emplo_id = 0;
            int emplo_per_id = 0;
            int con_id = 0;
            int con_doc_id = 0;
            int con_emplo_id = 0;
            int con_emplo_per_id = 0;
            int a_id = 0;
            int patient_id = 0;
            int person_id = 0;
            int ad_ext_id = 0;
            int ad_ext_per_id = 0;
            int w_id = 0;
            int aa_id = 0;
            ResultSet m = query.thequery_search("select patient_id as patient_id from Patient where patient_id='" + adm_patient_id + "'");
            ResultSet l = query.thequery_search("select non_consultant_id as non_con_id from non_consultant where non_consultant_id='" + adm_nonconsultant_id + "'");
            ResultSet n = query.thequery_search("select external_phy_id as ext_id from external_physician where external_phy_id='" + adm_ext_id + "'");
            ResultSet g = query.thequery_search("select ward_id from ward where ward_id='" + adm_ward_id + "'");

            if (n.next()) {
                ext_id = n.getInt("ext_id");

            }

            if (l.next()) {
                non_con_id = l.getInt("non_con_id");

            }

            if (m.next()) {
                pt_id = m.getInt("patient_id");

            }

            if (g.next()) {
                w_id = g.getInt("ward_id");
            }
            query.thequery("insert into addmission (admit_date,admit_time,discharge_date,discharge_time,non_consultant_non_consultant_id,external_physician_external_phy_id,Patient_patient_id) values('" + date + "','" + admit_time + "','" + date1 + "','" + discharge_time + "','" + non_con_id + "','" + ext_id + "','" + pt_id + "')");

            ResultSet e = query.thequery_search("select consultant_id as con_id from consultant where consultant_id='" + adm_consultant_id3 + "'");
            ResultSet v = query.thequery_search("select max(a_id) as aa_id from addmission");
            if (v.next()) {
                aa_id = v.getInt("aa_id");

            }
            ResultSet f = query.thequery_search("select a_id from addmission where a_id='" + aa_id + "'");

            if (f.next()) {
                a_id = f.getInt("a_id");

            }
            if (e.next()) {
                con_id = e.getInt("con_id");

            }
            query.thequery("insert into consultant_has_addmission (consultant_consultant_id,addmission_a_id) values ('" + con_id + "','" + a_id + "')");
            query.thequery("insert into addmission_has_ward (ward_ward_id,addmission_a_id) values('" + w_id + "','" + a_id + "')");

            JOptionPane.showMessageDialog(null, "Admission Submitted Sucessfully", "admission submit", JOptionPane.INFORMATION_MESSAGE);

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Check again whether you have entered the data for required text fields (that are represent in stars) !!! ", "Error Message", JOptionPane.ERROR_MESSAGE);

        }

    }

    public void update() {
        try {
            DateFormat fmt = new SimpleDateFormat("yyyy-MM-dd");
            String date = fmt.format(this.admit_date);
            String date1 = fmt.format(this.discharge_date);
            int nondoc = 0;
            int nonemp = 0;
            int nonpr = 0;
            int extpr = 0;
            int con = 0;
            ResultSet l = query.thequery_search("select * from non_consultant where non_consultant_id='" + adm_nonconsultant_id + "'");
            ResultSet m = query.thequery_search("select * from external_physician where external_phy_id='" + adm_ext_id + "'");

            if (l.next()) {
                nondoc = l.getInt("doctor_doctor_id");
                nonemp = l.getInt("doctor_employee_emp_id");
                nonpr = l.getInt("doctor_employee_person_person_id");
            }

            if (m.next()) {

                extpr = m.getInt("person_person_id");

            }

            query.thequery("update addmission set admit_date= '" + date + "',admit_time='" + admit_time + "',discharge_date='" + date1 + "',discharge_time='" + discharge_time + "',non_consultant_non_consultant_id='" + adm_nonconsultant_id + "',external_physician_external_phy_id='" + adm_ext_id + "' where a_id ='" + ad_id + "'");

            query.thequery("update consultant_has_addmission set consultant_consultant_id ='" + adm_consultant_id3 + "'where addmission_a_id='" + ad_id + "'");
            JOptionPane.showMessageDialog(null, "Information Has Updated", "Addmission update", JOptionPane.INFORMATION_MESSAGE);

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Check again whether you have entered the data for required text fields (that are represent in stars) !!! ", "Error Message", JOptionPane.ERROR_MESSAGE);

        }

    }

    public void search() {

        admission a = new admission();

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

            ResultSet j = query.thequery_search("select * from addmission where a_id='" + ad_id + "'");


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
            ResultSet l = query.thequery_search("select * from consultant_has_addmission where addmission_a_id ='" + ad_id + "'");

            if (n.next()) {
                fname = n.getString("person_fname");
                lname = n.getString("person_lname");

            }
            if (l.next()) {
                con_id = l.getInt("consultant_consultant_id");

            }

            Date date = fmt.parse(ad_date);
            Date date2 = fmt.parse(dish_date);

            System.out.println(ap_id);
            admission a1 = new admission();
            a1.set(Integer.parseInt(ad_id), ap_id, fname, lname, w_id, date, date2, dish_time, ad_time, con_id, noncon_id, ext_id);

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Check Whether Admission is Enter !!", "Error", JOptionPane.ERROR_MESSAGE);

        }

    }

    public void searchall(JTable table_recom) {
        try {
            // TODO add your handling code here:
            DefaultTableModel model = (DefaultTableModel) table_recom.getModel();

            int non_con_id = 0;
            int con_id = 0;
            int extphy_id = 0;
            int non_conper_id = 0;
            int conper_id = 0;
            int extper_id = 0;
            String noncon_fname = null;
            String noncon_lname = null;
            String con_fname = null;
            String con_lname = null;
            String ext_fname = null;
            String ext_lname = null;

            ResultSet j = query.thequery_search("select * from non_consultant");
            ResultSet k = query.thequery_search("select * from consultant");
            ResultSet l = query.thequery_search("select * from external_physician");

            while (j.next()) {
                non_con_id = j.getInt("non_consultant_id");
                non_conper_id = j.getInt("doctor_employee_person_person_id");
                ResultSet m = query.thequery_search("select * from person where person_id ='" + non_conper_id + "'");
                while (m.next()) {
                    noncon_fname = m.getString("person_fname");
                    noncon_lname = m.getString("person_lname");
                    model.addRow(new Object[]{non_con_id, "N_Con", noncon_fname, noncon_lname});

                }

            }
            while (k.next()) {
                con_id = k.getInt("consultant_id");
                conper_id = k.getInt("doctor_employee_person_person_id");
                ResultSet n = query.thequery_search("select * from person where person_id ='" + conper_id + "'");
                while (n.next()) {
                    con_fname = n.getString("person_fname");
                    con_lname = n.getString("person_lname");
                    model.addRow(new Object[]{con_id, "Con", con_fname, con_lname});

                }

            }
            while (l.next()) {
                extphy_id = l.getInt("external_phy_id");
                extper_id = l.getInt("person_person_id");
                ResultSet q = query.thequery_search("select * from person where person_id ='" + extper_id + "'");
                while (q.next()) {
                    ext_fname = q.getString("person_fname");
                    ext_lname = q.getString("person_lname");
                    model.addRow(new Object[]{extphy_id, "Ext", ext_fname, ext_lname});

                }
            }

        } catch (Exception ex) {
        }

    }

}
