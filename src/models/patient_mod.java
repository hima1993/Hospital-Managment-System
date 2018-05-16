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
import models.person_mod;

/**
 *
 * @author hima1993
 */
public class patient_mod extends person_mod {

    public int patient_id;
    public String gurdian_fname;
    public String gurdian_lname;
    public String gurdian_contact;
    

    public patient_mod() {
        
    }

    public void update_patient() {
        
        try {
           
            
            DateFormat fmt = new SimpleDateFormat("yyyy-MM-dd");
            
            
            int pr = 0;
           
            String p1_dob = fmt.format(this.dob);
            
            ResultSet l = query.thequery_search("select person_person_id as person_id from patient where patient_id='" + patient_id + "'");
            if (l.next()) {
                pr = l.getInt("person_id");
                
            }
            query.thequery("update person set person_fname='" + p_fname + "',person_lname='" + p_lname + "',gender='" + gender + "',person_addr1='" + p_addr1 + "',person_addr2='" + p_addr2+ "',person_contact='" + p_contact + "',nic='" + nic + "',blood_group='" + p_bld + "',dob='" + p1_dob + "' where person_id='" + pr + "'");
            
            query.thequery("update  patient set gurdian_fname = '" + gurdian_fname + "',gurdian_lname='" + gurdian_lname + "',gurdian_contact='" + gurdian_contact + "' where patient_id = '" + patient_id + "'");
        } catch (Exception ex) {
            Logger.getLogger(patient_mod.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
