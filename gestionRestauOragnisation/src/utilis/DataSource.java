/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utilis;

/**
 *
 * @author Ahmed Fourati
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Ahmed Fourati
 */
public class DataSource {
    Connection cnx;
    String url="jdbc:mysql://localhost:3306/moduleaf";
    String login="root" ; 
    String mdp="";
    static DataSource instance ;

    private DataSource() {
        try {
            cnx = DriverManager.getConnection(url, login, mdp);
            System.out.println("Bonjour cnx etablie");
        } catch (SQLException ex) {
            Logger.getLogger(DataSource.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    public static DataSource getInstance(){
        if(instance==null)
       instance = new DataSource();
        return instance ;
       
    }
    

    public Connection getConnexion() {
        return cnx ;
    }
   
  
    
}

