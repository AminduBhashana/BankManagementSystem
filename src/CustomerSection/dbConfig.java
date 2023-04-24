/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CustomerSection;

import com.mysql.cj.jdbc.MysqlDataSource;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author AMINDU
 */
public class dbConfig {
    private static String servername = "localhost";
    private static String username = "root";
    private static String dbname = "bankmgtsys";
    private static Integer portnumber = 3307 ;
    private static String password = "";
    
    public static Connection getConnection(){
        Connection conn = null;
        
        MysqlDataSource datasource = new MysqlDataSource();
        
        datasource.setServerName(servername);
        datasource.setUser(username);
        datasource.setDatabaseName(dbname);
        datasource.setPortNumber(portnumber);
        datasource.setPassword(password);
        
        try{
            conn = (Connection) datasource.getConnection();
            System.out.println("Connection Success");
            return conn;
        }catch(SQLException ex){
            System.out.println("Connection Error");
            JOptionPane.showMessageDialog(null,"Connection Error", "Error", 2);
            Logger.getLogger(" Get Connection -> " + dbConfig.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
               
}
}
