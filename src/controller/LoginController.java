/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.sql.ResultSet;
import models.query;

/**
 *
 * @author hima1993
 */
public class LoginController {
    
    public static boolean login(String userName,String password) throws Exception
    {   
        
        ResultSet j = query.thequery_search("select emp_username as emp_usr from employee");
        ResultSet k = query.thequery_search("select emp_username as emp_usr from employee");
        if (userName.equals(j) && password.equals(k)){
        return true;
        }
        else{
            return false;
        }
    }
    
}

