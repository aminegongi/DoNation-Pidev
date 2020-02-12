/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utils;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Hedi
 */
public class DataBase {
    String url="jdbc:mysql://localhost:3306/aide";
    String login="root";
    String pwd="";
    
    public static DataBase db;
    public Connection con;

    private DataBase() {
        try {
            con=DriverManager.getConnection(url, login, pwd);
            System.out.println("cnx etablie");
        } catch (SQLException ex) {
            Logger.getLogger(DataBase.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    public Connection getConnection(){
        return con;
    }
    
    public static DataBase getInstance(){
        if(db == null)
            db=new DataBase();
        return db;
    }
    
    
}
