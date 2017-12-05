/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MesClasses;

import java.sql.Connection;
import java.sql.DriverManager;
import javax.swing.JOptionPane;

/**
 *
 * @author xor
 */
public class Cnx {

    Connection  cn = null;

    public static Connection connect() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
             Connection cn = DriverManager.getConnection("jdbc:mysql://localhost:3306/snv?zeroDateTimeBehavior=convertToNull", "root", "");
             System.out.println("connected to data base :D ");
             return cn;
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null,"ERREUR, veuillez contactez l'administrateur de l'application");
            return null;
            }};
                
    
}
