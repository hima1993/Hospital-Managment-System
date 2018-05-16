/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;

/**
 *
 * @author hima1993
 */
public class query {
    
    
    public static void thequery(String query) throws Exception {
     Connection con = null;
     Statement st = null;
     
     
         Class.forName("com.mysql.jdbc.Driver");
         con = DriverManager.getConnection("jdbc:mysql://localhost:3306/hospitalsystem","root","hima3993");
         st = con.createStatement();
         st.executeUpdate(query);
         JOptionPane.showMessageDialog(null,"Query Executed");
         
     
     
     
     
     
    
    }
    
    
    public static ResultSet thequery_search(String query) throws Exception {
     Connection con = null;
     Statement st = null;
     
     
         Class.forName("com.mysql.jdbc.Driver");
         con = DriverManager.getConnection("jdbc:mysql://localhost:3306/hospitalsystem","root","hima3993");
         st = con.createStatement();
         return st.executeQuery(query);
        // JOptionPane.showMessageDialog(null,"Query Executed");
         
     
     
    }
    
}
